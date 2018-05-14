<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="content">
	<div class="container">
		<div class="offset-md-3 col-md-6">
			<div class="card bg-primary">
				<div class="card-header">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="card-body bg-light">
					<!-- Font Element -->
					<sf:form class="form-horizontal" method="POST" id="registerForm"
						modelAttribute="user">
						<div class="form-group">
							<label class="col-form-label col-md-4">First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" placeholder="First Name"
									class="form-control" />
								<sf:errors path="firstName" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4">Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" placeholder="Last Name"
									class="form-control" />
								<sf:errors path="lastName" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4">Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" placeholder="Email"
									class="form-control" />
								<sf:errors path="email" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber"
									placeholder="Contact Number" class="form-control" />
								<sf:errors path="contactNumber" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4">Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" placeholder="Password"
									class="form-control" />
								<sf:errors path="password" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="col-form-label col-md-4">Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" placeholder="Re-enter Password"
									class="form-control" />
								<sf:errors path="confirmPassword" cssClass="help-block" element="em"/>
							</div>
						</div>

						<!-- radio button using bootstrap class of radio-inline -->

						<div class="form-group">
							<label class="col-form-label col-md-4">Select Role</label>
							<div class="col-md-8">
							<label class="radio-inline">
								<sf:radiobutton path="role" value="USER" checked="checked" />
								User
							</label>
							
							<label class="radio-inline">
								<sf:radiobutton path="role" value="SUPPLIER" checked="checked" />
								Supplier
							</label>
							</div>
						</div>

						<div class="form-group">
							<div class="offset-md-3 col-md-8">
								<!-- submit button inside the form -->
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
									Next<span class="fas fa-chevron-right"></span>
								</button>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>

