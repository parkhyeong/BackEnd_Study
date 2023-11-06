<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function() {
	$('#b1').click(function() {
		$.ajax({
			url:"data/car.json",
			success: function(json) {
				//console.log(json)
				//console.log(json[0])
				//console.log(json[0].email)
				
				$(json).each(function(i, one) {
						idValue= one.id
						emailValue= one.email
						carValue= one.car
						console.log(idValue+ " "+ emailValue+" "+carValue)
						$.ajax({
						url: "db_create.jsp",
						data: {
							id: one.id,
							email:one.email,
							car:one.car,
						},
						success: function(result) {
							console.log(result)
							if(result.trim()=='1'){
							console.log('db저장 성공')
							}
							else{
								console.log('db저장 실패')
							}
						}
					})
				})
			}
		})
	})
})

	$('#b2').click(function() {
		$('#d1').empty()
		$.ajax({
			url:"data/car.xml",
			success: function(xml) {
				list=$(xml).find('record')
				for(let i=0; i<list.length; i++){
					let id=$(list[i]).find('id').text()
					let email=$(list[i]).find('email').text()
					let car=$(list[i]).find('car').text()
					console.log(id+" "+email+" "+car)
					$('#d1').append(id+" "+email+" "+car+"<br>")
				}
			}
		})
		
	})
</script>

</head>
<body>
<button id="b1">car.json읽어와서 추출하기</button>
<button id="b2">car.xml읽어와서 추출하기</button>
<div id='d1' style="background: yellow">xml결과 넣는 곳<br></div>
</body>
</html>