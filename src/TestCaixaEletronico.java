import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaixaEletronico {

    @Test
    public void testLogar() {
        CaixaEletronico cx = new CaixaEletronico();
        MockHardware hw = new MockHardware();
        cx.setHardware(hw);
        MockServico sr = new MockServico();
        cx.setServicoRemoto(sr);
        assertEquals("Usuário Autenticado", cx.logar());
        hw.verificaChamadaCartao();
        sr.verificaChamadaRecuperaConta();
    }


}
