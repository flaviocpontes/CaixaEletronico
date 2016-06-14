public class MockServico implements ServicoRemoto {

    private boolean chamadaRecupera = false;

    public ContaCorrente recuperarConta(String numero){
        chamadaRecupera = true;
        return new ContaCorrente();
    }

    public void persistirConta(ContaCorrente cc) {
        System.out.println("Conta atualizada");
    }

    public void verificaChamadaRecuperaConta() {
    }

}
