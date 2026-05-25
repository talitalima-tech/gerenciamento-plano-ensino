package view;

import model.*;
public class HomeUserController implements Observer {

    private Model model;
    private HomeUserView view;


    /* Inicialização do controller da view principal */
    public void init(Model model, HomeUserView view) {
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
    //REMOVI  O FINALIZAR  HOME
    public void handleEvent(String event) {
        switch (event) {
            case "1" :  model.deslogarUsuario();
            			view.finalizarView();
                        break;
            case "2" : 
            			CreateNewPedView view2 = new CreateNewPedView();
            			view2.init(model);
            			break;
            case "3" : 	ReadPedView view3 = new ReadPedView();
            			view3.init(model);
            			break;
            case "4" :  UpdatePedDataView view4 = new UpdatePedDataView();
            			view4.init(model);
            			break;
            case "5" :	DeletePedView view5 = new DeletePedView();
						view5.init(model);
						break;
            case "6":   ReadUserInfoView view6 = new ReadUserInfoView(); 
                        view6.init(model);
                        break;
            case "7":   UpdateUserDataView view7 = new UpdateUserDataView();
                        view7.init(model);
                        break;
            case "8":   DeleteUserView view8 = new DeleteUserView();
                        view8.init(model);
                        break;

        }
        model.detachObserver(this);
    }



}
