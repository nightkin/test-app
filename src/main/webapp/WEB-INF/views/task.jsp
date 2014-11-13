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
    <h1>Ваш заказ №${task.id}</h1>
    <ul>
        <li>${task.title}</li>
        <li>${task.description}</li>
        <li>${task.bounty}</li>
        <li>
            <form:form method="POST" action="delete" modelAttribute="deleteInfo" role="form">
                <form:input type="hidden" value="${task.id}" path="taskID"/>
                <input class="btn btn-default" type="submit" value="удалить"/>
            </form:form>
        </li>
    </ul>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
