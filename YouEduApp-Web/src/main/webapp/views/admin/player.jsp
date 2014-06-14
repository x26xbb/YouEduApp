<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/header.jsp"/>

<script type="text/javascript">
    $(function() {
        $('.header-section').html('<h1>YouTube Player Manager</h1>');
    });
</script>


<form:form method="post" class="pure-form pure-form-stacked" action="player/submit" commandName="youTubePlayerVO"> 
    <fieldset>
        <legend>Video Player Settings</legend>

        <form:label path="hideControls" class="pure-checkbox">
            <form:checkbox path="hideControls" id="hideControls" />Do you want to Hide the Player Controls           
        </form:label>
        <br/>

        <form:label path="autoPlay" class="pure-checkbox">
            <form:checkbox path="autoPlay" id="autoPlay"/>Do you want the videos to auto play?(Only for desktop)
        </form:label>
        <br/>
        <form:label path="hideInfo" class="pure-checkbox">
            <form:checkbox path="hideInfo" id="hideInfo" />Do you want the player to Hide the Video Info?
        </form:label>
        <br/>
        <input type="submit" value="Save" class="pure-button pure-button-primary"/>
    </fieldset>
</form:form>
<jsp:include page="includes/footer.jsp"/>