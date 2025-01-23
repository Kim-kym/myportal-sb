<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<link type="text/css"
	rel="stylesheet"
	href="<c:url value="/css/home.css" />" />
</head>
<body>
  <div id="container">
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
	<div id="wrapper">
		<div id="content">
			<div id="site-introduction">
	
			<h1>OOPS!</h1>
			<h2>Error Occured: </h2>
			<h3>${name }</h3>
			<p>${message }			

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
  </div>
</body>
</html>