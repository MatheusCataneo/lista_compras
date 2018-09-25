/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.betha.dao;
import br.com.betha.entidade.Produto;
import br.com.betha.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author matheus
 */
public class ProdutoDAO {
    
    
    public void salvar(Produto produto){
        //Cria e abre a sessão
        Session session = HibernateUtil.getSessionFactory().openSession();
        //inicia
        session.beginTransaction();
        //salva
        session.persist(produto);
        //comita
        session.getTransaction().commit();
        //libera memoria
        session.flush();
        //fecha
        session.close();
    }
    
    public List<Produto> listar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<Produto> produto = session.getNamedQuery("Produto.findAll").list();
        
        session.close();
        return produto;

    }
}
