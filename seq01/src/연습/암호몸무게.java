package 연습;

import javax.swing.*;
//4500개는 java.~~~(핵심부품), javax.~~~(추가부품)
//패키지이름은 java, javax로 사용하지 않습니다.!!!

public class 암호몸무게 {

	public static void main(String[] args) {
		char pw1 = 'p';
		String s = JOptionPane.showInputDialog("비밀번호 입력"); //"q"
		char pw2 = s.charAt(0); //'q'
		
		if (pw1 == pw2) {
			JOptionPane.showMessageDialog(null, "PASS!!");
		} else {
			JOptionPane.showMessageDialog(null, "재입력!!");
		}
		
		double weight = 2.2;
		if (weight > 2) {
			JOptionPane.showMessageDialog(null, "다이어트 성공");
		}
		
		if (pw1 == pw2 && weight > 2) {
			JOptionPane.showMessageDialog(null, "오늘은 성공!!!!");
		} else {
			JOptionPane.showMessageDialog(null, "내일 다시 도전");
		}
		

	}

}
