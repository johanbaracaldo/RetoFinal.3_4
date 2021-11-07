/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.servicios;

import Reto3.Gimnasio.custom.CountClient;
import Reto3.Gimnasio.custom.StatusReservation;
import Reto3.Gimnasio.modelo.Reservaciones;
import Reto3.Gimnasio.repositorio.RepositorioReservaciones;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class ServiciosReservaciones {

    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservaciones> e = metodosCrud.getReservation((int) reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservaciones update(Reservaciones reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservaciones> e = metodosCrud.getReservation((int) reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservation reporteStatusServicio() {
        List<Reservaciones> completed = metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservaciones> cancelled = metodosCrud.ReservacionStatusRepositorio("cancelled");

        return new StatusReservation(completed.size(), cancelled.size());
    }

    /**
     *
     * @param datoA
     * @param datoB
     * @return
     */
    public List<Reservaciones> reporteTiempoServicio(String datoA, String datoB) throws java.text.ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        datoUno = parser.parse(datoA);
        datoDos = parser.parse(datoB);
        if (datoUno.before(datoDos)) {
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();

        }
    }

    /**
     *
     * @return
     */
    public List<CountClient> reporteClientesServicio() {
        return metodosCrud.getClientesRepositorio();
    }

}
