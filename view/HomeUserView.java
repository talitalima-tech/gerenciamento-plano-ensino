package view;

import java.util.*;
import model.*;
public class HomeUserView implements Observer{
    /* Primeira tela que o usuário vê ao ser autenticado no sistema */
    private Model model;
    private HomeUserController controller;
    private int totalUsers;	// Usado para armazenar o total de usuário que deve ser exibido na tela
    private String usuarioLogado; // Usado para armazenar o usuário logado no sistema
    private boolean finalizar = false;	// Flag para indicar quando a view será finalizada

    public String getUsuarioLogado() {
        return usuarioLogado;
    }
    public void finalizarView() {
        finalizar = true;
    }

    /* Inicialização da view Home */
    public void init(Model model) {
        if (model != null){
            this.model = model;	// Guarda o modelo
            controller = new HomeUserController();	// Cria seu controller
            controller.init(model, this);	// Inicializa o controller
            model.attachObserver(this);	// Registra a view na lista de observadores do modelo
            menuHome();	// Chama o menu da tela Home
        }
    }

    /* Menu de opções da tela principal */
    public void menuHome() {
    	this.update();
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Fazer Logout",
                "[2] - Criar PED", "[3] - Visualizar PED", "[4] - Editar PED", "[5] - Excluir PED",
                "[6] - Visualizar Dados do Usuário", "[7] - Editar Dados do Usuário", "[8] - Excuir Usuário"};
        if(usuarioLogado.equals("") == false && usuarioLogado.equals(null) == false) {
	        do {
	            System.out.println("MENU");
	            System.out.println("====");
	            System.out.println();
	            System.out.println("Seja bem-vindo(a) " + model.getNomeUsuario(model.getUsuarioAutenticado()));
	            System.out.println();
	
	            for (String opcao: opcoes) {
	                System.out.println(opcao);
	            }
	            System.out.println();
	            System.out.print("Digite a opcao desejada: ");
	            String event = sc.nextLine();
	            System.out.println();
	            controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller
	        } while (!finalizar);
        }
    }

    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
        if(usuarioLogado.equals("") || usuarioLogado.equals(null)) {
        	finalizarView();
        }
    }

}
