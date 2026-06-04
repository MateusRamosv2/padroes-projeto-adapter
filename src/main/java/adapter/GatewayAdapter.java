package adapter;

public class GatewayAdapter extends GatewayEstrangeiroUSD {

    private IDespesaBRL despesaLocal;

    public GatewayAdapter(IDespesaBRL despesaLocal) {
        this.despesaLocal = despesaLocal;
    }


    public double recuperarDespesaConvertida() {
        double convertidoParaReais = this.getValorUSD() * 5.0;
        despesaLocal.setValorReais(convertidoParaReais);
        return despesaLocal.getValorReais();
    }


    public void processarNoGateway() {
        double convertidoParaDolar = despesaLocal.getValorReais() / 5.0;
        this.setValorUSD(convertidoParaDolar);
    }
}