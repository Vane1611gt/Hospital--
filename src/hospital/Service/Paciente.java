package hospital.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Clase Paciente
class Paciente {
    private String nombre;
    private String fechaNacimiento;
    private String horarioCita;
    private String motivoVisita;

    // Constructor
    public Paciente(String nombre, String fechaNacimiento, String horarioCita, String motivoVisita) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.horarioCita = horarioCita;
        this.motivoVisita = motivoVisita;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getHorarioCita() { return horarioCita; }
    public String getMotivoVisita() { return motivoVisita; }
}

// Clase DataPaciente
class DataPaciente {
    private List<Paciente> pacientes;

    public DataPaciente() {
        pacientes = new ArrayList<>();

        // Lista de nombres únicos
        String[] nombres = {"Juan Pablo", "Carlos Mejía", "Ana Gómez", "María López", "José Hernández",
                "Lucía Martínez", "Pedro Alvarado", "Sofía Ramírez", "Fernando Gutiérrez", "Luis Torres",
                "Isabel Fuentes", "Miguel Rojas", "Elena Morales", "Gabriel Vargas", "Daniela Cruz",
                "Raúl Castillo", "Paula Muñoz", "Javier Pérez", "Andrea Delgado", "Manuel Herrera"};

        // Lista de fechas, horarios y motivos no repetidos
        String[] fechas = {"10/04/1995", "21/11/2000", "30/06/1988", "05/05/1975", "15/09/1992",
                "02/03/1990", "08/12/1985", "19/01/2003", "12/07/1999", "25/10/1996",
                "18/08/1982", "29/02/1978", "03/04/2001", "11/11/1994", "07/06/1993",
                "27/03/1987", "09/09/1980", "15/12/1997", "22/10/1991", "01/01/1983"};

        String[] horarios = {"08:00 AM", "09:30 AM", "11:00 AM", "02:00 PM", "03:30 PM",
                "04:00 PM", "05:30 PM", "06:45 AM", "07:30 AM", "01:00 PM",
                "08:45 AM", "10:15 AM", "11:45 AM", "12:00 PM", "02:30 PM",
                "03:45 PM", "05:00 PM", "06:00 PM", "09:00 AM", "10:30 AM"};

        String[] motivos = {"Consulta General", "Revisión", "Control", "Diagnóstico", "Tratamiento",
                "Evaluación", "Chequeo", "Consulta Especializada", "Seguimiento", "Terapia",
                "Medicina Preventiva", "Evaluación de Cirugía", "Consulta de Emergencia",
                "Medicina Deportiva", "Atención Primaria", "Dermatología", "Oftalmología",
                "Consulta Ginecológica", "Pediatría", "Psiquiatría"};

        // Crear pacientes con datos únicos
        for (int i = 0; i < 20; i++) {
            Paciente paciente = new Paciente(nombres[i], fechas[i], horarios[i], motivos[i]);
            pacientes.add(paciente);
        }
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}

// Clase PacienteView
class PacienteView {
    private List<Paciente> pacientes;

    public PacienteView(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public JPanel panelPaciente() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 255, 255)); // Color de fondo claro

        // Crear tabla
        String[] columnas = {"Nombre", "Fecha de Nacimiento", "Horario de Cita", "Motivo de Visita"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Paciente paciente : pacientes) {
            Object[] fila = {paciente.getNombre(), paciente.getFechaNacimiento(), paciente.getHorarioCita(), paciente.getMotivoVisita()};
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(35); // Aumentar la altura de las filas

        // Estilo de tabla
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tabla.getTableHeader().setBackground(new Color(0, 191, 255)); // Color de encabezado
        tabla.getTableHeader().setForeground(Color.WHITE);

        // Alternar colores de las filas
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(new Color(70, 130, 180)); // Color para fila seleccionada
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(row % 2 == 0 ? new Color(224, 255, 255) : Color.WHITE); // Colores alternos
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        };

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        panel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(700, 300)); // Ajustar el tamaño de la tabla

        return panel;
    }
}

// Clase DoctorView
class DoctorView extends JFrame {
    public DoctorView() {
        DataPaciente dataPaciente = new DataPaciente();
        JPanel panelPacientes = new PacienteView(dataPaciente.getPacientes()).panelPaciente();

        // Crear el panel lateral para los botones
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new GridLayout(0, 1));
        panelLateral.setPreferredSize(new Dimension(200, 0)); // Ancho fijo para el menú lateral
        panelLateral.setBackground(new Color(0, 191, 255)); // Color de fondo del menú lateral

        // Crear botones
        JButton btnConsultasDelDia = new JButton("Consultas Del Día");
        JButton btnSalas = new JButton("Salas");
        JButton btnFarmacia = new JButton("Farmacia");
        JButton btnPacientesRegistrados = new JButton("Pacientes Registrados");
        JButton btnCitarEnOtraArea = new JButton("Citar en Otra Área");

        // Estilo de botones
        Color buttonColor = new Color(173, 216, 230); // Color de fondo de los botones
        for (JButton button : new JButton[]{btnConsultasDelDia, btnSalas, btnFarmacia, btnPacientesRegistrados, btnCitarEnOtraArea}) {
            button.setBackground(buttonColor);
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setFocusPainted(false); // Quitar el borde al enfocar
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado interno
        }

        // Agregar botones al panel lateral
        panelLateral.add(btnConsultasDelDia);
        panelLateral.add(btnSalas);
        panelLateral.add(btnFarmacia);
        panelLateral.add(btnPacientesRegistrados);
        panelLateral.add(btnCitarEnOtraArea);

        // Configurar el layout de la ventana principal
        setLayout(new BorderLayout());
        add(panelLateral, BorderLayout.WEST); // Agregar menú lateral
        add(panelPacientes, BorderLayout.CENTER); // Agregar panel de pacientes

        // Configurar la ventana
        setTitle("Vista de Pacientes");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

// Clase principal para ejecutar la aplicación
class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorView());
    }
}
