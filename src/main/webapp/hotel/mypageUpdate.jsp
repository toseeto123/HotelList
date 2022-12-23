<%@page import="com.hotel.vo.hotelVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/hotelRegister.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<script type="text/javascript" src="script/checkinfo.js"></script>
</head>

<body>
     <div class="container">
         <div class="Register_form">
            <div class="Logo">
                    <p> 회원정보수정 </p>
             </div>
          <form name="frm" method="post" action="HotelServlet">
		   <input type="hidden" name="command" value="member_mypage_update">
                <!--아이디-->
                <input type="text" name="id" value="${hotel.id}" >
                <!-- 이름: -->
                <input type="text" name="name" value="${hotel.name}">
				<!-- 패스워드: -->                
                <input type="password" name="pass" value="${hotel.pass}"> 
                <input type="password" name="repass" placeholder="비밀번호 확인입력">
                <!-- 핸드폰: -->
                <input type="text" name="phone" value="${hotel.phone}">
                <!-- 이메일: -->
                <input type="text" name="email" value="${hotel.email}">
                
               <!-- script 체크시에 return을 하지않으면 그냥 script문을 실행하고 바로 넘어가게되므로 주의 -->
                <input type="submit" name="fix" value="정보수정" onclick="return registerCheck()" >
                <input type="button" name="delete" value="회원탈퇴" onclick="location.href='HotelServlet?command=delete_myinfo'">
                <input type="button" name="list" value="메인페이지로" onclick="location.href='HotelServlet?command=return_main_page'" >
             
             </form>
            </div>

       </div>
</body>
</html>