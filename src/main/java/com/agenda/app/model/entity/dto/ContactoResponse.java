package com.agenda.app.model.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Schema(description = "DTO para respuesta de contacto")
public class ContactoResponse {

    @Schema(description = "ID único del contacto", example = "1")
    private Long id;

    @Schema(description = "Nombre del contacto", example = "Juan")
    private String nombre;

    @Schema(description = "Apellido del contacto", example = "Pérez")
    private String apellido;

    @Schema(description = "Número de teléfono", example = "+1234567890")
    private String telefono;

    @Schema(description = "Dirección de email", example = "juan@example.com")
    private String email;

    @Schema(description = "Dirección física", example = "Calle Principal 123")
    private String direccion;

    @Schema(description = "Fecha de creación del contacto")
    private LocalDateTime fechaCreacion;

    @Schema(description = "Fecha de última actualización")
    private LocalDateTime fechaActualizacion;
}