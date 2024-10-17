package hospital.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DoctorView extends JFrame {
    private int[] pantalla = {1300, 800}; // Dimensiones de la ventana
    private JLabel nombreDoctor; // Etiqueta para el nombre del doctor
    private JLabel especialidad;  // Etiqueta para la especialidad del doctor

    // Constructor que recibe los datos del doctor
    public DoctorView(LinkedHashMap<String, String> datos) {
        setTitle("Perfil del Doctor - Hospital Santa Catalina");
        setSize(pantalla[0], pantalla[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Centrar la ventana

        // Panel de cabecera
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(1300, 60));
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setLayout(new BorderLayout());

        // Panel para el nombre del hospital
        JPanel hospitalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hospitalPanel.setBackground(Color.DARK_GRAY);
        JLabel hospitalLabel = new JLabel("Hospital Santa Catalina:");
        hospitalLabel.setForeground(Color.WHITE);
        hospitalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        hospitalPanel.add(hospitalLabel);
        headerPanel.add(hospitalPanel, BorderLayout.WEST);

        // Panel derecho para el logo y los datos del doctor
        JPanel doctorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        doctorPanel.setBackground(Color.DARK_GRAY);

        // Panel para el logo simulado (cuadro verde)
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(50, 50));
        logoPanel.setBackground(Color.GREEN);
        doctorPanel.add(logoPanel);

        // Etiqueta para el nombre del doctor
        nombreDoctor = new JLabel(datos.get("nombreDoctor")); // Se accede al HashMap correctamente
        nombreDoctor.setForeground(Color.WHITE);
        nombreDoctor.setFont(new Font("Arial", Font.BOLD, 16));
        doctorPanel.add(nombreDoctor);

        // Etiqueta para la especialidad del doctor
        especialidad = new JLabel(datos.get("especialidad")); // Se accede al HashMap correctamente
        especialidad.setForeground(Color.LIGHT_GRAY);
        especialidad.setFont(new Font("Arial", Font.PLAIN, 14));
        doctorPanel.add(especialidad);

        headerPanel.add(doctorPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Panel lateral vacío
        add(componenteMenuLateral(), BorderLayout.WEST);

        // Panel central vacío
        add(new JPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    public DoctorView() {

    }

    // Panel vacío para el menú lateral
    private JPanel componenteMenuLateral() {
        JPanel panelMenu = new JPanel();
        panelMenu.setPreferredSize(new Dimension(250, pantalla[1]));
        panelMenu.setBackground(new Color(35, 38, 40));
        return panelMenu;
    }

    // Método para iniciar sesión
    public void iniciarSesion() {
        // Lógica de inicio de sesión
        System.out.println("Iniciando sesión...");
        // Aquí podrías implementar un cuadro de diálogo de login o cualquier otro método de autenticación.
    }

    public static void main(String[] args) {
        // Suponiendo que el backend proporciona los datos del doctor como un HashMap
        LinkedHashMap<String, String> datos = backend.getDatos();  // El backend retorna el LinkedHashMap

        // Crear una instancia de la vista con los datos
        DoctorView doctorView = new DoctorView(datos); // Pasar los datos al constructor
    }
}

// Ejemplo de clase "backend" que retorna datos simulados del doctor
class backend {
    public static LinkedHashMap<String, String> getDatos() {
        LinkedHashMap<String, String> datos = new LinkedHashMap<>();
        datos.put("nombreDoctor", "Vanes Diaz");
        datos.put("especialidad", "Pediatría");
        return datos;
    }
}
