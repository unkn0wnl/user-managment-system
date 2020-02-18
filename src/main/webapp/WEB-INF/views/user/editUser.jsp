<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Edit</title>
    </head>
    <body>
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout"/>">Logout</a>
        </sec:authorize>
        <div class="form ${error != null ? 'has-error' : ''}">
            <form:form method="POST" modelAttribute="editForm" class="form-signin">
                <h2 class="text-center">Edit User</h2>
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
                <spring:bind path="enabled">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <a>Status</a>
                        <form:select path="enabled">
                            <form:option value="true">ACTIVE</form:option>
                            <form:option value="false">INACTIVE</form:option>
                        </form:select>
                        <div class="error">
                            <span><form:errors path="enabled"/></span>
                        </div>
                    </div>
                </spring:bind>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
            </form:form>
    </body>
</html>