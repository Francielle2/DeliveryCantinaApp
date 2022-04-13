package DeliveryCantinaApp;

public enum PratosPrecos  {
	
    PASTA(30d),
    LASANHA(70d),
    POLPETONE(50d);

    private final double valor;

    PratosPrecos(double valor) {this.valor = valor;}

    public double getValor() {return this.valor;}
}