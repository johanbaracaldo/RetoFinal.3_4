/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Gimnasio.servicios;

import Reto3.Gimnasio.modelo.Admin;
import Reto3.Gimnasio.repositorio.RepositorioAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class ServiciosAdmin {
    @Autowired
    private RepositorioAdmin adminRepository;
 
    public List<Admin> getAll(){
       return adminRepository.getAll();
    }
    
         public Optional<Admin> getAdmin(int adminId) {
        return adminRepository.getAdmin(adminId);
    }

    
    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
    
    //idAdmin,email,password,name
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> evento = adminRepository.getAdmin(admin.getIdAdmin());
            if(!evento.isEmpty()){
                if("".equals(admin.getName()!=null)){
                    evento.get().setName(admin.getName());
                }
                
                if("".equals(admin.getPassword()!=null)){
                    evento.get().setPassword(admin.getPassword());
                }
                if("".equals(admin.getEmail()!=null)){
                    evento.get().setEmail(admin.getEmail());
                    
                }
                adminRepository.save(admin);
                return  evento.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }       
    }
    
    public boolean delete(int adminId){
     Boolean aBoolean = adminRepository.getAdmin(adminId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}