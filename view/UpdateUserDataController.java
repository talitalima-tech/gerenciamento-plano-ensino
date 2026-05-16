package view;

import model.*;
public class UpdateUserDataController implements Observer {

    private Model model;
    private UpdateUserDataView view;

    public void init(Model model, UpdateUserDataView view) {
        if (model != null && view != null) {
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(String event) {
        switch (event) {
            case "0" : // cancelou a alteração, volta para a tela anterior
                        view.finalizarView(); //finaliza esta view
                        break;
            case "1": // salvar os dados e volta para a tela anterior
                        model.atualizarDadosUsuario(view.getNome(), view.getSenha(),
                            view.getNacionalidade(), view.getSexo(), view.getEmail(), view.getNivelDeFormacao(),
                            view.getInstituicaoDeFormacao(), view.getDataNascimento(), view.getLogin() );
                        view.finalizarView();
                        break;
        }
        model.detachObserver(this);
    }

    public void update() {
    }
}
