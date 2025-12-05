package mx.edu.utez.RegistroCuneta.controller;

import mx.edu.utez.RegistroCuneta.dtos.CreateCuentaDTO;
import mx.edu.utez.RegistroCuneta.service.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cuenta")
@CrossOrigin(origins = "*")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody CreateCuentaDTO dto) {
        Map<String, Object> respuesta = cuentaService.crearCuenta(dto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(cuentaService.obtenerCuentas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(cuentaService.obtenerPorId(id), HttpStatus.OK);
    }
}
