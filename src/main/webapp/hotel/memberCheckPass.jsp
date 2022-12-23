<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정페이지</title>
<link rel="stylesheet" type="text/css" href="css/hotelMainPage.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/slick.css">
</head>
<body>
<!-- 수정페이지 공간 -->
<h1 align="center">회원정보 수정</h1>
<div class="contents">
     <div class="container">
         <div class="successInfo">
          <form name="frm" method="post" action="HotelServlet">
            	
                <input type="text" name="id" value="${hotel.id}" readonly="readonly">
                <input type="text" name="name" value="${hotel.name}" readonly="readonly">
                <input type="password" name="pass">
                <input type="text" name="lev" value="${hotel.lev}" readonly="readonly">
                <input type="text" name="phone" value="${hotel.phone}" readonly="readonly">
                <input type="text" name="email" value="${hotel.email}" readonly="readonly">
                
                <input type="button" name="list" value="메인페이지" onclick="location.href='/hotel/hotelMainPage.jsp'" >
             
             </form>
            </div>
       </div>
    </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="script/hotel.js"></script>
<script src="script/slick.min.js"></script>
<script type="text/javascript" src="script/hotelMainPage.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

</body>
</html>