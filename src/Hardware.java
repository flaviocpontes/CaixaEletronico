import java.io.IOError;
import java.util.concurrent.TimeoutException;

public interface Hardware {
    String pegarNumeroDaContaCartao() throws IOError;
    void entregarDinheiro(double valor) throws HardwareError;
    void lerEnvelope() throws HardwareError, TimeoutException;
}
