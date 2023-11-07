package bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hi22")
public class Hi2 extends HttpServlet {
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿이 탄생함.");
		String tel=config.getInitParameter("tel"); //web.xml에 있는 init-param 불러옴
		String email=config.getInitParameter("email");
		System.out.println("관리자 전화번호인 "+ tel+"로 문자보냄.");
		System.out.println("관리자 이메일인 "+ email+"로 문자보냄.");
		
	}
	@Override
	public void destroy() {
		System.out.println("서블릿 생명을 다함.");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget요청이 들어오면 자동호출됨");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메소가 자동호출됨");
	}

}
