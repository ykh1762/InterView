<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach items="${userList }" var="user">
<c:set var="bg_addrpath" value="/background?mem_id=${user.user_id }"/>
<c:set var="profile_addrpath" value="/profile?mem_id=${user.user_id }"/> 
<c:choose>
   <c:when test="${fn:contains(user.bg_path, 'http')}">
      <c:set var="bg_path" value="${user.bg_path }"/> 
   </c:when>
   <c:when test="${fn:contains(user.profile_path, 'http')}">
      <c:set var="profile_path" value="${user.profile_path }"/> 
   </c:when>
</c:choose>
	<li>
		<div class="whiteBox"><!-- ;background-image:url("http://www.naver.com"); ;background-image:url("/profile?mem_id=jin"); -->
			<div style="width: 108px; height: 108px;background-image:url(${not empty profile_path ? profile_path : profile_addrpath});background-repeat: no-repeat;background-size: cover;background-position: center;margin-left: 30px;border: 4px solid #E3EEF2;border-radius: 100px;"></div>
			<div><strong>${user.user_name}</strong></div>
			<div>${user.introduce}</div>
		</div>
		
	</li>
</c:forEach>

