<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 메뉴 보기</title>
</head>
<body>
	<div class="view_container">
	<c:forEach var="list" items="${menuList}">
		<div>
			<img src="<c:url value='/resources/menuImg/${list.image.imgName}'/>">
			<p>제품명 : <span>${list.menuName}</span></p>
			<p>가격 : <span>${list.menuPrice}</span></p>
			<p>카테고리 : <span>${list.bigCategoryName.bigCategoryName}</span></p>
		</div>
	</c:forEach>
	</div>
		<button class="btn btn-default" onclick='location.href="<c:url value='add_menuitem'/>"' >상품 등록으로 돌아가기</button>
</body>
</html>