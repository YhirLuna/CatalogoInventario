package mx.edu.utez.RegistroCuneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Cuenta, Integer> {

    boolean existsBySkuid(String skuid);

    void save(Producto producto);
}
