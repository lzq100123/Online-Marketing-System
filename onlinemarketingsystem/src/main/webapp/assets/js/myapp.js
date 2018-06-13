$(function() {
	// solving the active menu problem
	switch (menu) {

	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Chat Room':
		$('#chat').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if ((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}

	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPprice',
								mRender : function(data, type, row) {
									return '&#36;' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1)
										return '<span style="color:red">Out of Stock!</span>';
									return data;
								}
							},
							{
								data : 'id',
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="far fa-eye"></span></a> &#160;';
									if (userRole == 'ADMIN') {
										str += '<a href="'
												+ window.contextRoot
												+ '/manage/'
												+ data
												+ '/product" class="btn btn-warning"><span class="fas fa-pencil-alt"></span></a>';
									} else {
										if (row.quantity < 1)
											str += '<a href="javascript.void(0)" class="btn btn-success"><span class="fas fa-cart-arrow-down"></span></a>';
										else {
											str += '<a href="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/product" class="btn btn-success"><span class="fas fa-cart-arrow-down"></span></a>';
										}
									}

									return str;
								}
							} ]
				});
	}
	
	
	// dataTable for chat room
	var $chattable = $('#chatroomListTable');

	// execute the below code only where we have this table
	if ($chattable.length) {
		var jsonUrl = window.contextRoot + '/json/data/all/chatrooms';

		$chattable
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
					           {
					        	   data: 'id'
					           },
							{
								data : 'name'
							},
							{
								data : 'description'
							},
							{
								data : 'type',
							},
							{
								data : 'id',
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/chatroom" class="btn btn-primary"><span class="fas fa-user-plus"></span></a> &#160;';

									return str;
								}
							} ]
				});
	}
	

	// dismissing the alert after 3 seconds
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow')
		}, 3000)
	}

	// Toggle switch prompt

	/**
	 * Data table for admin
	 */
	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductsTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1)
										return '<span style="color:red">Out of Stock!</span>';
									return data;
								}
							},
							{
								data : 'unitPprice',
								mRender : function(data, type, row) {
									return '&#36;' + data;
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '" checked="checked"><div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.id
												+ '"><div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="fas fa-pencil-alt"></span>';
									str += '</a>';

									return str;
								}
							} ],
					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the product'
													: 'You want to deactivate the product';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activate & Deactivate',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																console
																		.log(value);
																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : "medium",
																								title : "Information",
																								message : data
																							});
																				});

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}

													})
										})
					}
				});
	}

	// validation code for category
	var $categoryForm = $('#categoryForm');
	if ($categoryForm.length) {
		$categoryForm
				.validate({
					rules : {
						name : {
							required : true,
							minlength : 2
						},
						description : {
							required : true
						}
					},
					messages : {
						name : {
							required : 'Please add the category name!',
							minlength : 'The category name should not be less than 2 characters'
						},
						description : {
							required : 'Please add description for the category!'
						}
					},
					errorElement : 'em',
					errorPlacement : function(error, element) {
						// add the class of help-block
						error.addClass('help-block');
						// add error element after the input element
						error.insertAfter(element);
					}
				});
	}

	// validation code for login
	var $loginForm = $('#loginForm');
	if ($loginForm.length) {
		$loginForm.validate({
			rules : {
				username : {
					required : true,
					email : true
				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter the user name!',
					email : 'please enter valid email address!'
				},
				password : {
					required : 'Please enter the password!'
				}
			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add error element after the input element
				error.insertAfter(element);
			}
		});
	}

	
	//handling the click refreshCart
	$('button[name="refreshCart"]').click(function() {
		
		//fetch the cartLine id
		var cartLineId = $(this).attr('value');
		var countElement = $('#count_' + cartLineId);
		
		var originalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		//work only when the count has changed
		if(currentCount !== originalCount){
			
			if(currentCount < 1 || currentCount > 3){
				//retrieving back to the original count
				//user has given value below 1 and above 3
				countElement.val(originalCount);
				bootbox.alert({
					size: 'medium',
					title: 'Error',
					message: 'Product count should be minimum 1 and maximum 3'
				});
			}else{
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
				
				//forward it to the controller
				window.location.href = updateUrl;
				
			}
		}
		
	});

	//single chat room
	
	
	var usernamePage = document.querySelector('#username-page');
	var chatPage = document.querySelector('#chat-page');
	var usernameForm = document.querySelector('#usernameForm');
	var messageForm = document.querySelector('#messageForm');
	var messageInput = document.querySelector('#message');
	var messageArea = document.querySelector('#messageArea');
	var connectingElement = document.querySelector('.connecting');

	var stompClient = null;
	var username = null;

	var colors = [
	    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
	    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
	];

	function connect(event) {
	    username = document.querySelector('#name').value.trim();

	    if(username) {
	        usernamePage.classList.add('hidden');
	        chatPage.classList.remove('hidden');

	        var socket = new SockJS('/ws');
	        stompClient = Stomp.over(socket);

	        stompClient.connect({}, onConnected, onError);
	    }
	    event.preventDefault();
	}


	function onConnected() {
	    // Subscribe to the Public Topic
	    stompClient.subscribe('/topic/public', onMessageReceived);

	    // Tell your username to the server
	    stompClient.send("/app/chat.addUser",
	        {},
	        JSON.stringify({sender: username, type: 'JOIN'})
	    )

	    connectingElement.classList.add('hidden');
	}


	function onError(error) {
	    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
	    connectingElement.style.color = 'red';
	}


	function sendMessage(event) {
	    var messageContent = messageInput.value.trim();
	    if(messageContent && stompClient) {
	        var chatMessage = {
	            sender: username,
	            content: messageInput.value,
	            type: 'CHAT'
	        };
	        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
	        messageInput.value = '';
	    }
	    event.preventDefault();
	}


	function onMessageReceived(payload) {
	    var message = JSON.parse(payload.body);

	    var messageElement = document.createElement('li');

	    if(message.type === 'JOIN') {
	        messageElement.classList.add('event-message');
	        message.content = message.sender + ' joined!';
	    } else if (message.type === 'LEAVE') {
	        messageElement.classList.add('event-message');
	        message.content = message.sender + ' left!';
	    } else {
	        messageElement.classList.add('chat-message');

	        var avatarElement = document.createElement('i');
	        var avatarText = document.createTextNode(message.sender[0]);
	        avatarElement.appendChild(avatarText);
	        avatarElement.style['background-color'] = getAvatarColor(message.sender);

	        messageElement.appendChild(avatarElement);

	        var usernameElement = document.createElement('span');
	        var usernameText = document.createTextNode(message.sender);
	        usernameElement.appendChild(usernameText);
	        messageElement.appendChild(usernameElement);
	    }

	    var textElement = document.createElement('p');
	    var messageText = document.createTextNode(message.content);
	    textElement.appendChild(messageText);

	    messageElement.appendChild(textElement);

	    messageArea.appendChild(messageElement);
	    messageArea.scrollTop = messageArea.scrollHeight;
	}


	function getAvatarColor(messageSender) {
	    var hash = 0;
	    for (var i = 0; i < messageSender.length; i++) {
	        hash = 31 * hash + messageSender.charCodeAt(i);
	    }
	    var index = Math.abs(hash % colors.length);
	    return colors[index];
	}

	usernameForm.addEventListener('submit', connect, true)
	messageForm.addEventListener('submit', sendMessage, true)
});