package mx.edu.utez.RegistroCuneta.service;


import mx.edu.utez.RegistroCuneta.dtos.CreateProductoDTO;
import mx.edu.utez.RegistroCuneta.model.Producto;
import mx.edu.utez.RegistroCuneta.repository.Productorepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService {
    private final Productorepository productorepository;


    public ProductoService(Productorepository productorepository) {
        this.productorepository = productorepository;
    }


    public Map<String, Object> createProducto(CreateProductoDTO dto){
    Map<String, Object> respuesta = new HashMap<>();

    if(productorepository.existsBySku(dto.getSku())){
        respuesta.put("mensaje", "El sku ya esta registrado");
        respuesta.put("code", 400);
        return respuesta;
    }
    if (dto.getPrecio() <= 0){
        respuesta.put("mensaje", "El precio es menor a 0");
        respuesta.put("code", 400);
        return respuesta;
    }

        if (dto.getStock() < 0){
            respuesta.put("mensaje", "El stock es negativo");
            respuesta.put("code", 400);
            return respuesta;
        }

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setSku(dto.getSku());
        producto.setStock(dto.getStock());

        productorepository.save(producto);
        respuesta.put("mensaje", "Producto creado");
        respuesta.put("code", 200);
        respuesta.put("producto", producto);
        return respuesta;

    }

    public Map<String, Object> obtenerPorId(Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        Optional<Producto> opt = productorepository.findById(id);

        if (opt.isPresent()) {
            respuesta.put("producto", opt.get());
            respuesta.put("mensaje", "procuto encontrado");
        } else {
            respuesta.put("mensaje", "Producto no encontrado");
        }

        return respuesta;
    }


    public Map<String, Object> actualizarProducto(Integer id, CreateProductoDTO dto){
        Map<String, Object> respuesta = new HashMap<>();
        Optional<Producto> opt = productorepository.findById(id);

        if (!opt.isPresent()){
            respuesta.put("message", "El producto no se encontro");
            respuesta.put("code", "404");
        }

        Producto producto = opt.get();

        if(!producto.getSku().equals(dto.getSku()) && productorepository.existsBySku(dto.getSku())){
            respuesta.put("message", "El Sku ya existe");
            respuesta.put("code", 400);
        }

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setSku(dto.getSku());
        producto.setStock(dto.getStock());


        productorepository.save(producto);
        respuesta.put("message", "Producto actualizado con exito");
        respuesta.put("empleado", producto);
        respuesta.put("code", 200);
        return respuesta;
    }
}
