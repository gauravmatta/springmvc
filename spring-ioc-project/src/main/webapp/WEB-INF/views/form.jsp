<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Tutor Form</title>
</head>
<body style="background: #e2e2e2;">
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-white"
							style="text-transform: uppercase;">Tutor Form</h3>
						<form class="mt-3" action="handle">
							<div class="form-group">
								<label for="name">Name:</label> <input name="name" type="text"
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter Name" /> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							
							<div class="form-group">
								<label for="id">Your id:</label> <input name="id" type="text"
									class="form-control" id="id" placeholder="Enter ID" />
							</div>
							
							<div class="form-group">
								<label for="dob">Your DOB:</label> <input name="dob" type="text"
									class="form-control" id="dob" placeholder="Enter DOB" />
							</div>
							
							<div class="form-group">
								<label for="course">Example Course</label> <select multiple
									class="form-control" id="course" name="course">
									<option value="java">Java</option>
									<option value="python">Python</option>
									<option value="c++">C++</option>
									<option value="django">Django</option>
								</select>
							</div>
							<div class="form-group">
								<label for="gender">Select Gender</label>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="male" value="male"> <label
										class="form-check-label" for="inlineRadio1">male</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="female" value="female"> <label
										class="form-check-label" for="inlineRadio2">female</label>
								</div>
							</div>
							<div class="form-group">
								<label for="gender">Select Type</label> <select
									class="custom-select" name="studenttype">
									<option selected>Select Type</option>
									<option value="old">Old Student</option>
									<option value="2">Two</option>
									<option value="3">Three</option>
								</select>
							</div>
							<div class="container text-center">
								<button class="btn btn-outline-light">Search</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>