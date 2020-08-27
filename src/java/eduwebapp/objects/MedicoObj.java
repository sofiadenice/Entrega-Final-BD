package eduwebapp.objects;

public class MedicoObj {
    private int idDoctor;
    private String nombreDoctor;
    private String apellidoDoctor;
    private String cargo;
    private String usuario;

    public MedicoObj(int p_idDoctor, String p_nombreDoctor, String p_apellidoDoctor, String p_cargo, String p_usuario) {
        setIdDoctor(p_idDoctor);
        setNombreDoctor(p_nombreDoctor);
        setApellidoDoctor(p_apellidoDoctor);
        setCargo(p_cargo);
        setUsuario(p_usuario);
    }

    
    private void setIdDoctor(int p_idDoctor) {
        idDoctor = p_idDoctor;
    }
    
    public int getIdDoctor() {
            return idDoctor;
    }
    
    private void setNombreDoctor(String p_nombreDoctor) {
        nombreDoctor = p_nombreDoctor;
    }
    
    public String getNombreDoctor() {
        return nombreDoctor;
    }

    private void setApellidoDoctor(String p_apellidoDoctor) {
        apellidoDoctor = p_apellidoDoctor;
    }

    public String getApellidoDoctor() {
        return apellidoDoctor;
    }
    
    private void setCargo(String p_cargo) {
        cargo = p_cargo;
    }
    
    public String getCargo() {
        return cargo;
    }

    private void setUsuario(String p_usuario) {
        usuario = p_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

}
