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
            <h2>Edit/Delete Media Item</h2>
        		<table>
        			<c:forEach var="media" items="${items}">
        				<tr>
        					<td>${media.name}</td>
        					<td><form method="post" action="<c:url value='/admin/editmediaitem.do' />">
        					   <input type="hidden" name="id" value="${media.id}" />
                               <input type="hidden" name="genreId" value="${media.genreId}" />
                               <input type="hidden" name="mediaTypeId" value="${media.mediaTypeId}" />
                               <input type="hidden" name="name" value="${media.name}" />
                               <input type="hidden" name="year" value="${media.year}" />
                               <input type="hidden" name="comments" value="${media.comments}" />
                               <input type="hidden" name="curVal" value="${media.curVal}" />
                               <input type="hidden" name="purId" value="${media.purInfo.id}" />
                               <input type="hidden" name="purInfoPurPrice" value="${media.purInfo.purPrice}" />
                               <input type="hidden" name="purInfoPurDate" value="${media.purInfo.purDate}" />
                               <input type="hidden" name="purInfoId" value="${media.purInfo.purInfoId}" />
                               <input type="hidden" name="purInfoMediaItemId" value="${media.purInfo.mediaItemId}" />                              
                               <input type="submit" value="Edit" class="button" >
        					</form></td>
        					<td><form method="post" action="<c:url value='/admin/deletemediaitem.do' />">
        					   <input type="hidden" name="id" value="${media.id}" />
                               <input type="hidden" name="genreId" value="${media.genreId}" />
                               <input type="hidden" name="mediaTypeId" value="${media.mediaTypeId}" />
                               <input type="hidden" name="name" value="${media.name}" />
                               <input type="hidden" name="year" value="${media.year}" />
                               <input type="hidden" name="comments" value="${media.comments}" />
                               <input type="hidden" name="curVal" value="${media.curVal}" />
                               <input type="hidden" name="purId" value="${media.purInfo.id}" />
                               <input type="hidden" name="purInfoPurPrice" value="${media.purInfo.purPrice}" />
                               <input type="hidden" name="purInfoPurDate" value="${media.purInfo.purDate}" />
                               <input type="hidden" name="purInfoId" value="${media.purInfo.purInfoId}" />
                               <input type="hidden" name="purInfoMediaItemId" value="${media.purInfo.mediaItemId}" />
                               <input name="id" type="submit" value="Delete" class="button">
        					</form></td>
        				</tr>
        			</c:forEach>
        		</table>
        	<p><a href="<c:url value='/login.do' />" target="_self">Return to Administration Home</a></p>
        </div>
        <jsp:include page="/Footer.jsp" />
    </div>
</body>
</html>