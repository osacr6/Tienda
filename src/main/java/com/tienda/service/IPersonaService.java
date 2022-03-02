package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getAllPerson();
    public void savePerson (Persona Persona);
    public Persona getPersonById (long id);
    public void delete (long id);
}
