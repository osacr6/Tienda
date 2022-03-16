package com.tienda.controller;

import com.tienda.entity.*;
import com.tienda.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonasController {
    @Autowired
    private IPersonaService personaService;
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/personas")
    public String index (Model model){
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute ("titulo", "personas");
        model.addAttribute ("personas", listaPersonas);
        return "personas";
    }
    
    @GetMapping("/crearPersona")
    public String crearPersona(Model model) {
        List<Pais> listaPais = paisService.listContry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPais);
        return "crear";
    }
    
    @PostMapping("/guardarPersona")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePerson(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/modificarPersona/{id}")
    public String modificarPersona(Model model, @PathVariable("id") Long idPersona) {
        Persona persona = personaService.getPersonById(idPersona);
        List<Pais> ListaPais  = paisService.listContry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", ListaPais);
        return "modificarPersona";
    }
    
    @PostMapping("/editarPersona")
    public String editarPersona(@ModelAttribute Persona persona) {
        personaService.savePerson(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/eliminarPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/personas";
    }
}
