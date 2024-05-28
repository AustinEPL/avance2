package com.proyecto.nuevoproyecto;

import java.util.Date;

public class Canchas {
    private int id;
    private String nombre;
    private String direccion;
    private String horario;
    private double precio;
    private int longitud, ancho;
    private String descripcion;
    private int capacidad;
    private String imagen;

    public Canchas(int id, String nombre, String direccion, String horario, double precio, int longitud, int ancho, String descripcion, int capacidad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.precio = precio;
        this.longitud = longitud;
        this.ancho = ancho;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.imagen = imagen;
    }

    public Canchas(String nombre, String direccion, String horario, double precio, int longitud, int ancho, String descripcion, int capacidad, String imagen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.precio = precio;
        this.longitud = longitud;
        this.ancho = ancho;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.imagen = imagen;
    }

    //sin imagen


    public Canchas(int id, String nombre, String direccion, String horario, double precio, int longitud, int ancho, String descripcion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.precio = precio;
        this.longitud = longitud;
        this.ancho = ancho;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Canchas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", horario='" + horario + '\'' +
                ", precio=" + precio +
                ", longitud=" + longitud +
                ", ancho=" + ancho +
                ", capacidad=" + capacidad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
