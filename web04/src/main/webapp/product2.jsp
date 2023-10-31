<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 
   1.앞페이지에서 넘어온 id를 받아서 bag을 만들어서 저장 
   (액션태그이용)
   2.dao를 이용해서 db처리 
   3.db에서 가지고 온 데이터를 테이블로 출력 
    -->
    <!--
    import bean.ProductDTO;
    ProductDTO bag = new ProductDTO();
      -->
    <jsp:useBean id="bag" class="bean.ProductDTO"></jsp:useBean>
    <!-- 
    	bag.setId(request.getParamter("id");
     -->
    <jsp:setProperty property="id" name="bag"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/project.css">
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div id="total">
	<div id="top">
		<jsp:include page="top.jsp"></jsp:include> <!-- 액션태그 -->
	</div>
	<div id="top2">
		<jsp:include page="top2.jsp"></jsp:include>
	</div>
	<div id="center">
	<br><br>
		<% if(session.getAttribute("id") != null ) { %>
			<%= session.getAttribute("id") %>님 환영합니다.
		<% } %>
	</div>
</div>
</body>
</html>