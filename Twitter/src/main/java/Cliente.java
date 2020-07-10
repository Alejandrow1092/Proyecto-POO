import java.net.Socket;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

public class Cliente {
    Socket cliente;//Socket
    ObjectOutputStream salida;//variables de los flujos
    ObjectInputStream entrada;
    
    ArrayList <String> respuesta;
    
    public Cliente(){
        respuesta=new ArrayList <String>();
    }
    
    void conecta(){
        try{
            conectaServidor();
           
            estableceFlujos();
           
           // manejaConexion();
        }

        catch(EOFException exceptionEOF){
            System.out.println("Cliente termino la conexion");
        }
        catch(IOException exceptionES){
            exceptionES.printStackTrace();
        }
    }
    
    private void conectaServidor() throws  UnknownHostException, IOException{
        cliente= new Socket("localhost", 5000);
     //   System.out.println("Conecto con el servidor");
    }

    private void estableceFlujos() throws IOException{
     //   System.out.println("holi34");

        salida= new ObjectOutputStream(cliente.getOutputStream());
        salida.flush();

        entrada= new ObjectInputStream(cliente.getInputStream());
       // System.out.println("Establecio flujos");
    
    }
    
    public Object manejaConexion(ArrayList arr)throws IOException{
            Object obj1=null;
            enviarDatos(arr);
            try{
                System.out.println("Espero la respuesta");
                obj1=entrada.readObject();
                respuesta=(ArrayList)obj1;
                System.out.println("Me contesto: "+ respuesta.get(0));
                
                
                //user=new PaginaUsuario(arrCliente.get(1), respuesta);
            
            }
            catch(ClassNotFoundException exceptionClaseNoEncontrada){
                System.out.println("Error "+exceptionClaseNoEncontrada);
            }
       
            return obj1;
    }
    
     private void enviarDatos(ArrayList arr){       
       try{
            salida.writeObject(arr);
            salida.flush();
            System.out.println("Al servidor se le envio el arreglo ");
        }
        catch(IOException ExceptionES){
            System.out.println("Error al enviar al servidor");
        }
    }
    
   // public static void main(String args[]){
        
    //}
}
