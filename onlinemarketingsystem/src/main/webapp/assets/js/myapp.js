$(function() {
	//solving active menu problem
	switch(menu) {
	
	case "Home":
		$("#home").addClass("active");
		break;
	case "About Us":
		$("#about").addClass("active");
		break;
	case "Contact Us":
		$("#contact").addClass("active");
		break;
	case "All Products":
		$("#listProducts").addClass("active");
		break;
	default:
		$("#listProducts").addClass("active");
		$("#a_"+menu).addClass("active");
		break;
	}
	
	//code for jquery datatable
	//create dataset
	var products = [
	                ['1','ABC'],
	                ['2','DEF'],
	                ['3','GHI'],
	                ['4','JKL'],
	                ['5','MNO'],
	                ['6','PQR'],
	                ['7','STU'],
	                ['8','VWX']
	                ];
	var $table = $('#productListTable');
	
	//execute the below code only where we have this table
	if($table.length){
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			pageLength: 5,
			data:products
		});
		
	}
})