<%-- 
    Document   : header
    Created on : Jun 13, 2014, 1:41:25 PM
    Author     : o.villalobos.alfaro
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rootContext = application.getContextPath();
    String resourcesContext = rootContext + "/resources/";
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Proto YouEduApp</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width,height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, minimal-ui">
        <meta name="HandheldFriendly" content="True">
        <meta name="mobile-web-app-capable" content="yes">        
        <link rel="stylesheet" type="text/css" href="<%= resourcesContext + "css/style.css"%>" media="screen" />
        <link rel="stylesheet" href="<%= resourcesContext + "css/libs/animate/animate.css"%>" />

    </head>
    <body>
        <div  id="wrapper">
            <div id="header">
                <div class="menu_icon_box box_left">          
                    <div class="menu_icon menu_icon_image menu_icon_image_opened"></div>
                    <!--                    <div class='menu_icon'><div><span>Aspect ratio 1:1</span></div></div>-->
                </div>
                <div class="menu_icon_box box_right"> 
                    <div class='menu_icon menu_icon_admin config_icon_image'></div>
                </div>
            </div>


            <div id="mainmenu">
                <ul>

                    <c:forEach var="item" items="${menu_objects}">
                        <c:if test="${item.type == TYPE_CATEGORY}">
                            <li class='has-sub'><a href='#'><span>${item.categoryName}</span></a>
                                <ul>
                                    <c:forEach var="elem" items="${item.objects}">
                                        <c:if test="${elem.type == TYPE_CATEGORY}">
                                            <li class='has-sub'><a href='#'><span>${elem.categoryName}</span></a>
                                                <ul>
                                                    <c:forEach var="vid" items="${elem.videos}">
                                                        <li class='active'><a href='<%= rootContext %>/video/${vid.id}'><span>${vid.videoName}</span></a></li>
                                                                </c:forEach>
                                                </ul>
                                            </c:if>
                                            <c:if test="${elem.type == TYPE_VIDEO}">
                                            <li class='active'><a href='<%= rootContext %>/video/${elem.id}'><span>${elem.videoName}</span></a></li>
                                                    </c:if>
                                                </c:forEach>
                                </ul>
                            </c:if>
                            <c:if test="${item.type == TYPE_VIDEO}">
                            <li class='active'><a href='<%= rootContext %>/video/${item.id}'><span>${item.videoName}</span></a></li>
                                    </c:if>
                                </c:forEach>
                </ul>

            </div>
            <script type="text/javascript" src="<%= resourcesContext + "js/libs/jquery/jquery-2.1.1.min.js"%>"></script>
            <script type="text/javascript" src="<%= resourcesContext + "js/script.js"%>" ></script> 
            <script type="text/javascript" src="<%= resourcesContext + "js/libs/hideaddrbar.js"%>" ></script>
            <script type="text/javascript" >
                YouEduAppMenu.context = '<%= rootContext%>';
                YouEduAppMenu.init();
            </script>