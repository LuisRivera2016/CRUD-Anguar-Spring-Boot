package com.example.curso.Repository;

import com.example.curso.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    @Query(value = "SELECT * FROM Persona WHERE  id_persona =:idPersona",nativeQuery = true)
    Persona obtenerPersona(@Param("idPersona") Long idPersona);

    @Query(value = "SELECT count(*) FROM Persona WHERE  id_persona =:idPersona",nativeQuery = true)
    long validaExistePersona(@Param("idPersona") Long idPersona);

    @Query(value = "UPDATE Persona SET nombre = :nombreN WHERE id_persona =:idPersona ",nativeQuery = true)
    String actualizarPersona(@Param("idPersona") Long idPersona,String nombreN);

}
