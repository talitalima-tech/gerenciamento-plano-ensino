package view;

import java.util.*;
import model.*;
import java.util.ArrayList;
import java.util.InputMismatchException;//classe para tratar erros de Strings digitadas em nextInt

public class CreateNewPedView implements Observer{
	private Model model;
	private CreateNewPedController controller;
	
	//testando arraylist em vez de muitos atributos
	
	private ArrayList<String> informacoesPedStrings = new ArrayList<>();
	private ArrayList<String[]> calendarioDeAtividades = new ArrayList<>(); // guarda uma lista de Array de Strings
	private boolean finalizar = false;
	//
	
    /* Inicialização da view CreatePed */
    public void init(Model model) {
        if (model != null){
            this.model = model;	// Guarda o modelo
            controller = new CreateNewPedController();	// Cria seu controller
            controller.init(model, this);	// Inicializa o controller
            model.attachObserver(this);	// Registra a view na lista de observadores do modelo
            menuPed();	// Chama o menu da tela Home
        }
    }
    public void finalizarView() {
        finalizar = true;
    }
    //gets e sets
    public String getCampus(){
    	return informacoesPedStrings.get(0);
    }
    public String getAno(){
    	return informacoesPedStrings.get(1);
    }
    public String getSemestre(){
    	return informacoesPedStrings.get(2);
    }
    public String getUnidade(){
    	return informacoesPedStrings.get(3);
    }
    public String getCurso(){
    	return informacoesPedStrings.get(4);
    }
    public String getAnoDisc(){
    	return informacoesPedStrings.get(5);
    }
    public String getPeriodo(){
    	return informacoesPedStrings.get(6);
    }
    public String getNomeDaDisciplina(){
    	return informacoesPedStrings.get(7);
    }
    public String getCodigoDaDisciplina(){
    	return informacoesPedStrings.get(8);
    }
    public String getCaraterDaDisciplina(){
    	return informacoesPedStrings.get(9);
    }
    public String getRegimeDeOfertaDaDisciplina(){
    	return informacoesPedStrings.get(10);
    }
    public String getJustificativa(){
    	return informacoesPedStrings.get(11);
    }
    public String getEmenta(){
    	return informacoesPedStrings.get(12);
    }
    public String getObjetivoGeral(){
    	return informacoesPedStrings.get(13);
    }
    public String getObjetivosEspecificos(){
    	return informacoesPedStrings.get(14);
    }
    public String getMetodologiaDeEnsino(){
    	return informacoesPedStrings.get(15);
    }
    public String getAtividadesDiscentes(){
    	return informacoesPedStrings.get(16);
    }
    public String getSistemaDeAvaliação(){
    	return informacoesPedStrings.get(17);
    }
    public String getBibliografiaBasicaComplementar(){
    	return informacoesPedStrings.get(18);
    }
    public ArrayList<String[]> getCalendarioDeAtividades() {
    	return this.calendarioDeAtividades; //retorna toda a lista de array de strings
    }
    
    
    public void menuPed() {
		Scanner sc = new Scanner(System.in);
		boolean finalizarHashMap = false;
		int verifica = 0;
		do {
			System.out.println("CADASTRAR NOVO PLANO DE ENSINO");
			System.out.println("==============================");
			System.out.println();
			System.out.print("Campus: ");
			informacoesPedStrings.add(sc.nextLine()); //0 ---> informacoesPedStrings
			System.out.print("Ano: ");
			informacoesPedStrings.add(sc.nextLine()); //1 ---> informacoesPedStrings
			System.out.print("Semestre: ");
			informacoesPedStrings.add(sc.nextLine()); //2 ---> informacoesPedStrings
			System.out.print("Unidade: ");
			informacoesPedStrings.add(sc.nextLine()); //3 ---> informacoesPedStrings
			System.out.print("Curso: ");
			informacoesPedStrings.add(sc.nextLine()); //4 ---> informacoesPedStrings
			System.out.print("Ano(Estrutura Curricular): ");
			informacoesPedStrings.add(sc.nextLine()); //5 ---> informacoesPedStrings
			System.out.print("Período(Estutura Curricular 1 ou 2): ");
			informacoesPedStrings.add(sc.nextLine()); //6 ---> informacoesPedStrings
			System.out.print("Nome da disciplina: ");
			informacoesPedStrings.add(sc.nextLine()); //7 ---> informacoesPedStrings
			System.out.print("Código da disciplina: ");
			informacoesPedStrings.add(sc.nextLine()); //8 ---> informacoesPedStrings
			System.out.print("Caráter da disciplina: ");
			informacoesPedStrings.add(sc.nextLine()); //9 ---> informacoesPedStrings
			System.out.print("Regime de oferta da disciplina: ");
			informacoesPedStrings.add(sc.nextLine()); //10 ---> informacoesPedStrings
			//
			System.out.print("Justificativa: ");
			informacoesPedStrings.add(sc.nextLine()); //11 ---> informacoesPedStrings
			System.out.print("Ementa: ");
			informacoesPedStrings.add(sc.nextLine()); //12 ---> informacoesPedStrings
			System.out.print("Objetivo geral: ");
			informacoesPedStrings.add(sc.nextLine()); //13 ---> informacoesPedStrings
			System.out.print("Objetivos específicos: ");
			informacoesPedStrings.add(sc.nextLine()); //14 ---> informacoesPedStrings
			System.out.print("Metodologia de ensino: ");
			informacoesPedStrings.add(sc.nextLine()); //15 ---> informacoesPedStrings
			System.out.print("Atividades discentes: ");
			informacoesPedStrings.add(sc.nextLine()); //16 ---> informacoesPedStrings
			System.out.print("Sistema de avaliação: ");
			informacoesPedStrings.add(sc.nextLine()); //17 ---> informacoesPedStrings
			System.out.print("Bibliografia básica complementar: ");
			informacoesPedStrings.add(sc.nextLine()); //18 ---> informacoesPedStrings
			System.out.println("Calendário de atividades");
			System.out.println("========================");
			do {
				//hashmap
				boolean valido = false;
				String[] campo = new String[3];
				System.out.print("Data:");
				campo[0] = sc.nextLine();
				System.out.print("Descricão do conteúdo:");
				campo[1] = sc.nextLine();
				System.out.print("Carga horária:");
				campo[2] = sc.nextLine();
				calendarioDeAtividades.add(campo);
				//bloco que recebe a opcao do calendario de atividades já com correção que evita erro de String em nextInt
				while(!valido) {
					System.out.println("[1] - Continuar adicionando no Calendário de atividades?");
					System.out.println("[2] - Finalizar");
					try {
						verifica = sc.nextInt();
						valido = true;
					}
					catch(InputMismatchException e) {
						System.out.println("Mensagem Inválida. Por favor, digite apenas números inteiros");
						System.out.println("");
						
					}
					sc.nextLine(); //limpa a linha
				}
				//fim do bloco
				if(verifica == 2) {
					finalizarHashMap = true;
				}
				}while(!finalizarHashMap);
			controller.handleEvent("OK");
		}while(!finalizar);
		model.detachObserver(this);
    }
    public void update() {
    	//o update não é necessário ser implementado, pois essa tela server apenas para criação e não visualização
    	// o que faz-se desnecessário atualizar dados que nunca vão ser mostrados
    }
    
}
