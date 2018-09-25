/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.betha.servlet;

import br.com.betha.dao.ProdutoDAO;
import br.com.betha.entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author matheus
 */
@WebServlet(name = "AdicionaProdutoServlet", urlPatterns = {"/AdicionaProdutoServlet"})
public class AdicionaProdutoServlet extends HttpServlet {

   @Override
   protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
       Produto produto = new Produto();
       produto.setNome(req.getParameter("nome"));
       produto.setPreco(Float.parseFloat(req.getParameter("preco")));
       
       ProdutoDAO dao = new ProdutoDAO(); 
       dao.salvar(produto);
      
       
       PrintWriter out = resp.getWriter();
       out.println("Produto salvo com Sucesso");
   }

}
