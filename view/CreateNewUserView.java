package view;

import java.util.*;
import model.*;

/*
 * Classe de View - o único lugar que pode enviar System.out.println para views do prompt de comando
 */
public class CreateNewUserView implements Observer {
	private Model model;
	private CreateNewUserController controller;
	private String nome;
	private String login;
	private String senha;
	private String nacionalidade;
	private String sexo;
	private String email;
	private String nivelDeFormacao;
	private String instituicaoDeFormacao;
	private String dataNascimento;

	public void init(Model model) {
		this.model = model;
		controller = new CreateNewUserController();
		controller.init(model, this);
		model.attachObserver(this);
		menuCadastrarUsuario();
	}

	public void menuCadastrarUsuario() {
		Scanner sc = new Scanner(System.in);
		System.out.println("CADASTRAR NOVO USUARIO");
		System.out.println("======================");
		System.out.println();
		System.out.print("Nome: ");
		nome = sc.nextLine();
		do {
			System.out.print("Login: ");
			login = sc.nextLine();
			if (model.loginIndisponivel(login)) {
				System.out.println("Login indisponível! Digite outro.");
			}
		} while (model.loginIndisponivel(login));
		System.out.println();
		System.out.print("Senha: ");
		senha = sc.nextLine();
		System.out.print("Nacionalidade: ");
		nacionalidade = sc.nextLine();
		System.out.print("Sexo: ");
		sexo = sc.nextLine();
		System.out.print("E-mail: ");
		email = sc.nextLine();
		System.out.print("Nível de formação: ");
		nivelDeFormacao = sc.nextLine();
		System.out.print("Instituição de Formação: ");
		instituicaoDeFormacao = sc.nextLine();
		System.out.print("Data de Nascimento: ");
		dataNascimento = sc.nextLine();
		controller.handleEvent("OK");
		model.detachObserver(this);
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

	}
}