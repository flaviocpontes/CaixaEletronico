import java.io.IOException;

public class CaixaEletronico {

    private Hardware hw;
    private ServicoRemoto sr;
    private ContaCorrente cc;

    public void setHardware(Hardware hw){
        this.hw = hw;
    }

    public void setServicoRemoto(ServicoRemoto sr){
        this.sr = sr;
    }

    public String logar() throws IOException{
        String numeroConta = hw.pegarNumeroDaContaCartao();
        this.cc = sr.recuperarConta(numeroConta);
        return "Usuário Autenticado";
    }

    public String saldo() {
        double saldo = cc.getSaldo();
        return String.format("O saldo é R$%.2f", saldo);
    }

    public void depositar(double valor) {

    }
}
