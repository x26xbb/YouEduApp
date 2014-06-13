<%-- 
    Document   : header
    Created on : Jun 13, 2014, 1:41:25 PM
    Author     : o.villalobos.alfaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rootContext = application.getContextPath();
    String resourcesContext = rootContext + "/resources/";
%>

<!DOCTYPE html>
<html>
    <head>
        <title>YourEduApp Manager</title>
        <meta charset="utf-8">
        <meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <!--<meta name="HandheldFriendly" content="True">-->
        <meta name="apple-mobile-web-app-status-bar-style" content="black">

        <!-- Style Sheets --> 
        <link rel="stylesheet" type="text/css" media="all" href="<%=resourcesContext + "js/libs/trunk/css/reset.css"%>" />
        <link rel="stylesheet" type="text/css" media="all" href="<%=resourcesContext + "js/libs/trunk/css/trunk.css"%>" />

        <!-- Scripts --> 

        <script type="text/javascript" src="<%=resourcesContext + "js/libs/trunk/js/jquery-1.9.js"%>"></script>
        <script type="text/javascript" src="<%=resourcesContext + "js/libs/trunk/js/trunk.js"%>"></script>
    </head>
    <body>
        <div class="container">

            <header class="slide">     <!--	Add "slideRight" class to items that move right when viewing Nav Drawer  -->
                <ul id="navToggle" class="burger slide">    <!--	Add "slideRight" class to items that move right when viewing Nav Drawer  -->
                    <li></li><li></li><li></li>
                </ul>
                <h1>YourEduApp Manager</h1>
            </header>

            <nav class="slide">
                <ul>
                    <li><a href="<%= rootContext + "/admin/"%>" class="active">HOME</a></li>			
                    <li><a href="<%= rootContext + "/admin/category"%>">Categories</a></li>
                    <li><a href="<%= rootContext + "/admin/video"%>">Videos</a></li>
                    <li><a href="<%= rootContext + "/admin/player"%>">Players</a></li>     
                    <li><a href="<%= rootContext + "/"%>">Get Back!</a></li> 
                </ul>
            </nav>

            <div class="content slide">     <!--Add "slideRight" class to items that move right when viewing Nav Drawer  -->
                <ul class="responsive">
                    <li class="header-section">
                        <p class="placefiller">HEADER</p>
                    </li>
                    <li class="body-section">