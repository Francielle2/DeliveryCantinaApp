package DeliveryCantinaApp;

public interface ICardapio {

    void iniciaCardapio();
    void listaProdutos();
    double getPreco(int idProduto);
    String getProduto(int idProduto);

}