package view;

import model.Model;
import model.Usuario;

public class LoginUserController implements Observer{
	private Model model;
	private LoginUserView view;
	
	public void init(Model model, LoginUserView view) {
		if (model != null && view != null){
			this.model = model;
			this.view = view;
			model.attachObserver(this);
		}
	}
	public void handleEvent(String event) {
		switch (event) {
		case "OK" :
			boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
			if (!autenticado) {
				view.exibeMSG("ERRO: Usuario e/ou Senha invalidos!");
			} else {
				view.exibeMSG("SUCESSO: Usuario autenticado!");
				HomeUserView view2 = new HomeUserView();
				view2.init(model);
				view.finalizarView();
			}
			model.detachObserver(this);
			break;
		}
	}

	public void update() {
	}
}
