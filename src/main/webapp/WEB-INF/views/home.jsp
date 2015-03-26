<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="toolbar.jsp"/>
<div class="container">
    <h1>Добро пожаловать, <a href="profile/${username}">${username}</a></h1>
    <h3>Ваши последние заказы</h3>
    <ul>
        <c:forEach var="task" items="${myTasks}">
            <li><a href="task/${task.id}">${task.title} / $${task.bounty}</a></li>
        </c:forEach>
    </ul>
    <a href="new-task">Создать задачу</a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
