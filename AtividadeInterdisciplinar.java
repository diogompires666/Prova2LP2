import java.util.Arrays;

public class AtividadeInterdisciplinar extends Atividade{
    private String areaDC;

    public AtividadeInterdisciplinar(int codigo, String texto, String[] competencias, String areaDC) {
        super(codigo, texto, competencias);
        this.areaDC = areaDC;
    }

    @Override
    public int calculaPontuacao() {
        int pontuacao = 0;
        for (String competencia : competencias) {
            switch (competencia) {
                case "ABS", "DA", "AV", "GE" -> pontuacao += 2;
                case "DEC" -> {
                    if (areaDC.equals("Matemática e suas Tecnologias")){
                        pontuacao += 4;
                    } else pontuacao += 2;
                }
            }
        } return pontuacao;
    }

    @Override
    public String toString() {
        return "AtividadeInterdisciplinar #" + getCodigo() + "\nQuestão: " + texto +
                "\nArea do Conhecimento: " + areaDC + "\nCompetencias: " + Arrays.toString(competencias);
    }
}
