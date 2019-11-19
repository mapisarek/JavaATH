<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.example.guestbook.User" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post">
    Login:<input name="login"/><br>
    Email:<input name="email"/><br>
    Password:<input name="password"/><br><br>
    <input type="Submit" value="Register"/>
</form>
</body>
</html>
