package mx.edu.utez.RegistroCuneta.repository;


import mx.edu.utez.RegistroCuneta.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productorepository extends JpaRepository<Producto, Integer> {
    boolean existsBySku(String sku);
}
