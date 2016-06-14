package tests;

import main.ErroDeHardware;
import main.Hardware;

import java.io.IOException;

public class MockHardwareFalha implements Hardware {

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
