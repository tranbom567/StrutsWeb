<%-- 
    Document   : Body
    Created on : Jul 22, 2022, 11:21:50 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<div class="FormContainer">	
	<p><bean:message key="home.Question"/>: </p>
	<p><bean:message key="home.comments"/>: </p>
	<p>User: comment</p>
	<form action="" method="post">
		<input type="text"/>
	<button type="submit"><bean:message key="home.SendComment"/></button>
	</form>
	<br/>
	</div>
