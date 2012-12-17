<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Create Blog</title>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
	<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
</head>
<body>
<div class="container">
	<h1>
		Create Blog
	</h1>
	<div class="span-12 last">
		<c:url value="/blogs/create" var="abcURL"/> 
		<form:form modelAttribute="blog" action="${abcURL}" method="post">
		  	<fieldset>
				<legend>Blog Fields</legend>
				<p>
					<form:label	for="title" path="title" cssErrorClass="error">Title</form:label><br/>
					<form:input path="title" /> <form:errors path="title" />
				</p>
				<p>
					<form:label for="content" path="content" cssErrorClass="error">Content</form:label><br/>
					<form:input path="content" /> <form:errors path="content" />
				</p>
				<p>
					<form:label for="comment" path="comment" cssErrorClass="error">Comment</form:label><br/>
					<form:input path="comment" /> <form:errors path="comment" />
				</p>
				<p>
					<form:label for="created_at" path="created_at" cssErrorClass="error">Created At</form:label><br/>
					<form:input path="created_at" /> <form:errors path="created_at" />
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
