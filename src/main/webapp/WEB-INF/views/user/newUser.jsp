<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add user</title>
    </head>
    <body>
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout"/>">Logout</a>
        </sec:authorize>
        <div class="form ${error != null ? 'has-error' : ''}">
            <form:form method="POST" modelAttribute="registrationForm" class="form-signin">
                <h2 class="text-center">Registration</h2>
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username" class="form-control" placeholder="Username"
                                    autofocus="true"/>
                        <div class="error">
                            <span><form:errors path="username"/></span>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="firstName" class="form-control" placeholder="First Name"
                                    autofocus="true"/>
                        <div class="error">
                            <span><form:errors path="firstName"/></span>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="lastName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="lastName" class="form-control" placeholder="Last Name"
                                    autofocus="true"/>
                        <div class="error">
                            <span><form:errors path="lastName"/></span>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control"
                                    placeholder="Password"/>
                        <div class="error">
                            <span><form:errors path="password"/></span>
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="role">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <a>Role</a>
                        <form:select path="role">
                            <form:option value="ROLE_USER">USER</form:option>
                            <form:option value="ROLE_ADMIN">ADMINISTRATOR</form:option>
                        </form:select>
                        <div class="error">
                            <span><form:errors path="role"/></span>
                        </div>
                    </div>
                </spring:bind>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
            </form:form>
            <p class="text-center small">Already have an account? <a href="/login">Log in now</a>
            </p>
        </div>
    </body>
</html>
