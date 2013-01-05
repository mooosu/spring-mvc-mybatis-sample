<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title><fmt:message key="sign_in.title"/></title>
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
        <!--[if lt IE 8]>
                <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
        <![endif]-->
    </head>
    <body>
        <div class="container">
            <h1>
                <fmt:message key="sign_in.title"/>
            </h1>
            <div class="span-12 last">
                <c:url value="/sessions/create" var="create"/>
                <form:form modelAttribute="signIn" action="${create}" method="post">
                    <form:errors cssClass="xxx" />
                    <fieldset>
                        <legend>登陆信息</legend>
                        <p>
                            <form:label	for="username" path="username" cssErrorClass="error">用户名</form:label><br/>
                            <form:input path="username" /> <form:errors path="username" />
                        </p>
                        <p>
                            <form:label for="password" path="password" cssErrorClass="error">密码</form:label><br/>
                            <form:password path="password" /> <form:errors path="password" />
                        </p>
                        <p>
                            <form:label for="captcha" path="captcha" cssErrorClass="error">验证码</form:label><br/>
                            <form:input path="captcha" /> <form:errors path="captcha" />
                        </p>
                        <p>
                            <input type="submit" />
                        </p>
                    </fieldset>
                </form:form>
            </div>
            <hr>
            <ul>
                <li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
            </ul>
        </div>
    </body>
</html>
