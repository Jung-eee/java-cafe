<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="container no-padding" style="position: relative;">
      <div>
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 mb-md-0">
          <li><a class="nav-link px-2 text-white" href="<c:url value='/main'/>"><img alt="logo" src="<c:url value='/resources/coffee.png'/>" style="width: 50px; height: 50px;"></a></li>
          <li><button value="1001" class="nav-link px-2 text-white si active">커피</button></li>
          <li><button value="1004" class="nav-link px-2 text-white si">티</button></li>
          <li><button value="1002" class="nav-link px-2 text-white si">에이드</button></li>
          <li><button value="1003" class="nav-link px-2 text-white si">스무디</button></li>
          <li><button value="1005" class="nav-link px-2 text-white si">디저트</button></li>
        </ul>
        <div class="text-end" style=" position: absolute; right: 25px; top: 2px;">
        <%if(session.getAttribute("userId") == null) {%>
          <button type="button"  class="btn btn-outline-light me-2" onclick='location.href="<c:url value='/menuitem/add_menuitem'/>"'>관리자 페이지</button>
         <%} else { %>
          <button type="button"  class="btn btn-outline-light me-2" onclick='location.href="<c:url value='/login_add/logout'/>"'>로그아웃</button>
          <button type="button"  class="btn btn-outline-light me-2" style="border:none;">${name}님</button>
          <%} %>
        </div>
      </div>
    </div>