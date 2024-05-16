import java.util.ArrayList;
import java.util.HashMap;

public class PenseComigoSistema {
    HashMap<String, Usuario> usuarioHashMap;
    ArrayList<Atividade> atividadeArrayList;

    public PenseComigoSistema() {
    }

    private void verificaUsuario(String email, int senha){
        if (usuarioHashMap.get(email).getSenha() != senha){
            throw new RuntimeException("Usuario Inválido");
        }
    }

    public boolean cadastrarUsuario(String nome, String nickname, String email, int senha){
        Usuario novoUsuario = new Usuario(nome, nickname, email, senha);
        usuarioHashMap.put(email, novoUsuario);
        return true;
    }

    public boolean alterarSenha(String email, int senha, int senhaNova){
        Usuario usuario = usuarioHashMap.get(email);
        if (usuario.getSenha() == senha){
            usuario.setSenha(senhaNova);
            return true;
        } return false;
    }

    public boolean cadastrarAtividadeProgramacao(String email, int senha, String questao, String linguagem, String[] competencias){
        verificaUsuario(email, senha);
        int codigo = atividadeArrayList.size() + 1;
        Atividade novaAtividade = new AtividadeProgramacao(codigo, questao, competencias, linguagem);
        return true;
    }

    public boolean cadastraAtividadeProgramacao(String email, int senha, String questao, String[] competencias){
        verificaUsuario(email, senha);
        int codigo = atividadeArrayList.size() + 1;
        Atividade novaAtividade = new AtividadeProgramacao(codigo, questao, competencias);
        return true;
    }

    public boolean cadastraAtividadeInterdisciplinar(String email, int senha, String questao, String[] competencias, String areaDC){
        verificaUsuario(email, senha);
        int codigo = atividadeArrayList.size() + 1;
        Atividade novaAtividade = new AtividadeInterdisciplinar(codigo, questao, competencias, areaDC);
        return true;
    }

    public boolean cadastraAtividadeDesplugada(String email, int senha, String descricao, String[] competencias, String material, String tema, int duracao){
        verificaUsuario(email, senha);
        int codigo = atividadeArrayList.size() + 1;
        Atividade novaAtividade = new AtividadeDesplugada(codigo, descricao, competencias, material, tema, duracao);
        return true;
    }

    public String[] listarAtividades(){
        String[] atvs = new String[atividadeArrayList.size()];
        for (int i = 0; i < atividadeArrayList.size(); i++){
            atvs[i] = atividadeArrayList.get(i).toString();
        } return atvs;
    }

    public String[] listarUsuarios(){
        String[] usuarios = new String[usuarioHashMap.size()];
        for (int i = 0; i < usuarioHashMap.size(); i++){
            usuarios[i] = usuarioHashMap.get(i).toString();
        } return usuarios;
    }

    public double pontuacaoParaResolucaoDeProblemas(int codigo){
        int index = codigo - 1;
        Atividade atividade = atividadeArrayList.get(index);
        return atividade.calculaPontuacao();
    }

    public String comparaCapacidades(String email, int senha){
        verificaUsuario(email, senha);
        Usuario usuario = usuarioHashMap.get(email);
        int contador = 0;
        for (Usuario usuarioIterado : usuarioHashMap.values()){
            if (usuarioIterado.calculaPontuacao() >= usuario.calculaPontuacao()){
                contador++;
            }
        } return usuario.repCompara() + " // apenas " + contador + " usuários possuem uma pontuação maior ou\n" +
                "igual a de " + usuario.getNickname();
    }
}
