package adapter;

public class PagamentoERP {

    IDespesaBRL despesa;
    GatewayAdapter adaptadorAPI;

    public PagamentoERP() {
        despesa = new DespesaLocal();
        adaptadorAPI = new GatewayAdapter(despesa);
    }


    public void registrarDespesa(double valorEmReais) {
        despesa.setValorReais(valorEmReais);
        adaptadorAPI.processarNoGateway();
    }

    public double getValorNoERP() {
        return adaptadorAPI.recuperarDespesaConvertida();
    }


    public double getValorNaAPIExterna() {
        return adaptadorAPI.getValorUSD();
    }
}