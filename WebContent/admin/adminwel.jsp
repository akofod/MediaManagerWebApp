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
            <h2>Welcome, Administrator!</h2>
            <p><a href="<c:url value='/admin/addmediatype.do' />" target="_self">Add Media Type</a></p>
            <p><a href="<c:url value='/admin/addGenre.do' />" target="_self">Add Genre</a></p>
            <p><a href="<c:url value='/admin/addpurchaseinfo.do' />" target="_self">Add Purchase Location</a></p>
            <p><a href="<c:url value='/admin/additem.do' />" target="_self">Add Media Item</a></p>
            <p><a href="<c:url value='/admin/alltypes.do' />" target="_self">Edit/Delete Media Type</a></p>
            <p><a href="<c:url value='/admin/allgenres.do' />" target="_self">Edit/Delete Genre</a></p>
            <p><a href="<c:url value='/admin/allpurchlocs.do' />" target="_self">Edit/Delete Purchase Locations</a></p>
            <p><a href="<c:url value='/admin/allitems.do' />" target="_self">Edit/Delete Media Item</a></p>
        </div>
        <jsp:include page="/Footer.jsp" />
    </div>
</body>
</html>