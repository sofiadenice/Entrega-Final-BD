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
public final class TratamientoObj {
    

    private int idTratamiento;
    private String medicamentos;
    private String precio;

    public TratamientoObj(int idTratamiento, String medicamentos, String precio) {
        setIdTratamiento(idTratamiento);
        setMedicamentos(medicamentos);
        setPrecio(precio);
        
    }

    
    
    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int pIdTratamiento) {
        this.idTratamiento = pIdTratamiento;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String pMedicamentos) {
        this.medicamentos = pMedicamentos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String pPrecio) {
        this.precio = pPrecio;
    }
}


    

    
