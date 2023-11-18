<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link rel="stylesheet" href="../../css/home.css">
	<meta charset="ISO-8859-1">
	<title>AppVenda</title>
	</head>
	<body class="home">
	<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link active" href="/">AppVenda</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/vendedor/lista">Vendedores</a></li>
					<li class="nav-item"><a class="nav-link" href="/produto/lista">Produtos</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/livro/lista">Livros</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/vestuario/lista">Vestuários</a></li>
				</ul>
			</div>	 		
			<c:if test="${not empty listagem}">
				<form id="form_home_busca" class="d-flex" action="/${rota}/pesquisar">
					<input class="form-control me-2" type="text" name="campoBusca"
						placeholder="Search ${searchFilter}">
					<button class="btn btn-primary" type="submit">Search</button>
				</form>
			</c:if>
		</nav>
	</header>
	<main>
		<div class="container mt-3">
			<span class="badge rounded-pill bg-primary">Vendedor:${qtdeVendedor}</span> 
			<span class="badge rounded-pill bg-secondary">Produto:${qtdeProduto}</span> 
			<span class="badge rounded-pill bg-success">Livro:${qtdeLivro}</span> 
			<span class="badge rounded-pill bg-danger">Vestuário:${qtdeVestuario}</span>

			<c:if test="${not empty listagem}">
				<h2>AppVenda</h2>
				<p>Gestão de vendas de produtos:</p>
				<table class="table table-striped">
					<thead class="table-dark">
						<tr>
							<th>${titulo}</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${listagem}">
							<tr>
								<td>${item}</td>
								<td><a href="/${rota}/${item.id}/excluir">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${not empty homeFeedbackPesquisaSucess}">
				<div class="alert alert-success">
					<strong>Sucesso!</strong> ${homeFeedbackPesquisaSucess}
				</div>
			</c:if>
			<c:if test="${not empty homeFeedbackPesquisaFail}">
				<div class="alert alert-danger">
					<strong>Erro!</strong> ${homeFeedbackPesquisaFail}
				</div>
			</c:if>
		</div>
			
		</main>
		<footer>
			<p id="copyright">Copyright Idinaldo Teteo - 2023</p>
		</footer>
	
	
	
		<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</body>
</html>