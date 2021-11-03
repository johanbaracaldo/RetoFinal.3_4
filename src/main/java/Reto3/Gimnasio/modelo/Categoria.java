/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author johan
 */

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
     @Id
     @GeneratedValue
     private Integer idCategoria;
     private String name;
     private String description;
     
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="categoria")
     @JsonIgnoreProperties("categoria")
     private List<Gymmachine> machine;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Gymmachine> getMachine() {
        return machine;
    }

    public void setMachine(List<Gymmachine> machine) {
        this.machine = machine;
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
  
     
     

    
     
     
     
     
}

