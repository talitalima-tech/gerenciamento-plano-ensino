package view;

import model.*;

public class CreateNewPedController implements Observer{
    private Model model;
    private CreateNewPedView view;
    
    /* Inicialização do controller da view principal */
    public void init(Model model, CreateNewPedView view) {
        if (model != null && view != null){
            this.model = model;  // Guarda o modelo
            this.view = view;	 // Guarda a view
            model.attachObserver(this);
        }
    }
  
    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
	public void handleEvent(String event) {
		switch (event) {//vou passar toda a arrayList do calendariodeatividades
			case "OK" :			
				model.setPlanoDeEnsino(view.getCampus(), view.getAno(), view.getSemestre(),view.getJustificativa(), view.getEmenta(), view.getObjetivoGeral(), view.getObjetivosEspecificos(), view.getMetodologiaDeEnsino(), view.getAtividadesDiscentes(), view.getSistemaDeAvaliação(), view.getBibliografiaBasicaComplementar()
					 ,view.getUnidade(), view.getCurso(), view.getAno(), view.getPeriodo(), view.getNomeDaDisciplina(), view.getCodigoDaDisciplina(), view.getCaraterDaDisciplina(), view.getRegimeDeOfertaDaDisciplina(), view.getCalendarioDeAtividades());
				break;			
		}
		view.finalizarView();
		model.detachObserver(this);
	}
	
    public void update() {
    	
    }
	
}

