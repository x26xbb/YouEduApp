<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/header.jsp"/>
        <h2>YouTube Player Manager</h2>

        <form:form method="post" action="player/submit" commandName="youTubePlayerVO">  
            <table>
                <tr>
                    <td>Do you want to Hide the Player Controls :</td>
                    <td><form:checkbox path="hideControls" /></td>                   
                </tr>
                <tr>
                    <td>Do you want the videos to auto play? :(Only for desktop)</td>
                    <td><form:checkbox path="autoPlay" /></td>                   
                </tr>
                <tr>
                    <td>Do you want the player to Hide the Video Info? :</td>
                    <td><form:checkbox path="hideInfo" /></td>                   
                </tr> 
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form:form>
<jsp:include page="includes/footer.jsp"/>