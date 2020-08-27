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
public final class PacienteObj {
    

    private int idPaciente;
    private String Nombre;
    private String Apellido;
    private String Sexo;
    private int Edad;
    private String Direccion;
    private int Contacto;
    private int IdFactura;
    private int IdFacturaTratamiento;

    public PacienteObj(int idPaciente, String Nombre, String Apellido, String pSexo, String pEdad, 
            String pDireccion, String pContacto, int pIdFactura, int pIdFacturaTratamiento) {
        setIdPaciente(idPaciente);
        setNombre(Nombre);
        setApellido(Apellido);
        setSexo(Sexo);
        setEdad(Edad);
        setDireccion(Direccion);
        setContacto(Contacto);
        setIdFactura(IdFactura);
        setIdFacturaTratamiento(IdFacturaTratamiento);
        
    }

    public PacienteObj(int iIdPaciente, String strNombre, String strApellido, String strSexo, int iEdad, String strDireccion, int iContacto, int iIdFactura, int iIdFacturaTratamiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int pIdPaciente) {
        this.idPaciente = pIdPaciente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String pNombre) {
        this.Nombre = pNombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String pApellido) {
        this.Apellido = pApellido;
    }
    
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String pSexo) {
        this.Sexo = pSexo;
    }
    
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int pEdad) {
        this.Edad = pEdad;
    }
    
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String pDireccion) {
        this.Direccion = pDireccion;
    }
    
    public int getContacto() {
        return Contacto;
    }

    public void setContacto(int pContacto) {
        this.Contacto = pContacto;
    }
    
    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int pIdFactura) {
        this.IdFactura = pIdFactura;
    }
    
    public int getIdFacturaTratamiento() {
        return IdFacturaTratamiento;
    }

    public void setIdFacturaTratamiento(int pIdFacturaTratamiento) {
        this.IdFacturaTratamiento = pIdFacturaTratamiento;
    }
}


    

    
