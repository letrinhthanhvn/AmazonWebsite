<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/web/css/small-business.css'/>"
	rel="stylesheet" type="text/css">

<style>
div {
	display: block;
}

.top-detail {
	padding-top: 100px;
	display: flex;
}

.top-detail img {
	display: inline-block;
	float: left;
	display: -ms-flexbox;
	display: flex;
	-ms-flex-wrap: wrap;
	flex-wrap: wrap;
	margin-right: -15px;
	margin-left: -15px;
}

.fadeIn {
	-webkit-animation-name: fadeIn;
	animation-name: fadeIn;
}

.right-detail {
	display: inline-block;
	width: 50%;
	float: left;
}

.mb-3 {
	margin-bottom: 1rem !important;
	display: flex;
}

.category {
	padding: .25em .4em;
	font-size: 100%;
	font-weight: 700;
	line-height: 1;
	text-align: center;
	white-space: nowrap;
	vertical-align: baseline;
	border-radius: .25rem;
	transition: color .15s ease-in-out, background-color .15s ease-in-out,
		border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.price {
	font-size: 1.25rem;
	font-weight: 300;
}

.font-weight-bold {
	font-weight: 700 !important;
	font-size: 1.25rem;
	font-weight: 300;
}

.left-detail {
	width: 50%;
}

.d-flex {
	display: flex !important;
}

.form-control {
	display: block;
	height: calc(1.5em + .75rem + 2px);
	padding: .375rem .75rem;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: .25rem;
	transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.btn-primary {
	color: #fff;
	background-color: #4285f4 !important;
	height: 38.38px;
	margin-left: 3px;
}

.btn {
	display: inline-block;
	font-weight: 400;
	color: #212529;
	text-align: center;
	vertical-align: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-color: transparent;
	border: 1px solid transparent;
	padding: .375rem .75rem;
	font-size: 1rem;
	line-height: 1.5;
	border-radius: .25rem;
	transition: color .15s ease-in-out, background-color .15s ease-in-out,
		border-color .15s ease-in-out, box-shadow .15s ease-in-out;
	font-weight: 400;
}
</style>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<div class="container">
		<div class="top-detail fadeIn">
			<div class="left-detail">
				<img
					src="https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SX466_.jpg"
					width="400" height="300">
			</div>

			<div class="right-detail">
				<div class="mb-3">
					<p class="category">Category</p>
					<p class="category">New</p>
					<p class="category">BestSeller</p>
				</div>
				<p class="price">$100</p>
				<p class="font-weight-bold">Description</p>
				<p>Category 2 New Bestseller $200 $100 Description Lorem ipsum
					dolor sit amet consectetur adipisicing elit. Et dolor suscipit
					libero eos atque quia ipsa sint voluptatibus! Beatae sit assumenda
					asperiores iure at maxime atque repellendus maiores quia sapiente.</p>
				<form class="d-flex">
					<input type="number" value="1" aria-label="Search"
						class="form-control" style="width: 100px">
					<button
						class="btn btn-primary btn-md my-0 p waves-effect waves-light"
						type="submit">
						Add to cart <i class="fas fa-shopping-cart ml-1"></i>
					</button>
				</form>
			</div>
		</div>
		<!-- top-detail fadeIn -->
		<hr>

		<div class="row d-flex justify-content-center wow fadeIn">

			<!--Grid column-->
			<div class="col-md-6 text-center">

				<h4 class="my-4 h4">Additional information</h4>

				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
					Natus suscipit modi sapiente illo soluta odit voluptates, quibusdam
					officia. Neque quibusdam quas a quis porro? Molestias illo neque
					eum in laborum.</p>

			</div>
			<!--Grid column-->

		</div>

		<div class="row wow fadeIn">

			<!--Grid column-->
			<div class="col-lg-4 col-md-12 mb-4">

				<img
					src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/11.jpg"
					class="img-fluid" alt="">

			</div>
			<!--Grid column-->

			<!--Grid column-->
			<div class="col-lg-4 col-md-6 mb-4">

				<img
					src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/12.jpg"
					class="img-fluid" alt="">

			</div>
			<!--Grid column-->

			<!--Grid column-->
			<div class="col-lg-4 col-md-6 mb-4">

				<img
					src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/13.jpg"
					class="img-fluid" alt="">

			</div>
			<!--Grid column-->

		</div>

	</div>
	<!-- Container -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- Bootstrap core JavaScript -->
	<script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>