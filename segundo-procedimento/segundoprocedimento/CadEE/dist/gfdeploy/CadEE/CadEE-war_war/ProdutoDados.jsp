<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dados do Produto</title>
    
    </head>
<body>
    <h1>Dados do Produto</h1>
    <form action="ProdutoFrontController" method="post">
        <input type="hidden" name="acao" value="${param.acao eq 'formIncluir' ? 'incluir' : 'alterar'}">
        <input type="hidden" name="id" value="${produto != null ? produto.idProduto : ''}">
        <div>
            <label>Nome:</label>
            <input type="text" name="nome" value="${produto != null ? produto.nome : ''}">
        </div>
        <div>
            <label>Quantidade:</label>
            <input type="text" name="quantidade" value="${produto != null ? produto.quantidade : ''}">
        </div>
        <div>
            <label>Preço:</label>
            <input type="text" name="precoVenda" value="${produto != null ? produto.precoVenda : ''}">
        </div>
        
        <div>
            <button type="submit">${param.acao eq 'formIncluir' ? 'Incluir' : 'Alterar'}</button>
        </div>
    </form>
    
</body>
</html>
