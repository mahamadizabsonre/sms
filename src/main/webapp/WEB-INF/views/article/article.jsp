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
      <title><fmt:message key="common.applicationtitle"/></title>
      <!-- Custom fonts for this template-->
      <link
         href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
         rel="stylesheet" type="text/css">
      <!--   <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet"> -->
      <!-- Custom styles for this template-->
      <link
         href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
         rel="stylesheet">
	  <!-- Custom styles for this page -->
	  <link href="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	  <!-- Custom styles for this datatable-->
	  <link href="<%=request.getContextPath()%>/resources/css/datatable/responsive.bootstrap.min.css" rel="stylesheet">
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
               <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                  <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
               </nav>
               <!-- End of Topbar -->
               <!-- Begin Page Content -->
               <div class="container-fluid">
                  <!-- Page Heading -->
                  <h1 class="h3 mb-4 text-gray-800">
                     <fmt:message key="common.article" />
                  </h1>
                  
                  <div class="row">
                  	<div class="col-lg-12">
	                    <ol class="breadcrumb">
						    <li class="breadcrumb-item"><a href="<c:url value="nouveau/"/>"> <i class="fa fa-plus">&nbsp;<fmt:message key="common.add"/></i></a></li>
						    <li class="breadcrumb-item"><a href="#"><i class="fa fa-download">&nbsp;<fmt:message key="common.exporter"/></i></a></li>
						    <li class="breadcrumb-item"><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message key="common.importer"/></i></a></li>
						 </ol>
                  	</div>
                  </div>
                  <!-- Start of DataTable Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3 bg-primary">
							<h6 class="m-0 font-weight-bold flex-grow-1 text-white text-center">
								<fmt:message key="article.liste"/>
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<div id="dataTable_wrapper"
									class="dataTables_wrapper dt-bootstrap4">
									<div class="row">
										<div class="col-sm-12">
										<!--table table-bordered dataTable  -->
											<table class="table table-striped table-bordered dt-responsive nowrap " id="dataTable-exemple"
												role="grid"
												aria-describedby="dataTable_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0"
															aria-controls="dataTable" rowspan="1" colspan="1"
															aria-sort="ascending"
															aria-label="Name: activate to sort column descending"
															style="width: 203px;">
															<fmt:message key="common.codeArticle"/>
														</th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label="Position: activate to sort column ascending"
															style="width: 311px;">
															<fmt:message key="common.designation"/>
														</th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label="Office: activate to sort column ascending"
															style="width: 151px;">
															<fmt:message key="common.prixUnitaireHT"/>
														</th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label="Age: activate to sort column ascending"
															style="width: 72px;">
															<fmt:message key="common.tauxTva"/>
														</th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label="Start date: activate to sort column ascending"
															style="width: 142px;">
															<fmt:message key="common.prixUnitaireTTC"/>
														</th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label=""
															style="width: 142px;">
															<fmt:message key="common.photo"/>
														</th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label=""
															style="width: 133px;"><fmt:message key="common.article.category"/></th>
														<th class="sorting" tabindex="0" aria-controls="dataTable"
															rowspan="1" colspan="1"
															aria-label=""
															style="width: 133px;"><fmt:message key="common.actions"/></th>
													</tr>
												</thead>
												<tfoot>
													<tr>
														<th rowspan="1" colspan="1"><fmt:message key="common.codeArticle"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.designation"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.prixUnitaireHT"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.tauxTva"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.prixUnitaireTTC"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.photo"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.article.category"/></th>
														<th rowspan="1" colspan="1"><fmt:message key="common.actions"/></th>
													</tr>
												</tfoot>
												<tbody>
													<c:forEach items="${articles }" var="article">
														<tr role="row" class="odd">
															<td class="sorting_1 text-center">${article.getCodeArticle() }</td>
															<td class="text-center">${article.getDesignation() }</td>
															<td class="text-center">${article.getPrixUnitaireHT() }</td>
															<td class="text-center">${article.getTauxTva() }</td>
															<td class="text-center">${article.getPrixUnitaireTTC() }</td>
															<td class="text-center"><img alt="photo-client" src="${article.getPhoto() }" width="50px" height="50px"></td>
															<td class="text-center">${article.category.code }</td>
															<td> 
																<c:url value="/article/modifier/${article.getIdArticle() }" var="urlModifier"/>
																<a href="${urlModifier }" title="Modifier">
																	<i class="fa fa-edit">&nbsp;</i>
																</a>
																&nbsp;|&nbsp;
																<a href="javascript:void(0)" title="Supprimer" data-toggle="modal" data-target="#modalArticle${article.getIdArticle() }">
																	<i class="fa fa-trash">&nbsp;</i>
																</a>
																<!-- Modal Start -->
																<div class="modal fade" id="modalArticle${article.getIdArticle() }" tabindex="-1" 
																	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
																  <div class="modal-dialog" role="document">
																    <div class="modal-content">
																      <div class="modal-header">
																        <h5 class="modal-title" id="exampleModalLabel">
																        	<fmt:message key="common.modal.title.delete.article"/>
																        </h5>
																        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
																          <span aria-hidden="true">&times;</span>
																        </button>
																      </div>
																      <div class="modal-body">
																      	<fmt:message key="common.confirmation.suppression"/> 
																      </div>
																      <div class="modal-footer">
																        <button type="button" class="btn btn-secondary" data-dismiss="modal">
																        	<i class="fa fa-arrow-left">&nbsp;</i><fmt:message key="common.reset"/>
																        </button>
																        <c:url value="/article/supprimer/${article.getIdArticle() }" var="urlSuppression"/>
																        <a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash">&nbsp;<fmt:message key="common.confirm"/></i></a>
																      </div>
																    </div>
																  </div>
																</div>
																<!-- End Modal -->
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- End of DataTable Example -->
               </div>
               <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
               <%@ include file="/WEB-INF/views/footer/footer.jsp" %>
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
         src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

	  <!-- Page level plugins -->
	  <script src="<%=request.getContextPath()%>/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	  <script src="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	  
	  <!-- Page level custom scripts for search and pagination options. It added them automatically  -->
	  <script src="<%=request.getContextPath()%>/resources/js/demo/datatables-demo.js"></script>
		  
   </body>
</html>