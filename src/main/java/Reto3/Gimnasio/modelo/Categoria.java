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
     /**
        *definicion de campos id 
        */
     @Id
     @GeneratedValue
     private Integer id;
     /**
        * camponame 
        */
     private String name;
     /**
        * descripcion 
        */
     private String description;
     /**
        *relacion de categoria con maquinas
        */
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")
     @JsonIgnoreProperties("category")
     private List<Machine> machines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}