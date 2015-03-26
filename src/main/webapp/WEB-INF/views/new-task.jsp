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
        <form:form method="POST" action="task-creation" modelAttribute="createTaskInfo" role="form">
            <h3>Создание новой задачи</h3>
            <div class="form-group">
                <label for="username">Заголовок</label>
                <form:input class="form-control" placeholder="текст заголовка" path="title" id="title"/>
            </div>
            <div class="form-group">
                <label for="password">Описание</label>
                <form:textarea class="form-control" placeholder="текст описания" path="description" id="description"/>
            </div>
            <div class="form-group">
                <label for="password">Срок выполнения, до:</label>
                <form:input class="form-control" placeholder="дата" type="date" path="deadline" id="deadline"/>
            </div>
            <div class="form-group">
                <label for="password">Вознаграждение</label>
                <form:input class="form-control" type="number" placeholder="сумма в евро" path="bounty" id="bounty"/>
            </div>
            <input class="btn btn-default" type="submit" value="Создать"/>
        </form:form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
