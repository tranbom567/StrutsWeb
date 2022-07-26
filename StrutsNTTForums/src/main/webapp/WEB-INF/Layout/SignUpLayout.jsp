<%-- 
    Document   : SignUpLayout
    Created on : Jul 21, 2022, 5:43:28 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<% response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="/UserInfo/SignUpDeco.css"/>
        <title><bean:message key="Title"/></title>
</head>

    <body>
    
    <tiles:insert attribute="header" />
    <tiles:insert attribute="body"/>
    <div style="position: fixed;bottom: 0;width: 100%;text-align:center"><tiles:insert attribute="footer"/></div>
    </body>
</html>
