/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.modelo;

/**
 *
 * @author user
 */
public class Jornalero extends Empleado {

    private int horasExtras;

    public Jornalero(String nombre, double numHorasTrabajadas, int horasExtras, double tarifa) {
        super(nombre, numHorasTrabajadas);
        this.horasExtras = horasExtras;
        this.calcularSalario((int) numHorasTrabajadas, tarifa);
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return this.horasExtras;
    }

    public double calcularSalario(int numHorasTrabajadas, double tarifa, int horasExtras) {

        return super.calcularSalario(numHorasTrabajadas + (2 * horasExtras), tarifa);
    }

    @Override
    public String toString() {
        return super.toString() + "\nHoras trabajadas: " + getNumHorasTrabajadas() + "\nHoras Extras: "
                + this.horasExtras;
    }
}

