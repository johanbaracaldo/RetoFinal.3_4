/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.servicios;

import Reto3.Gimnasio.modelo.Gymmachine;
import Reto3.Gimnasio.repositorio.RepositorioMachine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */

@Service
public class ServiciosMachine {
     @Autowired
    private RepositorioMachine metodosCrud;

    public List<Gymmachine> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Gymmachine> getMachine(int id) {
        return metodosCrud.getMachine(id);
    }

    public Gymmachine save(Gymmachine machine){
        if(machine.getId()==null){
            return metodosCrud.save(machine);
        }else{
            Optional<Gymmachine> e=metodosCrud.getMachine(machine.getId());
            if(e.isEmpty()){
                return metodosCrud.save(machine);
            }else{
                return machine;
            }
        }
    }

    public Gymmachine update(Gymmachine machine){
        if(machine.getId()!=null){
            Optional<Gymmachine> e=metodosCrud.getBike(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getCategoria()!=null){
                    e.get().setCategoria(machine.getCategoria());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }


    public boolean deleteMachine(int id) {
        Boolean aBoolean = getMachine(id).map(machine -> {
            metodosCrud.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
