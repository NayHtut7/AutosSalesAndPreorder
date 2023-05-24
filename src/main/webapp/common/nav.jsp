	<%@taglib uri = "jakarta.tags.core" prefix="c" %>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="cars"><img id="logo"
				src="assets/logo.jpg" alt="logo" /> AUTO SPOT</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="cars">Home</a></li>
						
						<c:if test="${user.role == 'admin' }">
							
							<li class="nav-item"><a class="nav-link" href="cars?mode=PAGE">Add Car</a></li>
							<li class="nav-item"><a class="nav-link" href="admin?mode=PAGE">Add Admin</a></li>
							<li class="nav-item"><a class="nav-link" href="preorder?mode=PAGE">Preordered List</a></li>
							<li class="nav-item"><a class="nav-link" href="customer?mode=SHOW">Reserved List</a></li>
							
						</c:if>
						<c:if test="${user.role == 'user' }">
							<li class="nav-item"><a class="nav-link" href="preorder?mode=LOAD">Preorder</a></li>
							<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
						</c:if>
						
							
					
						
					
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">${user.username }</a>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="logout">Log Out</a></li>
							
									
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
