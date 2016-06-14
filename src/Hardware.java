import java.io.IOError;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface Hardware {
    String pegarNumeroDaContaCartao() throws IOException;
    void entregarDinheiro(double valor) throws ErroDeHardware;
    void lerEnvelope() throws ErroDeHardware, TimeoutException;
}
