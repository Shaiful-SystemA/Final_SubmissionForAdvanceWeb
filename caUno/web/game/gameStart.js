$(document).ready(function() {
	var socket = null;      
        
        
        
	$("#connectBtn").on("click", function() {
		socket = new WebSocket("ws://localhost:8080/caUno/chat/"
			 	+ $("#gid").val());
                        alert("waiting to connect");
                
		socket.onopen = function() {
			$("#uppercase-msg").text("connected");
                }
                    
		socket.onmessage = function(evt) {
			var msg = JSON.parse(evt.data);
                        console.log(evt.data);
                        
                        if (msg.status == "Waiting") {
                            $("#uppercase-msg").text("waiting");
                        } else {
                        
                        var el1 = document.createElement('img');
                            el1.src = "../images/" + msg.card1;
                            $("#cardDisplay").append(el1);
                        var el2 = document.createElement('img');
                            el2.src = "../images/" + msg.card2;
                            $("#cardDisplay").append(el2);
                        }
                        
			var $li = $("<li>");
			$li.text("[" + msg.name + "] " + msg.message);
			$("#chats").prepend($li);
		}
	});
        
        $("#joinBtn").on("click", function() {
		var msg = {
			name: "GAME TABLE",
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


