<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<div class="row">
		
		<c:if test="${not empty message}">
		<div class="col-md-12">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${message}
			</div>
		</div>
		</c:if>
		<div class="offset-md-2 col-md-8">
			<div class="card bg-primary">
				<div class="card-header">
					<h4>Product Management</h4>
				</div>
				<div class="card-body bg-light">
					<!-- Font Element -->
					<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST">
						<div class="form-group">
							<label class="col-form-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
								<em class="help-block">Please Enter Product Name!</em> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-form-label col-md-4" for="brand">Enter Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/>
								<em class="help-block">Please Enter Brand Name!</em> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-form-label col-md-4" for="description">Product Description:</label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" id="description" placeholder="Product Description" class="form-control"/>
								<em class="help-block">Please Enter Product Description!</em> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-form-label col-md-4" for="unitPrice">Enter Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPprice" id="unitPrice" placeholder="Unit Price" class="form-control"/>
								<em class="help-block">Please Enter Unit Price!</em> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-form-label col-md-4" for="quantity">Enter Product Quantity:</label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity" placeholder="Product Quantity" class="form-control"/>
								<em class="help-block">Please Enter Brand Name!</em> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-form-label col-md-4" for="categoryId">Select Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId"
									items="${categories}"
									itemLabel="name"
									itemValue="id"
								/>
							</div>
						</div>
						
						<div class="form-group">
							
							<div class="offset-md-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
								<!-- Hidden fields for product -->
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="active"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	
</div>