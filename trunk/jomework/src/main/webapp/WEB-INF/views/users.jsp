<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Jomework :: Users</title>
	</head> 
	<body>
		<header>Users</header>
		<article><h2>${greet}</h2></article>
		<nav>
			<ul>
				<li>
					<a href="assignments" title="View Users">View assigments</a>
				</li>
				<li>
					<a href="users" title="View users">View users</a>
				</li>
		</nav>
		
		<sf:form method="post" modelAttribute="user">
			<fieldset><legend>New User</legend>			
				<label for="login">Login</label><br />
				<sf:input path="login"  /><br />
				<label for="password">Password</label><br />
				<sf:input path="password" /><br />
				<sf:textarea  path="description" /><br />
			</fieldset>
		</sf:form>
		<c:forEach items="${users}"  var="user" >
			<article>
				<div>${user.login}</div>
				<div>${user.description}</div>
			</article>
		</c:forEach>
	</body>
</html>

