public class Tarefa {
    private String titulo;
    private String data;
    private boolean concluida;

    public Tarefa(String titulo, String data) {
        this.titulo=titulo;
        this.data=data;
        this.concluida=false;
    }

    public void editarTitulo(String titulo) {
        this.titulo = titulo;
        System.out.println("Titulo editado!");
    }

    public void editarData(String data) {
        this.data = data;
        System.out.println("Data editada!");
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida() {
        this.concluida = true;
        System.out.println("Tarefa concluida!");
    }

    public void imprimirTarefa() {
        System.out.println(
                "---------------------------------\n" +
                "Título - " + this.titulo + "\n" +
                "Data - " + this.data + "\n" +
                "Concluida - " + this.isConcluida()

        );
    }
}
