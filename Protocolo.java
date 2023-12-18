package src;
public class Protocolo{ 
    private static int idcontador;
    private int numero;
    private String descricao;
    private int prazo;
    private String contribuinte;
    private String dataabertura;
    
    public Protocolo(int numero, String descricao, int prazo, String contribuinte, String dataabertura) {
        this.numero = idcontador++;
        this.descricao = descricao;
        this.prazo = prazo;
        this.contribuinte = contribuinte;
        this.dataabertura = dataabertura;
    }
    public Protocolo(String descricao2, String dataAbertura2, int prazo2, Pessoas contribuinte2) {
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPrazo() {
        return prazo;
    }
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    public String getContribuinte() {
        return contribuinte;
    }
    public void setContribuinte(String contribuinte) {
        this.contribuinte = contribuinte;
    }
    public String getDataabertura() {
        return dataabertura;
    }
    public void setDataabertura(String dataabertura) {
        this.dataabertura = dataabertura;
    }
 
    }
