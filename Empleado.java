// clase abstracta Empleado
abstract class Empleado {
    private String RFC;
    private String apellidos;
    private String nombres;

    public Empleado(String RFC, String apellidos, String nombres) {
        this.RFC = RFC;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }
    public abstract double ingresos();
    public abstract double bonificacion();
    public abstract double descuento();

    public double sueldoNeto() {
        return ingresos() + bonificacion() - descuento();
    }

    public void mostrarInformacion() {
        System.out.println("RFC: " + RFC);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Nombres: " + nombres);
        System.out.println("Ingresos: $" + ingresos());
        System.out.println("Bonificación: $" + bonificacion());
        System.out.println("Descuento: $" + descuento());
        System.out.println("Sueldo Neto: $" + sueldoNeto());
    }
}

// clase hija de nombre EmpleadoVendedo
class EmpleadoVendedor extends Empleado {
    private double montoVendido;
    private double tasaComision;

    public EmpleadoVendedor(String RFC, String apellidos, String nombres, double montoVendido, double tasaComision) {
        super(RFC, apellidos, nombres);
        this.montoVendido = montoVendido;
        this.tasaComision = tasaComision;
    }

    @Override
    public double ingresos() {
        return montoVendido * tasaComision;
    }

    @Override
    public double bonificacion() {
        if (montoVendido < 1000) {
            return 0;
        } else if (montoVendido >= 1000 && montoVendido <= 5000) {
            return ingresos() * 0.05;
        } else {
            return ingresos() * 0.10;
        }
    }

    @Override
    public double descuento() {
        if (ingresos() < 1000) {
            return ingresos() * 0.11;
        } else {
            return ingresos() * 0.15;
        }
    }
}

// clase hija de nombre EmpleadoPermanente 
class EmpleadoPermanente extends Empleado {
    private double sueldoBase;
    private String numeroSeguroSocial;

    public EmpleadoPermanente(String RFC, String apellidos, String nombres, double sueldoBase, String numeroSeguroSocial) {
        super(RFC, apellidos, nombres);
        this.sueldoBase = sueldoBase;
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    @Override
    public double ingresos() {
        return sueldoBase;
    }

    @Override
    public double bonificacion() {
        return 0;
    }

    @Override
    public double descuento() {
        return sueldoBase * 0.11;
    }
}

