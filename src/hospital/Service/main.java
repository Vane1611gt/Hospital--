package hospital.Service;

import hospital.view.DoctorView;

import javax.swing.*;

// Clase principal para ejecutar la aplicación
public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorView());
    }
}
