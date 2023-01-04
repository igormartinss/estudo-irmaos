package application;

import java.time.MonthDay;

public class DiaFeito {
    public MonthDay diaDoMes;
    public Boolean estaFeito;
    public HorarioEspiritual horarioEspiritual;

    public DiaFeito(MonthDay diaDoMes, HorarioEspiritual horarioEspiritual) {
        this.diaDoMes = diaDoMes;
        this.estaFeito = false;
        this.horarioEspiritual = horarioEspiritual;
    }

    public void marcaComoFeito() {
        this.estaFeito = true;
    }

    @Override
    public String toString() {
        return "Dia: " + diaDoMes.getDayOfMonth() + "/" + diaDoMes.getMonthValue() + " | " +
                "Ponto: " + horarioEspiritual.getTitulo() + this.estaFeito() + "\n";
    }
    private String estaFeito() {
        return this.estaFeito ? " está feito" : " não está feito";
    }
}
