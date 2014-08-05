<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="<c:url value='/styles.css' />" type="text/css">
    <title>Error Page</title>
</head>
<body>
    <div id="container">
        <jsp:include page="/Header.jsp" />
        <div id="content">
            <h2>This request has generated an error.</h2>
            <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
            <p><b>Error Message:</b> ${pageContext.exception.message}</p>
            <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p><br />
            <button onclick="history.back()">Back to Previous Page</button>
        </div>
        <jsp:include page="/Footer.jsp" />
    </div>
</body>
</html>