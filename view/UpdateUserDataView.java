package view;

import java.util.*;
import model.*;

// PARECIDA COM createNewUser ???
public class UpdateUserDataView implements Observer{

    private Model model;
    private UpdateUserDataController controller;
    private String usuarioLogado;
    private String nome;
    private String login;
    private String senha;
    private String nacionalidade;
    private String sexo;
    private String email;
    private String nivelDeFormacao;
    private String instituicaoDeFormacao;
    private String dataNascimento;
    private boolean finalizar = false;
    public void finalizarView() {
        finalizar = true;
    }

    public void init(Model model) {
        this.model = model;
        controller = new UpdateUserDataController();
        controller.init(model, this);
        model.attachObserver(this);
        menuAtualizar();
    }

    public void menuAtualizar() {
        Scanner sc = new Scanner(System.in);
        String event;
        this.update();

        do {
            String informacoes[] = {"[0] - Voltar/Cancelar edição", "[1] - Salvar dados\n",
                    "[2] - Nome: " + nome, "[3] - Nacionalidade: " + nacionalidade, "[4] - Sexo: " + sexo,
                    "[5] - Email: " + email , "[6] - Nivel de Formacao: " + nivelDeFormacao, "[7] - Instituicao de Formacao: " + instituicaoDeFormacao,
                    "[8] - Data de Nascimento: " + dataNascimento, "[9] - Senha: ____________" };
            System.out.println();
            System.out.println("ATUALIZAR DADOS DO USUARIO");
            System.out.println("==========================");
            System.out.println("Escolha qual dado deseja alterar");
            System.out.println();
            for (String info : informacoes) {
                System.out.println(info);
            }
            System.out.println();
            System.out.print("Opcao desejada: ");
            event = sc.nextLine();

            switch (event) {
                // caso seja 0 ou 1 entrega para o controller
                // nos outros casos, os dados ficam nas variáveis locais até que se decida salvar ou não as alterações
                case "0":   // para voltar
                case "1":   // para salvar
                            controller.handleEvent(event);
                            break;
                case "2":   System.out.print("Nome: ");
                            nome = sc.nextLine();
                            break;
                case "3":   System.out.print("Nacionalidade: ");
                            nacionalidade = sc.nextLine();
                            break;
                case "4":   System.out.print("Sexo: ");
                            sexo = sc.nextLine();
                            break;
                case "5":   System.out.print("E-mail: ");
                            email = sc.nextLine();
                            break;
                case "6":   System.out.print("Nível de formação: ");
                            nivelDeFormacao = sc.nextLine();
                            break;
                case "7":   System.out.print("Instituição de Formação: ");
                            instituicaoDeFormacao = sc.nextLine();
                            break;
                case "8":   System.out.print("Data de Nascimento: ");
                            dataNascimento = sc.nextLine();
                            break;
                case "9":   System.out.print("Senha: ");
                            senha = sc.nextLine();
                            break;
            }
        }while (!finalizar);
        model.detachObserver(this);
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public String getNivelDeFormacao() {
        return nivelDeFormacao;
    }

    public String getInstituicaoDeFormacao() {
        return instituicaoDeFormacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void update() {
        //totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
        nome = model.getNomeUsuario(model.getUsuarioLogin());
        login = model.getUsuarioLogin();
        senha = model.getUsuarioSenha();
        nacionalidade = model.getNacionalidadeUsuario(model.getUsuarioLogin());
        sexo = model.getSexoUsuario(model.getUsuarioLogin());
        email = model.getEmailUsuario(model.getUsuarioLogin());
        nivelDeFormacao = model.getNivelDeFormacaoUsuario(model.getUsuarioLogin());
        instituicaoDeFormacao = model.getInstituicaoDeFormacaoUsuario(model.getUsuarioLogin());
        dataNascimento = model.getDataNascimentoUsuario(model.getUsuarioLogin());

    }

}
