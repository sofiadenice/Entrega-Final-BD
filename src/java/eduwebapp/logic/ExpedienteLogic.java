package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.ExpedienteObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ExpedienteLogic extends Logic
{
    //metodo constructor
   
    
    public ExpedienteLogic(String pConnectionString)
    {
        super(pConnectionString);
    } 

    public int insertNewExpediente(String pFechaIngreso,String pFechaAlta, String pIdPaciente) {
        DatabaseX database = getDatabase();
        String sql = "insert into hospitaldb.expediente "
                + "(id, fecha_de_ingreso, fecha_de_alta, id_paciente) "
                + "value(0, '"+pFechaIngreso+"', '"+pFechaAlta+"', "+pIdPaciente+")";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
    public int deleteExpediente(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM hospitaldb.expediente "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<ExpedienteObj> getAllExpediente()
    {
        DatabaseX database = getDatabase();
        ArrayList<ExpedienteObj> expedienteArray = new ArrayList<>();
        String sql = "select * from hospitaldb.expediente";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iIdExpediente;
                String strFechaIngreso;
                String strFechaAlta;
                int iIdPaciente;
                ExpedienteObj temp;
                
                while(result.next())
                {
                    iIdExpediente = result.getInt("id");
                    strFechaIngreso = result.getString("FechaIngreso");
                    strFechaAlta = result.getString("FechaAlta");
                    iIdPaciente = result.getInt("idPaciente");
                    temp = new ExpedienteObj(iIdExpediente, strFechaIngreso, strFechaAlta, iIdPaciente);
                    expedienteArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ExpedienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return expedienteArray;
    }
    
    public ExpedienteObj getExpedienteById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<ExpedienteObj> expedienteArray = new ArrayList<>();
        String sql = "select * from hospitaldb.expediente where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        ExpedienteObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iIdExpediente;
                String strFechaIngreso;
                String strFechaAlta;
                int iIdPaciente;
                while(result.next())
                {
                    iIdExpediente = result.getInt("id");
                    strFechaIngreso = result.getString("FechaIngreso");
                    strFechaAlta = result.getString("FechaAlta");
                    iIdPaciente = result.getInt("idPaciente");
                    temp = new ExpedienteObj(iIdExpediente, strFechaIngreso, strFechaAlta, iIdPaciente);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ExpedienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 

    
    public int updateExpediente(int pIdExpediente, String pFechaIngreso, String pFechaAlta, int pIdPaciente) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE hospitaldb.expediente "
                + "SET fecha_de_ingreso = '"+pFechaIngreso+"', fecha_de_alta="+pFechaAlta+","
                + "id_paciente ="+pIdPaciente+" "
                + "WHERE (id = '"+pIdExpediente+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
        
    
}

   
