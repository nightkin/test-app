<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<body>

    <h1>Настройки пользователя</h1>
    <dl>
        <dt>Username:</dt>
        <dd>${name}</dd>
        <dt>Password:</dt>
        <dd>${password}</dd>
        <dt>Role:</dt>
        <dd>${role}</dd>
    </dl>

</body>
</html>
