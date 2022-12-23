<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="wrap" align="center">

	<h1>예약정보 수정</h1>
	<form name="frm" method="post" action="HotelServlet">
	<input type="hidden" name="command" value="reservation_update">
	<input type="hidden" name="num" value="${reservation.num}">
	
	<table>
		
	
		<tr>
			<th>객실타입</th>
			<td><input type="text" size="12" name="start_date" value="${reservation.start_date}"></td>			
		</tr>
		<tr>
			<th>인원</th>
			<td><input type="text" size="12" name="finish_date" value="${reservation.finish_date}"></td>			
		</tr>
		<tr>
			<th>호실번호</th>
			<td><input type="text" size="12" name="room" value="${reservation.room}"></td>			
		</tr>
		<tr>
			<th>체크인</th>
			<td><input type="text" size="12" name="room_num" value="${reservation.room_num}"></td>			
		</tr>
		<tr>
			<th>체크아웃</th>
			<td><input type="text" size="12" name="person" value="${reservation.person}"></td>			
		</tr>
		

	</table>
	<br><br>
	
	<input type="submit" value="등록" >
	<input type="reset" value="다시 작성">
	<input type="button" value="목록 보기" onclick="location.href='HotelServlet?command=reservation_manage'">
	
	
	</form>
	</div>

</body>
</html>