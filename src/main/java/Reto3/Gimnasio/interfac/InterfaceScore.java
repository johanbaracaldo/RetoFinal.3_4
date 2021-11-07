/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3.Gimnasio.interfac;

import Reto3.Gimnasio.modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author johan
 */
public interface InterfaceScore extends CrudRepository<Score,Integer> {

    
}
