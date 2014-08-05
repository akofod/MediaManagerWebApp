<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <title>Genres</title>
</head>
<body>
    <div id="container">
        <jsp:include page="Header.jsp" />
        <div id="content">
            <h2>Media Types</h2>
            <table class="descTable">
            <tr><th>MediaType ID:</th><th>Description:</th><th>No. of Items:</th></tr>
            <c:forEach items="${requestScope.types}" var="type">
            <c:url var="itemLink" value="SearchForItems.do">
                    <c:param name="searchType" value="type"/>
                    <c:param name="type" value="${type.mediaType}"/>
                </c:url>
                    <tr>
                        <c:if test="${type.itemCount < 1}">
                            <td>${type.id}</td>
                        </c:if>
                        <c:if test="${type.itemCount > 0}">
                            <td><a href="${itemLink}">${type.id}</a></td>
                        </c:if>
                        <td>${type.mediaType}</td>
                        <c:if test="${type.itemCount < 1}">
                            <td>No Items</td>
                        </c:if>
                        <c:if test="${type.itemCount > 0}">
                            <td>${type.itemCount}</td>
                        </c:if>
                    </tr>
            </c:forEach>
            </table>
        </div>
        <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>