/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.UsuarioOperador;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface UsuarioOperadorFacadeLocal {

    void create(UsuarioOperador usuarioOperador);

    void edit(UsuarioOperador usuarioOperador);

    void remove(UsuarioOperador usuarioOperador);

    UsuarioOperador find(Object id);

    List<UsuarioOperador> findAll();

    List<UsuarioOperador> findRange(int[] range);

    int count();
    
}
