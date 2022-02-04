package com.example.curso.Contoller;

import com.example.curso.DTO.PersonaDTO;
import com.example.curso.domain.Persona;
import com.example.curso.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/persona",produces = APPLICATION_JSON_VALUE)
public class ControladorBueno {
    @Autowired
    private PersonaService personasI;

    @GetMapping(path = "/verpersonas/{idPersona}")
    public PersonaDTO verPersonas(@PathVariable Long idPersona){
        return personasI.encontrarPersona(idPersona);
    }

    @GetMapping(path = "/verpersonas")
    public List<PersonaDTO> listaPersona(){
        return  personasI.listaPersona();
    }

    @PutMapping(path = "/actualizarpersonas/{idPersona}")
    public String actualizarPersona(@RequestBody PersonaDTO personaDTO,@PathVariable("idPersona") Long idPersona){
        return  personasI.actualizarPersona(personaDTO,idPersona);
    }

    @PostMapping(path = "/insertarpersona")
    public String guardar(@RequestBody PersonaDTO personaDTO){
        System.out.println(personaDTO.getNombre());
        System.out.println(personaDTO.getApellido());
        System.out.println(personaDTO.getEmail());
        System.out.println(personaDTO.getTelefono());
        personasI.guardar(personaDTO);
        return "Hola insertar";
    }

    @DeleteMapping(path = "/borrarpersona/{idPersona}")
    public String eliminar(@PathVariable("idPersona") Long idPersona){
         return personasI.eliminar(idPersona);
    }

}
