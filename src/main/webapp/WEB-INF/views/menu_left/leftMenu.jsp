<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="javascript:void(0)">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			<fmt:message key="common.applicationname" /> <%-- <sup>1</sup> --%>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<c:url value="/home/" var="home" />
	<li class="nav-item">
		<a class="nav-link" href="${home }"> 
			<i	class="fas fa-fw fa-tachometer-alt"></i> 
			<span> 
				<fmt:message key="common.dashboard" />
			</span>
		</a>
	</li>
	<c:url value="/article/" var="article" />
	<li class="nav-item">
		<a class="nav-link" href="${article }"> 
			<i	class="fas fa-fw fa-tachometer-alt"></i> 
			<span> 
				<fmt:message key="common.article" />
			</span>
		</a>
	</li>

	<!-- Divider -->
<!-- 	<hr class="sidebar-divider"> -->

	<!-- Heading -->
<!-- 	<div class="sidebar-heading">Clients/div> -->

	<!-- Nav Item - Pages Collapse Menu -->
	
	<li class="nav-item">
	<c:url value="/client/" var="client" />
	<a class="nav-link collapsed" 
		href="${client }" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-folder"></i>
		<span><fmt:message key="common.client" /></span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
<!-- 				<h6 class="collapse-header">Custom Components:</h6> -->
				<a class="collapse-item" href="${client }"><fmt:message key="common.client" /></a>
				<c:url value="/commandeclient/" var="cdeClient" /> 
				<a class="collapse-item" href="${cdeClient }"><fmt:message key="common.client.commande" /></a>
			</div>
		</div></li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<c:url value="/fournisseur/" var="fournisseur" />
	<li class="nav-item">
		<a class="nav-link collapsed" href="${fournisseur }"
			data-toggle="collapse" data-target="#collapseUtilities"
			aria-expanded="true" aria-controls="collapseUtilities"> <i
				class="fas fa-fw fa-wrench"></i> 
				<c:url value="/home/" var="home" />
				<span><fmt:message key="common.fournisseur" /></span>
		</a>
			<div id="collapseUtilities" class="collapse"
				aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<!--<h6 class="collapse-header">Custom Utilities:</h6> -->
					<a class="collapse-item" href="${fournisseur }"><fmt:message key="common.fournisseur" /></a> 
					<c:url value="/commandefournisseur/" var="cdeFournisseur" />
					<a class="collapse-item" href="cdeFournisseur"><fmt:message key="common.fournisseur.commande" /></a> 
				</div>
			</div>
	</li>
	
	<c:url value="/stock/" var="stock" />
	<li class="nav-item">
		<a class="nav-link" href="${stock}"> 
			<i	class="fas fa-fw fa-table"></i> 
			<span> 
				<fmt:message key="common.stock" />
			</span>
		</a>
	</li>
	<c:url value="/vente/" var="vente" />
	<li class="nav-item">
		<a class="nav-link" href="${vente }"> 
			<i	class="fa fa-shopping-basket" aria-hidden="true"></i> 
			<span> 
				<fmt:message key="common.vente"/>
			</span>
		</a>
	</li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Paramétrage</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<c:url value="/utilisateur/" var="user" />
	<li class="nav-item active"><a class="nav-link" href="${parametrageUtilisateur }"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> 
		<i class="fas fa-fw fa-cog"></i> <span><fmt:message key="common.parametrage" /></span>
	</a>
		<div id="collapsePages" class="collapse show"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<!--<h6 class="collapse-header">Login Screens:</h6> -->
				<a class="collapse-item" href="${user }"><fmt:message key="common.parametrage.utilisateur" /></a> 
				<c:url value="/category/" var="category" />
				<a class="collapse-item" href="${category }">
					<fmt:message key="common.parametrage.category" />
				</a> 
				<div class="collapse-divider"></div>
				
				<h6 class="collapse-header"><fmt:message key="common.other" /></h6>
				<c:url value="/motdepasseoublie/" var="forgotPassword" />
				<a class="collapse-item active" href="${forgotPassword }"><fmt:message key="common.other.forgot" /></a>
			</div>
		</div></li>
	<c:url value="/security/" var="security" />
	<li class="nav-item">
		<a class="nav-link" href="${security }"> 
			<i	class="fa fa-shopping-basket" aria-hidden="true"></i> 
			<span> 
				<fmt:message key="common.other.security" />
			</span>
		</a>
	</li>


	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->