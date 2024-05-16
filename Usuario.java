import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
    private String nome, nickname, email;
    private int senha;
    private ArrayList<Atividade> atividadesPessoais;

    public Usuario(String nome, String nickname, String email, int senha) {
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.atividadesPessoais = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public ArrayList<Atividade> getAtividadesPessoais() {
        return atividadesPessoais;
    }

    public void setAtividadesPessoais(ArrayList<Atividade> atividadesPessoais) {
        this.atividadesPessoais = atividadesPessoais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    public int calculaPontuacao(){
        int pontuacao = 0;
        for (Atividade atividade : atividadesPessoais) {
            pontuacao += atividade.calculaPontuacao();
        } return pontuacao;
    }

    @Override
    public String toString() {
        return this.nickname + "\npontuação: " + calculaPontuacao() +
                "\ntotalAtividades: " + atividadesPessoais.size();
    }

    public void addAtividade(Atividade atividade){
        this.atividadesPessoais.add(atividade);
    }

    public String repCompara(){
        return this.nickname + " - " + this.atividadesPessoais.size() + ":" + this.calculaPontuacao();
    }
}
