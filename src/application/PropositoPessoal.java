package application;

public class PropositoPessoal extends HorarioEspiritual {
    public String frase;

    public PropositoPessoal(String titulo, String descricao, String frase) {
        super(titulo, descricao);
        this.frase = frase;
    }
}
