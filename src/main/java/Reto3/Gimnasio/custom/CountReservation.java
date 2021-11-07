/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.custom;
import Reto3.Gimnasio.modelo.Reservaciones;

/**
 *
 * @author johan
 */
public class CountReservation {
    private Integer total;
    private Reservaciones reservation;

    public CountReservation(Integer total, Reservaciones reservation) {
        this.total = total;
        this.reservation = reservation;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Reservaciones getReservation() {
        return reservation;
    }

    public void setReservation(Reservaciones reservation) {
        this.reservation = reservation;
    }
    
}