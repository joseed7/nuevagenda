package com.agenda.app.controller;

import com.agenda.app.model.entity.dto.ContactoRequest;
import com.agenda.app.model.entity.dto.ContactoResponse;
import com.agenda.app.service.ContactoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@RequiredArgsConstructor
@Tag(name = "Contactos", description = "API para gestión de contactos de agenda")
public class ContactoController {

    private final ContactoService contactoService;

    @GetMapping
    @Operation(summary = "Obtener todos los contactos")
    public ResponseEntity<List<ContactoResponse>> obtenerTodos() {
        return ResponseEntity.ok(contactoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener contacto por ID")
    public ResponseEntity<ContactoResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(contactoService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo contacto")
    public ResponseEntity<ContactoResponse> crear(@Valid @RequestBody ContactoRequest contactoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactoService.crear(contactoRequest));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar contacto existente")
    public ResponseEntity<ContactoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ContactoRequest contactoRequest) {
        return ResponseEntity.ok(contactoService.actualizar(id, contactoRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar contacto")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        contactoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar contactos por nombre")
    public ResponseEntity<List<ContactoResponse>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(contactoService.buscarPorNombre(nombre));
    }

    @GetMapping("/buscar-termino")
    @Operation(summary = "Búsqueda general")
    public ResponseEntity<List<ContactoResponse>> buscarPorTermino(@RequestParam String termino) {
        return ResponseEntity.ok(contactoService.buscarPorTermino(termino));
    }
}