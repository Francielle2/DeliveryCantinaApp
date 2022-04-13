package DeliveryCantinaApp;

public enum PratosDescricao {
	
    PASTA("Pasta"),
    LASANHA("Lasanha"),
    POLPETONE("Polpetone");

    private final String descricao;

    PratosDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}