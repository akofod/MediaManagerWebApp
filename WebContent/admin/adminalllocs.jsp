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
            <h2>Edit/Delete Purchase Location</h2>
        		<table>
        			<c:forEach var="loc" items="${locations}">
        				<tr>
        					<td>${loc.purLoc}</td>
        					<td><form method="post" action="<c:url value='/admin/editpurchaseinfo.do' />">
        					   <input type="hidden" name="id" value="${loc.id}" />
                               <input type="hidden" name="desc" value="${loc.purLoc}" />
                               <input type="hidden" name="count" value="${loc.itemCount}" />
                               <input type="submit" value="Edit" class="button" >
        					</form></td>
        					<td><form method="post" action="<c:url value='/admin/deletepurchaseinfo.do' />">
        					   <input type="hidden" name="id" value="${loc.id}" />
                               <input type="hidden" name="desc" value="${loc.purLoc}" />
                               <input type="hidden" name="count" value="${loc.itemCount}" />
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