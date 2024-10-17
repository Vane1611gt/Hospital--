package controller;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login() {
        // Configurar el marco principal
        this.setTitle("Login");
        this.setLayout(new GridLayout(1, 2));
        this.setBounds(0, 0, 800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel izquierdo con color
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.PINK); // Cambiado el color a rosa
        this.add(colorPanel);

        // Crear el panel derecho con el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar
        this.add(formPanel);

        // Crear contenedor interno para el formulario
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new GridBagLayout()); // Usar GridBagLayout para el formulario
        GridBagConstraints gbc = new GridBagConstraints();

        // Crear etiquetas y campos de texto
        JLabel usuarioLabel = new JLabel("Usuario:");
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado
        formContainer.add(usuarioLabel, gbc);

        JTextField usuario = new JTextField(20); // Tamaño del campo de texto
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 0; // Fila 0
        formContainer.add(usuario, gbc);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        formContainer.add(contrasenaLabel, gbc);

        JPasswordField contrasena = new JPasswordField(20); // Tamaño del campo de contraseña
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 1; // Fila 1
        formContainer.add(contrasena, gbc);

        // Crear botón de inicio de sesión
        JButton loginButton = new JButton("Iniciar sesión");
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 2; // Fila 2
        gbc.gridwidth = 2; // Span across two columns
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado
        formContainer.add(loginButton, gbc);

        // Añadir el contenedor del formulario al panel con GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(formContainer, gbc);

        // Configurar comportamiento de cierre y visibilidad
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new); // Ensure thread safety
    }
}
