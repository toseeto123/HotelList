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
<link rel="stylesheet" type="text/css" href="css/HotelReservation.css">
</head>
<body>
 
 <jsp:include page="header.jsp"/>
 

 <div class="container1">
      <div class="ReserveBox">
<!--         <form action="HotelServlet" name="frm" method="post"> -->
<!--         <input type="hidden" name="command" value="hotel_reservation_result"> -->
       <form action="HotelServlet" name="frm" method="post">   
       <input type="hidden" name="command" value="hotel_reservation_result">
        <select
          id="room2" 
          name="room"
          class="room1"
          onchange="categoryChange(this)"
        >
          <option value="./images/enter.jpg" selected disabled>객실타입 선택</option>
          <option class="standard" value="./images/standard.jpg">스탠다드룸</option>
          <option class="deluxe" value="./images/deluxe.jpg">디럭스룸</option>
          <option class="suite" value="./images/suite.jpg">스위트룸</option>

        </select>

        <select name="person" class="person1">
          <option value="선택하세요" selected disabled>인원 선택</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>

 		<select name="room_num" class="room_num1" id="room_num2">
          <option value="room_number" selected disabled>호실</option>
          <option value="201호">201호</option>
          <option value="202호">202호</option>
          <option value="203호">203호</option>
          <option value="204호">204호</option>
          <option value="205호">205호</option>
          <option value="301호">301호</option>
          <option value="302호">302호</option>
          <option value="303호">303호</option>
          <option value="304호">304호</option>
          <option value="305호">305호</option>
          <option value="401호">401호</option>
          <option value="402호">402호</option>
          <option value="403호">403호</option>
          <option value="404호">404호</option>
          <option value="405호">405호</option>
          <option value="501호">501호</option>
          <option value="502호">502호</option>
          <option value="503호">503호</option>
          <option value="504호">504호</option>
          <option value="505호">505호</option>
          <option value="601호">601호</option>
          <option value="602호">602호</option>
          <option value="603호">603호</option>
          <option value="604호">604호</option>
          <option value="605호">605호</option>
          
        </select>
        
       

        <input type="date"  name ="start_date" class="startdate1" />

        <input type="date"  name="finish_date" class="finishdate1" />
        
         <select name="payment" class="payment1" id="payment2" >
         <option>가격선택</option>
<!-- 	    	<option id = "2000,000원" value="200,000원" style="dislplay:none;">200,000원</option> -->
<!--         	<option value="250,000원" style="dislplay:none;">250,000원</option> -->
<!--         	<option value="300,000원" style="dislplay:none;">300,000원</option>       	 -->
        </select>

        <input type="submit" class="reserve1" value="예약">

</form>
      </div>
      
      <div class="imageBox">
        <img id="myImg" src="" alt="" width=100%; height=100%;>
      </div>

    </div>
	
	
	
	
	
	
	
<script type="text/javascript" src="script/HotelReservation.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="script/hotel.js"></script>
<script src="script/slick.min.js"></script>
<script type="text/javascript" src="script/hotelMainPage.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</body>
</html>