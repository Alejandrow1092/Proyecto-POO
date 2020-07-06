import java.sql.*;
//import java.sql.ResultSetMetaData;
        
public class ConexionDB{
    static final String CONTROLADOR="com.mysql.jdbc.Driver";
    static final String URL_BASEDATOS="jdbc:mysql://localhost/twitter";
    
    Connection conexion=null; //maneja la conexion
    Statement instruccion = null; //instruccion de consulta
    ResultSet conjuntoResultados= null; //maneja los resultados
    ResultSetMetaData metaDatos=null;
    String query;
    
    public boolean conexion(){
        boolean c=false;
        
        try{
            //carga la clase controlador
            Class.forName(CONTROLADOR);
            
            //establece la conexion a la base de datos
            conexion=DriverManager.getConnection(URL_BASEDATOS, "root", "12345678");
            
            if(conexion!=null){
                c=true;
            }
        }
        catch(Exception e){
            System.out.println("Ocurrio un error"+e);
        }
        return c;
        
    }

}