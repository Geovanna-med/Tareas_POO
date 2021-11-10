public class Empleado implements Comparable<Empleado> {
    private String nombre;
    private double salario;
    private double numHorasTrabajadas;

    public Empleado(String nombre, double numHorasTrabajadas) {
        this.nombre = nombre;
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public Empleado(String nombre, double numHorasTrabajadas, double salario) {
        this.nombre = nombre;
        this.salario = salario;
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;

    }

    public void setNumHorasTrabajadas(double numHorasTrabajadas) {
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public double getNumHorasTrabajadas() {
        return this.numHorasTrabajadas;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nSalario: " + this.salario;
    }

    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        this.salario = numHorasTrabajadas * tarifa;
        return this.salario;
    }

    public int compareTo(Empleado emp) {
        if (this.getClass() == Administrador.class) {
            if (emp instanceof Administrador) {
                if (this.salario == emp.salario) {
                    return 0;
                } else if (this.salario > emp.salario) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        } else {
            if (emp instanceof Jornalero) {
                if (this.salario == emp.salario) {
                    return 0;
                } else if (this.salario > emp.salario) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Daniel", 80, 15);
        System.out.println(empleado);
        empleado.setSalario(130);
        System.out.println(empleado.getSalario());

    }
}