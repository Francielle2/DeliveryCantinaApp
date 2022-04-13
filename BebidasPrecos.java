package DeliveryCantinaApp;

public enum BebidasPrecos {
	
    REFRIGERANTE(5d),
    SUCO(7d),
    VINHO(50d);

    private final double valor;

    BebidasPrecos(double valor) {this.valor = valor;}

    public double getValor() {return this.valor;}
}