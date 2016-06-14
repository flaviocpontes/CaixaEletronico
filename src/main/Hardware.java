package main;

import java.io.IOException;

public interface Hardware {
    String pegarNumeroDaContaCartao() throws IOException;
    void entregarDinheiro(double valor) throws ErroDeHardware;
    void lerEnvelope() throws ErroDeHardware;
}
