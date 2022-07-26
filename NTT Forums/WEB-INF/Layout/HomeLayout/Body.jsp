<%-- 
    Document   : Body
    Created on : Jul 22, 2022, 11:21:50 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<c:forEach items="${AllForums.forums}" var="ForumsList">
<div class="FormContainer">
    <img class="avatar" src="${ForumsList.avatar}">
    <h4>${ForumsList.username}</h4>
	<p><bean:message key="home.Question"/>: ${ForumsList.content}</p>
        <form action="/SendComment.do" method="post">
            <input type="hidden" value="${ForumsList.forumsid}" name="forumsid"/>
            <textarea name="comment" style="vertical-align: middle"></textarea>
	<button type="submit" style="vertical-align: middle"><bean:message key="home.SendComment"/></button>
	</form>
        <br/>
         <div class="comments">
             <br/>
        <c:forEach items="${ForumsList.comments}" var="comments">
            <hr noshade="true"/>
             
                 
        <p>
             <img class="avatarComment"  src="${comments.avatar}" alt="avatar">
  <span style="vertical-align:middle">${comments.name}: ${comments.comments}</span>
        </p>
     

            
        </c:forEach>
	        </div>
	
	</div>
        <br/><br/>
        </c:forEach>
