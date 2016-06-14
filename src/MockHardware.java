import java.io.IOError;

import static org.junit.Assert.*;

public class MockHardware implements Hardware {

    private boolean chamadaCartao = false;

    public String pegarNumeroDaContaCartao() throws IOError {
        chamadaCartao = true;
        return "012345";
    }

    public void entregarDinheiro(double valor) {
        System.out.println("Dinheiro entregue");
    }

    public void lerEnvelope() {
        System.out.println("Envelope recebido");
    }

    public void verificaChamadaCartao(){
        assertEquals(true, chamadaCartao);
    }

}
