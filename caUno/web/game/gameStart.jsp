

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Table</title>
        <script type='text/javascript' src="../lib/jquery-2.2.0.js"></script>
        <script type='text/javascript' src="gameStart.js"></script>
    </head>
    <body>
        <h1 id="name">GAME TABLE</h1>
        <h2><%=request.getRemoteUser()%>, this is Game Table</h2>
       
        <h2>Game Id: ${gameid}</h2>
        </br>

        <input type="hidden" id="room" value="${gameid}"/>
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
            <ul id="chats"><li></li>
            </ul>
        
            <div id="cardDisplay"></div>
            
        <button type="submit">Logout</button>
        
        
    </body>
</html>
