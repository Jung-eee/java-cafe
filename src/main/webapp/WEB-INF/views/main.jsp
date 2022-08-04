<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/resources/css/customize.css' />">
</head>
<body>
	<header class="p-3 text-white">
		<jsp:include page="./incl/header.jsp"/>
	</header>	
	<ul class="menuItem_ul">
	</ul>
	
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <script>
   $('.si').on('click', function(){
       var categoryId = $(this).attr('value')
       console.log(categoryId)
       $(".si").each(function(index, el){
          $(el).removeClass("active")
          $(".menuItem_ul").empty                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ()
       })
       $(this).addClass("active")
       if($(this).hasClass("active") == true){
         $.ajax({
             url: "requestObject",
             type: "POST",
             contentType: "application/json; charset=euc-kr",
             dataType: "text",
             data: JSON.stringify({
          'categoryId': categoryId
          }),
            success: function(data){
             var html = ""
          $.each(JSON.parse(data), function(index, el){
             html = "<li class='menuItem'><a href='/java-cafe/kiosk/add_cart?imgName=" + el.image.imgName +"'>"
             html += "<img src=/java-cafe/resources/menuImg/" + el.image.imgName + ">"
             html += "<p>" + el.menuName + "<br>" + el.menuPrice + "원</p></a><li>"
             $(".menuItem_ul").append(html)
          })   
           },
           error: function(){
               alert("simpleWithObject err");
           }
       });         
 }
});
   </script>
</body>
</html>