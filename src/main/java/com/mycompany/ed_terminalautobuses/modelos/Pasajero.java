/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_terminalautobuses.modelos;

public class Pasajero {
    private String nombre;
    private String origen;
    private String destino;
    private double precio;
    private int numeroAsiento;
    
    public Pasajero(String nombre, String origen, String destino, 
                   double precio, int numeroAsiento) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.numeroAsiento = numeroAsiento;
    }
    
    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public double getPrecio() { return precio; }
    public int getNumeroAsiento() { return numeroAsiento; }
}