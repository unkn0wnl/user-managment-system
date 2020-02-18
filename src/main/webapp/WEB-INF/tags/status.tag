<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="status" required="true" %>
<%@ attribute name="userId" required="true" %>
<%@ attribute name="name" required="true" %>
<form method="post" action="/user/${userId}?lock=${!status}">
    <sec:authorize var="loggedIn" access="isAuthenticated()">
        <c:choose>
            <c:when test="${loggedIn}">
                <c:if test="<%= !request.getUserPrincipal().getName().equals(name) %>">
                    <button type="submit">${status eq true ? 'Lock' : 'Unlock'}</button>
                </c:if>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </sec:authorize>
</form>