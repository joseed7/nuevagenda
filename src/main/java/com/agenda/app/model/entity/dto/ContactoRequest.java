package com.agenda.app.model.entity.dto;

// CORRECTOS PARA SPRING BOOT 3
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "DTO para crear o actualizar un contacto")
public class ContactoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Schema(description = "Nombre del contacto", example = "Juan")
    private String nombre;

    @Size(max = 100, message = "El apellido no puede exceder 100 caracteres")
    @Schema(description = "Apellido del contacto", example = "Pérez")
    private String apellido;

    @Size(max = 20, message = "El teléfono no puede exceder 20 caracteres")
    @Schema(description = "Número de teléfono", example = "+1234567890")
    private String telefono;

    @Email(message = "El formato del email no es válido")
    @Size(max = 150, message = "El email no puede exceder 150 caracteres")
    @Schema(description = "Dirección de email", example = "juan@example.com")
    private String email;

    @Size(max = 255, message = "La dirección no puede exceder 255 caracteres")
    @Schema(description = "Dirección física", example = "Calle Principal 123")
    private String direccion;
}