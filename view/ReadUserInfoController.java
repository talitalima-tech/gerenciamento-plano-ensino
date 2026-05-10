package view;

import model.Model;

public class ReadUserInfoController implements Observer{

    private Model model;
    private ReadUserInfoView view;


    /* Inicialização do controller da view principal */
    public void init(Model model, ReadUserInfoView view) {
        if (model != null && view != null){
            this.model = model;  // Guarda o modelo
            this.view = view;	 // Guarda a view
            model.attachObserver(this);
        }
    }

    /* O controller só implementa o update se for necessário */
    public void update() {

    }

    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
    public void handleEvent(String event) {
        switch (event) {
            case "1" :  //volta para a home
                view.finalizarView(); //finaliza esta view
                break;
//

        }
        model.detachObserver(this);
    }
}
