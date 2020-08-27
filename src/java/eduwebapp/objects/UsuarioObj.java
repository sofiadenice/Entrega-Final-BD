/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduwebapp.objects;

public class UsuarioObj 
{
    private String username;
    private String password;
    private String cargo;

    public UsuarioObj(String pUsername, 
            String pPassword, String pCargo) 
    {
        setUsername(pUsername);
        setPassword(pPassword);
        setCargo(pCargo);
    }

    public String getUsername() 
    {
        return username;
    }

    private void setUsername(String pUsername) 
    {
        this.username = pUsername;
    }

    public String getPassword() 
    {
        return password;
    }

    private void setPassword(String pPassword) 
    {
        this.password = pPassword;
    }
    
    public String getCargo() 
    {
        return cargo;
    }

    private void setCargo(String pCargo) 
    {
        this.cargo = pCargo;
    }
}
