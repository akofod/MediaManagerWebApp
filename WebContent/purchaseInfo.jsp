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
            <h2>Purchase Locations</h2>
            <table class="descTable">
            <tr><th>Location ID:</th><th>Description:</th><th>No. of Items:</th></tr>
            <c:forEach items="${requestScope.locations}" var="loc">
                <c:url var="itemLink" value="SearchForItems.do">
                    <c:param name="searchType" value="location"/>
                    <c:param name="location" value="${loc.purLoc}"/>
                </c:url>
                    <tr>
                        <c:if test="${loc.itemCount < 1}">
                            <td>${loc.id}</td>
                        </c:if>
                        <c:if test="${loc.itemCount > 0}">
                            <td><a href="${itemLink}">${loc.id}</a></td>
                        </c:if>
                        <td>${loc.purLoc}</td>
                        <c:if test="${loc.itemCount < 1}">
                            <td>No Items</td>
                        </c:if>
                        <c:if test="${loc.itemCount > 0}">
                            <td>${loc.itemCount}</td>
                        </c:if>
                    </tr>
            </c:forEach>
            </table>
        </div>
        <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>