package com.latin.colegio.Controller;

import com.latin.colegio.Model.Alumno;
import com.latin.colegio.Resource.Conexion;
import com.latin.colegio.Service.IAlumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandoval
 */
public class Controller implements IAlumno {

    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion conexion=new Conexion();
    private String query;
    
    @Override
    public ArrayList<Alumno> list() {
        ArrayList<Alumno> list= new ArrayList();
        query = "SELECT * FROM ALUMNO";
        try{
            conexion.openConexion();
            ps = conexion.getConexion().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Alumno a=new Alumno();
                a.setCodigo(rs.getInt("codigo"));
                a.setNombre(rs.getString("nombre"));
                a.setDireccion(rs.getString("direccion"));
                a.setTelefono(rs.getString("telefono"));
                list.add(a);
            }
        }catch(SQLException e){
            System.out.println("Error "+e);
        }finally{
            conexion.closeConexion();
        }
        return list;
    }

    @Override
    public void create(Alumno alumno) {
        query = "INSERT INTO ALUMNO(nombre,direccion,telefono) VALUES(?,?,?)";
        try{
            conexion.openConexion();
            ps = conexion.getConexion().prepareStatement(query);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getDireccion());
            ps.setString(3, alumno.getTelefono());
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error "+e);
        }finally{
            conexion.closeConexion();
        }
    }

    @Override
    public void update(Alumno a) {
        query = "UPDATE ALUMNO SET NOMBRE=?, DIRECCION=?, TELEFONO=? WHERE CODIGO=?";
        try{
            conexion.openConexion();
            ps = conexion.getConexion().prepareStatement(query);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getDireccion());
            ps.setString(3, a.getTelefono());
            ps.setInt(4, a.getCodigo());
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error "+e);
        }finally{
            conexion.closeConexion();
        }
    }

    @Override
    public void delete(int codigo) {
        query = "DELETE FROM ALUMNO WHERE CODIGO="+codigo+"";
        try{
            conexion.openConexion();
            ps = conexion.getConexion().prepareStatement(query);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error "+e);
        }finally{
            conexion.closeConexion();
        }
    }
    
}
