<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>

<script>
$(function(){
	
			alert("성공")
			$('#1').click(function() {
				$.ajax({
					url:"https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.chosun.com%2Farc%2Foutboundfeeds%2Frss%2Fcategory%2Fsports%2F%3FoutputType%3Dxml&api_key=kpta19bcagtg9q6ytwikejmhthrhfa2gwkubfixk",
					success: function(x){
						x.
					}
			 })
			}
	
})


</script>

</head>
<body>
<h3>신문뉴스 데이터 받아오기(ajax로)</h3>
<button id='1'>연예인 기사(한경)</button>
<button id='2'>최신 기사(한경)</button>
<button id='3'>스포츠 기사(한경)</button>
<button id='4'>SBS</button>
<br>
<div></div>
</body>
</html>