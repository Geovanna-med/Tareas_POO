/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina.controller;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import nomina.database.*;
import nomina.modelo.*;
import nomina.database.NominaDBCRUD;

public class AdministradorController {
    NominaDBCRUD crud = new NominaDBCRUD();
    ArrayList<Administrador> listaAdministradores;
    
    public AdministradorController(){
        this.listaAdministradores = new ArrayList<Administrador>();
    }
    
    public ArrayList<Administrador> getAdministradores(){
        Administrador administrador;
        ResultSet table;
        table = crud.consultTable("administradores");
        
        try {
            while(table.next()){
                administrador = new Administrador(
                table.getInt("Id"),
                table.getString("Nombre"),
                table.getDouble("HorasTabajadas"),
                table.getInt("HorasExtras"),
                table.getDouble("Salario")
                );
               // administrador.calcularSalario(table.getInt("Horas Tabajadas"), table.getDouble("tarifa"));
                //administrador.setPorcentajeCompensacion();
                listaAdministradores.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAdministradores;
    
    }
    
    public ArrayList<Administrador> getListaAdministradores(){
        return listaAdministradores;
    }
    
    //Nos sirve para agregar comillas a los valores varchar en la base de datos
    private String addComillas (String cadena){
        return"'" + cadena + "'";
    }
    
    private String acentoGrave (String cadena){
        return "`" + cadena + "`";
    }
    
    //Agregar Admin
    public int addAdmin(Administrador admin){
        String[] columns = {"id", "Nombre", "Salario", "HorasTabajadas", "HorasExtras"};
        String[] values = {"NULL", addComillas(admin.getNombre()), String.valueOf(admin.getSalario()), String.valueOf(admin.getNumHorasTrabajadas()), String.valueOf(admin.getHorasExtras())};
        return this.crud.insertOne("administradores", columns, values);
    }
    
    //eliminar admin
    public int delateAdmin(Administrador admin){
        return this.crud.deleteOne("administradores", admin.getid());
    }
    
    //actualizar admin
    public int updateAdmin(Administrador admin){
        String[] columns = {"Nombre", "Salario", "HorasTabajadas", "HorasExtras"};
        String[] values = {addComillas(admin.getNombre())};
        return this.crud.updateOne("administradores", columns, values, admin.getid());
    }
    
    
    public static void main(String[] args) {
        AdministradorController adminController=new AdministradorController();
        adminController.getAdministradores();
        System.out.println(adminController.getListaAdministradores());
    }
    
}