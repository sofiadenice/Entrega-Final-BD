package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.TratamientoObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TratamientoLogic extends Logic
{
    //metodo constructor
   
    
    public TratamientoLogic(String pConnectionString)
    {
        super(pConnectionString);
    } 

    public int insertNewTratamiento(String pMedicamento, String pPrecio) {
        DatabaseX database = getDatabase();
        String sql = "insert into hospitaldb.tratamiento "
                + "(id, medicamento, precio) "
                + "value(0, '"+pMedicamento+"', "+pPrecio+")";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
    public int deleteTratamieto(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM hospitaldb.tratamiento "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<TratamientoObj> getAllTratamiento()
    {
        DatabaseX database = getDatabase();
        ArrayList<TratamientoObj> tratamientoArray = new ArrayList<>();
        String sql = "select * from hospitaldb.tratamiento";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iIdTratamiento;
                String strMedicamento;
                String strPrecio;
                TratamientoObj temp;
                
                while(result.next())
                {
                    iIdTratamiento = result.getInt("id");
                    strMedicamento = result.getString("medicamento");
                    strPrecio = result.getString("precio");
                    temp = new TratamientoObj(iIdTratamiento, strMedicamento, strPrecio);
                    tratamientoArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TratamientoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return tratamientoArray;
    }
    
    public TratamientoObj getTratamientoById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<TratamientoObj> tratamientoArray = new ArrayList<>();
        String sql = "select * from hospitaldb.tratamiento where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        TratamientoObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iIdTratamiento;
                String strMedicamento;
                String strPrecio;
                while(result.next())
                {
                    iIdTratamiento = result.getInt("id");
                    strMedicamento = result.getString("medicamento");
                    strPrecio = result.getString("precio");
                    temp = new TratamientoObj(iIdTratamiento, strMedicamento, strPrecio);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TratamientoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 

    
    public int updateTratamiento(int pIdTratamiento, String pMedicamento, String pPrecio) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE hospitaldb.tratamiento "
                + "SET medicamento = '"+pMedicamento+"', precio="+pPrecio+" "
                + "WHERE (id = '"+pIdTratamiento+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
        
    
}

   
