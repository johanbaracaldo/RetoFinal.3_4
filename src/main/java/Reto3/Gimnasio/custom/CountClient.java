/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.custom;
import Reto3.Gimnasio.modelo.Cliente;

/**
 *
 * @author johan
 */
public class CountClient {
    private long total;
    private Cliente client;

    public CountClient(long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
}