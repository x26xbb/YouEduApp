<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/header.jsp"/>

<script type="text/javascript">
    $(function (){
        $('.header-section').html('<h1>Category Manager</h1>');
    });
</script>

<h3>Categories</h3>
<c:if  test="${!empty categoryList}">
    <table class="data pure-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Category Parent</th>
                <th>Date Created</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <c:forEach items="${categoryList}" var="category">
            <tr>
                <td>${category.categoryName}</td>
                <td>${category.categoryParent}</td>
                <td>${category.dateCreated}</td>
                <td><a href="category/delete/${category.categoryId}">delete</a></td>                        
            </tr>
        </c:forEach>
    </table>
</c:if>

<br/>
<form:form method="post" action="category/add" commandName="category" class="pure-form pure-form-stacked">

    <fieldset>
        <legend>Adding a new Category</legend>

        <form:input path="categoryName"  placeholder="Category Name" />
        <br/>
        <form:label path="categoryParent">Category Parent</form:label>
        <form:select path="categoryParent" id="categoryParent">
            <form:option  value="${DEFAULT_CATEGORY}">Nothing Selected!</form:option>
            <form:options items="${categoryList}" itemValue="categoryId" itemLabel="categoryName" />
        </form:select> 
        <br/>
        <input type="submit" class="pure-button pure-button-primary" value="Add Category"/>

    </fieldset>

</form:form>

<c:if test="${PROCESS_RESULT != null && PROCESS_RESULT == '003'}">
    <span style="color: red;">An error occurred while processing the transaction.</span>
</c:if>



<jsp:include page="includes/footer.jsp"/>