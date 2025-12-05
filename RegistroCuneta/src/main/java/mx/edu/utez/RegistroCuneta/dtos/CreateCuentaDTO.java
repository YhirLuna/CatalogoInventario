package mx.edu.utez.RegistroCuneta.dtos;

import java.util.Date;

public class CreateCuentaDTO {

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String sexo;
    private String CURP;
    private String email;

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
