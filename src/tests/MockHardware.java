package tests;

import main.ErroDeHardware;
import main.Hardware;

import java.io.IOException;

public class MockHardware implements Hardware {

    private boolean chamadaCartao = false;
    private boolean chamadaDinheiro = false;
    private boolean chamadaEnvelope = false;

    public String pegarNumeroDaContaCartao() throws IOException {
        chamadaCartao = true;
        return "012345";
    }

    public void entregarDinheiro(double valor)  throws ErroDeHardware {
        chamadaDinheiro = true;
    }

    public void lerEnvelope()throws ErroDeHardware {
        chamadaEnvelope = true;
    }

    public boolean verificaChamadaCartao(){
        return chamadaCartao;
    }

    public boolean verificaChamadaDinheiro(){
        return chamadaDinheiro;
    }

    public boolean verificaChamadaEnvelope() {
        return chamadaEnvelope;
    }
}
