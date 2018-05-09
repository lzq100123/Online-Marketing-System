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
})