<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <div class="form ${error != null ? 'has-error' : ''}">
            <form action="login" method="post">
                <h2 class="text-center">Login</h2>
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
                <c:if test="${not empty errorMessage}">
                    <div class="error">
                        <c:out value="${errorMessage}"/>
                    </div>
                </c:if>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>
                </div>
            </form>
        </div>
    </body>
</html>
