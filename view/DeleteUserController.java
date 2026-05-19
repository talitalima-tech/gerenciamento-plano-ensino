package view;

import java.util.*;
import model.*;
public class DeleteUserController implements Observer{
    private Model model;
    private DeleteUserView view;
    private String loginUsuarioAutenticado;

    public void init(Model model, DeleteUserView view){
        if (model != null && view != null) {
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1" :
            	view.finalizarView();
                break;
            case "2" :
                loginUsuarioAutenticado = view.getLogin();
                model.deletarUsuario(loginUsuarioAutenticado);// remove usuario do model
                update();
                if (loginUsuarioAutenticado == null) {// exibe mensagem de sucesso/fracasso
                    view.exibeMSG("ERRO: Usuario invalidos!");
                } else {
                    view.exibeMSG("SUCESSO: Usuario deletado!");
                }
                model.deslogarUsuario(); // desloga e volta para a tela inicial
                view.finalizarView(); 
                break;
        }
        model.detachObserver(this);
    }

    public void update() {
    	loginUsuarioAutenticado = model.getUsuarioLogin();
    	
    }


}