public class MockServico implements ServicoRemoto {

    public ContaCorrente recuperarConta(String numero){
        return new ContaCorrente();
    }

    public void persistirConta(ContaCorrente cc) {
        System.out.println("Conta atualizada");
    }

}
