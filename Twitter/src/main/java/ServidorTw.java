import java.sql.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;


public class ServidorTw{
    ConexionDB nuevaConexion;
    
    ArrayList<ObjectOutputStream> clientObjectOutputStreams;//arreglo donde se guarda el flujo de salida de los clientes
    
    ArrayList <String> datosInicio;
    ArrayList <String> seguidores;
    
    final String notFound="Usuario no encontrado";
    final String wrongPwd="Contraseña equivocada";
    
    
     String nombre="";
     String noTweets="";
     String noSeguidores="";
     String noSeguidos="";
     String foto="";
    
    public ServidorTw(){
        nuevaConexion=new ConexionDB();//se hace la conexion a la BD
        if(nuevaConexion.conexion()){
             System.out.print("Conexión exitosa a MYSQL");
            }
        else{
            System.out.print("Fallo la conexión a MYSQL");
        }
        
        //datosInicio=new ArrayList<String>();
    }//cierra constructor
    
    public class ClientHandler implements Runnable{
            ObjectOutputStream writer;//flujo de salida
            ObjectInputStream reader;//flujo de entrada
            Socket sock;//socket recivido por el cliente
            
            public ClientHandler(Socket clientSocket, ObjectOutputStream writer){
                try {
                    this.writer=writer;//asignamos las variables de instancia con los parametros recividos
                    sock=clientSocket;
                    reader=new ObjectInputStream(sock.getInputStream());//obtenemos lo que envio el cliente
                } catch (Exception e) {
                    System.out.println("Exce Servidor reader " + e);
                    e.printStackTrace();
                }
            }//cierra constructor
            
