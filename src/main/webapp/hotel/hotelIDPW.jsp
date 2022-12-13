<%@page import="com.hotel.vo.hotelVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/hotelIDPW.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<script type="text/javascript" src="script/hotelIdPw.js"></script>

<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기페이지</title>
</head>

<!-- 아이디 비밀번호 찾기 페이지 -->
<!-- location.href='HotelServlet?command=id_find_form' 이 부분이 문제-> 정보를 가져가지 못하고 그냥 화면만 이동하기 때문-->
<!-- form에 action이 빠져있었  -->
<body>

 <div class="contents">
   <form name="frm" method="post" action="HotelServlet"> 
        <div class="container">
        
            <div class="IDFind_form">
                <input type="text" name="name"  placeholder="이름">
                <input type="text" name="email" placeholder="이메일">
                <input type="button" value="아이디 찾기" onclick="searchID()">
            </div>
              
            <div class="PWFind_form">
            
                <input type="text" name="id2"  placeholder="아이디">
                <input type="text" name="name2" placeholder="이름">
                <input type="text" name="email2" placeholder="이메일">
                <input type="button" value="비밀번호 찾기" onclick="passCheck()">
            
            </div>
        
        </div>
    </form>
    </div>
  
</body>
</html>