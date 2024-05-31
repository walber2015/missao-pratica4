/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = {"/ProdutoFrontController"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String acao = request.getParameter("acao");
        String destino = null;

        if (acao == null) {
            acao = "listar";
        }

        switch (acao) {
            case "listar":
                List<Produto> produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
                break;

            case "formIncluir":
                destino = "ProdutoDados.jsp";
                break;

            case "formAlterar":
                int idAlterar = Integer.parseInt(request.getParameter("id"));
                Produto produtoAlterar = facade.find(idAlterar);
                request.setAttribute("produto", produtoAlterar);
                destino = "ProdutoDados.jsp";
                break;

            case "excluir":
                int idExcluir = Integer.parseInt(request.getParameter("id"));
                Produto produtoExcluir = facade.find(idExcluir);
                facade.remove(produtoExcluir);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "alterar":
                int idProdutoAlterar = Integer.parseInt(request.getParameter("id"));
                Produto produtoParaAlterar = facade.find(idProdutoAlterar);
                if (produtoParaAlterar != null) {
                    produtoParaAlterar.setNome(request.getParameter("nome"));
                    produtoParaAlterar.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));
                    facade.edit(produtoParaAlterar);
                }
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "incluir":
                Produto novoProduto = new Produto();
                String nome = request.getParameter("nome");
                String precoStr = request.getParameter("precoVenda");
                String quantidadeStr = request.getParameter("quantidade");

                if (nome != null && !nome.isEmpty()) {
                    novoProduto.setNome(nome);
                }

                if (precoStr != null && !precoStr.isEmpty()) {
                    try {
                        novoProduto.setPrecoVenda(Float.parseFloat(precoStr));
                    } catch (NumberFormatException e) {
                        // Log the error and handle it appropriately
                    }
                }

                if (quantidadeStr != null && !quantidadeStr.isEmpty()) {
                    try {
                        novoProduto.setQuantidade(Integer.parseInt(quantidadeStr));
                    } catch (NumberFormatException e) {
                        // Log the error and handle it appropriately
                    }
                }

                facade.create(novoProduto);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;


            default:
                List<Produto> produtosDefault = facade.findAll();
                request.setAttribute("produtos", produtosDefault);
                destino = "ProdutoLista.jsp";
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
