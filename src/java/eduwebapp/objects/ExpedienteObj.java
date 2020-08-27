/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduwebapp.objects;

/**
 *
 * @author Olga Vigil
 */
public final class ExpedienteObj {
    

    private int idExpediente;
    private String FechaIngreso;
    private String FechaAlta;
    private int idPaciente;

    public ExpedienteObj(int idExpediente, String FechaIngreso, String FechaAlta, int idPaciente) {
        setIdExpediente(idExpediente);
        setFechaIngreso(FechaIngreso);
        setFechaAlta(FechaAlta);
        setIdPaciente(idPaciente);
        
    }

    
    
    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int pIdExpediente) {
        this.idExpediente = pIdExpediente;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String pFechaIngreso) {
        this.FechaIngreso = pFechaIngreso;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String pFechaAlta) {
        this.FechaAlta = pFechaAlta;
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int pIdPaciente) {
        this.idPaciente = pIdPaciente;
    }
}


    

    
