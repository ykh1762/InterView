<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <a class="navbar-brand" href="/timeline" style="padding-top: 8px;"><img alt="" src="/images/logo/linkedin.png"></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          	<li style=" width: 410px; height: 34px; padding-top: 8px;">
	          	<div class="searchbox">
				  <div class="searchgroup">
				      <input type="search" id="search" placeholder="검색"/>
				      <button class="icon"><i class="fa fa-search"></i></button>
				  </div>
				  	<div id="dropdownSearch">
					</div>
				</div>
          	</li>
            <li class="menu">
            	<a href="/timeline" class="menugroup" style="padding-top: 7px;">
            		<div><span style="font-size: 20px;"><i class="fas fa-home"></i></span></div>
            		<div>홈</div>
            	</a>
            </li>
            <li class="menu">
            	<a href="/personalConnection" class="menugroup" style="padding-top: 7px;">
            		<div><span style="font-size: 20px;"><i class="fas fa-users"></i></span></div>
            		<div>인맥</div>
            	</a>
            </li>
            <li class="menu">
            	<a href="/recruit" class="menugroup" style="padding-top: 7px;">
            		<div><span style="font-size: 20px;"><i class="fas fa-briefcase"></i></span></div>
            		<div>채용공고</div>
            	</a>
            </li>
            <li class="menu">
            	<a href="/mailHome" class="menugroup" style="padding-top: 7px;">
            		<div><span style="font-size: 20px;"><i class="far fa-comment-dots"></i></span></div>
            		<div>메일</div>
            	</a>
            </li>
            <li class="menu">
            	<a href="/alarm" class="menugroup" style="padding-top: 7px;">
            		<div><span style="font-size: 20px;"><i class="fas fa-bell"></i></span></div>
            		<div>알람</div>
            	</a>
            </li>
            <li class="menu profile">
			  	<a href="#" id="profile" class="menugroup" style="padding-top: 7px;">
            		<div><span style="font-size: 20px;"><i class="fas fa-user-circle"></i></span></div>
            		<div>나</div>
           		</a>
			  	<div id="dropdownProfile">
				  	
				</div>
          	</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
 </nav>

<script src="/js/sockjs.js"></script>
<script>
var socket = null;

// $(document).ready(function() {
// 	connectWS();
// 	sendMessege();
// });

// let ws2 = new SockJS("<c:url value="/timeline"/>");
// ws2.onmessage = onMessage;
// ws2.onclose = onClose;

// function sendMessege() {
// 	console.log("connect");
// }

// function onMessage(msg) {
// 	var data = msg.data;
// 	console.log(data);
// }

// function onClose(event) {
// 	console.log("disconnect");
// }


function connectWS() {
	var ws = new WebSocket("ws://localhost/echo");
	
	socket = ws;
	
	ws.onopen = function() {
		console.log("connect");
	};
	
	ws.onmessage = function(e) {
		console.log("msg : ", e.data + '\n');
	};
	
	ws.onclose = function() {
		console.log("disconnect");
	};
}

 </script>