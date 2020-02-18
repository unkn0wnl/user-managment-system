<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>List of users</title>
    </head>
    <body>
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout"/>">Logout</a>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <a href="user/new">Edit</a>
        </sec:authorize>
        <h1>List of users</h1>
        <table>
            <thead>
                <tr>
                    <td>Username</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Roles</td>
                    <td>Status</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="userAccount" items="${userList}">
                    <tr>
                        <td>
                            <a href="user/${userAccount.id}">${userAccount.username}</a>
                        </td>
                        <td>
                                ${userAccount.firstName}
                        </td>
                        <td>
                                ${userAccount.lastName}
                        </td>
                        <td>
                                ${userAccount.roles.stream()
                                        .findFirst()
                                        .get().getName()
                                        .toString()}
                        </td>
                        <td>${userAccount.enabled eq true ? 'ACTIVE' : 'INACTIVE'}</td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td>
                                <a href="user/${userAccount.id}/edit">Edit</a>
                            </td>
                            <td>
                                <tags:status userId="${userAccount.id}" status="${userAccount.enabled}" name="${userAccount.username}"/>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
