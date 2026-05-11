package view;

import model.*;
public class UpdatePedDataController implements Observer {

    private Model model;
    private UpdatePedDataView view;

    public void init(Model model, UpdatePedDataView view) {
        if (model != null && view != null) {
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(int numeroPlano, int event2) {
        switch (event2) {
            case 1 :
				model.atualizarPlanoDeEnsino(view.getCampus(), view.getAno(), view.getSemestre(),view.getJustificativa(), view.getEmenta(), view.getObjetivoGeral(), view.getObjetivosEspecificos(), view.getMetodologiaDeEnsino(), view.getAtividadesDiscentes(), view.getSistemaDeAvaliação(), view.getBibliografiaBasicaComplementar()
						 ,view.getUnidade(), view.getCurso(), view.getAno(), view.getPeriodo(), view.getNomeDaDisciplina(), view.getCodigoDaDisciplina(), view.getCaraterDaDisciplina(), view.getRegimeDeOfertaDaDisciplina(), view.getCalendarioDeAtividades(),view.getNumeroPlano()-1);
                        view.finalizarView(); //finaliza esta view
                        break;
            case 2:
                        break;
            case 3:
            	view.finalizarView();
                break;
        }
        model.detachObserver(this);
    }

    public void update() {
    }
}
