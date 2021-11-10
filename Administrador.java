public class Administrador extends Empleado {

    private double porcentajeCompensacion;
    private int horasExtras;

    public Administrador(String nombre, double numHorasTrabajadas, int horasExtras, double tarifa) {
        super(nombre, numHorasTrabajadas);
        this.horasExtras = horasExtras;
        this.calcularSalario((int) numHorasTrabajadas, tarifa);
    }

    public void setPorcentaje(double porcentajeCompensacion) {
        this.porcentajeCompensacion = porcentajeCompensacion;
    }

    public double getPorcentaje() {
        return this.porcentajeCompensacion;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return this.horasExtras;
    }

    public double calcularSalario(int numHorasTrabajadas, double tarifa, int horasExtras) {
        if (numHorasTrabajadas >= 80) {
            this.porcentajeCompensacion = 0.3;
            return super.calcularSalario(numHorasTrabajadas + horasExtras, tarifa * (1 + this.porcentajeCompensacion));
        } else {
            this.porcentajeCompensacion = 0.2;
            return super.calcularSalario(numHorasTrabajadas + horasExtras, tarifa * (1 + this.porcentajeCompensacion));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nPorcentaje: " + this.porcentajeCompensacion + "\nHoras trabajadas: "
                + getNumHorasTrabajadas() + "\nHoras extras: " + horasExtras;
    }

}