public interface Menus {

    static void menuPrincipal() {
        System.out.println("""
                
                ESCOLHA UMA OPÇÃO:
                1 - CRIAR TAREFA
                2 - EDITAR TAREFA
                3 - VISUALIZAR TAREFAS
                4 - SAIR
                
                """);
    }

    static void menuEditar() {
        System.out.println(
                """
                        1 - EDITAR TITULO
                        2 - EDITAR DATA
                        3 - MARCAR COMO CONCLUIDA
                        4 - EXCLUIR TAREFA"""
        );
    }





}
