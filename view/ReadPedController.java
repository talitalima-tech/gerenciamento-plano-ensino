package view;

import model.Model;

public class ReadPedController implements Observer{

    private Model model;
    private ReadPedView view;


    public void init(Model model, ReadPedView view) {
        if (model != null && view != null){
            this.model = model;  
            this.view = view;	 
            model.attachObserver(this);
        }
    }

    public void update() {

    }

    public void handleEvent(int event) {
        switch (event) {
            case 1 :  
                view.finalizarView();
                model.detachObserver(this);
                break;
            case 2:
            	break;
        }
    }
}
