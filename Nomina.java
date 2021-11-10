import java.util.Arrays;

public class Nomina {

    public Empleado empleados[];
    int numEmpleados = 0;

    public Nomina(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public void altaEmpleado(Empleado emp) {
        this.empleados[numEmpleados] = emp;
        Arrays.sort(empleados, 0, numEmpleados + 1);
        numEmpleados++;
    }

    public void bajaEmpleado(int posicion) {
        this.empleados[posicion] = null;
        Arrays.sort(empleados, 0, numEmpleados - 1);
        numEmpleados--;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

}
