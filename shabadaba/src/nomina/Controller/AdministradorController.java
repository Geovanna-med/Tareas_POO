/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.Controller;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import nomina.database.*;
import nomina.modelo.*;

public class AdministradorController {
    NominaDBCRUD nominadbcrud;
    ArrayList<Empleado> listaEmpleados;
    
    public AdministradorController(){
        this.listaEmpleados = new ArrayList<Empleado>();
    }
    
    public void recuperarDatosAdministradores(){
        Administrador administrador;
        ResultSet table;
        nominadbcrud = new NominaDBCRUD();
        table = nominadbcrud.consultTable("administradores");
        
        try {
            while(table.next()){
                administrador = new Administrador(
                table.getString("Nombre"),
                table.getDouble("Horas Tabajadas"),
                table.getInt("Horas extra"),
                table.getDouble("Salario")
                );
               // administrador.calcularSalario(table.getInt("Horas Tabajadas"), table.getDouble("tarifa"));
                //administrador.setPorcentajeCompensacion();
                listaEmpleados.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
  
    }
    
    public ArrayList<Empleado> getListaEmpleados(){
        return listaEmpleados;
    }
    
    public static void main(String[] args) {
        AdministradorController adminController=new AdministradorController();
        adminController.recuperarDatosAdministradores();
        System.out.println(adminController.getListaEmpleados());
    }
    
}