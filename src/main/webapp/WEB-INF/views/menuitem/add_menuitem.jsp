<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/resources/css/customize.css' />">
</head>
<body>
<div class="container add_ac">
  <div class="success">
		<h2>상품 등록</h2><br>
		<div class="form-group productInfo">
			<form:form modelAttribute="menuItemCommand" method="post" enctype="multipart/form-data">
				<div>
					<label class="">상품명</label> <input name="menuName" value="${MenuItem.menuName}" class="form-control" required>
				</div>
				<div>
					<label>상품가격</label> <input name="menuPrice" value="${MenuItem.menuPrice}" class="form-control" required>
				</div>
				<div>
					<label>상품분류</label>
						<form:select path="categoryId">
							<form:options 
								items="${catgegoryProvider}"
								itemValue="bid"
								itemLabel="bigCategoryName"
								/>
						</form:select>
				</div>
					<label>상품 사진</label> <input type="file" name="report" /><br/>
					<button class="btn btn-default" type="submit">상품 등록</button>
					<button class="btn btn-default" onclick='location.href="<c:url value='view_menu'/>"' >상품 전체리스트 보기</button>
			</form:form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>