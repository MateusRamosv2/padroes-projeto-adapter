package adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PagamentoERPTest {

    @Test
    void deveRetornarValorCorretoNoERP() {
        PagamentoERP pagamento = new PagamentoERP();
        pagamento.registrarDespesa(50.0);

        assertEquals(50.0, pagamento.getValorNoERP());
    }


}