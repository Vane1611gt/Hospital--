package hospital.Service;

import java.util.ArrayList;

class paciente {
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String horaCita;
    private String motivo;
    private int id;
    private String doctor;

    public paciente(String nombre, String email, String telefono, String direccion, String fechaNacimiento, String horaCita, String motivo, int id, String doctor) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.horaCita = horaCita;
        this.motivo = motivo;
        this.id = id;
        this.doctor = doctor;
    }

    // Método para obtener los datos del paciente
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", horaCita='" + horaCita + '\'' +
                ", motivo='" + motivo + '\'' +
                ", id=" + id +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}

public class ManejadorPacientes {
    public static ArrayList<paciente> crearPacientes() {
        ArrayList<paciente> pacientes = new ArrayList<>();

        pacientes.add(new paciente("Lucía González", "lucia.gonzalez@hotmail.com", "555-1111", "Calle A", "1991-05-12", "08:00 AM", "Consulta de seguimiento", 2, "Dr. Fernández"));
        pacientes.add(new paciente("Roberto Méndez", "roberto.mendez@gmail.com", "555-2222", "Calle B", "1987-09-25", "08:30 AM", "Consulta de seguimiento", 2, "Dr. Fernández"));
        pacientes.add(new paciente("Elena Vega", "elena.vega@gmail.com", "555-3333", "Calle C", "1995-12-10", "09:00 AM", "Chequeo general", 2, "Dr. García"));
        pacientes.add(new paciente("Mario Torres", "mario.torres@hotmail.com", "555-4444", "Calle D", "1982-07-15", "09:30 AM", "Examen físico", 2, "Dr. Rodríguez"));
        pacientes.add(new paciente("Cristina López", "cristina.lopez@gmail.com", "555-5555", "Calle E", "1990-01-20", "10:00 AM", "Consulta inicial", 2, "Dr. Pérez"));

        return pacientes;
    }

    public static void main(String[] args) {
        ArrayList<paciente> pacientes = crearPacientes();
        for (hospital.Service.paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }
}

