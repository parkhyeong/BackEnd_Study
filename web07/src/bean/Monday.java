package bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

//@WebServlet("/Monday")
public class Monday extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String temp =config.getInitParameter("temp");
    	System.out.println("객체 생성됨.");
    	System.out.println(temp);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청 받음.");
	}


}