            @Override
            public void run(){
                Object obj; //Guardamos el objecto recivido
                
                try {
                    while(true){
                        obj=(Object)reader.readObject();//guardamos el objeto recivido
                        System.out.println("El servidor recibio el objeto");
                        dispatch(obj, writer);//funcion de analisis y respuesta
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }   
    
       
    }
    
    public static void main(String args[]){
        new ServidorTw().go();
    }
    
    public void go(){
        clientObjectOutputStreams = new ArrayList<ObjectOutputStream>();//Arreglo de clientes
        try {
            ServerSocket serverSock=new ServerSocket(5000);//creamos el socket servidor
            while(true){
                Socket clientSocket = serverSock.accept();//el servidor espera indefinidamente a algun cliente
                ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());        
                clientObjectOutputStreams.add(writer);
                Thread t = new Thread(new ClientHandler(clientSocket, writer));
                t.start();
                System.out.println("got a conexion");
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
 
    }
    
    
    public void dispatch(Object obj, ObjectOutputStream writerp){
        ArrayList <String> arrCliente;
        arrCliente=(ArrayList)obj;//es el arreglo enviado por el cliente
        
   
        
        int i=Integer.parseInt(arrCliente.get(0));//que tipo de operacion se va a hacer (Registro, Logino PantallaInicio)
        
       if(i==1){//se esta haciendo un login
           
           System.out.println("Se ah ingresado al login");
           
           String usuario=arrCliente.get(1);
           String contrasena=arrCliente.get(2);
           
           System.out.println("El usuario es: "+usuario);
           //Crea objecto statement para consultr en la base de datos
           try {
               nuevaConexion.instruccion=nuevaConexion.conexion.createStatement();
               nuevaConexion.conjuntoResultados=nuevaConexion.instruccion.executeQuery(
               "SELECT contrasena FROM usuario where correoE='"+usuario+"'");
           
               //procesa los resultados de la consulta
               //nuevaConexion.metaDatos=nuevaConexion.conjuntoResultados.getMetaData();
               System.out.println("Buscando usuario");
               
               if(!(nuevaConexion.conjuntoResultados.next())){//si no encontro ningun usuario
                   System.out.println("no encontro al usuario");
                   
                   writerp.writeObject(notFound);//le mandamos una cadena
                   writerp.flush();
                   
               }
              
               else{
                   
                   System.out.println("Entro al else");
                   //nuevaConexion.conjuntoResultados.next();//se mueve a la primer fila de la tabla
                   
                   String contra=nuevaConexion.conjuntoResultados.getString("contrasena");
                   
                   System.out.println("La contrasena es: "+contra);
                   
                   if(contra.equals(contrasena)){ 
                        //traigo los datos para cargar la pantalla principal
                        nuevaConexion.conjuntoResultados=nuevaConexion.instruccion.executeQuery(
                        "SELECT Nombre, foto, NoTweets, NoSeguidores, NoSeguidos FROM usuario where correoE='"+usuario+"'");
                        
                       /* nuevaConexion.metaDatos=nuevaConexion.conjuntoResultados.getMetaData();
                        int numeroColumnas=nuevaConexion.metaDatos.getColumnCount();
                        */
                        infoUsuario(nuevaConexion, writerp);
                   
                   }
                   else{
                        writerp.writeObject(wrongPwd);
                        writerp.flush();
                   }
               }
               
               
           } catch (Exception e) {
               System.out.println("Error"+e);
           }
           
           
           //consulta la base de datos
           
       }
       if(i==2){//se esta haciendo un registro
           
          
           try {
               //validar si el usuario existe
               
               
                nuevaConexion.instruccion=nuevaConexion.conexion.createStatement();
                nuevaConexion.query="INSERT INTO USUARIO VALUES ('"+arrCliente.get(1)+"', '"+arrCliente.get(2)+
                "', null, '"+arrCliente.get(3)+"', 0, 0)";
                nuevaConexion.instruccion.executeUpdate(nuevaConexion.query);
                
                System.out.println("Registro insertado: "+nuevaConexion.query);
                infoUsuario(nuevaConexion, writerp);
                
           } catch (Exception e) {
               System.out.println("Se tuvo un error"+ e);
           }
          
           
       }
       
       //se requiere la tabla de seguidores
       if(i==3){
           String primarykey=arrCliente.get(1);//recibo nombre de usuario
           seguidores=new ArrayList <String>();
           try {
               nuevaConexion.instruccion=nuevaConexion.conexion.createStatement();
               nuevaConexion.conjuntoResultados=nuevaConexion.instruccion.executeQuery(
                        "SELECT correoE2 FROM seguidor WHERE correoE1='"+primarykey+"'");
               
               while(nuevaConexion.conjuntoResultados.next()){
                   seguidores.add(nuevaConexion.conjuntoResultados.getString("correoE2"));
                   
               }
                writerp.writeObject(seguidores);
                writerp.flush();
           } catch (Exception e) {
               System.out.println("Error "+e);
           }
           
           
           
           
       }
       //se esta accediendo a una pantalla principal, se regresan
       //los datos del usuario para que se arme la pagina del cliente  
       if(i==4){
           String primarykey=arrCliente.get(1);//recibo nombre de usuario
           seguidores=new ArrayList <String>();
           try {
               nuevaConexion.instruccion=nuevaConexion.conexion.createStatement();
               nuevaConexion.conjuntoResultados=nuevaConexion.instruccion.executeQuery(
                        "SELECT Nombre, Foto FROM usuario WHERE correoE='"+primarykey+"'");
               
               while(nuevaConexion.conjuntoResultados.next()){
                   seguidores.add("5");
                   seguidores.add(nuevaConexion.conjuntoResultados.getString("Nombre"));
                   seguidores.add(nuevaConexion.conjuntoResultados.getString("Foto"));
                   
               }
                writerp.writeObject(seguidores);
                writerp.flush();
           } catch (Exception e) {
               System.out.println("Error "+e);
           }
       }
       if(i==5){
           try {
               
               System.out.println("llego al 5");
               nuevaConexion.instruccion=nuevaConexion.conexion.createStatement();        
           nuevaConexion.conjuntoResultados=nuevaConexion.instruccion.executeQuery(
                        "SELECT Nombre, foto, NoTweets, NoSeguidores, NoSeguidos FROM usuario where correoE='"+arrCliente.get(1)+"'");
                 infoUsuario(nuevaConexion, writerp);
           
           } catch (Exception e) {
               System.out.println("Error "+e);
           }
           System.out.println("Ya le mande los datos");
       }
       if(i==6){
           
           System.out.println("Llego al 6");
            seguidores=new ArrayList <String>();
           try {
               nuevaConexion.instruccion=nuevaConexion.conexion.createStatement();
               nuevaConexion.conjuntoResultados=nuevaConexion.instruccion.executeQuery(
              "SELECT Fecha, Texto FROM tweet WHERE usuario1='"+arrCliente.get(1)+"'");
               
               nuevaConexion.conjuntoResultados.next();
               
                seguidores.add(nuevaConexion.conjuntoResultados.getString("fecha"));
                seguidores.add(nuevaConexion.conjuntoResultados.getString("texto"));
                writerp.writeObject(seguidores);
                writerp.flush();
           } catch (Exception e) {
               System.out.println("Exception del apratado 6"+e);
           }
               
       }
        
        
    }
    
    public void infoUsuario(ConexionDB nuevaConexion1, ObjectOutputStream writerp ) throws SQLException, IOException{
  
        
        while(nuevaConexion1.conjuntoResultados.next()){
            
            nombre=nuevaConexion1.conjuntoResultados.getString("Nombre");
            System.out.println("el nombre es: "+nombre);
            foto=nuevaConexion1.conjuntoResultados.getString("Foto");
            noTweets=Integer.toString(nuevaConexion1.conjuntoResultados.getInt("NoTweets"));
            noSeguidores=Integer.toString(nuevaConexion1.conjuntoResultados.getInt("NoSeguidores"));
            noSeguidos=Integer.toString(nuevaConexion1.conjuntoResultados.getInt("NoSeguidos"));
           
        }
        datosInicio=new ArrayList<String>();               
    //agrego los datos de inicio al arreglo
        datosInicio.add(nombre);
        System.out.println("que paso?"+datosInicio.get(0));
        datosInicio.add(foto);
        datosInicio.add(noTweets);
        datosInicio.add(noSeguidores);
        datosInicio.add(noSeguidos);
                       
        System.out.println("Se le esta enviando el arreglo");                

        writerp.writeObject(datosInicio);
        writerp.flush();
    }
}
    
