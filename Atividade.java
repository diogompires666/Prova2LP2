public abstract class Atividade {
    protected int codigo;
    protected String texto;
    protected String[] competencias;

    public Atividade(int codigo, String texto, String[] competencias) {
        this.codigo = codigo;
        this.texto = texto;
        this.competencias = competencias;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String[] getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String[] competencias) {
        this.competencias = competencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;
        return codigo == atividade.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    public abstract int calculaPontuacao();
}
