package mx.edu.utez.RegistroCuneta.controller;



import mx.edu.utez.RegistroCuneta.dtos.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ProductoDTO dto) {
        Map<String, Object> respuesta = productoService.crearCuenta(dto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(productoService.obtenerCuentas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(productoService.obtenerPorId(id), HttpStatus.OK);
    }
}
