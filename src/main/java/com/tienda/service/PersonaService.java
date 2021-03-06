
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;
import com.tienda.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> getAllPerson(){
        return (List<Persona>)personaRepository.findAll();
    }
    
    @Override
    public void savePerson (Persona Persona){
        personaRepository.save(Persona);
    }
    
    @Override
    public Persona getPersonById(long id){
        return personaRepository.findById(id).orElse(null);
    }
    
    @Override
    public void delete (long id){
        personaRepository.deleteById(id);
    }
}
