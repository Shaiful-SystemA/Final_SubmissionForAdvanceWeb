<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player</title>
        <script type='text/javascript' src="../lib/jquery-2.2.0.js"></script>
        <script type='text/javascript' src="gameOn.js"></script>
        <script>
                    function myFunction() {
                        document.getElementById("room").value = document.getElementById("gid").value;
                    }
        </script>
    </head>
    <body>
        <h1>Welcome! <%=request.getRemoteUser()%></h1>
        <p> Select game to join from list below by clicking radio button on the side </p>
        </br> </br>

        <form id="listGames" method="Post" action="joinPlayer">
            <c:forEach var="game_id" items="${applicationScopedGameBean.getAllGameIDFromMap()}">
                <li id="gameId">
                    ${game_id.getGameID()} <input type="radio" name="gid" value="${game_id.getGameID()}"> </h2> 
                    
                </li <Hr/>
            </c:forEach>
            </br> </br>
            <button type="submit" style="display: none;"> Reserved for future development</button>
        </form>

        Player Name: 
        <input type="text" id="name" size="30" value="<%=request.getRemoteUser()%>"></br></br>
        Selected Game ID: 
        <input type="text" id="room" size="30" value="$("input:radio[name==gid]").val()">
        <button onclick="myFunction()">Copy Text</button>
        <button type="button" id="connectBtn">Connect to game server</button>
        </br></br>

        <div id="uppercase-msg"></div>
        </br></br>

        <button type="button" id="joinBtn">Join Game</button>
        </br></br>

        Text: 
        <input type="text" id="msg" size="30" value="">
        <button type="button" id="msgBtn">Chat</button>
        <br>

        <br>
        <ul id="chats">
        </ul>

        <div id="cardDisplay"></div>
        
        </br></br>
        <button type="button" id="drawBtn">Draw</button>
        
    </body>

</html>







<form id="navButtons" method="POST" action="logout">
    <button type="submit">Logout</button>
</form>
</body>
</html>
