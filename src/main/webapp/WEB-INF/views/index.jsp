<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="toolbar.jsp"/>
<div class="container">
    <div class="col-md-8">
        <h1>Добро пожаловать</h1>
        <h3>Открытые заказы</h3>
        <ul>
            <c:forEach var="task" items="${openTasks}">
                <li>${task.title} / $${task.bounty}</li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-md-4">
        <form:form method="POST" action="login" modelAttribute="loginInfo" role="form">
            <h3>Авторизируйтесь <small>/ <a href="register">регистрация</a></small></h3>
            <div class="form-group">
                <label for="username">Логин</label>
                <form:input class="form-control" placeholder="username" path="username" id="username"/>
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <form:input class="form-control" placeholder="password" type="password" path="password" id="password"/>
            </div>
            <input class="btn btn-default" type="submit" value="Авторизироваться"/>
        </form:form>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
