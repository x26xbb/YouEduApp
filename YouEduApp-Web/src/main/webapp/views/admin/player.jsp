<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title><spring:message code="label.title"/></title>
    </head>
    <body>
        <h2>YouTube Player Manager</h2>

        <form:form method="post" action="admin/player/submit" commandName="YouTubePlayerVO">  
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
            </table>
        </form:form>

    </body>
</html>