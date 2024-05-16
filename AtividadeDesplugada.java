import java.util.Arrays;

public class AtividadeDesplugada extends Atividade{
    private String material, tema;
    private int duracao;

    public AtividadeDesplugada(int codigo, String texto, String[] competencias, String material, String tema, int duracao) {
        super(codigo, texto, competencias);
        this.material = material;
        this.tema = tema;
        this.duracao = duracao;
    }

    @Override
    public int calculaPontuacao() {
        int pontuacao = 0;
        for (String competencia : competencias) {
            switch (competencia) {
                case "ABS", "DEC", "DA", "AV", "GE" -> pontuacao++;
            }
        } if (duracao > 3600){
            pontuacao = 2 * pontuacao;
        } return pontuacao;
    }

    @Override
    public String toString(){
        return "Atividade Desplugada #" + codigo + "\nDescrição: " + texto + "\nMaterial: " +
                material + "\nTema: " + tema + "\nCompetencias: " + Arrays.toString(competencias);
    }
}
