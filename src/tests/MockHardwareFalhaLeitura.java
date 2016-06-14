package tests;

import main.ErroDeHardware;
import main.Hardware;

import java.io.IOException;

public class MockHardwareFalhaLeitura implements Hardware {
    public String pegarNumeroDaContaCartao() throws IOException {
        throw new IOException("Falha na leitura do cartão");
    }

    public void entregarDinheiro(double valor) throws ErroDeHardware {
        throw new ErroDeHardware("Falha na entrega das notas!");
    }

    public void lerEnvelope() throws ErroDeHardware {
        throw new ErroDeHardware("Falha ao ler envelope!");
    }

}