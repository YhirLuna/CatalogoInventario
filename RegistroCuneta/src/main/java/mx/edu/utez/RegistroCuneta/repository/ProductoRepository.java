package mx.edu.utez.RegistroCuneta.repository;

import mx.edu.utez.RegistroCuneta.model.Cuenta;
import mx.edu.utez.RegistroCuneta.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Cuenta, Integer> {

    boolean existsBySkuid(String skuid);

    void save(Producto producto);
}
