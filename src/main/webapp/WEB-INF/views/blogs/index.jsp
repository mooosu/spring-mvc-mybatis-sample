<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
        <title><fmt:message key="blogs.list"/></title>
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection" />
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"/>
        <!--[if lt IE 8]>
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"/>
        <![endif]-->
    </head>
    <body>
        <shiro:hasPermission name="write">
            
        </shiro:hasPermission>
        <shiro:hasPermission name="read">
            read permission here
        </shiro:hasPermission>
        <c:url var="newUrl" value="blogs/new" />
        <div class="container">
            <h1>
                <fmt:message key="blogs.list"/>
            </h1>
            <table>
                <c:forEach var="blog" items="${blogs}">
                    <tr>
                        <c:url var="showUrl" value="blogs/${blog.id}"/>
                        <c:url var="editUrl" value="blogs/${blog.id}/edit" />
                        <c:url var="deleteUrl" value="blogs/${blog.id}/delete"/>
                        <td>${blog.title}</td>
                        <td>${blog.content}</td>
                        <td>${blog.comment}</td>
                        <td>${blog.created_at}</td>
                        <td>
                            <a href='<c:out value="${showUrl}"/>'><fmt:message key="button.show"/></a>
                        </td>
                        <td>
                            <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                        <a href='<c:out value="${deleteUrl}" />'><fmt:message key="button.delete"/></a>
                    </sec:authorize>
                    </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <a href='<c:out value="${newUrl}"/>'><fmt:message key="button.new"/></a>
            </div>
            ${pager.currentPage}
        </div>
        <hr>
        <ul>
            <li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
        </ul>
    </body>
</html>

