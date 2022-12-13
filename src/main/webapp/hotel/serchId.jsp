<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/hotelIDPW.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
</head>
<body>
<section>
 <div class="wrap">
  <div id="name">${hvo.name}님의 아이디는</div>
  <div id="id">${hvo.id}입니다.</div>
  <input type="button" value="로그인하러가기" 
  onclick="location.href='HotelServlet?command=login_page'">
 </div>

</section>


</body>
</html>