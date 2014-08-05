<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles.css" type="text/css">
<title>Administration</title>
</head>
<body>
    <div id="container">
        <jsp:include page="Header.jsp" />
        <div id="content">
            <h2>Administrator Login</h2>
            <div id="login">
        		<form method="post" action="login.do">
        			<table>
        			    <tr><td>Username: </td><td><input name="username" type="text" class="txtfield" /></td></tr>
            			<tr><td>Password: </td><td><input name="password" type="password" class="txtfield" /></td><tr/>
            			<tr><td><input type="submit" value="Login" class="button" /></td></tr>
            		</table>
        		</form>
    		</div>
        </div>
        <jsp:include page="Footer.jsp" />
    </div>
</body>
</html>