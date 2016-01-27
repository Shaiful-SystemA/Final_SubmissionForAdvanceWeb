$(document).ready(function() {
	var socket = null;
        
        var cardCount = 1;
//        var test = $("input:radio[name==gid]").val();
//        console.log(gid);

	$("#connectBtn").on("click", function() {
		socket = new WebSocket("ws://localhost:8080/caUno/chat/"
			 	+ $("#gid").val());
                        alert("waiting to connect");
                
		socket.onopen = function() {
			$("#uppercase-msg").text("connected");
                }//onOpen
                
//                var msg = JSON.parse(evt.data);
//                //alert(msg.cardId);
//                document.getElementById("#uppercase-msg").innerHTML = msg.status; 
//                
//                var arr = JSON.parse(evt.data);
//            
//                var select = document.getElementById("listofgamenames");
//                select.innerHTML = "";
//
//                for(var i = 0; i < arr.length; i++)
//                {
//                    //alert(arr[i]);
//                    var gamerooms = arr[i];
//                    var el = document.createElement("option");
//                    el.textContent = gamerooms;
//                    el.value = gamerooms;
//                    select.appendChild(el);
//                }  
                
                
		socket.onmessage = function(evt) {
			var msg = JSON.parse(evt.data);	
                        console.log(evt.data);
                        
                        if (msg.cmd == "init"){
                            var el1 = document.createElement('img');
//                                el1.id = img1; //+ cardCount;
                                el1.src = "../images/" + msg.card1;
                                el1.style="visibility:visible";
                                $("#cardDisplay").append(el1);
                                $("#cardDisplay").on('click',function(){
                                    $("#"+el1.id).hide();
                                    send(el1.id);
                                });
                                cardCount++;
                                
                            var el2 = document.createElement('img');
//                                el2.id = img2; //+ cardCount;
                                el2.src = "../images/" + msg.card2;
                                el2.style="visibility:visible";
                                $("#cardDisplay").append(el2);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el2.id).hide();
//                                    send(el2.id);
//                                });
                                cardCount++;
                            var el3 = document.createElement('img');
//                                el3.id = img3; //+ cardCount;
                                el3.src = "../images/" + msg.card3;
                                el1.style="visibility:visible";
                                $("#cardDisplay").append(el3);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el3.id).hide();
//                                    send(el3.id);
//                                });
                                cardCount++;
                            var el4 = document.createElement('img');
//                                el4.id = img4; //+ cardCount;
                                el4.src = "../images/" + msg.card4;
                                el4.style="visibility:visible";
                                $("#cardDisplay").append(el4);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el4.id).hide();
//                                    send(el4.id);
//                                });
                                cardCount++;
                            var el5 = document.createElement('img');
//                                el5.id = img5; //+ cardCount;
                                el5.src = "../images/" + msg.card5;
                                el5.style="visibility:visible";
                                $("#cardDisplay").append(el5);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el5.id).hide();
//                                    send(el5.id);
//                                });
                                cardCount++;
                            var el6 = document.createElement('img');
//                                el6.id = img6; //+ cardCount;
                                el6.src = "../images/" + msg.card6;
                                el6.style="visibility:visible";
                                $("#cardDisplay").append(el6);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el6.id).hide();
//                                    send(el6.id);
//                                });
                                cardCount++;
                            var el7 = document.createElement('img');
//                                el7.id = img7; //+ cardCount;
                                el7.src = "../images/" + msg.card7;
                                el7.style="visibility:visible";
                                $("#cardDisplay").append(el7);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el7.id).hide();
//                                    send(el7.id);
//                                });
//                                cardCount++;
                        }//init
                        
                        if (msg.cmd == "draw"){
//                            Console.log(msg);
                            var el21 = document.createElement('img');
//                                el21.id = img21; //+ cardCount;
                                el21.src = "../images/" + msg.card1;
                                el21.style="visibility:visible";
                                $("#cardDisplay").append(el21);
//                                $("#cardDisplay").on('click',function(){
//                                    $("#"+el1.id).hide();
//                                    send(el1.id);
//                                });
//                                cardCount++;
                                
                        }//draw
                       
//                        var $li = $("<li>");
//			$li.text("[" + msg.name + "] " + msg.message);
//			$("#chats").prepend($li);

		}//onMessage
	});
        
        $("#joinBtn").on("click", function() {
		var msg = {
			name: $("#name").val(),
			room: $("#room").val(),
			message: "Join"
		}
		socket.send(JSON.stringify(msg));
	})
        
        $("#drawBtn").on("click", function() {
		var msg = {
			name: $("#name").val(),
			room: $("#room").val(),
			message: "Draw"
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
        
//        $("#cardDisplay").on("click", function() {
//                //alert(x.value);
//                var msg = { name: $("#name").val(),
//                            room: $("#gid").val(),
//                            message: $("#msg").val(),
//                            card1: $(this).val(), 
//		}
//                socket.send(JSON.stringify(msg));
//        })
        
        function send(target){            

            var msg = { name: $("#name").val(),
                        room: $("#gid").val(),
                        message: "Throw",
                        card1: target.valueOf(), 
		}
                socket.send(JSON.stringify(msg));
            //alert(1)
            
        }

              
})//document.ready

