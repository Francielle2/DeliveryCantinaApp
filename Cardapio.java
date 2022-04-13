package DeliveryCantinaApp;

public class Cardapio {
    private final Lanches cardapioLanche = new Lanches();
    private final Bebidas cardapioBebida = new Bebidas();
    private final Pratos cardapioPrato = new Pratos();

    public void opcoesCardapio() {
        System.out.println("Escolha a opção para ver nosso Cardápio:\n" +
                " 1 - Lanches\n" +
                " 2 - Pratos\n" +
                " 3 - Bebidas");
    }

    public String listaCardapio(int opt) {
        String tipoProduto;
        System.out.println();
        switch (opt) {
            case 1:
                cardapioLanche.iniciaCardapio();
                cardapioLanche.listaProdutos();
                tipoProduto = "Lanches";
                break;
            case 2:
                cardapioPrato.iniciaCardapio();
                cardapioPrato.listaProdutos();
                tipoProduto = "Pratos";
                break;
            case 3:
                cardapioBebida.iniciaCardapio();
                cardapioBebida.listaProdutos();
                tipoProduto = "Bebidas";
                break;
            default:
                tipoProduto = "ERRO";
        }
        return tipoProduto;
    }

    public String getProdutoCardapio(String tipoProduto, int idProduto){
        String produto = null;
        if (tipoProduto.equalsIgnoreCase("Lanches")){
            produto = cardapioLanche.getProduto(idProduto);
        } else if (tipoProduto.equalsIgnoreCase("Pratos")){
            produto = cardapioPrato.getProduto(idProduto);
        } else if (tipoProduto.equalsIgnoreCase("Bebidas")){
            produto = cardapioBebida.getProduto(idProduto);
        }
        return produto;
    }

    public double getValorProdutoCardapio(String tipoProduto, int idProduto){
        double valorProduto = 0d;
        if (tipoProduto.equalsIgnoreCase("Lanches")){
            valorProduto = cardapioLanche.getPreco(idProduto);
        } else if (tipoProduto.equalsIgnoreCase("Pratos")){
            valorProduto = cardapioPrato.getPreco(idProduto);
        } else if (tipoProduto.equalsIgnoreCase("Bebidas")){
            valorProduto = cardapioBebida.getPreco(idProduto);
        }
        return valorProduto;
    }

}