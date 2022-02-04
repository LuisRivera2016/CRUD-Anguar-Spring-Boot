package com.example.curso.Repository;

import com.example.curso.domain.Gato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GatoRepository extends JpaRepository<Gato,Long> {

    @Query(value = "SELECT count(*) FROM Gato WHERE  id_Gato =:idGato",nativeQuery = true)
    long validaExisteGato(@Param("idGato") Long idGato);

    @Query(value = "SELECT * FROM Gato WHERE  id_Gato =:idGato",nativeQuery = true)
    Gato obtenerGato(@Param("idGato") Long idGato);

    Gato findByidGato(Long idGato);
}
