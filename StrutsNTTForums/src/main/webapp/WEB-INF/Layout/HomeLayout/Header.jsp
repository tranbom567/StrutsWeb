<%-- 
    Document   : Header
    Created on : Jul 22, 2022, 11:21:03 AM
    Author     : PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Beans.UserBeans"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%!private boolean isLogin=false;%>
<%
UserBeans ub=(UserBeans)request.getAttribute("UserCookie");
if(ub==null||ub.getName()==null||ub.getName().isEmpty())
isLogin=false;
else
isLogin=true;
%>
        <div class="Header">
		<a class="title"><bean:message key="home.title"/></a>
		<div class="header-right">
                    <% if(!isLogin){ %>
	<a href="UserInfo/SignUp.jsp" class="link"><bean:message key="Title"/></a>
		|
		<a href="UserInfo/Login.jsp" class="link"><bean:message key="login"/></a>
                 <%}%>
		<br/>
		</div>
	</div>
	<div class="User">
		<br/>
<div class="User">
    <a href="/UserInfo/Dashboard.jsp"><img class="avatar" src="${Avatar.imagePath}" alt="Avatar"/></a>
<h4><c:out value="${UserCookie.name}" default="Guest"/></h4>
</div>

        
