<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <title>All Media Items</title>
</head>
<body>
    <div id="container">
        <jsp:include page="Header.jsp" />
        <div id="content">
            <h2>All Media Items</h2>
            <table class="allItems">
                <tr>
                    <th>Name: </th>
                    <th>Genre: </th>
                    <th>Media Type: </th>
                    <th>Year: </th>
                    <th>Comments: </th>
                </tr>
                <c:forEach items="${requestScope.items}" var="item">
                    <c:url var="itemLink" value="SearchForItems.do">
                        <c:param name="searchType" value="name"/>
                        <c:param name="itemName" value="${item.name}"/>
                    </c:url>
                    <tr>
                        <td><a href="${itemLink}">${item.name}</a></td>
                        <td>${item.genre}</td>
                        <td>${item.mediaType}</td>
                        <td>${item.year}</td>
                        <td>${item.comments}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>