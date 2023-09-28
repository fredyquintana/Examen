import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creación de objetos EmpleadoVendedor y EmpleadoPermanente
        Empleado empleado1 = new EmpleadoVendedor("YRNCIOUT", "Quintana Cruz", "Fredy", 4000, 0.03);
        Empleado empleado2 = new EmpleadoPermanente("CGGDJTIC", "Alberto de la Teja", "Julio", 5000, "2224805");

        // Creación de una lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);

        // Mostrar información de los empleados
        for (Empleado empleado : empleados) {
            empleado.mostrarInformacion();
            System.out.println();
        }
    }
}