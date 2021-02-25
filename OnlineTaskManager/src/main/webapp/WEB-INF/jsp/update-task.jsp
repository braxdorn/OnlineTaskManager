<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
</head>

<body>
<h1>Update Task</h1>
<br />

<form:form method="post">
        <label for="name">Task Name:</label>
        <input type="text" id="name" name="name" value="${task.name}">
    <br>
    <br>
        <label for="startdate">Start Date:</label>
        <input type="date" id="startdate" name="startDate" value=<fmt:formatDate pattern = "yyyy-MM-dd" value = "${task.startDate}" />>
    <br>
    <br>
        <label for="enddate">End Date:</label>
        <input type="date" id="enddate" name="endDate" value=<fmt:formatDate pattern = "yyyy-MM-dd" value = "${task.endDate}" />>
    <br>
    <br>
        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="4" cols="50" >${task.description}</textarea>
    <br>
    <br>
        <label for="severity">Severity:</label>
        <select name="severity" id="severity">
            <option value="high" <c:if test="${task.severity == 'high'}">selected</c:if>>High</option>
            <option value="medium" <c:if test="${task.severity == 'medium'}">selected</c:if>>Medium</option>
            <option value="low" <c:if test="${task.severity == 'low'}">selected</c:if>>Low</option>
        </select>
    <br>
    <br>
        <input type="submit" value="Submit">
    <br>

</form:form>
</body>
</html>