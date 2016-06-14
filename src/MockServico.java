import static org.junit.Assert.*;

public class MockServico implements ServicoRemoto {

    private String contaRecuperada;
    private boolean contaPersistida = false;

    public ContaCorrente recuperarConta(String numero){
        contaRecuperada = numero;
        return new ContaCorrente(2500);
    }

    public void persistirConta(ContaCorrente cc) {
        contaPersistida = true;
        System.out.println("Conta atualizada");
    }

    public void verificaChamadaRecuperaConta(String numeroEsperado) {
        assertEquals(numeroEsperado, contaRecuperada);
    }

    public void verificaChamadaPersisteConta() {
        assertTrue(contaPersistida);
    }
}
