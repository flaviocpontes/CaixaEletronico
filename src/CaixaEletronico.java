public class CaixaEletronico {

    private Hardware hw;
    private ServicoRemoto sr;

    public void setHardware(Hardware hw){
        this.hw = hw;
    }

    public void setServicoRemoto(ServicoRemoto sr){
        this.sr = sr;
    }

    public String logar(){
        return "Usuário Autenticado";
    }

}
