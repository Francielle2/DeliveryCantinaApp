package DeliveryCantinaApp;

public enum BebidasDescricao {

	REFRIGERANTE("Refrigerante"),
    SUCO("Suco"),
    VINHO("Vinho");

    private final String descricao;

    BebidasDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}