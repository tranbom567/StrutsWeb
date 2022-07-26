<%-- 
    Document   : HomeLayo
    Created on : Jul 22, 2022, 11:13:40 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html>
<html>
   <head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="/HomeDeco.css"/>
<title>Pie Forum</title>
</head>
    <body>
        <tiles:insert attribute="header"/>
        <tiles:insert attribute="menu"/>
        <hr noshade="true"/>
        <tiles:insert attribute="body"/>
      
    </body>
</html>
