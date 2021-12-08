/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int horasExtras;
    private String nombre;
    private double salario;
    private double numHorasTrabajadas;
    
    public administrador() {

    }

    public administrador(long id, String nombre, double numHorasTrabajadas, int horasExtras, double tarifa) {
        this.id = id;
        this.nombre = nombre;
        this.numHorasTrabajadas = numHorasTrabajadas;
        this.horasExtras = horasExtras;
        this.calcularSalario((int) numHorasTrabajadas, tarifa);
    }

    
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return this.horasExtras;
    }
    
     public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        this.salario = numHorasTrabajadas * tarifa;
        return this.salario;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNumHorasTrabajadas(double numHorasTrabajadas) {
        this.numHorasTrabajadas = numHorasTrabajadas;
    }


    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public double getNumHorasTrabajadas() {
        return numHorasTrabajadas;
    }

//    public double calcularSalario(int numHorasTrabajadas, double tarifa, int horasExtras) {
//        tarifa = 15;
//        if (numHorasTrabajadas >= 80) {
//            this.porcentajeCompensacion = 0.3;
//           // return super.calcularSalario(numHorasTrabajadas + horasExtras, tarifa * (1 + this.porcentajeCompensacion));
//        } else {
//            this.porcentajeCompensacion = 0.2;
//            return super.calcularSalario(numHorasTrabajadas + horasExtras, tarifa * (1 + this.porcentajeCompensacion));
//        }
//    }

//    @Override
//    public String toString() {
//        return super.toString() + "\nPorcentaje: " + this.porcentajeCompensacion + "\nHoras trabajadas: "
//                + getNumHorasTrabajadas() + "\nHoras extras: " + horasExtras;
//    }

}