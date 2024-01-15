<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="navbar.jsp" %>
<html>
<head>
    <title>Registration Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        #register-container {
            width: 300px;
            margin: 0 auto;
            margin-top: 50px;
        }

        #register-box {
            width: 100%;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        .flag-container {
            margin-bottom: 10px;
        }

        input[type="text"], input[type="password"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        select {
            padding: 8px;
        }
        .login-link {
            color: #007bff;
            text-decoration: none;
        }

        .error {
            color: #a94442;
            background-color: #f2dede;
            border: 1px solid #ebccd1;
            padding: 8px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div id="register-container">
    <div id="register-box">
        <h3>Registration</h3>
<form:form method="post" action="addPatient.html" modelAttribute="patient">

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <table>
        <tr>
            <td><spring:message code="label.firstName" /></td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="firstName" /></td>
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
    </div>
</div>
</body>
</html>

