package view;

import model.*;

import java.util.Scanner;

public class ReadUserInfoView implements Observer{

    /* Tela com as informações do usuário autenticado no sistema */
    private Model model;
    private ReadUserInfoController controller;
    private int totalUsers;	// Usado para armazenar o total de usuário que deve ser exibido na tela
    private String usuarioLogado; // Usado para armazenar o usuário logado no sistema
    private boolean finalizar = false;	// Flag para indicar quando a view será finalizada

    private String nome;
    private String login;
    private String senha;
    private String nacionalidade;
    private String sexo;
    private String email;
    private String nivelDeFormacao;
    private String instituicaoDeFormacao;
    private String dataNascimento;

    public void finalizarView() {
        finalizar = true;
    }

    /* Inicialização da view Home */
    public void init(Model model) {
        if (model != null){
            this.model = model;	// Guarda o modelo
            controller = new ReadUserInfoController();	// Cria seu controller
            controller.init(model, this);	// Inicializa o controller
            model.attachObserver(this);	// Registra a view na lista de observadores do modelo
            exibirInformacoes(); //
            menuHome();	// Chama o menu da tela Home
        }
    }

    //exibe as informacoes do usuario
    public void exibirInformacoes() {
        this.update();
        String informacoes[] = {"Nome: " + nome, "Login: " + login, "Nacionalidade: " + nacionalidade,
                "Sexo: " + sexo,"Email: " + email , "Nivel de Formacao: " + nivelDeFormacao,
                "Instituicao de Formacao: " + instituicaoDeFormacao, "Data de Nascimento: " + dataNascimento};
        System.out.println("INFORMACOES DO USUARIO");
        System.out.println("======================");
        System.out.println();
        for (String info : informacoes ) {
            System.out.println(info);
        }
        System.out.println();
    }

    //menu info
    public void menuHome() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Voltar"};
        do {

            System.out.println("MENU DE OPCOES");
            System.out.println();
            for (String opcao: opcoes) {
                System.out.println(opcao);
            }
            System.out.println();
            System.out.print("Digite a opcao desejada: ");
            String event = sc.nextLine();
            System.out.println();
            controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller
        } while (!finalizar);
    }

    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
        nome = model.getNomeUsuario(model.getUsuarioLogin());
        login = model.getUsuarioLogin();
        //senha;
        nacionalidade = model.getNacionalidadeUsuario(model.getUsuarioLogin());
        sexo = model.getSexoUsuario(model.getUsuarioLogin());
        email = model.getEmailUsuario(model.getUsuarioLogin());
        nivelDeFormacao = model.getNivelDeFormacaoUsuario(model.getUsuarioLogin());
        instituicaoDeFormacao = model.getInstituicaoDeFormacaoUsuario(model.getUsuarioLogin());
        dataNascimento = model.getDataNascimentoUsuario(model.getUsuarioLogin());
    }
}
