/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.repositorio;

import Reto3.Gimnasio.interfac.InterfaceReservaciones;
import Reto3.Gimnasio.modelo.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterfaceReservaciones crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int idReservacion){
        return crud4.findById(idReservacion);
    }
    public Reservaciones save(Reservaciones reservations){
        return crud4.save(reservations);
    }
    public void delete(Reservaciones reservations){
        crud4.delete(reservations);
    }
   
   
}
