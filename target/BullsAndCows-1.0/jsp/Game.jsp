<%@page contentType="text/html; charset=UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@page import="java.util.ArrayList" %>
			<html lang="ru">

			<head>
				<title>Game</title>
				<style>
					li {
						list-style-type: none;
					}
				</style>
			</head>

			<body>
<%--				<span>--%>
<%--					<c:out value="${hid}" />--%>
<%--				</span>--%>
				<form action="${pageContext.request.contextPath}" method="get">
					<input type="text" name="userVar" id="">
					<input type="submit" value="Enter">
				</form>
				<ul>
					<c:forEach var="m" items="${result}">
						<li>
							<c:out value="${m}" />
						</li>
					</c:forEach>
					<c:out value="${win}" />
				</ul>
			</body>

			</html>