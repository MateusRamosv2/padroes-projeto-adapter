package adapter;

public class DespesaLocal implements IDespesaBRL {

    private double valorReais;

    @Override
    public double getValorReais() {
        return this.valorReais;
    }

    @Override
    public void setValorReais(double valor) {
        this.valorReais = valor;
    }
}
