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
            <form method="post" action="<c:url value='/admin/additem.do' />">
            		<h2>Add Media Item</h2>
        			<table>
            			<tr><td>Title: </td><td><input name="title" type="text" class="txtfield" /></td></tr>
            			<tr><td>Year: </td><td><input name="year" type="text" class="txtfield" /></td></tr>
            			<tr><td>Comments: </td><td><input name="comments" type="text" class="txtfield" /></td></tr>
            			<tr><td>Current Value: </td><td><input name="currval" type="text" class="txtfield" /></td></tr>
            			<tr><td>Purchase Location: </td>
            				<td>
            					<select name="purchloc">
            						<c:forEach var="loc" items="${purInfo}">
            							<option value="${loc.id}">${loc.purLoc}</option>
            						</c:forEach>
            					</select>
            				</td></tr>
            			<tr><td>Purchase Price: </td><td><input name="price" type="text" class="txtfield" /></td></tr>
            			<tr><td>Purchase Date: </td><td><input name="date" type="text" class="txtfield" /></td></tr>
            			<tr><td>Media Type: </td>
            				<td>
            					<select name="type">
            						<c:forEach var="type" items="${types}">
            							<option value="${type.id}">${type.mediaType}</option>
            						</c:forEach>
            					</select>
            				</td></tr>
            			<tr><td>Genre: </td>
            				<td>
            					<select name="genre">
            						<c:forEach var="genre" items="${genres}">
            							<option value="${genre.id}">${genre.genreDesc}</option>
            						</c:forEach>
            					</select>
            				</td></tr>
            			<tr><td><input type="submit" value="Add" class="button" /></td></tr>
            		</table>
        	</form>
        	<p><a href="<c:url value='/login.do' />" target="_self">Return to Administration Home</a></p>
        </div>
        <jsp:include page="/Footer.jsp" />
    </div>
</body>
</html>