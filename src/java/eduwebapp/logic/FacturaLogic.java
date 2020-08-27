package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.FacturaObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class FacturaLogic extends Logic
{
    //metodo constructor
   
    
    public FacturaLogic(String pConnectionString)
    {
        super(pConnectionString);
    } 

    public int insertNewFactura(String pFechaDeEmision, String pHoraDeEmision, int pCorrelativo, String pTotal, int pIdTratamiento) {
        DatabaseX database = getDatabase();
        String sql = "insert into hospitaldb.factura "
                + "(id, correlativo, fecha, hora, Total, tratamiento_id) "
                + "value(0, '"+pCorrelativo+"', '"+pFechaDeEmision+"', '"+pHoraDeEmision+"', '"+pTotal+"', '"+pIdTratamiento+"')";
        int rows = database.executeNonQueryRows(sql); 
        return rows;
    } 
    
    public int deleteFactura(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM hospitaldb.factura "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<FacturaObj> getAllFactura()
    {
        DatabaseX database = getDatabase();
        ArrayList<FacturaObj> facturaArray = new ArrayList<>();
        String sql = "select * from hospitaldb.factura";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iIdFactura;
                int iCorrelativo;
                int iIdTratamiento;
                String strFechaDeEmision;
                String strHoraDeEmision;
                String strTotal;
                
                FacturaObj temp;
                
                while(result.next())
                {
                    iIdFactura = result.getInt("id");
                    iCorrelativo = result.getInt("correlativo");
                    strFechaDeEmision= result.getString("fecha");
                    strHoraDeEmision = result.getString("hora");
                    strTotal = result.getString("Total");
                    iIdTratamiento = result.getInt("tratamiento_id");
                    temp = new FacturaObj(iIdFactura, strFechaDeEmision, strHoraDeEmision, iCorrelativo, iIdTratamiento, strTotal);
                    facturaArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(FacturaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return facturaArray;
    }
    
    public FacturaObj getFacturaById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<FacturaObj> facturaArray = new ArrayList<>();
        String sql = "select * from hospitaldb.factura where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        FacturaObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iIdFactura;
                int iCorrelativo;
                String strFechaDeEmision;
                String strHoraDeEmision;
                String strTotal;
                int iIdTratamiento;
                while(result.next())
                {
                    iIdFactura = result.getInt("id");
                    iCorrelativo = result.getInt("correlativo");
                    strFechaDeEmision= result.getString("fecha");
                    strHoraDeEmision = result.getString("hora");
                    strTotal = result.getString("Total");
                    iIdTratamiento = result.getInt("tratamiento_id"); 
                    
                    temp = new FacturaObj(iIdFactura, strFechaDeEmision, strHoraDeEmision, iCorrelativo, iIdTratamiento, strTotal);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(FacturaLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 

    
    public int updateFactura(int pIdFactura, String pFechaDeEmision, String pHoraDeEmision, int pCorrelativo, String pTotal, int pIdTratamiento) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE hospitaldb.factura "
                + "SET correlativo = '"+pCorrelativo+"', fecha="+pFechaDeEmision+"', hora="+pHoraDeEmision+"', Total="+pTotal+"',tratamiento_id="+pIdTratamiento+" "
                + "WHERE (id = '"+pIdFactura+"');";
        
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }


}

   
