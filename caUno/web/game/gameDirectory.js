$(document).ready(function() {
	var socket = null;
        alert("websocket >>> trying to connect to /chat endpoint");
        
	$("#connectBtn").on("click", function() {
		socket = new WebSocket("ws://localhost:8080/caUno/chat/"
				+ $("#gid").val());
                
                
		socket.onopen = function() {
			$("#uppercase-msg").text("connected");
                }
                    
		socket.onmessage = function(evt) {
			var msg = JSON.parse(evt.data);	
                        var $li = $("<li>");
			$li.text("[" + msg.name + "] " + msg.message);
			$("#chats").prepend($li);

		}
	});
        
        $("#joinBtn").on("click", function() {
		var msg = {
			name: $("#name").val(),
			room: $("#room").val(),
			message: "Join"
		}
		socket.send(JSON.stringify(msg));
	})

	$("#msgBtn").on("click", function() {
		var msg = {
			name: $("#name").val(),
			room: $("#gid").val(),
			message: $("#msg").val()
		}
		socket.send(JSON.stringify(msg));
	})
        
        function getRadioCheckedValue(radio_name)
        {
           var oRadio = document.forms[0].elements[radio_name];

           for(var i = 0; i < oRadio.length; i++)
           {
              if(oRadio[i].checked)
              {
                 return oRadio[i].value;
              }
           }

           return '';
        }
              
              
})




