/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.UsuarioOperador;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UsuarioOperadorFacade extends AbstractFacade<UsuarioOperador> implements UsuarioOperadorFacadeLocal {

    @PersistenceContext(unitName = "CadEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioOperadorFacade() {
        super(UsuarioOperador.class);
    }
    
}
