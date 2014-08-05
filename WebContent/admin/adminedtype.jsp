<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/styles.css' />" type="text/css">
<title>Media Manager Web App</title>
</head>
<body>
    <div id="container">
        <jsp:include page="/Header.jsp" />
        <div id="content">
            <form method="post" action="<c:url value='/admin/performedittype.do' />">
            		<h2>Add Media Type</h2>
        			<table>
            			<tr><td>Media Type: </td><td><input name="type" type="text" class="txtfield" value="${type.mediaType}" /></td></tr>
            			<tr><td><input type="submit" value="Edit" class="button" /></td></tr>
            		</table>
            		<input type="hidden" name="id" value="${type.id}" />
            		<input type="hidden" name="count" value="${type.itemCount}" />
        	</form>
        	<p><a href="<c:url value='/login.do' />" target="_self">Return to Administration Home</a></p>
        </div>
        <jsp:include page="/Footer.jsp" />
    </div>
</body>
</html>