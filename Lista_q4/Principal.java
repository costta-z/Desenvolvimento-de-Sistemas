package Lista_q4;

import java.util.Scanner;

public class Principal {

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Curso curso = null;
        String aluno = "";
        double valorMatricula = 0;

        while (true) {

        System.out.println("\n===== SISTEMA DE CURSOS =====");
        System.out.println("1. Cadastrar curso");
        System.out.println("2. Escolher tipo");
        System.out.println("3. Cadastrar nome do aluno");
        System.out.println("4. Realizar matrícula");
        System.out.println("5. Realizar matrícula com desconto");
        System.out.println("6. Mostrar dados do curso");
        System.out.println("7. Mostrar dados da matrícula");
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

                System.out.print("Carga horária: ");
                int carga = scanner.nextInt();

                System.out.print("Valor: ");
                double valor = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("1. Curso presencial");
                System.out.println("2. Curso online");
                System.out.print("Tipo: ");

                int tipo = scanner.nextInt();
                scanner.nextLine();

                if (tipo == 1) {

                        System.out.print(
                                "Nome da sala: "
                        );

                        String sala =
                                scanner.nextLine();

                        System.out.print(
                                "Turno: "
                        );

                        String turno =
                                scanner.nextLine();

                        curso =
                                new CursoPresencial(
                                        codigo,
                                        nome,
                                        carga,
                                        valor,
                                        sala,
                                        turno
                                );

                } else if (tipo == 2) {

                        System.out.print(
                                "Endereço da plataforma: "
                        );

                        String plataforma =
                                scanner.nextLine();

                        System.out.print(
                                "Código de acesso: "
                        );

                        String acesso =
                                scanner.nextLine();

                        curso =
                                new CursoOnline(
                                        codigo,
                                        nome,
                                        carga,
                                        valor,
                                        plataforma,
                                        acesso
                                );

                } else {

                        System.out.println(
                                "Tipo inválido."
                        );
                }

                break;

                case 2:

                if (curso == null) {

                        System.out.println(
                                "Cadastre um curso primeiro."
                        );

                } else {

                        System.out.println(
                                "Tipo atual: "
                                + curso.getClass()
                                .getSimpleName()
                        );
                }

                break;

                case 3:

                System.out.print(
                        "Nome do aluno: "
                );

                aluno =
                        scanner.nextLine();

                System.out.println(
                        "Aluno cadastrado: "
                        + aluno
                );

                break;

                case 4:

                if (curso == null ||
                        aluno.isEmpty()) {

                        System.out.println(
                                "Cadastre o curso e o aluno."
                        );

                } else {

                        Matricula matricula =
                                (Matricula) curso;

                        valorMatricula =
                                matricula.realizarMatricula(
                                        aluno
                                );

                        System.out.printf(
                                "Matrícula realizada. Valor: R$ %.2f%n",
                                valorMatricula
                        );
                }

                break;

                case 5:

                if (curso == null ||
                        aluno.isEmpty()) {

                        System.out.println(
                                "Cadastre o curso e o aluno."
                        );

                } else {

                        System.out.print(
                                "Desconto: "
                        );

                        double desconto =
                                scanner.nextDouble();

                        Matricula matricula =
                                (Matricula) curso;

                        valorMatricula =
                                matricula.realizarMatricula(
                                        aluno,
                                        desconto
                                );

                        System.out.printf(
                                "Matrícula com desconto: R$ %.2f%n",
                                valorMatricula
                        );
                }

                break;

                case 6:

                if (curso == null) {

                        System.out.println(
                                "Nenhum curso cadastrado."
                        );

                } else {

                        curso.mostrarDados();
                }

                break;

                case 7:

                System.out.println(
                        "Aluno: "
                        + (aluno.isEmpty()
                        ? "Não cadastrado"
                        : aluno)
                );

                System.out.printf(
                        "Valor da matrícula: R$ %.2f%n",
                        valorMatricula
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