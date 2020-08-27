package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.PacienteObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PacienteLogic extends Logic
{
    //metodo constructor
   
    
    public PacienteLogic(String pConnectionString)
    {
        super(pConnectionString);
    } 

    public int insertNewPaciente(String pNombre,String pApellido, String pSexo, String pEdad, String pDireccion,
            String pContacto, int pIdFactura, int pIdFacturaTratamiento) {
        DatabaseX database = getDatabase();
        String sql = "insert into hospitaldb.paciente "
                + "(id, nombre, apellido, sexo, edad, direccion, contacto, Factura_id, Factura_tratamiento_id) "
                + "value(0, '"+pNombre+"', '"+pApellido+"', "+pSexo+"', "+pEdad+"', "+pDireccion+""
                + "', "+pContacto+"', "+pIdFactura+"', "+pIdFacturaTratamiento+")";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
    public int deletePaciente(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM hospitaldb.paciente "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<PacienteObj> getAllPaciente()
    {
        DatabaseX database = getDatabase();
        ArrayList<PacienteObj> pacienteArray = new ArrayList<>();
        String sql = "select * from hospitaldb.paciente";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iIdPaciente;
                String strNombre;
                String strApellido;
                String strSexo;
                int iEdad;
                String strDireccion;
                int iContacto;
                int iIdFactura;
                int iIdFacturaTratamiento;
                PacienteObj temp;
                
                while(result.next())
                {
                    iIdPaciente = result.getInt("id");
                    strNombre = result.getString("Nombre");
                    strApellido = result.getString("Apellido");
                    strSexo = result.getString("Sexo");
                    iEdad = result.getInt("Edad");
                    strDireccion = result.getString("Direccion");
                    iContacto = result.getInt("Contacto");
                    iIdFactura = result.getInt("idFactura");
                    iIdFacturaTratamiento = result.getInt("idFacturaTratamiento");
                    temp = new PacienteObj(iIdPaciente, strNombre, strApellido, strSexo, iEdad,
                            strDireccion, iContacto, iIdFactura, iIdFacturaTratamiento);
                    pacienteArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PacienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return pacienteArray;
    }
    
    public PacienteObj getPacienteById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<PacienteObj> pacienteArray = new ArrayList<>();
        String sql = "select * from hospitaldb.paciente where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        PacienteObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iIdPaciente;
                String strNombre;
                String strApellido;
                String strSexo;
                int iEdad;
                String strDireccion;
                int iContacto;
                int iIdFactura;
                int iIdFacturaTratamiento;
                while(result.next())
                {
                    iIdPaciente = result.getInt("id");
                    strNombre = result.getString("Nombre");
                    strApellido = result.getString("Apellido");
                    strSexo = result.getString("Sexo");
                    iEdad = result.getInt("Edad");
                    strDireccion = result.getString("Direccion");
                    iContacto = result.getInt("Contacto");
                    iIdFactura = result.getInt("IdFactura");
                    iIdFacturaTratamiento = result.getInt("IdFacturaTratamiento");
                    temp = new PacienteObj(iIdPaciente, strNombre, strApellido, strSexo, iEdad,
                            strDireccion, iContacto, iIdFactura, iIdFacturaTratamiento);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(PacienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 

    
    public int updatePaciente(int pIdPaciente, String pNombre,String pApellido, String pSexo, String pEdad, 
            String pDireccion, String pContacto, String pIdFactura, String pIdFacturaTratamiento) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE hospitaldb.paciente "
                + "SET nombre = '"+pNombre+"', apellido="+pApellido+","
                + "sexo ="+pSexo+",edad ="+pEdad+",direccion ="+pDireccion+",contacto ="+pContacto+","
                + "Factura_id ="+pIdFactura+", Factura_tratamiento_id ="+pIdFacturaTratamiento+","
                + "WHERE (id = '"+pIdPaciente+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }

         
    
}

   
