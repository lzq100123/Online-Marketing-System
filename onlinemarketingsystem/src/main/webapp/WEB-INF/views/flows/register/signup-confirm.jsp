<%@include file="../shared/flows-header.jsp"%>
<div class="content">
	<div class="container">
		<div class="row">

			<!-- column to display the personal details -->
			<div class="col-sm-6">

				<div class="card bg-primary">
					<div class="card-header">
						<h4>Personal Details</h4>
					</div>
					<div class="card-body bg-light">
						<div class="text-center">
							<p>
								Name: <strong>${registerModel.user.firstName}
									${registerModel.user.lastName}</strong>
							</p>
							<p>
								Email: <strong>${registerModel.user.email}</strong>
							</p>
							<p>
								Contact Number: <strong>${registerModel.user.contactNumber}</strong>
							</p>
							<p>
								Role: <strong>${registerModel.user.role}</strong>
							</p>
						</div>
					</div>
					<div class="card-footer">
						<!-- anchor to move to the edit of personal details -->
						<a href="${flowExecutionUrl}&_eventId_personal"
							class="btn btn-primary">Edit</a>
					</div>
				</div>

			</div>

			<!-- column to display the address  -->
			<div class="col-sm-6">

				<div class="card bg-primary">
					<div class="card-header">
						<h4>Billing Address</h4>
					</div>
					<div class="card-body bg-light">
						<div class="text-center">
							<p>Address Line One: ${registerModel.billing.addressLineOne}</p>
							<p>Address Line Two: ${registerModel.billing.addressLineTwo}</p>
							<p>City & Postal Code: ${registerModel.billing.city} -
								${registerModel.billing.postalCode}</p>
							<p>State & Country: ${registerModel.billing.state} -
								${registerModel.billing.country}
							<p>
						</div>
					</div>
					<div class="card-footer">
						<!-- anchor to move to the edit of billing details -->
						<a href="${flowExecutionUrl}&_eventId_billing"
							class="btn btn-primary">Edit</a>
					</div>
				</div>
			</div>
		</div>
		<br/>
		<!-- to provide the confirm button after displaying the details -->
		<div class="row">
			<div class="offset-sm-4 col-sm-4 ">

				<div class="text-center">
					<!-- anchor to move to the success page -->
					<a href="${flowExecutionUrl}&_eventId_submit"
						class="btn btn-primary">Confirm</a>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../shared/flows-footer.jsp"%>