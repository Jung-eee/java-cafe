<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<div class="container admin_container">
	<div class="row">
		<h3 class="jumbotron" >상품 등록</h3>
		<div class="form-group productInfo">
			<form:form modelAttribute="menuItemCommand" method="post" enctype="multipart/form-data">
				<div>
					<label>상품명</label> <input name="menuName" value="${MenuItem.menuName}" class="form-control" required>
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
					<button class="btn btn-default" >상품 리스트로 돌아가기</button>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>