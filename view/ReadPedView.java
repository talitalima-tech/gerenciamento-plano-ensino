package view;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;//classe para tratar erros de Strings digitadas em nextInt


public class ReadPedView implements Observer{

    private Model model;
    private ReadPedController controller;
    private boolean finalizar = false;
    
    private int numeroPlano = 0;
    
    //informacoes do PED vão ser armazenadas em uma Array de Strings
    private ArrayList<String> informacoesPed = new ArrayList<>();
    private ArrayList<String[]> calendarioDeAtividades = new ArrayList<>();
    //

    public void finalizarView() {
        finalizar = true;
    }

    public void init(Model model) {
        if (model != null){
            this.model = model;
            controller = new ReadPedController();	
            controller.init(model, this);	
            model.attachObserver(this);	
            menuHome(); 
        }
    }


    //menu info
    public void menuHome() {
    	Scanner sc = new Scanner(System.in);
    	int event = 1;
    	do {
    		boolean validoVisualizarPed = false;
    		boolean opcoesVisualizar =  false;
    		informacoesPed = new ArrayList<>(); //reinicia a arraylist de dados para poder guardar/mostrar os dados de apenas 1 plano, o último selecionado  pelo usuário
    		String[] planos = model.mostrarPlanos();
			if(planos.length == 0) {
				System.out.println("Sem planos cadastrados!");
				System.out.println("");
				opcoesVisualizar = true;
				break;
			}
			//bloco que recebe a opcao do plano já com correção que evita erro de String em nextInt
    		while(!validoVisualizarPed) {
        		for(String obj: planos) {
        			System.out.println(obj); 
        		}
    			try {
		            System.out.println("");
    				System.out.println("Qual plano quer visualizar?");
    				this.numeroPlano = sc.nextInt();
    				validoVisualizarPed = true;
    			}
    			catch(InputMismatchException e) {
    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
    				System.out.println("");
    			}
    			sc.nextLine(); //limpa a linha
    		}
	    	//fim do bloco
	    	this.update();
	        String informacoes[] = {"Campus: " + informacoesPed.get(0), "Ano: " + informacoesPed.get(1), "Semestre: " + informacoesPed.get(2),
	                "Unidade: " + informacoesPed.get(3), "Curso: " + informacoesPed.get(4) , "Ano(Estrutura curricular): " + informacoesPed.get(5),
	                "Período: " + informacoesPed.get(6), "Nome da Discipplina: " + informacoesPed.get(7),
	                "Código da Disciplina: " + informacoesPed.get(8), "Caráter da Disciplina: " + informacoesPed.get(9), "Regime de oferta da disciplina: " + informacoesPed.get(10),
	                "Justificativa: " + informacoesPed.get(11), "Ementa: " + informacoesPed.get(12), "Objetivo Geral: " + informacoesPed.get(13), "Objetiivos Específicos: " + informacoesPed.get(14), "Metodologia de ensino: " + informacoesPed.get(15), 
	                "Atividades Discentes: " + informacoesPed.get(16), "Sistema de Avaliação: " + informacoesPed.get(17), "Bibliografia Básica Complementar: " + informacoesPed.get(18)
	                };
	        for(String obj: informacoes) {
	        	System.out.println(obj);
	        }
	        System.out.println("");
	        for(String[] obj: calendarioDeAtividades) {
	        	System.out.println("Data: " + obj[0]);
	        	System.out.println("Descrição da aula: " + obj[1]);
	        	System.out.println("Duração: " + obj[2]);
	        	System.out.println("");
	        }
			//bloco que recebe a opcao de visualizacao já com correção que evita erro de String em nextInt
	        while(!opcoesVisualizar) {
	        	String opcoes[] = {"[1] - Voltar", "[2] - Continuar vendo planos"};
		        for(String obj: opcoes) {
		        	System.out.println(obj);
		        }
		        try {
		        	event = sc.nextInt();
		        	opcoesVisualizar = true;
		        }
		        catch(InputMismatchException e) {
    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
    				System.out.println("");
		        }
		        sc.nextLine(); //resolve o bug pular linha
	        }
	        //fim do bloco
            controller.handleEvent(event);
	        System.out.println("");
        } while (!finalizar);
    }

    public void update() { //pega todos os dados do PED e passa para a ArrayList de Strings
    	if(model.visualizarPlano(numeroPlano).length >= 1) {
        	String[] dados = model.visualizarPlano(numeroPlano);
        	int tam = dados.length;
        	for(int i = 0; i<tam; i++) {
        		informacoesPed.add(dados[i]);
        	}
        	this.calendarioDeAtividades = model.getCalendario(numeroPlano); //pega as array de Strings da arrayList calendario de atividades
    	}

    }
}
