package main;

import java.io.IOException;

public class CaixaEletronico {

    private Hardware hw;
    private ServicoRemoto sr;
    private ContaCorrente cc;

    public void setHardware(Hardware hw){
        this.hw = hw;
    }

    public void setServicoRemoto(ServicoRemoto sr){
        this.sr = sr;
    }

    public String logar() throws IOException{
        String numeroConta = hw.pegarNumeroDaContaCartao();
        this.cc = sr.recuperarConta(numeroConta);
        return "Usuário Autenticado";
    }

    public String saldo() {
        double saldo = cc.getSaldo();
        return String.format("O saldo é R$%.2f", saldo);
    }

    public String depositar(double valor) throws ErroDeHardware {
        hw.lerEnvelope();
        cc.deposita(valor);
        sr.persistirConta(cc);
        return "Depósito recebido com sucesso";
    }

    public String sacar(double valor) throws ErroDeHardware{
        try {
            cc.sacar(valor);
            hw.entregarDinheiro(valor);
            sr.persistirConta(cc);
        } catch (SaldoInsuficienteException e) {
            return "Saldo insuficiente";
        }
        return "Retire seu dinheiro";
    }
}
