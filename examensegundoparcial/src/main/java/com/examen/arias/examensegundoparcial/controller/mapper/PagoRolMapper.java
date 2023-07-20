package com.examen.arias.examensegundoparcial.controller.mapper;

import com.examen.arias.examensegundoparcial.controller.dtos.CrearPagoRolRequest;
import com.examen.arias.examensegundoparcial.model.PagoRol;

public class PagoRolMapper {
    public static PagoRol map(CrearPagoRolRequest request) {
        return PagoRol.builder()
                .mes(request.getMes())
                .fechaProceso(request.getFechaProceso())
                .rucEmpresa(request.getRucEmpresa())
                .cuentaPrincipal(request.getCuentaPrincipal())
                .empleadosPagos(request.getEmpleadosPagos())
                .build();
    }
}
