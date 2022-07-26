<%-- 
    Document   : AskQuestionBody
    Created on : Jul 25, 2022, 6:23:22 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<form action="AskQuestion.do" method="post">

    <p><bean:message key="content"/></p>
        <html:messages id="msg" property="content">
        <p style="color:red"><bean:write name="msg"/></p>
    </html:messages>
		<textarea name="content" ></textarea>
		<br/>
		<button type="submit" class="AddCFSButton">Ask Question</button>
	</form>
