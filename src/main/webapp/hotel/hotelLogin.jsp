<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/hotelLogin.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<script type="text/javascript" src="script/hotel.js"></script>
</head>
<body>

<!-- 로그인 페이지 -->
 <section class="container">
        <div class="visual_slider">
            <div class="item item1">
                <img src="images/travel1.jpg" alt="">
            </div>
            
            <form action="HotelServlet" name="frm" method="post">
             <input type="hidden" name="command" value="hotel_main_page_form">
             
             
             <!-- lev값 가져와서 로그인하는 부분에는 문제있으나
              로그인되고나서 result 값으로  관리자 & 일반회원 게시판관리 달리하는거는 구분됨  -->
	            <div class="login_form">
                      <select name="lev"> 
                         <option value="A">ADMIN</option>
                         <option value="B" selected="selected">일반회원</option>
                      </select>
                <div class="top_box">
                    <h2>Log In</h2>
                </div>
                
                <div class="middle_box">
                        <input type="text" placeholder="아이디" name="id">
                        <input type="password" placeholder="비밀번호" name="pass">
                        <input type="submit" value="로그인" onclick="hotelCheck()">
                </div>
                
                <div class="bottom_box">
                    <input type="button" value="회원가입" onclick="location.href='HotelServlet?command=hotel_register_form'">
                  	<input type="button" value="아이디/비밀번호 찾기" onclick = "location.href='HotelServlet?command=hotel_id/pw_form'">
                </div>
             </div>
        </form>
        
        </div>
       </section>


</body>
</html>