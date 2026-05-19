package view;

import model.*;

public class DeletePedController implements Observer{
    private Model model;
    private DeletePedView view;
    
    /* Inicialização do controller da view principal */
    public void init(Model model, DeletePedView view) {
        if (model != null && view != null){
            this.model = model;  // Guarda o modelo
            this.view = view;	 // Guarda a view
            model.attachObserver(this);
        }
    }
  
    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
	public void handleEvent(int event1, int event2) {
		switch (event2) {//verificar a opcao do usuario
			case 1 :			
				view.finalizarView();
				break;
			case 2:
				model.excluirPlanoDeEnsino(event1);
				view.finalizarView();
				break;
		}
		model.detachObserver(this);
	}
	
    public void update() {
    	
    }
	
}

