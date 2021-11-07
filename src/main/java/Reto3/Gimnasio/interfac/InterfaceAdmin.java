/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3.Gimnasio.interfac;

import Reto3.Gimnasio.modelo.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author johan
 */
public interface InterfaceAdmin extends CrudRepository<Admin,Integer>{
    
}
