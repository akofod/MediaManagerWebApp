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
            <form method="post" action="<c:url value='/admin/performeditmediaitem.do' />">
            		<h2>Edit Media Item</h2>
        			<table>
            			<tr><td>Title: </td><td><input name="name" type="text" class="txtfield" value="${item.name}" /></td></tr>
            			<tr><td>Year: </td><td><input name="year" type="text" class="txtfield" value="${item.year}" /></td></tr>
            			<tr><td>Comments: </td><td><input name="comments" type="text" class="txtfield" value="${item.comments}" /></td></tr>
            			<tr><td>Current Value: </td><td><input name="curVal" type="text" class="txtfield" value="${item.curVal}" /></td></tr>
            			<tr><td>Purchase Location: </td>
            				<td>
            					<select name="purInfoId">
            						<c:forEach var="loc" items="${alllocations}">
            						<c:if test="${item.purInfo.purInfoId == loc.id}">
            						    <option selected="selected" value="${loc.id}">${loc.purLoc}</option>
            						</c:if>
            							<option value="${loc.id}">${loc.purLoc}</option>
            						</c:forEach>
            					</select>
            				</td></tr>
            			<tr><td>Purchase Price: </td><td><input name="purInfoPurPrice" type="text" class="txtfield" value="${item.purInfo.purPrice}" /></td></tr>
            			<tr><td>Purchase Date: </td><td><input name="purInfoPurDate" type="text" class="txtfield" value="${modDateStr}" /></td></tr>
            			<tr><td>Media Type: </td>
            				<td>
            					<select name="mediaTypeId">
            						<c:forEach var="type" items="${alltypes}">
            						<c:if test="${item.mediaTypeId == type.id}">
                                        <option selected="selected" value="${type.id}">${type.mediaType}</option>
                                    </c:if>
            							<option value="${type.id}">${type.mediaType}</option>
            						</c:forEach>
            					</select>
            				</td></tr>
            			<tr><td>Genre: </td>
            				<td>
            					<select name="genreId">
            						<c:forEach var="genre" items="${allgenres}">
            						<c:if test="${item.genreId == genre.id}">
                                        <option selected="selected" value="${genre.id}">${genre.genreDesc}</option>
                                    </c:if>
            							<option value="${genre.id}">${genre.genreDesc}</option>
            						</c:forEach>
            					</select>
            				</td></tr>
            			<tr><td><input type="submit" value="Edit" class="button" /></td></tr>
            		</table>
            		<input type="hidden" name="id" value="${item.id}" />
            		<input type="hidden" name="purId" value="${item.purInfo.id}" />
        	</form>
        	<p><a href="<c:url value='/login.do' />" target="_self">Return to Administration Home</a></p>
        </div>
        <jsp:include page="/Footer.jsp" />
    </div>
</body>
</html>