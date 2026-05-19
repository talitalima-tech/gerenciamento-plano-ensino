package view;

import java.util.Scanner;

import model.Model;
import java.util.InputMismatchException;//classe para tratar erros de Strings digitadas em nextInt

public class DeletePedView implements Observer{
    private Model model;
    private DeletePedController controller;
    private boolean finalizar = false;	// Flag para indicar quando a view será finalizada

    public void finalizarView() {
        finalizar = true;
    }

    public void init(Model model) {
        this.model = model;
        controller = new DeletePedController();
        controller.init(model, this);
        model.attachObserver(this);
        menuDeletarUsuario();
    }

    public void menuDeletarUsuario() {
        Scanner sc = new Scanner(System.in);
        int event1 = 0;
        int event2 = 0;
        String opcoes[] = { "[1] - Voltar", "[2] - Deletar Plano De Ensino" };
        String planos[] = model.mostrarPlanos();
        if(planos.length == 0){
        	System.out.println("Sem planos cadastrados!");
        	System.out.println("");
        }
        if(planos.length>=1) {
	        do {
	        	boolean plano = false;
	        	boolean opcoesExcluir = false;
	            System.out.println("DELETAR PLANO DE ENSINO");
	            System.out.println("=======================");
	            System.out.println();
	            System.out.println("Planos cadastrados: ");
	            System.out.println("");
	            //mostrar todos os planos
	            while(!plano) {
                	boolean numeroPlanoValido = false;
	                for(int i = 0; i<planos.length; i++) {
	                	System.out.println(planos[i]);
	                }
	                do {
			            System.out.println("");
		                System.out.println("Qual plano deseja excluir?");
		                try {
		                    event1 = sc.nextInt();
		                    if(event1>=1 && event1<=planos.length) {
		                    	numeroPlanoValido = true;
		                    }
		                    else {
		                    	System.out.println("Digite um plano válido");
		                    }
		                    plano = true;
		                }
		                catch(InputMismatchException e) {
		    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
		    				System.out.println("");
		                }
		    			sc.nextLine(); //limpa a linha
	                }while(!numeroPlanoValido);
	            }
	            System.out.println("");
	            System.out.println("Tem certeza que deseja excluir?");
	            System.out.println("");
	            //
	            while(!opcoesExcluir) {
	                System.out.println("Tem certeza que deseja excluir?");
	                for(String obj: opcoes) {
	                	System.out.println(obj);
	                }
	                try {
	                    event2 = sc.nextInt();
	                    opcoesExcluir = true;
	                }
	                catch(InputMismatchException e) {
	    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
	                }
	    			sc.nextLine(); //limpa a linha
	            }
	            //
	            System.out.println("Plano de ensino excluído!");
	            controller.handleEvent(event1, event2);
	            model.detachObserver(this);
	        } while (!finalizar);
        }
    }

    public void update() {
    	
    }

}