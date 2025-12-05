package mx.edu.utez.RegistroCuneta.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String sexo;

    @Column(unique = true)
    private String CURP;

    @Column(unique = true)
    private String email;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getCURP() { return CURP; }
    public void setCURP(String CURP) { this.CURP = CURP; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
