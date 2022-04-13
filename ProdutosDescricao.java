package DeliveryCantinaApp;

public enum ProdutosDescricao {
	
    BURGUER("Burguer"),
    PIZZA("Pizza"),
    FOGAZZA("Fogazza");

    private final String descricao;

    ProdutosDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}