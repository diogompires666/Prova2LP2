import java.util.Arrays;

public class AtividadeProgramacao extends Atividade{
    private String linguagem;

    public AtividadeProgramacao(int codigo, String texto, String[] competencias) {
        super(codigo, texto, competencias);
        this.linguagem = "Não Específicada";
    }

    public AtividadeProgramacao(int codigo, String texto, String[] competencias, String linguagem) {
        super(codigo, texto, competencias);
        this.linguagem = linguagem;
    }

    @Override
    public int calculaPontuacao() {
        int pontuacao = 0;
        for (String competencia : competencias) {
            switch (competencia) {
                case "ABS" -> pontuacao += 10;
                case "DEC" -> pontuacao += 5;
                case "DA", "AV", "GE" -> pontuacao++;
            }
        } if (!linguagem.equals("Não Específicada")){
            pontuacao += 10;
        } return pontuacao;
    }

    @Override
    public String toString(){
        return "Atividade de Programação #" + codigo + "\nTexto: " + texto +
                "\nLinguagem: " + linguagem + "\nCompetencias: " + Arrays.toString(competencias);
    }
}
