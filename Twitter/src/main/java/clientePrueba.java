import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

public class clientePrueba{
    ArrayList<String> preguntas;
    ArrayList<String> arrCliente;
    ArrayList <String> respuesta;
    
    Socket cliente;//Socket
    ObjectOutputStream salida;//variables de los flujos
    ObjectInputStream entrada;

    Scanner teclado;
    int numeroPregunta;

    

    public clientePrueba(){
        arrCliente=new ArrayList<String>();
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
                System.out.println("Me contesto: ");
            }
            catch(ClassNotFoundException exceptionClaseNoEncontrada){
                //System.out.println("caca");
            }
       // }while(true);

    }

  /* void elegirPregunta(){
        System.out.println("Ingresa un numero de pregunta: ");
        numeroPregunta=teclado.nextInt();
        enviarDatos(numeroPregunta);
    }*/

    public void enviarDatos(ArrayList arr){
        arr.add("2");
        arr.add("alex@hotmail.com");
        arr.add("Alejandro Martinez");
        arr.add("hola15");
        
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
        clientePrueba hola1 = new clientePrueba();
        hola1.conecta();    
    }


}