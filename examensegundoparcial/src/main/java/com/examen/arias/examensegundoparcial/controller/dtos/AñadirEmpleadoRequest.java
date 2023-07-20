package com.examen.arias.examensegundoparcial.controller.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AñadirEmpleadoRequest {
    private String cedula;
    private String apellidos;
    private String nombres;
    private String numeroCuenta;
}
