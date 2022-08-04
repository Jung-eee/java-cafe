<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<div class="container admin_container">
	<div class="row">
		<h3 class="jumbotron" >상품 등록이 완료 되었습니다.</h3>
		<div class="form-group productInfo">
				<div>
					<label>상품명</label> : ${menuitem.menuName}<br>
				</div>
				
				<div>
					<label>상품가격</label> : ${menuitem.menuPrice}
				</div>
					<button class="btn btn-default" onclick='location.href="<c:url value='add_menuitem'/>"' >상품 등록으로 돌아가기</button>
		</div>
	</div>
</div>
</body>
</html>