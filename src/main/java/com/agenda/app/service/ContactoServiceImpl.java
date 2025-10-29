package com.agenda.app.service;

import com.agenda.app.model.entity.dto.ContactoRequest;
import com.agenda.app.model.entity.dto.ContactoResponse;
import com.agenda.app.model.entity.Contacto;
import com.agenda.app.repository.ContactoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ContactoResponse> obtenerTodos() {
        return contactoRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ContactoResponse obtenerPorId(Long id) {
        Contacto contacto = contactoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado con ID: " + id));
        return convertirAResponse(contacto);
    }

    @Override
    public ContactoResponse crear(ContactoRequest contactoRequest) {
        if (contactoRequest.getEmail() != null &&
                contactoRepository.findByEmail(contactoRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un contacto con el email: " + contactoRequest.getEmail());
        }

        Contacto contacto = convertirAEntidad(contactoRequest);
        Contacto contactoGuardado = contactoRepository.save(contacto);
        return convertirAResponse(contactoGuardado);
    }

    @Override
    public ContactoResponse actualizar(Long id, ContactoRequest contactoRequest) {
        Contacto contactoExistente = contactoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado con ID: " + id));

        if (contactoRequest.getEmail() != null &&
                contactoRepository.existsByEmailAndIdNot(contactoRequest.getEmail(), id)) {
            throw new RuntimeException("Ya existe otro contacto con el email: " + contactoRequest.getEmail());
        }

        contactoExistente.setNombre(contactoRequest.getNombre());
        contactoExistente.setApellido(contactoRequest.getApellido());
        contactoExistente.setTelefono(contactoRequest.getTelefono());
        contactoExistente.setEmail(contactoRequest.getEmail());
        contactoExistente.setDireccion(contactoRequest.getDireccion());

        Contacto contactoActualizado = contactoRepository.save(contactoExistente);
        return convertirAResponse(contactoActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!contactoRepository.existsById(id)) {
            throw new RuntimeException("Contacto no encontrado con ID: " + id);
        }
        contactoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactoResponse> buscarPorNombre(String nombre) {
        return contactoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactoResponse> buscarPorTermino(String termino) {
        return contactoRepository.buscarPorTermino(termino)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    private ContactoResponse convertirAResponse(Contacto contacto) {
        ContactoResponse response = new ContactoResponse();
        response.setId(contacto.getId());
        response.setNombre(contacto.getNombre());
        response.setApellido(contacto.getApellido());
        response.setTelefono(contacto.getTelefono());
        response.setEmail(contacto.getEmail());
        response.setDireccion(contacto.getDireccion());
        response.setFechaCreacion(contacto.getFechaCreacion());
        response.setFechaActualizacion(contacto.getFechaActualizacion());
        return response;
    }

    private Contacto convertirAEntidad(ContactoRequest request) {
        Contacto contacto = new Contacto();
        contacto.setNombre(request.getNombre());
        contacto.setApellido(request.getApellido());
        contacto.setTelefono(request.getTelefono());
        contacto.setEmail(request.getEmail());
        contacto.setDireccion(request.getDireccion());
        return contacto;
    }
}