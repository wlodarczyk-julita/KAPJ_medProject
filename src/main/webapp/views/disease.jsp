<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Disease page</title>
</head>
<body>
<h1>Disease Information:</h1>
<form:form method="post" action="addDisease.html" modelAttribute="disease">

    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description" /></td>
            <td><form:errors path="description" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add Disease"/>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>

