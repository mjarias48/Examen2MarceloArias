package com.examen.arias.examensegundoparcial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.arias.examensegundoparcial.controller.dtos.CrearPagoRolRequest;
import com.examen.arias.examensegundoparcial.controller.dtos.ValidarPagoRolResponse;
import com.examen.arias.examensegundoparcial.controller.mapper.EmpresaMapper;
import com.examen.arias.examensegundoparcial.controller.mapper.PagoRolMapper;
import com.examen.arias.examensegundoparcial.model.Empresa;
import com.examen.arias.examensegundoparcial.model.PagoRol;
import com.examen.arias.examensegundoparcial.service.PagoRolService;

@RestController
@RequestMapping("/api/pago-rol")
public class PagoRolController {

    private final PagoRolService pagoRolService;

    public PagoRolController(PagoRolService pagoRolService) {
        this.pagoRolService = pagoRolService;
    }

    @PostMapping
    public ResponseEntity createPagoRol(
            @RequestBody CrearPagoRolRequest request) {
        try {
            PagoRol pagoRol = PagoRolMapper.map(request);
            this.pagoRolService.createPagoRol(pagoRol);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{mes}/{ruc}")
    public ResponseEntity<ValidarPagoRolResponse> validatePagoRol(
            @PathVariable("mes") String mes,
            @PathVariable("ruc") String ruc) {
        try {

            ValidarPagoRolResponse response = this.pagoRolService.validatePagoRol(mes, ruc);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
