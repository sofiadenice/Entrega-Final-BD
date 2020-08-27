/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.UsuarioObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class UsuarioLogic extends Logic {


    public UsuarioLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public UsuarioObj getUserByUser(String pUsername)
    {
        DatabaseX database = getDatabase();
        String sql = "select * from hospitaldb.medico "
                + "where usuario like '"+pUsername+"';";
        ResultSet result = database.executeQuery(sql);
        
        UsuarioObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                String username;
                String password;
                String cargo;
                while(result.next())
                {
                    username = result.getString("usuario");
                    password = result.getString("contrasena");
                    cargo = result.getString("cargo");
                    temp = new UsuarioObj(username,password,cargo);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MedicoLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }     
}

