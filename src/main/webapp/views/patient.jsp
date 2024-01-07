<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Patient page</title>
</head>
<body>
<h1>Patient Information:</h1>
<form:form method="post" action="addPatient.html" modelAttribute="patient">

    <table>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName" /></td>
            <td><form:errors path="lastName" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="telephone">Telephone</form:label></td>
            <td><form:input path="telephone" /></td>
            <td><form:errors path="telephone" /></td>
        </tr>
        <tr>
            <td><form:label path="dateOfBirth">Date of Birth</form:label></td>
            <td><form:input path="dateOfBirth" type="date" /></td>
            <td><form:errors path="dateOfBirth" type="date" /></td>
        </tr>
        <tr>
            <td><form:label path="address">Address</form:label></td>
            <td><form:input path="address" /></td>
            <td><form:errors path="address" /></td>
        </tr>
        <tr>
            <td><form:label path="pesel">PESEL</form:label></td>
            <td><form:input path="pesel" /></td>
            <td><form:errors path="pesel" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add Patient"/>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>

