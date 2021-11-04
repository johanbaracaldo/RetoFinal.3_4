/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.repositorio;

import Reto3.Gimnasio.modelo.Gymmachine;
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

    public List<Gymmachine> getAll(){
        return (List<Gymmachine>) crud.findAll();
    }

    public Optional<Gymmachine> getBike(int id){
        return crud.findById(id);
    }

    public Gymmachine save(Gymmachine machine){
        return crud.save(machine);
    }
    public void delete(Gymmachine machine){
        crud.delete(machine);
    }

    public Optional<Gymmachine> getMachine(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Optional<Gymmachine> getGymmachine(int machineId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}