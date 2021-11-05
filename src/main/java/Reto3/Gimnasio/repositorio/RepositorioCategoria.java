/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.repositorio;

import Reto3.Gimnasio.modelo.Categoria;
import Reto3.Gimnasio.interfac.InterfaceCategoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */

@Repository
public class RepositorioCategoria {
     @Autowired
    private InterfaceCategoria crud;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    
    public Optional <Categoria> getCategoria(int idCategoria){
        return crud.findById(idCategoria);
    }
    
    public Categoria save(Categoria categoria ){
        return crud.save(categoria);
    }
    public void delete(Categoria categoria){
       crud.delete(categoria);
    }
}
