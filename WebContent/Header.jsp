<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <div id="heading">
        <h1>Media Manager Web App</h1>
    </div>
    <div id="search">
        <form method="post" action="SearchForItems.do">
            <input name="itemName" type="text" value="" class="txtfield" />
            <input type="submit" value="Search Items" class="button" />
        </form>
    </div>
    <div id="menu">    
        <ul>
            <li id="navIndex">
                <a href="<c:url value='/index.jsp' />" target="_self">Home</a>
            </li>
            <li id="navItems">
                <a href="<c:url value='/items.do' />" target="_self">Media Items</a>
            </li>
            <li id="navG">
                <a href="<c:url value='/genres.do' />" target="_self">Genres</a>
            </li>
            <li id="navT">
                <a href="<c:url value='/mediatypes.do' />" target="_self">Types</a>
            </li>
            <li id="navPI">
                <a href="<c:url value='/purchaseinfo.do' />" target="_self">Purchase Info</a>
            </li>
            <li id="navAdmin">
                <a href="<c:url value='/login.do' />" target="_self">Admin</a>
            </li>
            <li id="navContact">
                <a href="<c:url value='/contact.jsp' />" target="_self">Contact</a>
            </li>
        </ul>
    </div>
</div> <!-- /#header -->