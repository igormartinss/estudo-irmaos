package application;

import java.util.Objects;

public class HorarioEspiritual {
    private String titulo;
    private String descricao;

    public HorarioEspiritual(String titulo, String descricao) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioEspiritual that = (HorarioEspiritual) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(descricao, that.descricao);
    }

}
