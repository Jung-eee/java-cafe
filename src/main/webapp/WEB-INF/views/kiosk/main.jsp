<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/resources/css/customize.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/main.css' />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="p-3 text-white">
		<jsp:include page="../incl/header.jsp"/>
	</header>	
	<ul class="menuItem_ul">
		<c:forEach var="menuItem" items="${menuItemList }">
			<li class="menuItem">
            <a class="modal-btn" data-toggle="modal" data-target="#exampleModal" >
               <img src="/java-cafe/resources/menuImg/${menuItem.image.imgName}">
               <p class="menu text">${menuItem.menuName }<br>${menuItem.menuPrice }원</p>
            </a>
         </li>
		</c:forEach>
	</ul>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
     <div class="modal-dialog" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="exampleModalLabel">수량 선택</h5>
           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
             <span aria-hidden="true">&times;</span>
           </button>
         </div>
         <div class="modal-body">
         </div>
       </div>
     </div>
   </div>
   <div class="cart-container">
   <c:forEach var="cart" items="${cartList}">
         <div class="cart_content">
            <span class="remove">X</span>
            <img src="/java-cafe/resources/menuImg/${cart.imgName}" style="width: 150px; height: 150px;">
            <div class="cart_content_text">
               <span class="cart_menuName">${cart.menuName}</span>
               <span class="cart_menuPrice">${cart.menuPrice * cart.quantity}원</span>
               <span class="cart_quantity">${cart.quantity}개</span>
            </div>
         </div>
      </c:forEach>
      <div class="t_price">
      <span class="t_font">총액 : </span>
      <span class="total_price t_font"></span><br>
      <button type="button"  class="btn btn-outline-light me-2 co" onclick='location.href="<c:url value='/kiosk/pay'/>"'>결제하기</button>
      </div>
   </div>
<script type="text/javascript" src="<c:url value='/resources/js/main.js'/>"></script>
</body>
</html>