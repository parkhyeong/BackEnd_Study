<%@page import="bean.CompanyDAO"%>
<%@page import="bean.CompanyDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // 1. 브라우저로 부터 넘오온 데이터를 받아서 dto를 만들어서 dto에 넣어준다.
    // 2. dao객체 생성해서 dto를 주면서 insert(dto)요청
    %>
	<jsp:useBean id="bag" class="bean.CompanyDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="bag"/>
    <%
    CompanyDAO dao = new CompanyDAO(); 
    // import 하는법
    //ctrl + Shift + M
    // 글자 지우고 ctrl+ 스페이스
    int result =dao.insert(bag);
    %>
    <%=result%>