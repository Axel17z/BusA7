/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed_terminalautobuses.modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Terminal {
    private List<String> terminales;
    private int terminalActual;
    private List<Asiento> asientos;
    private List<Pasajero> pasajeros;
    private double gananciasTotales;
    
    public Terminal() {
        terminales = Arrays.asList(
            "Navojoa", "Obregón", "Empalme", "Guaymas", 
            "Hermosillo", "Santa Ana", "Magdalena", "Imuris", "Nogales"
        );
        terminalActual = 0;
        gananciasTotales = 0;
        pasajeros = new ArrayList<>();
        
        // Inicializar 20 asientos
        asientos = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            asientos.add(new Asiento(i));
        }
    }
    
    public String getTerminalActual() {
        return terminales.get(terminalActual);
    }
    
    public String getTerminalSiguiente() {
        if (terminalActual < terminales.size() - 1) {
            return terminales.get(terminalActual + 1);
        }
        return "FIN DEL VIAJE";
    }
    
    public void avanzarTerminal() {
        if (terminalActual < terminales.size() - 1) {
            terminalActual++;
            // Bajar pasajeros en esta terminal
            bajarPasajeros();
        }
    }
    
    private void bajarPasajeros() {
        int bajados = 0;
        for (Pasajero p : pasajeros) {
            if (p.getDestino().equals(getTerminalActual())) {
                bajados++;
                // Liberar asiento
                for (Asiento a : asientos) {
                    if (a.getPasajero() == p) {
                        a.desocupar();
                        break;
                    }
                }
            }
        }
        System.out.println("Se bajan " + bajados + " pasajeros en " + getTerminalActual());
    }
    
    public boolean venderBoleto(Pasajero pasajero, int numeroAsiento) {
        if (numeroAsiento < 1 || numeroAsiento > 20) return false;
        
        Asiento asiento = asientos.get(numeroAsiento - 1);
        if (!asiento.isOcupado()) {
            asiento.ocupar(pasajero);
            pasajeros.add(pasajero);
            gananciasTotales += pasajero.getPrecio();
            return true;
        }
        return false;
    }
    
    public List<Asiento> getAsientosDisponibles() {
        List<Asiento> disponibles = new ArrayList<>();
        for (Asiento a : asientos) {
            if (!a.isOcupado()) {
                disponibles.add(a);
            }
        }
        return disponibles;
    }
    
    public List<Pasajero> getPasajerosActuales() {
        return new ArrayList<>(pasajeros);
    }
    
    public double getGananciasTotales() {
        return gananciasTotales;
    }
    
    public boolean esUltimaTerminal() {
        return terminalActual == terminales.size() - 1;
    }
    
    public List<String> getTerminales() {
        return new ArrayList<>(terminales);
    }
}