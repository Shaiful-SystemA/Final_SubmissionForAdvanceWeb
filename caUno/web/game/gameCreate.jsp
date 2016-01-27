<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Game Here</title>
    </head>
    <body>
        <h1>Hello! <%=request.getRemoteUser()%></h1>
        <form method="POST" action="create">
            <table>
                <tr>
                    <td>Number of players:</td>
                            <td>
                                    <input type="text" size="30" name="numPlayers"/>
                            <td>
                </tr>
            </table>
            </br> </br>
            <button type="submit">Create game</button>
	</form>
            </br> </br>
        <form method="POST" action="logout">
            <button type="submit">Logout</button>
        </form>
        
    </body>
</html>
