package Lista_q3;

import java.util.Scanner;

public class Principal {

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto produto = null;
        int quantidade = 0;
        double valorFinal = 0;

        while (true) {

        System.out.println("\n===== SISTEMA DE PRODUTOS =====");
        System.out.println("1. Cadastrar produto");
        System.out.println("2. Escolher tipo");
        System.out.println("3. Mostrar dados do produto");
        System.out.println("4. Informar quantidade");
        System.out.println("5. Realizar venda");
        System.out.println("6. Realizar venda com desconto");
        System.out.println("7. Mostrar valor final");
        System.out.println("8. Encerrar");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

                case 1:

                System.out.print("Código: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Preço: ");
                double preco = scanner.nextDouble();

                System.out.println("1. Produto físico");
                System.out.println("2. Produto digital");
                System.out.print("Tipo: ");

                int tipo = scanner.nextInt();

                if (tipo == 1) {

                        System.out.print("Frete: ");
                        double frete = scanner.nextDouble();

                        produto = new ProdutoFisico(
                                codigo,
                                nome,
                                preco,
                                frete
                        );

                } else if (tipo == 2) {

                        produto = new ProdutoDigital(
                                codigo,
                                nome,
                                preco
                        );

                } else {

                        System.out.println("Tipo inválido.");
                }

                break;

                case 2:

                if (produto == null) {

                        System.out.println(
                                "Cadastre um produto primeiro."
                        );

                } else {

                        System.out.println(
                                "Tipo atual: "
                                + produto.getClass().getSimpleName()
                        );
                }

                break;

                case 3:

                if (produto == null) {

                        System.out.println(
                                "Nenhum produto cadastrado."
                        );

                } else {

                        produto.mostrarDados();
                }

                break;

                case 4:

                System.out.print("Quantidade: ");

                quantidade =
                        scanner.nextInt();

                System.out.println(
                        "Quantidade registrada: "
                        + quantidade
                );

                break;

                case 5:

                if (produto == null ||
                        quantidade <= 0) {

                        System.out.println(
                                "Cadastre um produto e informe a quantidade."
                        );

                } else {

                        Venda venda =
                                (Venda) produto;

                        valorFinal =
                                venda.realizarVenda(
                                        quantidade
                                );

                        System.out.printf(
                                "Valor da venda: R$ %.2f%n",
                                valorFinal
                        );
                }

                break;

                case 6:

                if (produto == null ||
                        quantidade <= 0) {

                        System.out.println(
                                "Cadastre um produto e informe a quantidade."
                        );

                } else {

                        System.out.print(
                                "Desconto em porcentagem: "
                        );

                        double desconto =
                                scanner.nextDouble();

                        Venda venda =
                                (Venda) produto;

                        valorFinal =
                                venda.realizarVenda(
                                        quantidade,
                                        desconto
                                );

                        System.out.printf(
                                "Valor com desconto: R$ %.2f%n",
                                valorFinal
                        );
                }

                break;

                case 7:

                System.out.printf(
                        "Valor final: R$ %.2f%n",
                        valorFinal
                );

                break;

                case 8:

                System.out.println(
                        "Programa encerrado."
                );

                scanner.close();
                return;

                default:

                System.out.println(
                        "Opção inválida."
                );
        }
        }
}
}