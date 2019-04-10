import java.io.Serializable;

public class Expendedora implements Serializable {

    private static final long serialVersionUID = 1L;

    private float totalMaquina;

    private float saldoCliente;

    // --------------------------------------------

    public Expendedora(float totalFile) {
        totalMaquina = totalFile;
    }

    public float getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(float saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    // --------------------------------------------

    public void setTotalMaquina(float nuevoTotalMaquina) {
        this.totalMaquina = nuevoTotalMaquina;
    }

    public void agregarTotalMaquina(float agregadoTM) {
        totalMaquina = totalMaquina + agregadoTM;
    }

    public void restarTotalMaquina(float restadoTM) {
        totalMaquina = totalMaquina - restadoTM;
    }

    public float getTotalMaquina() {
        return totalMaquina;
    }

    //--------------------------------------------

    //public void imprimirBoleto()

}