package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.ServicioMedicoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


public class ServicioMedicoLogic extends Logic 
{
    public ServicioMedicoLogic(String pConnectionString)
    {
        super(pConnectionString);
    } 
    
    public int insertNewServicioMedico(int p_idServicioMedico, int p_idMedico, int p_idPaciente, int p_numeroCama, String p_diagnostico, String p_fecha, String p_hora) {
        DatabaseX database = getDatabase();
        String sql = "insert into hospitaldb.medico "
                + "(id, diagnostico_enfermedad, fecha, hora, id_medico, id_paciente_cama, id_expediente) "
                + "value(0, '"+p_diagnostico+"', '"+p_fecha+"', '"+p_hora+"', '"+p_idMedico+"', '"+p_numeroCama+"', '"+p_idPaciente+"')";
        int rows = database.executeNonQueryRows(sql); 
        return rows;
    } 
            
    public int deleteServicioMedico(int p_idServicioMedico)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM hospitaldb.servicio_medico "
                + "WHERE id = '"+p_idServicioMedico+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<ServicioMedicoObj> getAllServicioMedico()
    {
        DatabaseX database = getDatabase();
        ArrayList<ServicioMedicoObj> serviciomedicoArray = new ArrayList<>();
        String sql = "select * from hospitaldb.servicio_medico";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int idServicioMedico;
                int idMedico;
                int idPaciente;
                int numeroCama;
                String diagnostico;
                String fecha;
                String hora;
                
                ServicioMedicoObj temp;
                
                while(result.next())
                {
                    idServicioMedico = result.getInt("id");
                    idMedico = result.getInt("id_medico");
                    idPaciente = result.getInt("id_expediente");
                    numeroCama = result.getInt("id_paciente_cama");
                    diagnostico = result.getString("diagnostico_enfermedad");
                    fecha = result.getString("fecha");
                    hora = result.getString("hora");
                    temp = new ServicioMedicoObj(idServicioMedico, idMedico, idPaciente, numeroCama, diagnostico, fecha, hora);
                    serviciomedicoArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MedicoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return serviciomedicoArray;
    }
    
    public ServicioMedicoObj getServicioMedicoById(int p_idServicioMedico)
    {
        DatabaseX database = getDatabase();
        ArrayList<ServicioMedicoObj> serviciomedicoArray = new ArrayList<>();
        String sql = "select * from hospitaldb.servicio_medico where id="+p_idServicioMedico+";";
        ResultSet result = database.executeQuery(sql);
        
        ServicioMedicoObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int idServicioMedico;
                int idMedico;
                int idPaciente;
                int numeroCama;
                String diagnostico;
                String fecha;
                String hora;
                
                while(result.next())
                {
                    idServicioMedico = result.getInt("id");
                    idMedico = result.getInt("id_medico");
                    idPaciente = result.getInt("id_expediente");
                    numeroCama = result.getInt("id_paciente_cama");
                    diagnostico = result.getString("diagnostico_enfermedad");
                    fecha = result.getString("fecha");
                    hora = result.getString("hora");
                    
                    temp = new ServicioMedicoObj(idServicioMedico, idMedico, idPaciente, numeroCama, diagnostico, fecha, hora);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MedicoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 

    
    public int updateServicioMedico(int p_idServicioMedico, int p_idMedico, int p_idPaciente, int p_numeroCama, String p_diagnostico, String p_fecha, String p_hora) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE hospitaldb.medico "
                + "SET diagnostico_enfermedad = '"+p_diagnostico+"', fecha = '"+p_fecha+"', hora = '"+p_hora+"', id_medico = '"+p_idMedico+"', id_paciente_cama = '"+p_numeroCama+"', id_expediente = '"+p_idPaciente+"' "
                + "WHERE (id = '"+p_idServicioMedico+"');";
        
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
}
