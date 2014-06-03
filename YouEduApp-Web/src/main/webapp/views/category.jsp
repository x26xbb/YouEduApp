<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title><spring:message code="label.title"/></title>
    </head>
    <body>

        <h2>Category Manager</h2>

        <form:form method="post" action="category/add" commandName="category">

            <table>
                <tr>
                    <td>Category Name</td>
                    <td><form:input path="categoryName" /></td> 
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
        
        <c:if test="${PROCESS_RESULT != null && PROCESS_RESULT == '003'}">
            <span style="color: red;">An error occurred while processing the transaction.</span>
        </c:if>


        <h3>Categories</h3>
        <c:if  test="${!empty categoryList}">
            <table class="data">
                <tr>
                    <th>Name</th>
                    <th>Category Parent</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${categoryList}" var="category">
                    <tr>
                        <td>${category.categoryName}</td>
                        <td>${category.categoryParent}</td>

                        <td><a href="category/delete/${category.categoryId}">delete</a></td>                        
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>