package com.agenda.app.service;

import com.agenda.app.model.entity.dto.ContactoRequest;
import com.agenda.app.model.entity.dto.ContactoResponse;
import java.util.List;

public interface ContactoService {

    List<ContactoResponse> obtenerTodos();
    ContactoResponse obtenerPorId(Long id);
    ContactoResponse crear(ContactoRequest contactoRequest);
    ContactoResponse actualizar(Long id, ContactoRequest contactoRequest);
    void eliminar(Long id);
    List<ContactoResponse> buscarPorNombre(String nombre);
    List<ContactoResponse> buscarPorTermino(String termino);
}