$(function (){
	// solving the active menu problem
	switch (menu) {

	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns:[
			        	{
			        		data: 'code',
			        		mRender: function(data, type, row) {
			        			return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImg"/>';
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
			        		mRender: function(data, type, row){
			        			return '&#36;' + data;
			        		}
			        	},
			        	{
			        		data : 'quantity',
			        		mRender: function(data, type, row){
			        			if(data < 1)
			        				return '<span style="color:red">Out of Stock!</span>';
			        			return data;
			        		}
			        	},
			        	{
			        		data : 'id',
			        		mRender: function(data, type, row){
			        			var str = '';
								str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="far fa-eye"></span></a> &#160;';
								
								if(row.quantity < 1)
									str += '<a href="javascript.void(0)" class="btn btn-success"><span class="fas fa-cart-arrow-down"></span></a>';
								else
									str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="fas fa-cart-arrow-down"></span></a>';
								return str;
			        		}
			        	}
			        ]
		});
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow')
		},3000)
	}
	
	// Toggle switch prompt
	$('.switch input[type="checkbox"]').on('change', function(){
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked) ? 'You want to activiate the product' :
							   'You want to deactiviate the product';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'medium',
			title: 'Product Activiate & Deactivate',
			message: dMsg,
			callback: function(confirmed){
				if(confirmed){
					console.log(value);
					bootbox.alert({
						size: "medium",
						title: "Information",
						message: 'You are going to perform operation on product ' + value
					})
				}else{
					checkbox.prop('checked', !checked);
				}
			}
		
		})
	})
	
	/**
	 *  Data table for admin
	 */
	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductsTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductsTable.DataTable({
			lengthMenu : [ [ 10, 30, 50, -1 ],[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
			pageLength : 30,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns:[
			         	{
			         		data: 'id'
			         	},
			         	
			        	{
			        		data: 'code',
			        		bSortable: false,
			        		mRender: function(data, type, row) {
			        			return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg"/>';
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
			        		mRender: function(data, type, row){
			        			if(data < 1)
			        				return '<span style="color:red">Out of Stock!</span>';
			        			return data;
			        		}
			        	},
			        	{
			        		data : 'unitPprice',
			        		mRender: function(data, type, row){
			        			return '&#36;' + data;
			        		}
			        	},
			        	{
							data : 'active',
							bSortable : false,
							mRender : function(data, type, row) {
								var str = '';
								if(data) {		
									str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked"><div class="slider round"> </div></label>';
									
								}else {
									str += '<label class="switch"> <input type="checkbox" value="'+row.id+'"><div class="slider round"> </div></label>';
								}
								
								return str;
							}
						},
			        	{
		        			data: 'id',
		        			bSortable: false,
		        			mRender: function(data, type, row){
		        				str = '';
		        				
		        				str += '<a href="${contextRoot}/manage/' + data + '/product" class="btn btn-warning">';
								str += '<span class="fas fa-pencil-alt"></span>';
								str += '</a>';
								
								return str;
		        			}
		        		}
			        ]
		});
	}
	
	
	
})