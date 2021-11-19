<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Using GET Method to Read Form Data</title>
</head>

<body>
<h1>Using GET Method to Read Form Data</h1>
<ul>
    <li><p><b>First Name:</b>
        <%= request.getParameter("first_name")%>
    </p></li>
    <li><p><b>Last Name:</b>
        <%= request.getParameter("last_name")%>
    </p></li>
</ul>

</body>
</html>