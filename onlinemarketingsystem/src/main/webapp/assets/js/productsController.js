var app = angular.module('marketingApp', []);

app.controller('ProductController', function($http) {
	
	var me = this;
	
	me.mvProducts = [];
	me.mpProducts = [];
	
	me.fetchProducts = function() {
		
		$http.get('/onlinemarketingsystem/json/data/mv/products')
			.then(function(response) {
				me.mvProducts = response.data;
			});
		
		$http.get('/onlinemarketingsystem/json/data/mp/products')
			.then(function(response) {
				me.mpProducts = response.data;
			});
		
	}
});