<%-- 
    Document   : Body
    Created on : Jul 21, 2022, 6:11:51 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

 
 <form action="SignUp.do" method="post" class="SignUpForm">
            <bean:message key="Username"/>
            <br/>
            <html:messages id="msg" property="name">
                <p style="color: red"><bean:write name="msg"/></p>
            </html:messages>
          
	<input type="text" class="input" name="name" value="${UBean.name}" x-webkit-speech/>
		<br/><br/>
		 <bean:message key="Email"/>
                 <br/>
                   <html:messages id="msg" property="email">
                <p style="color: red"><bean:write name="msg"/></p>
            </html:messages>
                
		
			<input type="text" class="input" name="email" value="${UBean.email}" x-webkit-speech/>
		<br/><br/>
		 <bean:message key="Born"/>
                  <br/>
          <html:messages id="msg" property="born">
                <p style="color: red"><bean:write name="msg"/></p>
            </html:messages>
		
			<input type="date" class="input" name="born" value="${UBean.born}" x-webkit-speech/>
		<br/><br/>
		 <bean:message key="Password"/>
                    <br/>
           <html:messages id="msg" property="password">
                <p style="color: red"><bean:write name="msg"/></p>
            </html:messages>
			<input type="text" class="input" name="password" value="${UBean.password}" x-webkit-speech/>
		<br/><br/>
                <button type="submit" class="SignUpButton"><bean:message key="submit"/></button>
	</form>
  
