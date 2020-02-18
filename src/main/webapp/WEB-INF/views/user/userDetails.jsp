<%@ page import="java.util.Date" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Details</title>
    </head>
    <body>
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout"/>">Logout</a>
        </sec:authorize>
        <table>
            <thead>
            <tr>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tr>
                <td>Username</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>Fist Name</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td>Roles</td>
                <td>${user.roles.stream()
                                .findFirst()
                                .get().getName()
                                .toString()}</td>
            </tr>
            <tr>
                <td>Create At</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${Date.from(user.createAt)}"/></td>
            </tr>
            <tr>
                <td>Status</td>
                <td>${user.enabled eq true ? 'ACTIVE' : 'INACTIVE'}</td>
            </tr>
        </table>
    </body>
</html>
