package view;

import java.util.*;
import model.*;

/*
 * Classe de View - o único lugar que pode enviar System.out.println para views do prompt de comando
 */
public class LoginUserView implements Observer {
	private Model model;
	private LoginUserController controller;
	private String login;
	private String senha;
	private boolean finalizar = false;
	public void init(Model model) {
		if (model != null) {
				this.model = model;
				controller = new LoginUserController();
				controller.init(model, this);
				model.attachObserver(this);
				logarUsuario();
			}
	}

	public void logarUsuario() {
		Scanner sc = new Scanner(System.in);
		System.out.println("TELA DE LOGIN");
		System.out.println("======================");
		System.out.println();
		System.out.print("Login: ");
		login = sc.nextLine();
		System.out.print("Senha: ");
		senha = sc.nextLine();
		controller.handleEvent("OK");
		model.detachObserver(this);
	}
	
    public void finalizarView() {
        finalizar = true;
    }

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void update() {

	}

	public void exibeMSG(String msg) {
		System.out.println();
		System.out.println(msg);
		System.out.println();
	}
}