package mx.edu.utez.RegistroCuneta.service;


import mx.edu.utez.RegistroCuneta.dtos.CreateCuentaDTO;
import mx.edu.utez.RegistroCuneta.dtos.ProductoDTO;
import mx.edu.utez.RegistroCuneta.model.Cuenta;
import mx.edu.utez.RegistroCuneta.model.Producto;
import mx.edu.utez.RegistroCuneta.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;


    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Map<String, Object> crearCuenta(ProductoDTO dto) {
        Map<String, Object> respuestas = new HashMap<>();

        if (productoRepository.existsBySkuid(dto.getSkuid())) {
            respuestas.put("mensaje", "El email ya está registrado");
            respuestas.put("code", 400);
            return respuestas;
        }


        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCaducidad(dto.getCaducidad());
        producto.setSkuid(dto.getSkuid());

       productoRepository.save(producto);
        respuestas.put("mensaje", "Producto creado con exito");
        respuestas.put("code", 200);
        respuestas.put("producto", producto);
        return respuestas;

    }

    public Map<String, Object> obtenerCuentas() {
        Map<String, Object> respuestas = new HashMap<>();
        respuestas.put("cuentas", productoRepository.findAll());
        respuestas.put("mensaje", "Consulta exitosa");
        return respuestas;
    }

    public Map<String, Object> obtenerPorId(Integer id) {
        Map<String, Object> respuestas = new HashMap<>();
        Optional<Cuenta> opt = productoRepository.findById(id);

        if (opt.isPresent()) {
            respuestas.put("cuenta", opt.get());
            respuestas.put("mensaje", "Cuenta encontrada");
        } else {
            respuestas.put("mensaje", "Cuenta no encontrada");
        }

        return respuestas;
    }






}
