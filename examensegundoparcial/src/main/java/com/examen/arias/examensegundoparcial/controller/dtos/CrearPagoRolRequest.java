package com.examen.arias.examensegundoparcial.controller.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.examen.arias.examensegundoparcial.model.EmpleadoPago;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CrearPagoRolRequest {

    private String mes;
    private LocalDateTime fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private List<EmpleadoPago> empleadosPagos;

}
