<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dados do Produto</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
    <h1>Dados do Produto</h1>
    <form class="form" action="ProdutoFrontController" method="post">
        <input type="hidden" name="acao" value="${param.acao eq 'formIncluir' ? 'incluir' : 'alterar'}">
        <input type="hidden" name="id" value="${produto != null ? produto.idProduto : ''}">
        <div class="mb-3">
            <label class=" form-label">Nome:</label>
            <input class="form-control" type="text" name="nome" value="${produto != null ? produto.nome : ''}">
        </div>
        <div>
            <label class=" form-label">Quantidade:</label>
            <input class="form-control" type="text" name="quantidade" value="${produto != null ? produto.quantidade : ''}">
        </div>
        <div>
            <label class=" form-label">Preço:</label>
            <input class="form-control" type="text" name="precoVenda" value="${produto != null ? produto.precoVenda : ''}">
        </div>
        
        <div>
            <button class="btn btn-primary mt-3" type="submit">${param.acao eq 'formIncluir' ? 'Incluir' : 'Alterar'}</button>
        </div>
    </form>
    
</body>
</html>
