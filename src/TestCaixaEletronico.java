import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaixaEletronico {

    @Test
    public void testLogar() {
        CaixaEletronico cx = new CaixaEletronico();
        cx.setHardware(new MockHardware());
        cx.setServicoRemoto(new MockServico());
        assertEquals("Usuário Autenticado", cx.logar());
    }


}
