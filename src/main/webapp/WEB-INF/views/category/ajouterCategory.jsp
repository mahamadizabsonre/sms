<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title><fmt:message key="common.applicationtitle" /></title>

<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<!--   <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet"> -->

<!-- Custom styles for this template-->
<link
	href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->

		<%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->

		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->

			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<%@ include file="/WEB-INF/views/menu_top/topMenu.jsp"%>
				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">
						<fmt:message key="common.parametrage.category" />
					</h1>
					<!-- Start of form div -->
					<div class="card shadow mb-4">
						<div class="card-header py-3 bg-primary">
							<h6	class="m-0 font-weight-bold flex-grow-1 text-white text-center">
								<fmt:message key="category.nouveau" />
							</h6>
						</div>
						<div class="card-body border-bottom-primary">
							<div class="p-5">
								<c:url value="/category/enregistrer" var="urlEnregister" />
								<f:form modelAttribute="category" class="user"
									action="${urlEnregister }" enctype="multipart/form-data"
									role="form">
									<f:hidden path="idCategory" />
									
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<fmt:message key="common.code" var="codeCategory" />
											<label><fmt:message key="common.code" /></label>
											<f:input path="code" class="form-control form-control-user"
												id="codeCategory" name="codeCategory" placeholder="${codeCategory }"
												required="required" />
										</div>
										<div class="col-sm-6">
											<fmt:message key="common.designation" var="designation" />
											<label><fmt:message key="common.designation" /></label>
											<f:input path="designation" class="form-control form-control-user"
												id="designation" name="designation"
												placeholder="${designation }" required="required" />
										</div>
									</div>
									<div class="text-center">
										<button type="submit" class="btn btn-primary btn-lg">
											<i class="fa fa-save">&nbsp;<fmt:message
													key="common.save" /></i>
										</button>
										<a href="<c:url value="/category/"/>" class="btn btn-danger btn-lg"><i class="fa fa-arrow-left">&nbsp;<fmt:message
													key="common.reset" /></i></a>
									</div>
									<hr>
								</f:form>
								<hr>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>

			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<%@ include file="/WEB-INF/views/logout_modal/modalLogout.jsp"%>
	</div>



	<!-- Bootstrap core JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js">
		
	</script>

	<!-- CUSTOM JS Allow us to show file name in file selected option-->
	<script
		src="<%=request.getContextPath()%>/resources/js/custom/custom.js">
		
	</script>
</body>

</html>
