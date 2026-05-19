package view;

import java.util.*;
import model.*;

public class DeleteUserView implements Observer{
    private Model model;
    private DeleteUserController controller;
    private String login;
    private boolean finalizar = false;	// Flag para indicar quando a view será finalizada

    public void finalizarView() {
        finalizar = true;
    }

    public String getLogin(){
        return login;
    }

    public void init(Model model) {
        this.model = model;
        this.login = model.getUsuarioAutenticado(); //alterei isso
        controller = new DeleteUserController();
        controller.init(model, this);
        model.attachObserver(this);
        menuDeletarUsuario();
    }

    public void menuDeletarUsuario() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = { "[1] - Voltar", "[2] - Deletar Usuario" };
        do {
            System.out.println("DELETAR USUARIO");
            System.out.println("===============");
            System.out.println();
            for (String opcao : opcoes) {
                System.out.println(opcao);
            }
            String event = sc.nextLine();
            controller.handleEvent(event);
            model.detachObserver(this);
        } while (!finalizar);
    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void update() {
    	login = model.getUsuarioLogin();
    	
    }

}
