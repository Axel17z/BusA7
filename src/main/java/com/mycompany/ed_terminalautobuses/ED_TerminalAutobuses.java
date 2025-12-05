package com.mycompany.ed_terminalautobuses;

import com.mycompany.ed_terminalautobuses.visitas.VentanaPrincipal;

public class ED_TerminalAutobuses {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });

    }
}
