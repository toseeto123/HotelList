<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/board.js"></script>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
<div id="wrap" align = "center">
	<h1>예약정보 상세보기</h1>
		<table>
			
			<tr>
				<th>객실타입</th> <td>${reservation.start_date} </td>		
			</tr>
			
			<tr>
				<th>인원</th> <td>${reservation.finish_date}</td>	
				
			</tr>
			
		
			<tr>
				<th>호실번호</th> <td>${reservation.room}</td>
				
			</tr>
			
			<tr>
				<th>체크인</th> <td>${reservation.room_num}</td>
				
			</tr>
			
			<tr>
				<th>체크아웃</th> <td>${reservation.person}</td>
				
			</tr>
			
		</table>
		<br><br>
		<input type="button" value="예약정보 수정" 
		onclick="location.href='HotelServlet?command=reservation_update_form&num=${reservation.num}'">
		
		<input type="button" value="예약정보 삭제"
		onclick="location.href='HotelServlet?command=reservation_delete_form&num=${reservation.num}'">
		
		<input type="button" value="예약정보 리스트"
		onclick="location.href='HotelServlet?command=reservation_manage'">


</div>



</body>
</html>