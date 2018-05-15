<div class="container">

	<div class="row">


		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		</div>

	</div>

	<div class="row">
		<!-- Display product image -->
		<div class="col-xs-12 col-sm-4">

			<img src="${images}/${product.code}.jpg"
				class="img img-thumbnail img-responsive" />

		</div>
		<!-- Display product description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong>&#36; ${product.unitPprice}</strong>
			</h4>
			<hr />
			
			<security:authorize access="hasAuthority('USER')">
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>
						Quantity Available: <span style="color:red;">Out of Stock!</span>
					</h6>
					<a href="javascript.void(0)" class="btn btn-success disabled"><span
						class="fas fa-cart-arrow-down">Add To Cart</span></a>
				</c:when>
				<c:otherwise>
					<h6>
						Quantity Available: <strong>${product.quantity}</strong>
					</h6>
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"><span class="fas fa-cart-arrow-down">Add
							To Cart</span></a>
				</c:otherwise>
			</c:choose>
			</security:authorize>
			
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product"
						class="btn btn-warning"><span class="fas fa-pencil-alt">Edit</span></a>
			</security:authorize>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary"><span
				class="fas fa-undo-alt">Back</span></a>



		</div>

	</div>
</div>