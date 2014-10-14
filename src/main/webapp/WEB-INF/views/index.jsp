<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body>

<h1>Добро пожаловать</h1>
<div class="float:left; width: 60%">
<h3>Последние заказы</h3>
<ul>

</ul>
</div>

<form:form style="float:right;" method="POST" action="/test-mvn-app/login" modelAttribute="loginInfo">
    <h3>Авторизируйтесь</h3>
    <form:input placeholder="username" path="username" id="username"/>
    <form:input placeholder="password" type="password" path="password" id="password"/>
    <input type="submit" value="Log in"/>
</form:form>


</body>
</html>
