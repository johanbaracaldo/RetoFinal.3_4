/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.repositorio;

import Reto3.Gimnasio.interfac.InterfaceScore;
import Reto3.Gimnasio.modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class RepositorioScore {
    @Autowired
    private InterfaceScore scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }  
  
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}