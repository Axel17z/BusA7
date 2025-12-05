/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_terminalautobuses.modelos;

public class Asiento {
    private int numero;
    private boolean ocupado;
    private Pasajero pasajero;
    
    public Asiento(int numero) {
        this.numero = numero;
        this.ocupado = false;
        this.pasajero = null;
    }
    
    public void ocupar(Pasajero pasajero) {
        this.ocupado = true;
        this.pasajero = pasajero;
    }
    
    public void desocupar() {
        this.ocupado = false;
        this.pasajero = null;
    }
    
    public int getNumero() { return numero; }
    public boolean isOcupado() { return ocupado; }
    public Pasajero getPasajero() { return pasajero; }
}