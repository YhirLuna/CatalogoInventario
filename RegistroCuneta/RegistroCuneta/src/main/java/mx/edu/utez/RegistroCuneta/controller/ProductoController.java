package mx.edu.utez.RegistroCuneta.controller;


import mx.edu.utez.RegistroCuneta.dtos.CreateProductoDTO;
import mx.edu.utez.RegistroCuneta.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cuenta")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;

    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody CreateProductoDTO dto) {
        Map<String, Object> respuesta = productoService.createProducto(dto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(productoService.obtenerPorId(id), HttpStatus.OK);
    }
}
