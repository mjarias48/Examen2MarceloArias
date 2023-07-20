package com.examen.arias.examensegundoparcial.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.arias.examensegundoparcial.controller.dtos.AñadirEmpleadoRequest;
import com.examen.arias.examensegundoparcial.controller.dtos.CrearEmpresaRequest;
import com.examen.arias.examensegundoparcial.controller.mapper.EmpresaMapper;
import com.examen.arias.examensegundoparcial.model.Empleado;
import com.examen.arias.examensegundoparcial.model.Empresa;
import com.examen.arias.examensegundoparcial.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity createEmpresa(
            @RequestBody CrearEmpresaRequest request) {
        try {
            Empresa empresa = EmpresaMapper.map(request);
            this.empresaService.createEmpresa(empresa);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{ruc}")
    public ResponseEntity añadirEmpleado(
            @PathVariable("ruc") String ruc,
            @RequestBody AñadirEmpleadoRequest request) {
        try {
            Empleado empleado = EmpresaMapper.map(request);
            this.empresaService.addEmpleado(ruc, empleado);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
