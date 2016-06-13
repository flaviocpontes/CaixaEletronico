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

    public String logar(){
        String numeroConta = hw.pegarNumeroDaContaCartao();
        this.cc = sr.recuperarConta(numeroConta);
        return "Usuário Autenticado";
    }

}
