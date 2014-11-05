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
    <div class="col-lg-4">
        <form:form method="POST" action="/test-mvn-app/registration" modelAttribute="registerInfo" role="form">
            <h3>Регистрация на портале</h3>
            <c:if test="${not empty error}">
                <p class="bg-warning">${error}</p>
            </c:if>
            <div class="form-group ${loginTaken ? 'has-error' : ''}">
                <label for="username">Желаемый логин</label>
                <form:input class="form-control" placeholder="username" path="username" id="username"/>
            </div>
            <div class="form-group">
                <label for="password">Сложный пароль</label>
                <form:input class="form-control" placeholder="password" type="password" path="password" id="password"/>
            </div>
            <div class="form-group">
                <div class="checkbox">
                    <label>
                        <form:checkbox id="role" value='employer' path="role"/>
                        Я — заказчик
                    </label>
                </div>
            </div>
            <input class="btn btn-default" type="submit" value="Авторизироваться"/>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
