<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호텔예약 정보 확인</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/hotelReservationResult.css">
</head>
<!-- 카드결제 방문결제 계좌이체 -->
<body>

    <div class="container">
        <div class="ReservationForm">
        
            <h1>결제 정보</h1>
            
            <form action="HotelServlet" name="frm" method="post">
            <input type="hidden" name="command" value="hotel_pay_form">
            <table class="list">
			

                <tr>
                	<th>결제번호</th>
                    <th>객실 타입</th>
                    <th>인원</th>
                    <th>호실 번호</th>                    
                    <th>체크인</th>
                    <th>체크아웃</th>
                    <th>결제금액</th>
                    
                    
                    
                </tr>
                
               
                <c:forEach var="reservation" items="${reserveList}">
                
                    <tr class="record">
                    <td>${reservation.num}</td>
                    
                    <td>${reservation.start_date}</td>
                    
                      <td>${reservation.finish_date}</td>
    
                           
                        <td>${reservation.room}</td>
                        
                         <td>${reservation.room_num}</td>
                                               
                        <td>${reservation.person}</td>
                        
                         <td>${reservation.payment}</td>
                                     
                    </tr>
    
                </c:forEach>
    
            </table>
           

			
            <input type="button" value="결제하기" onClick="location.href='HotelServlet?command=hotel_pay_form&num=${reservation.num}'" >
			 </form>
           
        </div>

    </div>

 
    
</body>
</html>