<%-- 
    Document   : RegisterBodu
    Created on : 22-07-2022, 17:57:17
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
    <p><bean:message key="Username"/>: ${UBean.name}</p>
     <p><bean:message key="Email"/>: ${UBean.email}</p>
     <p><bean:message key="Password"/>: ${UBean.password}</p>
     <p><bean:message key="Born"/>: ${UBean.born}</p>