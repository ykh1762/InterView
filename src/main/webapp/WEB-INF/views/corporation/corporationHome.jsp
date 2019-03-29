<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 페이지</title>



</head>
<body>
	<br>
	<%@ include file="/WEB-INF/views/corporation/module/top.jsp"%>
	<br>
	<%@ include file="/WEB-INF/views/corporation/module/left.jsp"%>
	<br>
	<%@ include file="/WEB-INF/views/corporation/module/write.jsp"%>
	
	-------------
	회사 타임라인
	-------------
	<br>
	
	request.setCharacterEncoding("utf-8");
	out.println("에디터 결과"); 
	out.println(request.getParameter("smarteditor"));



	<br>
	
		<c:forEach items="${timelinePost }" var="post">
	            <div class="panel panel-default">
		          <div id="post_data" class="scrolling" data-post="${post }">
	                <div class="panel-body">
	                  <div class="writer_info">
	                    <h4><a href="#">${post.writer_name }</a></h4>
	                    <span>${post.post_date }</span>
	                  </div>
	                  <div class="post_info">
	                  	<span>${post.post_contents }</span>
	                  </div>
	                </div>
	              <div class="panel-footer">
	              </div>
		          </div>
	            </div>
	          </c:forEach>
	          
</body>
</html>