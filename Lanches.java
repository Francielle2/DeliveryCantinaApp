package DeliveryCantinaApp;

import java.util.ArrayList;

public class Lanches implements ICardapio {
    private final ArrayList<String> listaProdutos = new ArrayList<>();
    private final ArrayList<Double> listaPrecos = new ArrayList<>();

    @Override
    public void iniciaCardapio(){
        for (ProdutosDescricao lanchesProdutos : ProdutosDescricao.values()) {
            this.listaProdutos.add(lanchesProdutos.getDescricao());
        }
        for (PrecoLanches lanchesPrecos : PrecoLanches.values()) {
            this.listaPrecos.add(lanchesPrecos.getValor());
        }
    }

    @Override
    public void listaProdutos() {
        System.out.println("Lanches:");
        for (int i = 0; i < this.listaProdutos.size(); i++){
            System.out.printf("%d - %s - R$ %.2f", i+1, this.listaProdutos.get(i), this.listaPrecos.get(i));
            System.out.println();
        }
    }

    @Override
    public double getPreco(int idProduto) {
        return listaPrecos.get(idProduto);
    }

    @Override
    public String getProduto(int idProduto) {
        return listaProdutos.get(idProduto);
    }
}