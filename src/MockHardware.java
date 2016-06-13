import java.io.IOError;

public class MockHardware implements Hardware {

    public String pegarNumeroDaContaCartao() throws IOError {
        return "012345";
    }

    public void entregarDinheiro(double valor) {
        System.out.println("Dinheiro entregue");
    }

    public void lerEnvelope() {
        System.out.println("Envelope recebido");
    }

    public void verificaChamadas(){

    }

}
