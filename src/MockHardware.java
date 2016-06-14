import java.io.IOError;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

public class MockHardware implements Hardware {

    private boolean chamadaCartao = false;

    public String pegarNumeroDaContaCartao() throws IOException {
        chamadaCartao = true;
        return "012345";
    }

    public void entregarDinheiro(double valor)  throws ErroDeHardware {
        System.out.println("Dinheiro entregue");
    }

    public void lerEnvelope()throws ErroDeHardware, TimeoutException {
        System.out.println("Envelope recebido");
    }

    public void verificaChamadaCartao(){
        assertEquals(true, chamadaCartao);
    }

}
