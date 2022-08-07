<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/resources/css/customize.css' />">
<link rel="stylesheet" href="<c:url value='/resources/css/main.css' />">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="p-3 text-white">
		<jsp:include page="../incl/header.jsp"/>
	</header>
	<div class="container add_ac">
  <div class="success">
<h4>결제가 완료 되었습니다.</h4>
<form>
 <button type="submit" formaction="didpay" formmethod="post" class="btn btn-outline-light me-2 co" >메인으로</button>
</form>
</div>
</div>
</body>
</html>