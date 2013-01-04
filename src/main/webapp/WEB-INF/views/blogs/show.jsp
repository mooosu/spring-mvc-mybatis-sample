<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title><fmt:message key="blogs.show"/></title>
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
        <!--[if lt IE 8]>
                <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
        <![endif]-->
    </head>
    <body>
        <c:url var="newUrl" value="new" />
        <c:url var="listUrl" value="./" />
        <div class="container">
            <h1>
                <fmt:message key="blogs.show"/>
            </h1>
            <div class="span-12 last">	
                <form:form modelAttribute="blog" action="${blog.id}" method="post">
                    <fieldset>		
                        <legend>Blog Fields</legend>
                        <p>
                            <form:label	for="title" path="title">Title</form:label><br/>
                            <form:input path="title" readonly="true"/>		
                        </p>
                        <p>	
                            <form:label for="content" path="content">Content</form:label><br/>
                            <form:input path="content" readonly="true"/>
                        </p>
                    </fieldset>
                </form:form>
            </div>
            <br class="clear"/>
            <div>
                <a href='<c:out value="${newUrl}"/>'><fmt:message key="button.new"/></a>|
                <a href='<c:out value="${listUrl}"/>'><fmt:message key="button.back"/></a>
            </div>
            <hr>
            <ul>
                <li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
            </ul>	
        </div>
    </body>
</html>
