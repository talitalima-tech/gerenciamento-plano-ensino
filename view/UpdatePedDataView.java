package view;

import java.util.*;
import model.*;
import java.util.ArrayList;
import java.util.InputMismatchException;//classe para tratar erros de Strings digitadas em nextInt

public class UpdatePedDataView implements Observer{

    private Model model;
    private UpdatePedDataController controller;
    //
    private int numeroPlano = 0;
    private ArrayList<String> informacoesPed = new ArrayList<>(); // obtido
    private ArrayList<String[]> calendarioDeAtividades = new ArrayList<>();
    private boolean finalizar = false;
    
    public void finalizarView() {
        finalizar = true;
    }

    public void init(Model model) {
        this.model = model;
        controller = new UpdatePedDataController();
        controller.init(model, this);
        model.attachObserver(this);
        menuAtualizar();
    }
    //gets e sets
    public String getCampus(){
    	return informacoesPed.get(0);
    }
    public String getAno(){
    	return informacoesPed.get(1);
    }
    public String getSemestre(){
    	return informacoesPed.get(2);
    }
    public String getUnidade(){
    	return informacoesPed.get(3);
    }
    public String getCurso(){
    	return informacoesPed.get(4);
    }
    public String getAnoDisc(){
    	return informacoesPed.get(5);
    }
    public String getPeriodo(){
    	return informacoesPed.get(6);
    }
    public String getNomeDaDisciplina(){
    	return informacoesPed.get(7);
    }
    public String getCodigoDaDisciplina(){
    	return informacoesPed.get(8);
    }
    public String getCaraterDaDisciplina(){
    	return informacoesPed.get(9);
    }
    public String getRegimeDeOfertaDaDisciplina(){
    	return informacoesPed.get(10);
    }
    public String getJustificativa(){
    	return informacoesPed.get(11);
    }
    public String getEmenta(){
    	return informacoesPed.get(12);
    }
    public String getObjetivoGeral(){
    	return informacoesPed.get(13);
    }
    public String getObjetivosEspecificos(){
    	return informacoesPed.get(14);
    }
    public String getMetodologiaDeEnsino(){
    	return informacoesPed.get(15);
    }
    public String getAtividadesDiscentes(){
    	return informacoesPed.get(16);
    }
    public String getSistemaDeAvaliação(){
    	return informacoesPed.get(17);
    }
    public String getBibliografiaBasicaComplementar(){
    	return informacoesPed.get(18);
    }
    public ArrayList<String[]> getCalendarioDeAtividades() {
    	return this.calendarioDeAtividades; //retorna toda a lista de array de strings
    }
    public int getNumeroPlano() {
    	return this.numeroPlano;
    }

