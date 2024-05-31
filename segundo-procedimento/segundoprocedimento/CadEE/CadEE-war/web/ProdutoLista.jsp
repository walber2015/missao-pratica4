<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Produtos</title>
    </head>
<body>
    <h1>Listagem de Produtos</h1>
    <a href="ProdutoFrontController?acao=formIncluir">Incluir Novo Produto</a>
    <table>
        <thead>
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
                    <a href="ProdutoFrontController?acao=formAlterar&id=${produto.idProduto}">Alterar</a>
                    <a href="ProdutoFrontController?acao=excluir&id=${produto.idProduto}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>
