package com.examen.arias.examensegundoparcial.controller.dtos;

import java.util.List;

import com.examen.arias.examensegundoparcial.model.Empleado;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CrearEmpresaRequest {

    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
    private List<Empleado> empleados;
}
