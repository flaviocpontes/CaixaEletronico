import static org.junit.Assert.*;
import org.junit.Test;

public class TestContaCorrente {

    @Test
    public void testGetSaldo(){
        ContaCorrente cc = new ContaCorrente(2500.00);
        assertEquals(2500.00, cc.getSaldo(), 1);
    }

    @Test
    public void testDeposita(){
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(1500.00);
        assertEquals(1500.00, cc.getSaldo(), 1);
    }

    @Test
    public void testSacar(){
        ContaCorrente cc = new ContaCorrente();
        cc.deposita(1500.00);
        assertEquals(1500.00, cc.getSaldo(), 1);
        cc.sacar(1000.00);
        assertEquals(500.00, cc.getSaldo(), 1);
    }

}
