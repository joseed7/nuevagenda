package com.agenda.app.repository;

import com.agenda.app.model.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    List<Contacto> findByNombreContainingIgnoreCase(String nombre);

    Optional<Contacto> findByEmail(String email);

    @Query("SELECT c FROM Contacto c WHERE " +
            "LOWER(c.nombre) LIKE LOWER(CONCAT('%', :termino, '%')) OR " +
            "LOWER(c.apellido) LIKE LOWER(CONCAT('%', :termino, '%')) OR " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :termino, '%'))")
    List<Contacto> buscarPorTermino(@Param("termino") String termino);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END " +
            "FROM Contacto c WHERE c.email = :email AND c.id != :id")
    boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") Long id);
}