    public void menuAtualizar() {
        Scanner sc = new Scanner(System.in);
        int event = 0;
        int event2 = 0;
        boolean finalizarCalendario = false;
        boolean escolherPlano = false;
    	informacoesPed = new ArrayList<>();
    	String[] planos = model.mostrarPlanos();
    	if(planos.length == 0) {
    		System.out.println("Sem planos cadastrados!");
    		System.out.println("");
    		finalizarCalendario = true;
    	}
    	if(planos.length>=1) { //só exibe se tiver 1 ou mais planos
	    	while(!escolherPlano) {
	    		boolean numeroPlanoValido = false;
	    		for(String obj: planos) {
	    			System.out.println(obj);
	    		}
	    		do {
		    		try {
			            System.out.println("");
		    	    	System.out.println("Qual plano deseja modificar?");
		    	    	numeroPlano = sc.nextInt();
		    	    	escolherPlano = true;
		    	    	if(numeroPlano>=1 && numeroPlano<=planos.length) {
		    	    		numeroPlanoValido = true;
		    	    	}
		    	    	else {
		    	    		System.out.println("Digite um plano válido!");
		    	    	}
		    		}
		    		catch(InputMismatchException e) {
						System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
						System.out.println("");
		    		}
		            sc.nextLine(); //resolve o erro de pular linha
	    		}while(!numeroPlanoValido);
	    	}
	    	this.update();
	        do {
	        	int campo = 1;
	        	int opcaoCalendario = 1;
	        	boolean campoCalendario = false;
	        	boolean confirmacaoFinal = false;
	        	
	            System.out.println();
	            System.out.println("ATUALIZAR DADOS DO PLANO DE ENSINO");
	            System.out.println("==================================");
	            String[] opcoes = {"[1] - Confirmar", "[2] - Continuar alterando", "[3] - Voltar"};
		        String[] opcoesCalendario = {"[1] - Continuar alterando calendário" , "[2] - Voltar"};
		        String informacoes[] = {"[1] - Campus: " + informacoesPed.get(0), "[2] - Ano: " + informacoesPed.get(1), "[3] - Semestre: " + informacoesPed.get(2),
		                "[4] - Unidade: " + informacoesPed.get(3), "[5] - Curso: " + informacoesPed.get(4) , "[6] - Ano(Estrutura curricular): " + informacoesPed.get(5),
		                "[7] - Período: " + informacoesPed.get(6), "[8] - Nome da Disciplina: " + informacoesPed.get(7),
		                "[9] - Código da Disciplina: " + informacoesPed.get(8), "[10] - Caráter da Disciplina: " + informacoesPed.get(9), "[11] - Regime de oferta da disciplina: " + informacoesPed.get(10),
		                "[12] - Justificativa: " + informacoesPed.get(11), "[13] - Ementa: " + informacoesPed.get(12), "[14] - Objetivo Geral: " + informacoesPed.get(13), "[15] - Objetivos Específicos: " + informacoesPed.get(14), "[16] - Metodologia de ensino: " + informacoesPed.get(15), 
		                "[17] - Atividades Discentes: " + informacoesPed.get(16), "[18] - Sistema de Avaliação: " + informacoesPed.get(17), "[19] - Bibliografia Básica Complementar: " + informacoesPed.get(18)};
	            //
	            while(!campoCalendario) {
	                System.out.println("");
	                for(String obj: informacoes) {
	                	System.out.println(obj);
	                }
	    	        System.out.println("[20] - Calendário de atividades");
		            System.out.println("");
	                System.out.println("Qual dado deseja alterar?");
	            	try {
	            		event = sc.nextInt();
	            		campoCalendario = true;
	            	}
	            	catch(InputMismatchException e) {
	    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
	    				System.out.println("");
	            	}
	                sc.nextLine(); //resolve o erro de pular linha
	            }
	            //
	            switch (event) {
			        case 1:   System.out.print("Campus: ");
			        			informacoesPed.set(0, sc.nextLine());
			                    break;
	                case 2:   System.out.print("Ano: ");
	                			informacoesPed.set(1, sc.nextLine());
	                            break;
	                case 3:   System.out.print("Semestre: ");
	    						informacoesPed.set(2, sc.nextLine());
	                            break;
	                case 4:   System.out.print("Unidade: ");
								informacoesPed.set(3, sc.nextLine());
	                            break;
	                case 5:   System.out.print("Curso: ");
								informacoesPed.set(4, sc.nextLine());
	                            break;
	                case 6:   System.out.print("Ano(Estrutura curricular): ");
								informacoesPed.set(5, sc.nextLine());
	                            break;
	                case 7:   System.out.print("Período: ");
								informacoesPed.set(6, sc.nextLine());
	                            break;
	                case 8:   System.out.print("Nome da Disciplina: ");
								informacoesPed.set(7, sc.nextLine());
	                            break;
	                case 9:   System.out.print("Código da Disciplina: ");
								informacoesPed.set(8, sc.nextLine());
	                            break;
	                case 10:  System.out.print("Caráter da Disciplina: ");
								informacoesPed.set(9, sc.nextLine());
				                break;
	                case 11:  System.out.print("Regime de oferta da disciplina: ");
								informacoesPed.set(10, sc.nextLine());
				                break;
	                case 12:  System.out.print("Justificativa: ");
					 			informacoesPed.set(11, sc.nextLine());
				                break;
	                case 13:  System.out.print("Ementa: ");
		 						informacoesPed.set(12, sc.nextLine());
				                break;
	                case 14:  System.out.print("Objetivo Geral: ");
								informacoesPed.set(13, sc.nextLine());
				                break;
	                case 15:  System.out.print("Objetivos Específicos: ");
								informacoesPed.set(14, sc.nextLine());
				                break;
	                case 16:  System.out.print("Metodologia de ensino: ");
								informacoesPed.set(15, sc.nextLine());
				                break;
	                case 17:  System.out.print("Atividades Discentes: ");
								informacoesPed.set(16, sc.nextLine());
				                break;
	                case 18:  System.out.print("Sistema de Avaliação: ");
								informacoesPed.set(17, sc.nextLine());
				                break;
	                case 19:  System.out.print("Bibliografia Básica Complementar: ");
								informacoesPed.set(18, sc.nextLine());
				                break;
	                case 20:  System.out.print("Calendário de Atividades: ");
	                			do {
	                				boolean opcaoCalendarioSeleciona = false;
	                				boolean opcaoCampo = false;
	                				String[] informacoesCalendario = new String[3];
	                				int i = 1;
	                		        for(String[] obj: calendarioDeAtividades) {
	                		        	System.out.println("===== [" + i + "] =====");
	                		        	System.out.println("");
	                		        	System.out.println("Data: " + obj[0]);
	                		        	System.out.println("Descrição da aula: " + obj[1]);
	                		        	System.out.println("Duração: " + obj[2]);
	                		        	System.out.println("");
	                		        	i++;
	                		        }
	                		        while(!opcaoCampo){
	                    		        System.out.println("Qual campo deseja alterar?");
	                		        	try {
	                        		        campo = sc.nextInt();
	                        		        opcaoCampo = true;
	                		        	}
	                		        	catch(InputMismatchException e) {
	                	    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
	                	    				System.out.println("");
	                		        	}
	                    		        sc.nextLine(); //resolve bug do pular linha
	                		        }
	                		        System.out.print("Data:");
	                		        informacoesCalendario[0] = sc.nextLine();
	                		        System.out.print("Descrição da aula:");
	                		        informacoesCalendario[1] = sc.nextLine();
	                		        System.out.print("Duração:");
	                		        informacoesCalendario[2] = sc.nextLine();
	                		        calendarioDeAtividades.set(campo-1, informacoesCalendario);
	                		        while(!opcaoCalendarioSeleciona) {
	                       		        for(String obj: opcoesCalendario) {
	                    		        	System.out.println(obj);
	                    		        }
	                    		        try {
	                    		        	opcaoCalendario = sc.nextInt();
	                    		        	opcaoCalendarioSeleciona = true;
	                    		        }
	                    		        catch(InputMismatchException e) {
	                	    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
	                	    				System.out.println("");
	                    		        }
	                    		        sc.nextLine(); //resolve o erro de pular linha
	                		        }
	                		        if(opcaoCalendario == 2) {
	                		        	finalizarCalendario = true;
	                		        }
	                			}while(!finalizarCalendario);
				                break;
	            }
	            System.out.println("");
	            while(!confirmacaoFinal) {
	                System.out.println("Realmente deseja alterar esse dado?");
		            System.out.println("");
	                for(String obj: opcoes) {
	                	System.out.println(obj);
	                }
	                try {
	                	event2 = sc.nextInt();
	                	confirmacaoFinal = true;
	                }
	                catch(InputMismatchException e) {
	    				System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
	    				System.out.println("");
	                }
			        sc.nextLine(); //resolve o erro de pular linha
	            }
	            controller.handleEvent(numeroPlano, event2);
	        }while (!finalizar);
    	}
        model.detachObserver(this);
    }


    public void update() {
    	String[] dados = model.visualizarPlano(numeroPlano);
    	int tam = dados.length;
    	for(int i = 0; i<tam; i++) {
    		informacoesPed.add(dados[i]);
    	}
    	calendarioDeAtividades = model.getCalendario(numeroPlano);
    }

}
