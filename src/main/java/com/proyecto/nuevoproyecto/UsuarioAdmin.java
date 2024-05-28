package com.proyecto.nuevoproyecto;

public class UsuarioAdmin  {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private int dni;
    private int celular;
    private String cargo;


    public UsuarioAdmin(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public UsuarioAdmin(int id, String nombre, String apellido, String correo, String password, int dni, int celular, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.dni = dni;
        this.celular = celular;
        this.cargo = cargo;
    }

    public UsuarioAdmin(String nombre, String apellido, String correo, String password, int dni, int celular, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.dni = dni;
        this.celular = celular;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
