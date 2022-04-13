package DeliveryCantinaApp;

public enum PrecoLanches {
	
    BURGUER(30d),
    PIZZA(45d),
    FOGAZZA(20d);

    private final double valor;

    PrecoLanches(double valor) {this.valor = valor;}

    public double getValor() {return this.valor;}
}