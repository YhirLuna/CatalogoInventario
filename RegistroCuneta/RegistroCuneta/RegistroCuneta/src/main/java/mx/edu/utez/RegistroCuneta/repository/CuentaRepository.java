package mx.edu.utez.RegistroCuneta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    boolean existsByEmail(String email);

    boolean existsByCURP(String CURP);

    Cuenta findByEmail(String email);
}
