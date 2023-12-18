package src;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Pessoas {
    private static int quantidadeid =1;
    private int id;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;
    private int numero;
    private String cpf;
    private String sexo;
    private String nome;
    private String dnascimento; //necessita verificacao

    public Pessoas (String nome, String cidade, String bairro,String rua, String complemento,String sexo, int numero, String cpf2, String dnascimento2 ){
        this.id=quantidadeid++;
        this.nome=nome;
        this.cidade = cidade;
        this.bairro=bairro;
        this.rua=rua;
        this.complemento=complemento;
        this.cidade=cidade;
        this.sexo=sexo;
        this.numero=numero;
        this.cpf=cpf2;
        this.dnascimento=dnascimento2;

    }

    public Pessoas() {
    }

    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id=id;
    }

    public String getcidade(){
        return cidade;
    }
    public void setcidade(String cidade){
        this.cidade=cidade;
    }
    public String getbairro(){
        return bairro;
    }
    public void setbairro(String bairro){
        this.bairro=bairro;
    }
    public String getrua(){
        return rua;
    }
    public void setrua(String rua){
        this.rua=rua;
    }
    public String getcomplemento(){
        return complemento;
    }
    public void setcomplemento(String complemento){
        this.complemento= complemento;
    }
    public int getnumero(){
        return numero;
    }
    public void setnumero(int numero){
        this.numero=numero;
    }
    public String getcpf(){
        return cpf;
    }
    public void setcpf(String cpf){
        this.cpf=cpf;
    }
    public String getsexo(){
        return sexo;
    }
    public void setsexo(String sexo){
        this.sexo=sexo;
    }
    public String getnome(){
        return nome;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public String getdnasicmento(){
        return dnascimento;
    }
    public void setdnascimento(String dnascimento){
        this.dnascimento=dnascimento;
    }
    
    public class Atendimento { // ATENDIMENTO E CADASTRO
        List<Pessoas> listapessoas;
        private List<Protocolo> listaProtocolos;

        public Atendimento() {
            this.listapessoas = new ArrayList<>();
            this.listaProtocolos = new ArrayList<>();
        }

        public void CadastroPessoa(String nome, String cidade, String sexo, String bairro, String rua,
                                   String complemento, int numero, String cpf, String dnascimento) {
            Pessoas novaPessoa = new Pessoas(nome, cidade, sexo, bairro, rua, complemento, numero, cpf, dnascimento);
            listapessoas.add(novaPessoa);
        }

        public void cadastrarProtocolo(String descricao, String dataAbertura, int prazo, Pessoas contribuinte) {
            Protocolo novoProtocolo = new Protocolo(descricao, dataAbertura, prazo, contribuinte);
            listaProtocolos.add(novoProtocolo);
        }

        public void alterarProtocolo(int numero, String descricao, int prazo) {
            for (Protocolo protocolo : listaProtocolos) {
                if (protocolo.getNumero() == numero) {
                    protocolo.setDescricao(descricao);
                    protocolo.setPrazo(prazo);
                    break;
                }
            }
        }

        public List<Protocolo> consultarProtocolos() {
            return new ArrayList<>(listaProtocolos);
        }
    }
}