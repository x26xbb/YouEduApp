<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title><spring:message code="label.title"/></title>
    </head>
    <body>

        <h2>Video Manager</h2>

        <form:form method="post" action="video/add" commandName="video">

            <table>
                <tr>
                    <td><form:label path="videoName"><spring:message code="label.videoName"/></form:label></td>
                    <td><form:input path="videoName" /></td> 
                </tr>
                <tr>
                    <td><form:label path="videoDescription"><spring:message code="label.videoDescription"/></form:label></td>
                    <td><form:input path="videoDescription" /></td>
                </tr>
                <tr>
                    <td><form:label path="videoURL"><spring:message code="label.videoURL"/></form:label></td>
                    <td><form:input path="videoURL" /></td>
                </tr>
                <tr>
                    <td> 
                         <form:select path="categoryParent">
                            <form:option  value="${DEFAULT_CATEGORY}">Nothing Selected!</form:option>
                            <form:options items="${categoryList}" itemValue="categoryId" itemLabel="categoryName" />
                        </form:select>                 
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="<spring:message code="label.addVideo"/>"/>
                    </td>
                </tr>
            </table>	
        </form:form>


        <h3>Video</h3>
        <c:if  test="${!empty videoList}">
            <table class="data">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>URL</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${videoList}" var="video">
                    <tr>
                        <td>${video.videoName}</td>
                        <td>${video.videoDescription}</td>
                        <td>${video.videoURL}</td>
                        <td><a href="video/delete/${video.id}">delete</a></td>                        
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>