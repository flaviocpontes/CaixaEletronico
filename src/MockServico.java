import static org.junit.Assert.*;

public class MockServico implements ServicoRemoto {

    private String contaRecuperada;

    public ContaCorrente recuperarConta(String numero){
        contaRecuperada = numero;
        return new ContaCorrente(0);
    }

    public void persistirConta(ContaCorrente cc) {
        System.out.println("Conta atualizada");
    }

    public void verificaChamadaRecuperaConta(String numeroEsperado) {
        assertEquals(numeroEsperado, contaRecuperada);
    }


}
