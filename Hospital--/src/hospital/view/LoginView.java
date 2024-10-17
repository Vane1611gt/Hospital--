package hospital.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    // Constructor
    public LoginView() {
        setTitle("Login");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        // Etiqueta "Correo" centrada verticalmente respecto al campo de texto
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        correoLabel.setBounds(200, 57, 100, 30); // Centramos respecto al campo de texto de "Correo"
        panel.add(correoLabel);

        // Campo de texto para "Correo"
        JTextField correoText = new JTextField();
        correoText.setBounds(370, 50, 400, 35);
        correoText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        panel.add(correoText);

        // Etiqueta "Contraseña" centrada verticalmente respecto al campo de texto
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setBounds(200, 117, 100, 30); // Centramos respecto al campo de texto de "Contraseña"
        panel.add(passwordLabel);

        // Campo de texto para "Contraseña"
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(370, 110, 400, 35);
        passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        panel.add(passwordText);

        // Botón "Iniciar sesión"
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(370, 180, 400, 45);
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginView();
    }
}