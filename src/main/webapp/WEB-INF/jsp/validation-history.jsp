<%@ page import="java.util.ArrayList" %>
<%@ page import="lt.justas.dao.model.ValidationResultDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Work order validation</title>
</head>
<body>
<h1>Validation history:</h1>
<c:forEach var="validationResult" items="${validationHistory}">
    <ul><c:out value="${validationResult}"/></ul>
</c:forEach>
</body>
</html>