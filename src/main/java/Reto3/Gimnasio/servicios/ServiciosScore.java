/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.servicios;


import Reto3.Gimnasio.modelo.Score;
import Reto3.Gimnasio.repositorio.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class ServiciosScore {
    @Autowired
    private RepositorioScore metodosCrud;
 
    public List<Score> getAll(){
       return metodosCrud.getAll();
    }
    public Optional<Score> getScore(int scoreId) {
        return metodosCrud.getScore(scoreId);
    }
    public Score save(Score score) {
        if (score.getIdScore() == null) {
            return metodosCrud.save(score);
        } else {
            Optional<Score> scoreUno = metodosCrud.getScore(score.getIdScore());
            if (scoreUno.isEmpty()) {
                return metodosCrud.save(score);
            } else {
                return score;
            }
        }
    }
    
    //idscore,messagetext,stars
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> evento=metodosCrud.getScore(score.getIdScore());
            if(!evento.isEmpty()){
                if(score.getMessageText()!=null){
                    //evento.get().setStartDate(reservation.getStartDate());
                    evento.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    evento.get().setStars(score.getStars());
                }
                metodosCrud.save(evento.get());
                return evento.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    public boolean delete(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}