<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/header.jsp"/>


<script type="text/javascript">
    $(function() {
        $('.header-section').html('<h1>Video Manager</h1>');
    });
</script>

<h3>Videos</h3>
<c:if  test="${!empty videoList}">
    <table class="data pure-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>YouTubeID</th>
                <th>Date Created</th>
                <th>Category</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <c:forEach items="${videoList}" var="video">
            <tr>
                <td>${video.videoName}</td>
                <td>${video.videoDescription}</td>
                <td>${video.videoURL}</td>
                <td>${video.dateCreated}</td>
                <td>${video.category}</td>
                <td><a href="video/delete/${video.id}">delete</a></td>                        
            </tr>
        </c:forEach>
    </table>
</c:if>
<br/>

<form:form method="post" action="video/add" commandName="video" class="pure-form pure-form-stacked">
    <fieldset>
        <legend>Adding a new Video</legend>
        <form:input path="videoName" placeholder="Video Name" />
        <br/>
        <form:textarea path="videoDescription" placeholder="Video Description" rows="2" cols="80%" />
        <br/>
        <form:textarea path="videoURL" placeholder="YouTube Video Link"  rows="2" cols="80%" />
        <br/>
        <form:label path="category">Category</form:label>
        <form:select path="category" id="category">
            <form:option  value="${DEFAULT_CATEGORY}">Nothing Selected!</form:option>
            <form:options items="${categoryList}" itemValue="categoryId" itemLabel="categoryName" />
        </form:select>  
        <br/>
        <input type="submit" value="Add Video"  class="pure-button pure-button-primary"/>
    </fieldset>
    	
</form:form>

<jsp:include page="includes/footer.jsp"/>
