<div id="username-page">
    <div class="username-page-container">
        <form id="usernameForm" name="usernameForm">
            <div class="form-group">
                <input type="text" id="name" placeholder="Enter your username" autocomplete="off" class="form-control" />
            </div>
            <div class="form-group">
                <button type="submit" class="accent username-submit">Join Chat</button>
            </div>
        </form>
    </div>
</div>
<div id="chat-page">
	<div class="row" class="hidden">
		<div class="col-md-8 offset-2">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<span class="fas fa-comments"></span> Chat
					<div class="btn-group pull-right">
						<button type="button"
							class="btn btn-default btn-xs dropdown-toggle"
							data-toggle="dropdown">
							<span class="fas fa-chevron-down"></span>
						</button>
						<ul class="dropdown-menu slidedown">
							<li><a href="${contextRoot}/chatroom"> <span
									class="fas fa-power-off"></span> Sign Out
							</a></li>
						</ul>
					</div>
				</div>
				<ul id="messageArea">

				</ul>
				<form id="messageForm" name="messageForm" nameForm="messageForm">
					<div class="form-group">
						<div class="input-group clearfix">
							<input type="text" id="message"
								placeholder="Type your message here..." autocomplete="off"
								class="form-control" />
							<button type="submit" class="btn btn-warning btn-sm"
								id="btn-chat">Send</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>