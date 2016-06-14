import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MockHardwareErroLerEnvelope implements Hardware{

    public String pegarNumeroDaContaCartao() throws IOException {
        return "";
    }

    public void entregarDinheiro(double valor)  throws ErroDeHardware {
    }

    public void lerEnvelope()throws ErroDeHardware, TimeoutException {
        throw new ErroDeHardware("Não foi possíver ler o Envelope!");
    }
}
