<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>

	<!-- Pre-loader start -->
	<jsp:include page="theme-loader.jsp"></jsp:include>


	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">
			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">


					<jsp:include page="navbarmainmenu.jsp"></jsp:include>


					<div class="pcoded-content">
						<!-- Page-header start -->
						<div class="page-header">
							<div class="page-block">
								<div class="row align-items-center">
									<div class="col-md-8">
										<div class="page-header-title">
											<h5 class="m-b-10">Dashboard</h5>
											<p class="m-b-0">Welcome to Mega Able</p>
										</div>
									</div>
									<div class="col-md-4">
										<ul class="breadcrumb-title">
											<li class="breadcrumb-item"><a href="index.html"> <i
													class="fa fa-home"></i>
											</a></li>
											<li class="breadcrumb-item"><a href="#!">Dashboard</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">

										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">

													<div class="card-block">
														<h4 class="sub-title">Cad.Usuário</h4>
														<form class="form-material">

															<div class="form-group form-default"action="<%=request.getContextPath() %>/ServletUsuarioController" method="post">
																<input type="text" "name" id="Id"
																	class="form-control" readonly="readonly"value="${modelLogin.id}"> 
																	<span
																	class="form-bar"></span> <label class="float-label">ID:</label>
															</div>


															<div class="form-group form-default">
																<input type="text" "name"id="nome"
																	class="form-control" required="required"value="${modelLogin.nome}">
																	 <span
																	class="form-bar"></span> <label class="float-label">Name:</label>
															</div>

															<div class="form-group form-default">
																<input type="email" name= "email "id= "email"
																	class="form-control" required="required"autocomplete="off"value="${modelLogin.email}"> <span
																	class="form-bar"></span> <label class="float-label">E-mail:</label>
																	
																	</div>
															<div class="form-group form-default">
																<input type="text" name="login" id="Login"
																	class="form-control" required="required"autocomplete="off"value="${modelLogin.login}"> <span
																	class="form-bar"></span> <label class="float-label">Login:</label>
															</div>
															</div>
															<div class="form-group form-default">
																<input type="password" name="senha" id="senha"
																	class="form-control" required="required"autocomplete="off"value="${modelLogin.senha}"> <span
																	class="form-bar"></span> <label class="float-label">Senha</label>
															</div>

															<button class="btn btn-primary waves-effect waves-light">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Salvar</button>
															
															 <button class="btn btn-info waves-effect waves-light">Excluir</button>
															         
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Required Jquery -->
	<jsp:include page="javascriptfile.jsp"></jsp:include>

</body>

</html>