
package sv.edu.ujmd.util;
import java.sql.*;


public class Conexion {
    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String query = "";
    
    //constructor
    public Conexion() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Guia6poo1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "castillo999");
            s = conexion.createStatement();
        }
        catch(Exception ex){
            System.out.println("ERROR: No encuentro el driver de la BD: " +ex.getMessage());                        
        }
    }
    
    public ResultSet GetRs(){
        return rs;
    }
    
    public void setRs(String consulta){
        try{
            this.rs = s.executeQuery(consulta);
        } catch(SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
        }
    }
    
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
}
