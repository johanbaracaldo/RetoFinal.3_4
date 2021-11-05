/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.repositorio;

import Reto3.Gimnasio.modelo.Machine;
import Reto3.Gimnasio.interfac.InterfaceMachine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */


@Repository
public class RepositorioMachine {
      @Autowired
    private InterfaceMachine crud;
    

    public List<Machine> getAll(){
        return (List<Machine>) crud.findAll();       
    }
    
    public Optional <Machine> getMachine(int idMachine){
        return crud.findById(idMachine);
    }
    
    public Machine save(Machine machine){
        return crud.save(machine);
    }
     public void delete(Machine machine){
        crud.delete(machine);
    }

   
    
}