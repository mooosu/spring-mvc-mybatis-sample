<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<META http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
		<title>@Controller Example</title>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection" />
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"/>
		<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"/>
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<h1>
				Blogs
			</h1>
			<table>
				<c:forEach var="blog" items="${blogs}">
					<tr>
						<c:url var="editUrl" value="${blog.id}/edit">
						</c:url>
						<c:url var="deleteUrl" value="${blog.id}/delete">
						</c:url>
						<td>${blog.title}</td>
						<td>${blog.content}</td>
						<td>${blog.comment}</td>
						<td>${blog.created_at}</td>
						<td>
							<a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
							<sec:authorize ifAllGranted="ROLE_ADMIN">
								<a href='<c:out value="${deleteUrl}" />'><fmt:message key="button.delete"/></a>
							</sec:authorize>
						</td>
					</tr>
				</c:forEach>
			</table>
				${pager.currentPage}
		</div>
		<hr>
			<ul>
				<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
			</ul>
		</div>
	</body>
</html>

