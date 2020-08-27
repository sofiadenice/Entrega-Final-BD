package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.MedicoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MedicoLogic extends Logic 
{
    public MedicoLogic(String pConnectionString)
    {
        super(pConnectionString);
    } 
    
    public int insertNewMedico(String p_nombreDoctor, String p_apellidoDoctor, String p_cargo, String p_usuario) {
        DatabaseX database = getDatabase();
        String sql = "insert into hospitaldb.medico "
                + "(id, nombre, apellido, cargo, usuario) "
                + "value(0, '"+p_nombreDoctor+"', '"+p_apellidoDoctor+"', '"+p_cargo+"', '"+p_usuario+"')";
        int rows = database.executeNonQueryRows(sql); 
        return rows;
    } 
    
    public int deleteMedico(int p_idDoctor)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM hospitaldb.medico "
                + "WHERE id = '"+p_idDoctor+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<MedicoObj> getAllMedico()
    {
        DatabaseX database = getDatabase();
        ArrayList<MedicoObj> medicoArray = new ArrayList<>();
        String sql = "select * from hospitaldb.medico";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int idDoctor;
                String nombreDoctor;
                String apellidoDoctor;
                String cargo;
                String usuario;
                
                MedicoObj temp;
                
                while(result.next())
                {
                    idDoctor = result.getInt("id");
                    nombreDoctor = result.getString("nombre");
                    apellidoDoctor = result.getString("apellido");
                    cargo = result.getString("cargo");
                    usuario = result.getString("usuario");
                    temp = new MedicoObj(idDoctor, nombreDoctor, apellidoDoctor, cargo, usuario);
                    medicoArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MedicoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return medicoArray;
    }
    
    public MedicoObj getMedicoById(int p_idDoctor)
    {
        DatabaseX database = getDatabase();
        ArrayList<MedicoObj> medicoArray = new ArrayList<>();
        String sql = "select * from hospitaldb.medico where id="+p_idDoctor+";";
        ResultSet result = database.executeQuery(sql);
        
        MedicoObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int idDoctor;
                String nombreDoctor;
                String apellidoDoctor;
                String cargo;
                String usuario;
                while(result.next())
                {
                    idDoctor = result.getInt("id");
                    nombreDoctor = result.getString("nombre");
                    apellidoDoctor = result.getString("apellido");
                    cargo = result.getString("cargo");
                    usuario = result.getString("usuario"); 
                    
                    temp = new MedicoObj(idDoctor, nombreDoctor, apellidoDoctor, cargo, usuario);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MedicoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 

    
    public int updateMedico(int p_idDoctor, String p_nombreDoctor, String p_apellidoDoctor, String p_cargo, String p_usuario) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE hospitaldb.medico "
                + "SET nombre = '"+p_nombreDoctor+"', apellido='"+p_apellidoDoctor+"', cargo='"+p_cargo+"', usuario='"+p_usuario+"' "
                + "WHERE (id = '"+p_idDoctor+"');";
        
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
}
