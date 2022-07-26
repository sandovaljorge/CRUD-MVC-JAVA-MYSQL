package com.latin.colegio;

import com.latin.colegio.Controller.Controller;
import com.latin.colegio.Model.Alumno;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sandoval
 */
public class Colegio {

    private static Scanner in=new Scanner(System.in); 
    public static void main(String[] args) {
        
        int option=0;
        try{
            while(option!=5){
                System.out.println("------------------Menu Principal----------------\n"
                    + "1. Listar\n"
                    + "2. Agregar\n"
                    + "3. Modificar\n"
                    + "4. Eliminar\n"
                    + "5. Salir");
                System.out.println("Ingrese una opcion.");
                option=in.nextInt();
                switch(option){
                    case 1:
                        viewElements();
                        break;
                    case 2:
                        addElements();
                        break;
                    case 3:
                        updateElement();
                        break;
                    case 4:
                        deleteElement();
                        break;
                    default:
                        System.out.println("exit Menu");
                        System.exit(0);
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Error: "+e);
        }
    }
    
    public static void addElements(){
        Alumno a=new Alumno();
        System.out.println("Agregando elementos.");
        insertElements(a);
        Controller controller=new Controller();
        controller.create(a);
        System.out.println("Elemento insertado.");
    }
    
    public static void viewElements(){
        Controller controller=new Controller();
        for(Alumno a: controller.list()){
            System.out.println("ID: "+a.getCodigo()+" NOMBRE: "+a.getNombre().toUpperCase()+" "
                + "DIRECCION: "+a.getDireccion().toUpperCase()+" TELEFONO: "
                + ""+a.getTelefono().toUpperCase());
        }
    }
    
    public static void updateElement(){
        viewElements();
        Alumno a=new Alumno();
        System.out.println("Ingrese el codigo del alumno:");
        a.setCodigo(in.nextInt());
        insertElements(a);
        Controller controller=new Controller();
        controller.update(a);
        System.out.println("Elemento actualizado.");
    }
    
    public static void insertElements(Alumno a){
        System.out.println("Ingrese el nombre:");
        in.nextLine();
        a.setNombre(in.nextLine());
        System.out.println("Ingrese la direccion.");
        a.setDireccion(in.nextLine());
        System.out.println("Ingrese el telefono.");
        a.setTelefono(in.nextLine());
    }
    
    public static void deleteElement(){
        viewElements();
        System.out.println("Ingrese el codigo del alumno a eliminar:");
        int codigo=in.nextInt();
        Controller controller=new Controller();
        controller.delete(codigo);
        System.out.println("Elemento eliminado.");
    }
}
