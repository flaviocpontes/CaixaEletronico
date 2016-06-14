import static org.junit.Assert.*;
import org.junit.Test;

public class TestContaCorrente {

    @Test
    public void testGetSaldo(){
        ContaCorrente cc = new ContaCorrente(2500.00);
        assertEquals(2500.00, cc.getSaldo(), 1);
    }

}
