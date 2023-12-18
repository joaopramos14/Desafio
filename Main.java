package src;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Pessoas.Atendimento atendimento = new Pessoas().new Atendimento();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n       Menu     ");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Cadastrar Protocolo");
            System.out.println("3. Alterar Protocolo");
            System.out.println("4. Consultar Pessoas");
            System.out.println("5. Consultar Protocolos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();
                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = scanner.nextLine();
                    System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/mm/yyyy): ");
                    String dnascimento = scanner.nextLine();

                    atendimento.CadastroPessoa(nome, cidade, sexo, bairro, rua, complemento, numero, cpf, dnascimento);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data de Abertura (dd/mm/yyyy): ");
                    String dataAbertura = scanner.nextLine();
                    System.out.print("Prazo (em dias): ");
                    int prazo = scanner.nextInt();
                    scanner.nextLine(); 

                    // lista de pessoas com o contribuinte
                    System.out.println("\nLista de Pessoas:");
                    List<Pessoas> pessoasCadastradas = atendimento.listapessoas;
                    for (Pessoas pessoa : pessoasCadastradas) {
                        System.out.println("ID: " + pessoa.getid() +
                                ", Nome: " + pessoa.getnome() +
                                ", CPF: " + pessoa.getcpf());
                    }

                    System.out.print("Escolha o ID do Contribuinte: ");
                    int idContribuinte = scanner.nextInt();
                    scanner.nextLine(); 

                    // Encontra a pessoa pelo ID e cadastra o protocolo
                    Pessoas contribuinte = null;
                    for (Pessoas pessoa : pessoasCadastradas) {
                        if (pessoa.getid() == idContribuinte) {
                            contribuinte = pessoa;
                            break;
                        }
                    }

                    if (contribuinte != null) {
                        atendimento.cadastrarProtocolo(descricao, dataAbertura, prazo, contribuinte);
                        System.out.println("Protocolo cadastrado com sucesso!");
                    } else {
                        System.out.println("Contribuinte não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Número do Protocolo: ");
                    int numeroProtocolo = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner
                    System.out.print("Nova Descrição: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Novo Prazo (em dias): ");
                    int novoPrazo = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner

                    atendimento.alterarProtocolo(numeroProtocolo, novaDescricao, novoPrazo);
                    System.out.println("Protocolo alterado com sucesso!");
                    break;

                case 4:
                    System.out.println("\nLista de Pessoas:");
                    List<Pessoas> pessoas = atendimento.listapessoas;
                    for (Pessoas pessoa : pessoas) {
                        System.out.println("ID: " + pessoa.getid() +
                                ", Nome: " + pessoa.getnome() +
                                ", CPF: " + pessoa.getcpf());
                    }
                    break;

                case 5:
                    System.out.println("\nLista de Protocolos:");
                    List<Protocolo> protocolos = atendimento.consultarProtocolos();
                    for (Protocolo protocolo : protocolos) {
                        System.out.println("Número: " + protocolo.getNumero() +
                                ", Descrição: " + protocolo.getDescricao() +
                                ", Prazo: " + protocolo.getPrazo() +
                                ", Contribuinte: " + protocolo.getContribuinte());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}