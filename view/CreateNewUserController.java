package view;

import model.Model;

public class CreateNewUserController implements Observer{
	private Model model;
	private CreateNewUserView view;
	
	public void init(Model model, CreateNewUserView view) {
		if (model != null && view != null) {
			this.model = model;
			this.view = view;
			model.attachObserver(this);
		}
	}
	public void handleEvent(String event) {
		switch (event) {
		case "OK" :			
			model.setUsuario(view.getNome(), view.getLogin(),view.getSenha(), view.getNacionalidade(), view.getSexo(),
					view.getEmail(), view.getNivelDeFormacao(), view.getInstituicaoDeFormacao(), view.getDataNascimento() );
			model.detachObserver(this);
			break;			
		}
	}

	public void update() {
	}
}
