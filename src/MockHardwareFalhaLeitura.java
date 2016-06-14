import java.io.IOError;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MockHardwareFalhaLeitura implements Hardware{

    public String pegarNumeroDaContaCartao() throws IOException {
        throw new IOException("Falha na leitura do cartão");
    }

    public void entregarDinheiro(double valor)  throws ErroDeHardware {
    }

    public void lerEnvelope()throws ErroDeHardware {
    }

}
