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
        hw.verificaChamadaCartao();
        sr.verificaChamadaRecuperaConta("012345");
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
        sr.verificaChamadaPersisteConta();
    }

    @Test
    public void testDepositoFalhando() throws IOException, ErroDeHardware, TimeoutException {
        MockHardware hw = new MockHardware();
        MockServico sr = new MockServico();
        cx.setHardware(hw);
        cx.setServicoRemoto(sr);
        cx.logar();
        try {
            cx.depositar(1000.00);
            fail("Não pegou o ErroDeHardware");
        } catch (ErroDeHardware erroDeHardware) {
            assertEquals(cx.saldo(), "O saldo é R$2500,00");
        }
    }

}
