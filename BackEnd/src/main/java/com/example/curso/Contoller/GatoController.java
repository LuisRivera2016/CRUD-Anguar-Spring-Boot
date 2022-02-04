package com.example.curso.Contoller;

import com.example.curso.DTO.GatoDTO;
import com.example.curso.Exceptions.NotFoundException;
import com.example.curso.domain.Gato;
import com.example.curso.service.GatoService;
import com.example.curso.util.ConvertEntitytoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/gato",produces = APPLICATION_JSON_VALUE)
public class GatoController {

    @Autowired
    private GatoService gatoService;

    @Autowired
    private ConvertEntitytoDTO convertEntitytoDTO;

    @PostMapping(path = "/insertar",consumes = APPLICATION_JSON_VALUE)
    public String insertarGato(@RequestBody GatoDTO gatoDTO){
        gatoService.guardar(gatoDTO);
        return "Se inserto";
    }

    @GetMapping(path = "/obtener")
    public List<GatoDTO> obtenerGatos(){
        return  gatoService.listaGato();
    }

    @GetMapping(path = "/obtenerGato/{idGato}")
    public GatoDTO obtenerGato(@PathVariable("idGato") Long idGato){
        return gatoService.obtenerGato(idGato);
    }

    @PutMapping(path = "/actualizar/{idGato}")
    public String actualizarGato(@RequestBody GatoDTO gatoDTO,@PathVariable("idGato") Long idGato){
        return  gatoService.actualizarGato(gatoDTO,idGato);
    }

    @DeleteMapping(path = "/borrar/{idGato}")
    public String borrarGato(@PathVariable("idGato") Long idGato){
        return  gatoService.eliminar(idGato);
    }

}
