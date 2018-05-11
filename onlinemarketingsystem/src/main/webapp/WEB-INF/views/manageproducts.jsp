<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-form-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4" for="description">Product
								Description:</label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" id="description"
									placeholder="Product Description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPprice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<sf:errors path="unitPprice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4" for="quantity">Enter
								Product Quantity:</label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity"
									placeholder="Product Quantity" class="form-control" />
							</div>
						</div>
						<!-- Product image upload -->
						<div class="form-group">
							<label class="col-form-label col-md-4" for="file">Select
								an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
								<c:if test="${product.id==0}">
									<div class="text-right">
										<br/>
										<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add Category</button>
									</div>
								</c:if>
							</div>
						</div>

						<div class="form-group">

							<div class="offset-md-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
								<!-- Hidden fields for product -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<hr/>
	<div class="row">
		<div class="col-md-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-md-12">
			<div style="overflow: auto">
				<!-- Product table for admin -->
				<table id="adminProductsTable"
					class="table table-striped table-borderd">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<!-- comment these codes for debug -->
					<!-- <tbody>
						<td>4</td>
						<td>
							<img src="${contextRoot}/resources/images/PRDABCXYZDEFX.jpg" class="adminDataTableImg"/>
						</td>
						<td>Dell Latitude E6510 here</td>
						<td>dell</td>
						<td>5</td>
						<td>1099.00</td>
						<td>
							<label class="switch">
								<input type="checkbox" checked="checked" value="4"'/>
								<div class="slider round"></div>
							</label>
						</td>
					</tbody> -->
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<!-- Modal header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-boday">
					<!-- Category form -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="col-form-label col-md-4">Category Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="category_name" class="col-form-label"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="col-form-label col-md-4">Category Description</label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="5" path="description" id="category_description" class="col-form-label"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

</div>