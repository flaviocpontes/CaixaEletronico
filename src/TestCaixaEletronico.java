import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

public class TestCaixaEletronico {

    CaixaEletronico cx;

    @Before
    public void criaCaixa() {
        cx = new CaixaEletronico();
    }

    @Test
    public void testLogar() throws IOException{
        MockHardware hw = new MockHardware();
        cx.setHardware(hw);
        MockServico sr = new MockServico();
        cx.setServicoRemoto(sr);
        assertEquals("Usuário Autenticado", cx.logar());
        assertTrue(hw.verificaChamadaCartao());
        assertTrue(sr.verificaChamadaRecuperaConta("012345"));
    }

    @Test
    public void testLogarFalhaDeLeitura() {
        MockHardwareFalhaLeitura hw = new MockHardwareFalhaLeitura();
        cx.setHardware(hw);
        try {
            cx.logar();
            fail("Não levantou a exceção IOException esperada");
        } catch (IOException e) {
            System.out.println("YAY!");
        }
    }

    @Test
    public void testSaldo() throws IOException{
        MockHardware hw = new MockHardware();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        assertEquals(cx.saldo(), "O saldo é R$2500,00");
    }

    @Test
    public void testDeposito() throws IOException, ErroDeHardware, TimeoutException {
        MockHardware hw = new MockHardware();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        cx.depositar(1000.00);
        assertEquals(cx.saldo(), "O saldo é R$3500,00");
        assertTrue(sr.verificaChamadaPersisteConta());
        assertTrue(hw.verificaChamadaEnvelope());
    }

    @Test
    public void testDepositoFalhando() throws IOException, ErroDeHardware {
        MockHardwareErroLerEnvelope hw = new MockHardwareErroLerEnvelope();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        try {
            cx.depositar(1000.00);
            fail("Não pegou o ErroDeHardware");
        } catch (ErroDeHardware erroDeHardware) {
            assertEquals(cx.saldo(), "O saldo é R$2500,00");
            assertFalse(sr.verificaChamadaPersisteConta());
        }
    }

    @Test
    public void testEntregaDinheiro() throws ErroDeHardware, IOException {
        MockHardware hw = new MockHardware();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        assertEquals("Retire seu dinheiro", cx.sacar(1000.00));
        assertTrue(sr.verificaChamadaPersisteConta());
    }

    @Test
    public void testEntregaDinheiroInsuficiente() throws ErroDeHardware, IOException {
        MockHardware hw = new MockHardware();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        assertEquals("Saldo insuficiente", cx.sacar(5000.00));
    }

    @Test
    public void testEntregaDinheiroFalha() throws IOException {
        MockHardware hw = new MockHardware();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        try {
            cx.sacar(1000.00);
            fail("Erro de Hardware não levanado");
        } catch (ErroDeHardware e) {
            System.out.println("Erro de hardware leventado com sucesso!");
        }
    }


}
