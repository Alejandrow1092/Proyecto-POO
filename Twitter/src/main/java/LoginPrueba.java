import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

public class LoginPrueba{
    ArrayList<String> preguntas;
    ArrayList<String> arrCliente;
    ArrayList <String> respuesta;
    
    Socket cliente;//Socket
    ObjectOutputStream salida;//variables de los flujos
    ObjectInputStream entrada;

    Scanner teclado;
    int numeroPregunta;
    
    PaginaUsuario user;

    

    public LoginPrueba(){
        arrCliente=new ArrayList<String>();
        arrCliente.add("1");
        arrCliente.add("andrea@hotmail.com");
       // arr.add("Alejandro Martinez");
        arrCliente.add("hola15");
        
        respuesta=new ArrayList<String>();
        
    }
    
    void conecta(){
        
        try{
            conectaServidor();
           
            estableceFlujos();
           
            manejaConexion();
        }

        catch(EOFException exceptionEOF){
            System.out.println("Cliente termino la conexion");
        }
        catch(IOException exceptionES){
            exceptionES.printStackTrace();
        }
    }

    public void conectaServidor() throws  UnknownHostException, IOException{
        cliente= new Socket("localhost", 5000);
     //   System.out.println("Conecto con el servidor");
    }

    public void estableceFlujos() throws IOException{
     //   System.out.println("holi34");

        salida= new ObjectOutputStream(cliente.getOutputStream());
        salida.flush();

        entrada= new ObjectInputStream(cliente.getInputStream());
       // System.out.println("Establecio flujos");
    
    }

    public void manejaConexion()throws IOException{
        Object obj1;
       // System.out.println("Casi elijo pregunta");
     //   do{
            enviarDatos(arrCliente);
            try{
                System.out.println("Espero larespuesta");
                obj1=entrada.readObject();
                respuesta=(ArrayList)obj1;
                System.out.println("Me contesto: "+ respuesta.get(0));
                
                
                user=new PaginaUsuario(arrCliente.get(1), respuesta);
            
            }
            catch(ClassNotFoundException exceptionClaseNoEncontrada){
                //System.out.println("caca");
            }
       // }while(true);

    }

 

    public void enviarDatos(ArrayList arr){
       // arr.add("1");
        //arr.add("amrkratos@hotmail.com");
       // arr.add("Alejandro Martinez");
       // arr.add("hola1");
        
        try{
            salida.writeObject(arr);
            salida.flush();
            System.out.println("Al servidor se le envio el arreglo ");
        }
        catch(IOException ExceptionES){
            System.out.println("Error al enviar al servidor");
        }
    }
    
    
    public static void main (String args[]){
        LoginPrueba hola1 = new LoginPrueba();
        hola1.conecta();    
    }


}