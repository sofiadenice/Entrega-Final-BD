package eduwebapp.objects;

public final class FacturaObj {
    

    private int idFactura;
    private String fechaDeEmision;
    private String horaDeEmision;
    private int correlativo;
    private int idTratamiento; 
    private String total; 

    public FacturaObj(int idFactura, String fechaDeEmision, String horaDeEmision, int correlativo, int idTratamiento, String total) {
        setIdFactura(idFactura);
        setFechaDeEmision(fechaDeEmision);
        setHoraDeEmision(horaDeEmision);
        setCorrelativo(correlativo);
        setIdTratamiento(idTratamiento);
        setTotal(total);
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int pIdFactura) {
        this.idFactura = pIdFactura;
    }
    public String getFechaDeEmision() {
        return fechaDeEmision;
    }

    public void setFechaDeEmision(String pFechaDeEmision) {
        this.fechaDeEmision = pFechaDeEmision;
    }

    public String getHoraDeEmision() {
        return horaDeEmision;
    }

    public void setHoraDeEmision(String pHoraDeEmision) {
        this.horaDeEmision = pHoraDeEmision;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int pCorrelativo) {
        this.correlativo = pCorrelativo;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int pIdTratamiento) {
        this.idTratamiento = pIdTratamiento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String pTotal) {
        this.total = pTotal;
    }
    
}
    



    

    