import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PilhaEncadeada<Tarefa> pilhaTarefasPendentes = new PilhaEncadeada<>();
        PilhaEncadeada<Tarefa> pilhaTarefasConcluidas = new PilhaEncadeada<>();

        Scanner scan = new Scanner(System.in);

        int opcoes = 0;

        do{

            try {

                Menus.menuPrincipal();
                opcoes = scan.nextInt();

                switch (opcoes) {
                    // CRIAR TAREFA
                    case 1:
                        scan.nextLine();
                        System.out.print("DIGITE O TITULO DA TAREFA: ");
                        String titulo = scan.nextLine();

                        System.out.print("DIGITE A DATA DA TAREFA: ");
                        String data = scan.nextLine();

                        Tarefa novaTarefa = new Tarefa(titulo, data);

                        pilhaTarefasPendentes.push(novaTarefa);

                        break;

                    // EDITAR TAREFA
                    case 2:

                        System.out.println("Tarefas pendentes:");
                        imprimirTarefas(pilhaTarefasPendentes, false);



                        try {
                            System.out.println("DIGITE O NUMERO DA TAREFA");
                            int numeroTarefa = scan.nextInt();

                            if (
                                    pilhaTarefasPendentes.tamanhoPilha() <= 0 ||
                                    pilhaTarefasPendentes.tamanhoPilha() - 1 < numeroTarefa ||
                                    numeroTarefa < 0
                            ) {
                                if (pilhaTarefasPendentes.tamanhoPilha() <= 0) {
                                    System.out.println("Lista vazia, crie uma tarefa!");
                                } else {
                                    System.out.println("Digite um numero de tarefa existente!");
                                }
                                break;
                            }

                            Tarefa tarefaEditar = pilhaTarefasPendentes.peek(numeroTarefa);

                            Menus.menuEditar();
                            int resposta = scan.nextInt();

                            switch (resposta) {
                                case 1:
                                    System.out.println("Digite um novo título: ");
                                    scan.nextLine();
                                    String novoTitulo = scan.nextLine();
                                    tarefaEditar.editarTitulo(novoTitulo);
                                    break;
                                case 2:
                                    System.out.println("Digite uma nova data: ");
                                    scan.nextLine();
                                    String novaData = scan.nextLine();
                                    tarefaEditar.editarData(novaData);
                                    break;
                                case 3:
                                    tarefaEditar.setConcluida();
                                    Tarefa tarefaRemover = pilhaTarefasPendentes.remove(numeroTarefa);
                                    pilhaTarefasConcluidas.push(tarefaRemover);
                                    break;
                                case 4:
                                    pilhaTarefasPendentes.remove(numeroTarefa);
                                    break;
                                default:
                                    System.out.println("Valor inválido! (Escolha numeros entre 1 e 3)");
                            }

                            break;

                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Erro: Você não digitou um número inteiro.");
                            scan.next();
                            break;
                        }

                    // VISUALIZAR TAREFAS
                    case 3:

                        limparConsole();

                        System.out.println("Tarefas pendentes:");
                        imprimirTarefas(pilhaTarefasPendentes, true);

                        System.out.println("Tarefas concluidas:");
                        imprimirTarefas(pilhaTarefasConcluidas, true);

                        System.out.println("Aperte ENTER para continuar...");
                        scan.nextLine();
                        scan.nextLine();

                        break;

                    // FINALIZAR PROGRAMA
                    case 4:
                        System.out.println("Finalizando...");
                        break;
                    default:
                        System.out.println("Valor inválido!");
                        break;


                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Você não digitou um número inteiro.");
                scan.next();
            }
        }while(opcoes != 4);

    }

    // LIMPA CONSOLE COM \n
    public static void limparConsole() {

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    //EXIBIR MENU
    public static void textoMenu() {
        System.out.println("ESCOLHA UMA OPÇÃO:");
        System.out.println("1 - CRIAR TAREFA");
        System.out.println("2 - EDITAR TAREFA");
        System.out.println("3 - VISUALIZAR TAREFAS");
        System.out.println("4 - SAIR");
    }


    // IMPRIME CADA TAREFA DA PILHA PASSADA COMO PARÂMETRO, PODE IMPRIMIR O TITULO E A TAREFA,
    // COMO TAMBÉM SOMENTE O ID E O TÍTULO PARA FACILITAR NA ETAPA DE EDIÇÃO.
    public static void imprimirTarefas(PilhaEncadeada<Tarefa> p, boolean comData) {
        if (comData) {
            for (int i = 0; i < p.tamanhoPilha(); i++) {
                Tarefa t = p.peek(i);
                t.imprimirTarefa();
            }
            return;
        }
        for (int i = 0; i<p.tamanhoPilha(); i++) {
            Tarefa t = p.peek(i);
            System.out.println(
                    i + " -> " + t.getTitulo()
            );
        }
    }

}
