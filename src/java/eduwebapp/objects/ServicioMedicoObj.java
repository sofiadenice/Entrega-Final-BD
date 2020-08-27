package eduwebapp.objects;

public class ServicioMedicoObj {
    private int idServicioMedico;
    private int idMedico;
    private int idPaciente;
    private int numeroCama;
    private String diagnostico;
    private String fecha;
    private String hora;

    public ServicioMedicoObj(int p_idServicioMedico, int p_idMedico, int p_idPaciente, int p_numeroCama, String p_diagnostico, String p_fecha, String p_hora) {
        setIdServicioMedico(p_idServicioMedico);
        setIdMedico(p_idMedico);
        setIdPaciente(p_idPaciente);
        setNumeroCama(p_numeroCama);
        setDiagnostico(p_diagnostico);
        setFecha(p_fecha);
        setHora(p_hora);

    }

    private void setIdServicioMedico(int p_idServicioMedico) {
        idServicioMedico = p_idServicioMedico;
    }
    
    public int getIdServicioMedico() {
        return idServicioMedico;
    }
    
    private void setIdMedico(int p_idMedico) {
        idMedico = p_idMedico;
    }
    
    public int getIdMedico() {
        return idMedico;
    }

    private void setIdPaciente(int p_idPaciente) {
        idPaciente = p_idPaciente;
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }

    private void setNumeroCama(int p_numeroCama) {
        numeroCama = p_numeroCama;
    }
    
    public int getNumeroCama() {
        return numeroCama;
    }

    private void setDiagnostico(String p_diagnostico) {
        diagnostico = p_diagnostico;
    }
    
    public String getDiagnostico() {
        return diagnostico;
    }

    private void setFecha(String p_fecha) {
        fecha = p_fecha;
    }
    
    public String getFecha() {
        return fecha;
    }

    private void setHora(String p_hora) {
        hora = p_hora;
    }

    public String getHora() {
        return hora;
    }
}
