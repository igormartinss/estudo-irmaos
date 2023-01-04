package application;

import java.time.MonthDay;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Horário Espiritual dos Quiquinhos!");

        String opcao = "";
        Mes mes = criaMes();
        while (!opcao.equals("F")) {
            System.out.println("Para sair do programa digite F: ");
            System.out.println("Para listar os dias e pontos faça o L: ");
            System.out.println("Para listar os pontos no dia de hoje digite H: ");
            System.out.println("Para marcar um dia como feito digite M: ");
            opcao = scanner.next();
            switch (opcao){
                case "L":
                    mes.printaDiasFeitos();
                    continue;
                case "M":
                    marcaDiaComoFeito(mes);
                    continue;
                case "H":
                    mes.printaPontosDeHoje();
            }

        }

        scanner.close();
    }

    private static Mes criaMes() {
        return new Mes(criaPontos(), criaPropositoPessoal(), YearMonth.now());
    }

    private static List<HorarioEspiritual> criaPontos() {
        String opcao = "";
        List<HorarioEspiritual> horarioEspiritualLista = new ArrayList<>();
        while (!opcao.equals("T")) {
            horarioEspiritualLista.add(criaPontoNormal());
            System.out.println("Digite T para terminar criação de pontos ou qualquer outra letra para seguir: ");
            opcao = scanner.next();
        }
        return horarioEspiritualLista;
    }

    private static HorarioEspiritual criaPontoNormal() {
        System.out.println("Digite o título deste ponto de seu HE: ");
        String titulo = scanner.next();
        System.out.println("Digite a descrição deste ponto de seu HE: ");
        String descricao = scanner.next();

        return new HorarioEspiritual(titulo, descricao);
    }

    private static PropositoPessoal criaPropositoPessoal() {
        System.out.println("Digite o título de seu PP: ");
        String titulo = scanner.next();
        System.out.println("Digite a descrição de seu PP: ");
        String descricao = scanner.next();
        System.out.println("Digite a frase de seu PP: ");
        String frase = scanner.next();

        return new PropositoPessoal(titulo, descricao, frase);
    }

    private static void marcaDiaComoFeito(Mes mes) {
        System.out.println("Digite o titulo do ponto que deseja marcar como feito: ");
        String titulo = scanner.next();
        System.out.println("Digite a descrição que deseja marcar como feita: ");
        String descricao = scanner.next();
        HorarioEspiritual horarioEspiritual = new HorarioEspiritual(titulo, descricao);
        System.out.println("Digite o dia que deseja marcar como feito: ");
        int dia = scanner.nextInt();
        MonthDay diaASerMarcado = MonthDay.of(mes.getMesReferente().getMonthValue(), dia);

        mes.trocaStatusDiaFeito(diaASerMarcado, horarioEspiritual);
    }
}
