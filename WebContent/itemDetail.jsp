<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <title>Item Details</title>
</head>
<body>
    <div id="container">
        <jsp:include page="Header.jsp" />
        <div id="content">
            <h2>Media Item Detail</h2>
            <c:forEach items="${requestScope.items}" var="item">
                <h4>${item.name}</h4>
                <table>
                    <tr>
                        <td class="tag">Year:</td><td>${item.year}</td><td class="tag">Genre:</td><td>${item.genre}</td><td class="tag">Media Type:</td><td>${item.mediaType}</td>
                    </tr>
                    <tr>
                        <td class="tag">Current Value:</td><td>${item.curVal}</td><td class="tag">Comments:</td><td>${item.comments}</td>
                    </tr>
                    <tr>
                        <td class="tag">Purchase Date:</td><td>${item.purDate}</td><td class="tag">Purchase Location:</td><td>${item.purLoc}</td><td class="tag">Purchase Price:</td><td>${item.purPrice}</td>
                    </tr>
                </table>
                <hr>
                <br>
            </c:forEach>
        </div>
        <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>