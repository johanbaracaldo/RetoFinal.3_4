/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.web;

import Reto3.Gimnasio.modelo.Score;
import Reto3.Gimnasio.servicios.ServiciosScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebScore {
    @Autowired
    private ServiciosScore scoreService;
        @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
    
    @GetMapping("/get/{id}")
    public Optional<Score> get(@PathVariable("id") int reservationId){
        return scoreService.getScore(reservationId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score reservation){
        return scoreService.save(reservation);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score reservation) {
        return scoreService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservation) {
        return scoreService.delete(reservation);
    }   
}