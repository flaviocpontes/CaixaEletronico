public class ContaCorrente {

    private double saldo;

    public ContaCorrente() {
        this.saldo = 0;
    }

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}
