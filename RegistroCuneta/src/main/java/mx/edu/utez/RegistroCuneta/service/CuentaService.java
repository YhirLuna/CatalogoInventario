package mx.edu.utez.RegistroCuneta.service;

import mx.edu.utez.RegistroCuneta.dtos.CreateCuentaDTO;
import mx.edu.utez.RegistroCuneta.model.Cuenta;
import mx.edu.utez.RegistroCuneta.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    private boolean esMayorDe17(Date fechaNacimiento) {
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);

        Calendar hoy = Calendar.getInstance();

        int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad >= 18;
    }


    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Map<String, Object> crearCuenta(CreateCuentaDTO dto) {
        Map<String, Object> respuesta = new HashMap<>();

        if (cuentaRepository.existsByEmail(dto.getEmail())) {
            respuesta.put("mensaje", "El email ya está registrado");
            respuesta.put("code", 400);
            return respuesta;
        }

        if (cuentaRepository.existsByCURP(dto.getCURP())) {
            respuesta.put("mensaje", "La CURP ya está registrada");
            respuesta.put("code", 400);
            return respuesta;
        }

        if (!esMayorDe17(dto.getFechaNacimiento())) {
            respuesta.put("mensaje", "Debes tener al menos 18 años.");
            return respuesta;
        }

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(dto.getNombre());
        cuenta.setApellido(dto.getApellido());
        cuenta.setFechaNacimiento(dto.getFechaNacimiento());
        cuenta.setSexo(dto.getSexo());
        cuenta.setCURP(dto.getCURP());
        cuenta.setEmail(dto.getEmail());

        cuentaRepository.save(cuenta);

        respuesta.put("mensaje", "Cuenta creada exitosamente");
        respuesta.put("code", 200);
        respuesta.put("cuenta", cuenta);
        return respuesta;
    }

    public Map<String, Object> obtenerCuentas() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("cuentas", cuentaRepository.findAll());
        respuesta.put("mensaje", "Consulta exitosa");
        return respuesta;
    }

    public Map<String, Object> obtenerPorId(Integer id) {
        Map<String, Object> respuesta = new HashMap<>();
        Optional<Cuenta> opt = cuentaRepository.findById(id);

        if (opt.isPresent()) {
            respuesta.put("cuenta", opt.get());
            respuesta.put("mensaje", "Cuenta encontrada");
        } else {
            respuesta.put("mensaje", "Cuenta no encontrada");
        }

        return respuesta;
    }
}
