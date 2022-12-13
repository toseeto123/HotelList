<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 페이지</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/slick.css">
<link rel="stylesheet" type="text/css" href="css/hotelReservation.css">
</head>
<body>

	 <div class="container1">
      <div class="ReserveBox">
        <form action="HotelServlet" name="frm" method="post">
        <input type="hidden" name="command" value="hotel_reservation_result">
        <select
          id="changeImg" 
          name="room"
          class="room"
        >
          <option value="./images/enter.jpg">객실타입 선택</option>
          <option class="aa" name="standard" value="./images/standard.jpg">스탠다드룸</option>
          <option class="aa" name="deluxe" value="./images/deluxe.jpg">디럭스룸</option>
          <option class="aa" name="sweet" value="./images/suite.jpg">스위트룸</option>
        </select>

        <select name="person" class="person">
          <option value="선택하세요">인원 선택</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>

 		<select name="room_num" id="room_num" class="room_num">
          <option value="room_number2">호실</option>
          <option value="room_number2">201호</option>
          <option value="room_number2">202호</option>
          <option value="room_number2">203호</option>
          <option value="room_number2">204호</option>
          <option value="room_number2">205호</option>
          <option value="room_number2">301호</option>
          <option value="room_number2">302호</option>
          <option value="room_number2">303호</option>
          <option value="room_number2">304호</option>
          <option value="room_number2">305호</option>
          <option value="room_number2">401호</option>
          <option value="room_number2">402호</option>
          <option value="room_number2">403호</option>
          <option value="room_number2">404호</option>
          <option value="room_number2">405호</option>
          <option value="room_number2">501호</option>
          <option value="room_number2">502호</option>
          <option value="room_number2">503호</option>
          <option value="room_number2">504호</option>
          <option value="room_number2">505호</option>
          <option value="room_number2">601호</option>
          <option value="room_number2">602호</option>
          <option value="room_number2">603호</option>
          <option value="room_number2">604호</option>
          <option value="room_number2">605호</option>


        </select>

        <input type="date" name ="startdate" class="startdate" />

        <input type="date" name="finishdate" class="finishdate" />

        <input type="submit" class="reserve" value="예약">
        </form>
      </div>
      
      <div class="imageBox">
        <img id="myImg" src="" alt="" width=100%; height=100%;>
      </div>

    </div>
	
	<script type="text/javascript" src="script/HotelReservation.js"></script>

</body>
</html>