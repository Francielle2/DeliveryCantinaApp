package DeliveryCantinaApp;

import java.util.Scanner;

public class Cantina {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        boolean hasPedido = false;
        boolean isMenu = true;
        Pedidos pedido = new Pedidos();
        Cardapio cardapio = new Cardapio();

        System.out.println("\nSeja bem Vindo à Cantina Codifichiamo!!!");

        do {
            if (hasPedido){
                System.out.println();
                System.out.println("Menu:\n" +
                        " 1 - Adicionar mais itens ao pedido\n" +
                        " 2 - Excluir itens do pedido\n" +
                        " 3 - Efetuar o pagamento do pedido\n" +
                        " 0 - Cancelar o pedido (sair)");
                switch (scanner.nextInt()){
                    case 1:
                        hasPedido = false;
                        break;
                    case 2:
                        pedido.listaPedido();
                        System.out.println();
                        System.out.println("Qual item deseja excluir?");
                        pedido.removeProduto(scanner.nextInt()); scanner.nextLine();
                        break;
                    case 3:
                        pedido.listaPedido();
                        System.out.println();
                        System.out.println("Confirma fechamento do pedido acima? S/N");
                        if (scanner.next().equalsIgnoreCase("S")){
                            pedido.removePedido();
                            isMenu = false;
                        }
                        break;
                    case 0:
                        pedido.listaPedido();
                        System.out.println("\nConfirma o cancelamento do pedido acima? S/N");
                        if (scanner.next().equalsIgnoreCase("S")){
                            pedido.removePedido();
                            isMenu = false;
                        }
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente!");
                }
            }
            System.out.println();
            while (!hasPedido) {
                cardapio.opcoesCardapio();
                int opt = scanner.nextInt(); scanner.nextLine();
                String tipoProduto = cardapio.listaCardapio(opt);
                while (tipoProduto.equalsIgnoreCase("ERRO")) {
                    System.out.printf("Opção %d inválida. Tente novamente!\n", opt);
                    cardapio.opcoesCardapio();
                    opt = scanner.nextInt(); scanner.nextLine();
                    tipoProduto = cardapio.listaCardapio(opt);
                }
                int idProduto = (scanner.nextInt() - 1); scanner.nextLine();
                try {
                    pedido.insereProduto(tipoProduto, cardapio.getProdutoCardapio(tipoProduto, idProduto),
                            cardapio.getValorProdutoCardapio(tipoProduto, idProduto));
                    pedido.insereDelivery(tipoProduto);
                    System.out.printf("%s adicionado ao pedido.\n",cardapio.getProdutoCardapio(tipoProduto,idProduto));
                } catch (IndexOutOfBoundsException exception){
                    System.out.println("Opção inválida! " + exception.getMessage());
                }
                System.out.println(" ");
                System.out.println("Deseja adicionar mais algum item ao pedido? S/N");
                if (scanner.next().equalsIgnoreCase("N")){
                    hasPedido = true;
                }
            }
        } while (isMenu);

        System.out.println("Obrigado pela preferência! \n Volte Sempre!");
    }
}