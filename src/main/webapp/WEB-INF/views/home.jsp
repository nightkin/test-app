<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<body>

    <h1>Добро пожаловать, <a href="/test-mvn-app/profile/${username}">${username}</a></h1>
    <h3>Ваша активность за последний месяц</h3>
    <ul>

    </ul>

</body>
</html>
