import java.io.IOError;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MockHardwareFalha implements Hardware{

    public String pegarNumeroDaContaCartao() throws IOException {
        return "";
    }

    public void entregarDinheiro(double valor) throws ErroDeHardware {
        throw new ErroDeHardware("Falha na entrega das notas!");
    }

    public void lerEnvelope()throws ErroDeHardware {
        throw new ErroDeHardware("Falha ao ler envelope!");
    }

}
