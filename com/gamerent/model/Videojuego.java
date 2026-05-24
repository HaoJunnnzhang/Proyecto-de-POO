package com.gamerent.model;

public abstract class  Videojuego {
    
    private String id;          
    private String titulo;
    private double precioBase;
    private boolean alquilado;// estado de disponibilidad

    public Videojuego(String id, String titulo, double precioBase) {
        this.id        = id;
        this.titulo    = titulo;
        this.precioBase = precioBase;
        this.alquilado  = false;
    }
    
    public abstract double calcularPrecioAlquiler(int dias);

    
    //Getters y Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
}
