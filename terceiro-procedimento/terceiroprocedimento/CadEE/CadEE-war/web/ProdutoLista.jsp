<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
    <h1>Listagem de Produtos</h1>
    <a class="btn btn-primary m-2" href="ProdutoFrontController?acao=formIncluir">Incluir Novo Produto</a>
    <table class="table table-striped ">
        <thead class="table-dark">
            <th>ID</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th>Ações</th>
        </thead>
        <c:forEach var="produto" items="${produtos}">
            <tr>
                <td>${produto.idProduto}</td>
                <td>${produto.nome}</td>
                <td>${produto.quantidade}</td>
                <td>${produto.precoVenda}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="ProdutoFrontController?acao=formAlterar&id=${produto.idProduto}">Alterar</a>
                    <a class="btn btn-danger btn-sm" href="ProdutoFrontController?acao=excluir&id=${produto.idProduto}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>
