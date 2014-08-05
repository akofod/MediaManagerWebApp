<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer">
    <div class="line-separator"></div>
    <div id="contacts">
        <h3>Contact Us</h3>
        <ul>
            <li><span>Email:</span>mediasiteadmin@franklin.edu</li>
            <li><span>Address:</span>201 S. Grant Ave., Columbus, OH, 43215</li>
            <li><span>Phone:</span>123-456-7890</li>
        </ul>
    </div>
    <div id="connect">
        <h3>Connect With Us</h3>
        <ul id="connect">
            <li><a href="<c:url value='/' />" target="_self">Home</a></li>
            <li><a href="https://www.facebook.com/andy.kofod" target="_self">Facebook</a></li>
            <li><a href=https://twitter.com/WilliamKofod target="_self">Twitter</a></li>
        </ul>
    </div>
    <div id="newsletter">
        <p><b>Sign-up for Newsletter</b>
            &nbsp;&nbsp;<i>Our newsletter rocks!</i>
        </p>
        <form method="post" action="SignUpForNewsletter">
            <input type="text" value="Name" class="txtfield" onblur="javascript:if(this.value==''){this.value=this.defaultValue;}" onfocus="javascript:if(this.value==this.defaultValue){this.value='';}" />
            <input type="text" value="Email Address" class="txtfield" onblur="javascript:if(this.value==''){this.value=this.defaultValue;}" onfocus="javascript:if(this.value==this.defaultValue){this.value='';}" />
            <input type="submit" value="Sign Up" class="button" />
        </form>
        <br>
    </div>
    <div class="footnote">&copy; Copyright &copy; 2013. All rights reserved</div>
</div> <!-- /#footer -->