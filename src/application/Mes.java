package application;

import java.time.MonthDay;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Mes {
    private List<HorarioEspiritual> pontos;
    private PropositoPessoal propositoPessoal;
    private List<DiaFeito> diasFeitos;
    private YearMonth mesReferente;

    public Mes(List<HorarioEspiritual> pontos, PropositoPessoal propositoPessoal, YearMonth mesReferente) {
        this.setPontos(pontos);
        this.setPropositoPessoal(propositoPessoal);
        this.setMesReferente(mesReferente);
        this.setDiasFeitos(this.criaDiasFeitos());
    }

    public void printaDiasFeitos() {
        this.getDiasFeitos().forEach(System.out::println);
    }

    public void printaPontosDeHoje() {
        this.getDiasFeitos().stream()
                .filter(diaFeito -> diaFeito.diaDoMes.equals(MonthDay.now()))
                .forEach(System.out::println);
    }

    public void trocaStatusDiaFeito(MonthDay diaReferente, HorarioEspiritual horarioEspiritual) {
        DiaFeito diaEncontrado = this.getDiasFeitos().stream()
                .filter(diaFeito ->
                        diaFeito.diaDoMes.equals(diaReferente) && diaFeito.horarioEspiritual.equals(horarioEspiritual))
                .findAny()
                .orElse(null);

        if(diaEncontrado != null) {
            diaEncontrado.marcaComoFeito();
        } else {
            System.out.println("Ponto não encontrado para o dia");
        }
    }

    private List<DiaFeito> criaDiasFeitos() {
        List<DiaFeito> diasFeitos = new ArrayList<>();

        for (int i = 1; i <= this.getMesReferente().lengthOfMonth(); i++) {
            MonthDay diaDoMes = MonthDay.of(this.getMesReferente().getMonthValue(), i);

            DiaFeito diaFeitoPropositoPessoal = new DiaFeito(diaDoMes, this.getPropositoPessoal());
            this.getPontos().forEach(ponto -> {
                DiaFeito diaFeitoPonto = new DiaFeito(diaDoMes, ponto);
                diasFeitos.add(diaFeitoPonto);
            });

            diasFeitos.add(diaFeitoPropositoPessoal);
        }

        return diasFeitos;
    }

    public List<HorarioEspiritual> getPontos() {
        return pontos;
    }

    public void setPontos(List<HorarioEspiritual> pontos) {
        this.pontos = pontos;
    }

    public PropositoPessoal getPropositoPessoal() {
        return propositoPessoal;
    }

    public void setPropositoPessoal(PropositoPessoal propositoPessoal) {
        this.propositoPessoal = propositoPessoal;
    }

    public List<DiaFeito> getDiasFeitos() {
        return diasFeitos;
    }

    public void setDiasFeitos(List<DiaFeito> diasFeitos) {
        this.diasFeitos = diasFeitos;
    }

    public YearMonth getMesReferente() {
        return mesReferente;
    }

    public void setMesReferente(YearMonth mesReferente) {
        this.mesReferente = mesReferente;
    }
}
