package Lista_q5;

import java.util.Scanner;

public class Principal {

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pedido pedido = null;

        while (true) {

        System.out.println("\n===== SISTEMA DE PEDIDOS =====");
        System.out.println("1. Cadastrar pedido");
        System.out.println("2. Escolher tipo");
        System.out.println("3. Mostrar dados do pedido");
        System.out.println("4. Escolher forma de pagamento");
        System.out.println("5. Pagar em dinheiro");
        System.out.println("6. Pagar via PIX");
        System.out.println("7. Pagar com cartão");
        System.out.println("8. Encerrar");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

                case 1:

                System.out.print("Número do pedido: ");

                int numero =
                        scanner.nextInt();
                        scanner.nextLine();

                System.out.print("Nome do cliente: ");

                String cliente = scanner.nextLine();

                System.out.print("Valor do pedido: ");

                double valor = scanner.nextDouble();

                System.out.println("1. Pedido local");

                System.out.println(
                        "2. Pedido delivery"
                );

                System.out.print(
                        "Tipo: "
                );

                int tipo =
                        scanner.nextInt();

                scanner.nextLine();

                if (tipo == 1) {

                        pedido =
                                new PedidoLocal(
                                        numero,
                                        cliente,
                                        valor
                                );

                } else if (tipo == 2) {

                        System.out.print(
                                "Endereço: "
                        );

                        String endereco =
                                scanner.nextLine();

                        System.out.print(
                                "Taxa de entrega: "
                        );

                        double taxa =
                                scanner.nextDouble();

                        pedido =
                                new PedidoDelivery(
                                        numero,
                                        cliente,
                                        valor,
                                        endereco,
                                        taxa
                                );

                } else {

                        System.out.println(
                                "Tipo inválido."
                        );
                }

                break;

                case 2:

                if (pedido == null) {

                        System.out.println(
                                "Cadastre um pedido primeiro."
                        );

                } else {

                        System.out.println(
                                "Tipo atual: "
                                + pedido.getClass()
                                .getSimpleName()
                        );
                }

                break;

                case 3:

                if (pedido == null) {

                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );

                } else {

                        pedido.mostrarDados();
                }

                break;

                case 4:

                System.out.println(
                        "1. Dinheiro"
                );

                System.out.println(
                        "2. PIX"
                );

                System.out.println(
                        "3. Cartão"
                );

                System.out.println(
                        "Escolha a forma de pagamento."
                );

                break;

                case 5:

                if (pedido == null) {

                        System.out.println(
                                "Cadastre um pedido primeiro."
                        );

                } else {

                        Pagamento pagamento =
                                (Pagamento) pedido;

                        double total;

                        if (pedido instanceof PedidoDelivery) {

                        PedidoDelivery delivery =
                                (PedidoDelivery) pedido;

                        total =
                                delivery.getValorTotal();

                        } else {

                        total =
                                pedido.getValorPedido();
                        }

                        pagamento.pagar(total);
                }

                break;

                case 6:

                if (pedido == null) {

                        System.out.println(
                                "Cadastre um pedido primeiro."
                        );

                } else {

                        System.out.print(
                                "Chave PIX: "
                        );

                        String chavePix =
                                scanner.nextLine();

                        Pagamento pagamento =
                                (Pagamento) pedido;

                        double total;

                        if (pedido instanceof PedidoDelivery) {

                        PedidoDelivery delivery =
                                (PedidoDelivery) pedido;

                        total =
                                delivery.getValorTotal();

                        } else {

                        total =
                                pedido.getValorPedido();
                        }

                        pagamento.pagar(
                                total,
                                chavePix
                        );
                }

                break;

                case 7:

                if (pedido == null) {

                        System.out.println(
                                "Cadastre um pedido primeiro."
                        );

                } else {

                        System.out.print(
                                "Quantidade de parcelas: "
                        );

                        int parcelas =
                                scanner.nextInt();

                        if (parcelas <= 0) {

                        System.out.println(
                                "Quantidade de parcelas inválida."
                        );

                        } else {

                        Pagamento pagamento =
                                (Pagamento) pedido;

                        double total;

                        if (pedido instanceof PedidoDelivery) {

                                PedidoDelivery delivery =
                                        (PedidoDelivery) pedido;

                                total =
                                        delivery.getValorTotal();
        } else { total = pedido.getValorPedido();
                        }

                        pagamento.pagar(total,parcelas);
                        }
                }

                break;

                case 8:

                System.out.println(
                        "Programa encerrado."
                );

                scanner.close();
                return;

                default:

                System.out.println("Opção inválida.");
        }
        }
}
}