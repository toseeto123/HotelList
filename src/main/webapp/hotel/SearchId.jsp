<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/searchIdPw.js"></script>
</head>
<body>
<h1> 아이디 찾기 </h1>
<div class="container">
 <div class="Register_form">
  <form name="frm" method="post" action="HotelServlet">
  
  이름:
  <input type="text" name="name" value="${hotel.name}">
  이메일:
  <input type="text" name="email" value="${hotel.email}">
  
  <input type="button" value="로그인창으로" onclick="checkOk()">
  
  </form>
 </div>
</div>
</body>
</html>