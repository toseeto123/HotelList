<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 내역</title>
<link rel="stylesheet" type="text/css" href="css/hotelPayForm.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
</head>
<body>

    <div class="container">
        <div class="ReservationFinishForm">
            
            <div class="topbox">
                <img src="images/check.png" alt="">
            </div>

            <div class="middlebox">
                <p>Payment completed!</p>
            </div>

            <div class="bottombox">
                <input type="button" value="Go to main page" onclick="location.href='HotelServlet?command=return_main_page&num=${reservation.num}'">
            </div>
          
        </div>

    </div>

</body>
</html>