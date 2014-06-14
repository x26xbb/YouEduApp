<%-- 
    Document   : home
    Created on : Jun 6, 2014, 12:12:20 PM
    Author     : o.villalobos.alfaro
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="includes/header.jsp"/>

<embed id="video" src="${videoPath}"/>

<script type="text/javascript" >
    YouEduAppMenu.video();
</script>

<jsp:include page="includes/footer.jsp"/>

