import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;

public class RSA_algorithm {
    static final int KEY_SIZE = 1200; //키 사이즈 설정

    public static void main(String[] args) {
        HashMap<String, String> rsaKeyPair = createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey"); //공개키 생성
        String privateKey = rsaKeyPair.get("privateKey"); //비밀키 생성

        System.out.println("만들어진 공개키:" + publicKey);
        System.out.println("만들어진 개인키:" + privateKey);

        Scanner sc= new Scanner(System.in);
        System.out.print("평문: " );
        String plainText = sc.nextLine(); //암호할 평문 키보드 입력
        
        String encryptedText = encode(plainText, publicKey); //평문+공개키 = 암호화
        System.out.println("암호화: " + encryptedText);

        String decryptedText = decode(encryptedText, privateKey); //평문 + 비밀키 = 복호화
        System.out.println("복호화: " + decryptedText); //복호화
    }

    /**
     * 키페어 생성
     * 	
	 * 공개키와 개인키 한 쌍 생성
     */
    static HashMap<String, String> createKeypairAsString() {
        HashMap<String, String> stringKeypair = new HashMap<>(); //해쉬맵 생성
        try {
            SecureRandom secureRandom = new SecureRandom(); //암호화적으로 강력한 난수를 생성
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(KEY_SIZE, secureRandom); //암호화 설정초기화
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            PublicKey publicKey = keyPair.getPublic(); //공개키 생성
            PrivateKey privateKey = keyPair.getPrivate(); //비밀키 생성

            String stringPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            //Base64 인코딩하여 전달
            String stringPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            stringKeypair.put("publicKey", stringPublicKey); //해쉬맵 키 값으로 publickey저장
            stringKeypair.put("privateKey", stringPrivateKey); //해쉬맵 키 값으로 privatekey저장

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringKeypair;
    }

    /**
     * 암호화= 평문+비밀키
     */
    static String encode(String plainData, String stringPublicKey) {
        String encryptedData = null;
        try {
            //평문으로 전달받은 공개키를 공개키객체로 만드는 과정
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePublicKey = Base64.getDecoder().decode(stringPublicKey.getBytes());
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytePublicKey);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            //만들어진 공개키객체를 기반으로 암호화모드로 설정하는 과정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            //평문을 암호화하는 과정
            byte[] byteEncryptedData = cipher.doFinal(plainData.getBytes());
            encryptedData = Base64.getEncoder().encodeToString(byteEncryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedData;
    }

    /**
     * 복호화
     */
    static String decode(String encryptedData, String stringPrivateKey) {
        String decryptedData = null;
        try {
            //평문으로 전달받은 개인키를 개인키객체로 만드는 과정
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePrivateKey = Base64.getDecoder().decode(stringPrivateKey.getBytes());
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            //만들어진 개인키객체를 기반으로 암호화모드로 설정하는 과정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            //암호문을 평문화하는 과정
            byte[] byteEncryptedData = Base64.getDecoder().decode(encryptedData.getBytes());
            byte[] byteDecryptedData = cipher.doFinal(byteEncryptedData);
            decryptedData = new String(byteDecryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedData;
    }
}