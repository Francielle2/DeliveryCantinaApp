package DeliveryCantinaApp;

import  java.util.ArrayList ;
import  java.util.Scanner ;

public class Pedidos implements IDelivery {
	
    Scanner sc = new Scanner(System.in);
    private final ArrayList<String> tiposProdutosPedido = new ArrayList<>();
    private final ArrayList<String> produtosPedido = new ArrayList<>();
    private final ArrayList<Double> valoresPedido = new ArrayList<>();
    private double vlrTotal;
 
    private double vlrDeliveryTotal;
    private final double VLR_DELIVERY_LANCHE = 1.0d;
    private final double VLR_DELIVERY_BEBIDA = 1.0d;
    private final double VLR_DELIVERY_PRATO = 2.0d;

    public void insereProduto(String tipoProduto, String produto, double valor){
        this.tiposProdutosPedido.add(tipoProduto);
        this.produtosPedido.add(produto);
        this.valoresPedido.add(valor);
        this.vlrTotal += valor;
    }

    public void listaPedido() {
        System.out.println("Pedido:");
        for (int i=0; i < this.produtosPedido.size(); i++){
            System.out.printf("%d - %s - R$ %.2f\n", i+1, this.produtosPedido.get(i), this.valoresPedido.get(i));
        }
        System.out.printf("Taxa Delivery: R$ %.2f\n",this.vlrDeliveryTotal);
        System.out.printf("Total: R$ %.2f",this.vlrTotal);
    }

    public void removeProduto(int seqProdutoPedido){
        System.out.printf("O produto %s será removido! Confirma a exclusão? S/N\n",this.produtosPedido.get(seqProdutoPedido - 1));
        if (sc.nextLine().equalsIgnoreCase("S")){
            this.vlrDeliveryTotal -= getVlrDeliveryProduto(this.tiposProdutosPedido.get(seqProdutoPedido - 1));
            this.vlrTotal -= this.valoresPedido.get(seqProdutoPedido - 1);
            this.tiposProdutosPedido.remove(seqProdutoPedido - 1);
            this.produtosPedido.remove(seqProdutoPedido - 1);
            this.valoresPedido.remove(seqProdutoPedido - 1);
            System.out.printf("Item %d excluído do pedido com sucesso",seqProdutoPedido);
        }
    }

    public void removePedido(){
        this.vlrTotal = 0;
        this.vlrDeliveryTotal = 0;
        this.tiposProdutosPedido.clear();
        this.produtosPedido.clear();
        this.valoresPedido.clear();
    }

    @Override
    public double getVlrDeliveryProduto(String tipoProduto) {
        double vlrDelivery = 0d;
        if (tipoProduto.equalsIgnoreCase("Lanches")) {
            vlrDelivery = VLR_DELIVERY_LANCHE;
        } else if (tipoProduto.equalsIgnoreCase("Bebidas")) {
            vlrDelivery = VLR_DELIVERY_BEBIDA;
        } else if (tipoProduto.equalsIgnoreCase("Pratos")) {
            vlrDelivery = VLR_DELIVERY_PRATO;
        }
        return vlrDelivery;
    }

    @Override
    public void insereDelivery(String tipoProduto) {
        if (tipoProduto.equalsIgnoreCase("Lanches")) {
            this.vlrDeliveryTotal += VLR_DELIVERY_LANCHE;
            this.vlrTotal += VLR_DELIVERY_LANCHE;
        } else if (tipoProduto.equalsIgnoreCase("Bebidas")){
            this.vlrDeliveryTotal += VLR_DELIVERY_BEBIDA;
            this.vlrTotal += VLR_DELIVERY_BEBIDA;
        } else if (tipoProduto.equalsIgnoreCase("Pratos")){
            this.vlrDeliveryTotal += VLR_DELIVERY_PRATO;
            this.vlrTotal += VLR_DELIVERY_PRATO;
        }
    }
}