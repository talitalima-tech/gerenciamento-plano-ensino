package model;

import java.util.HashMap;
import java.util.ArrayList;
import view.*;

/*
 * Classe Modelo que provê alguns dados e serviços para views e controllers
 */
public class Model {
	/*
	 * Dados do sistema
	 */
	private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
	private Usuario usuarioAutenticado;	// Usuário autenticado pelo sistema
	private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo
	
	private ArrayList<PlanoDeEnsino> planoDeEnsino = new ArrayList<>();
	
	private static Model instanciaUnica; // Instância do padrão Singleton
	
	
	/*
	 * Construtor privado para implementação do padrão de projeto Singleton
	 */	
	private Model(){
		super();
	}	
	
	public static Model getInstancia(){
		if (instanciaUnica == null){
			instanciaUnica = new Model();
		}
		return instanciaUnica;
	}
	
	/*
	 * Método utilizado para notificar todos os observadores contidos no ArrayList que o modelo mudou
	 */
	public void notifica() {
		for (Observer o : observers) {
			o.update(); // update é a operação definida na interface Observer
		}
	}
	


	///////////////////////////
	//metodos usados para visualizar dados do usuario (classe ReadUserInfoView, por exemplo)
	public String getNacionalidadeUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getNacionalidade();
			}
		}
		return "";
	}
	public String getSexoUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getSexo();
			}
		}
		return "";
	}
	public String getEmailUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getEmail();
			}
		}
		return "";
	}
	public String getNivelDeFormacaoUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getNivelDeFormacao();
			}
		}
		return "";
	}
	public String getInstituicaoDeFormacaoUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getInstituicaoDeFormacao();
			}
		}
		return "";
	}
	public String getDataNascimentoUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getDataNascimento();
			}
		}
		return "";
	}

	///////////////////////////

	/*
	 * Devolve o nome de um usuário do mapeamento
	 */
	public String getNomeUsuario(String login) {
		if (login != null) {
			Usuario usuario = usuarios.get(login);
			if (usuario != null){
				return usuario.getNome();
			}
		}
		return "";
	}

	/*
	 * Devolve o login do usuário autenticado
	 */
	public String getUsuarioLogin() {
		if (usuarioAutenticado != null) {
			return usuarioAutenticado.getLogin();			
		}
		return "";
	}


	// Devolve a Senha do usuário autenticado
	public String getUsuarioSenha() {
		if (usuarioAutenticado != null) {
			return usuarioAutenticado.getSenha();
		}
		return "";
	}
	
	/*
	 * Adiciona um usuário no mapeamento
	 */
	public void setUsuario(String nome, String login, String senha, String nacionalidade, String sexo, String email,
						   String nivelDeFormacao, String instituicaoDeFormacao, String dataNascimento) {
		if (nome != null && login != null && senha != null) {
			usuarios.put(login, new Usuario(nome, login, senha, nacionalidade, sexo, email, nivelDeFormacao, instituicaoDeFormacao, dataNascimento));
			notifica();
		}
	}

	// Remove um usuário do mapeamento, pela chave
	public void deletarUsuario(String login) {
		if (login != null && login.equals(usuarioAutenticado.getLogin())) {
			usuarios.remove(login);
			usuarioAutenticado = null;
			//notifica();
		}
		notifica();
	}

	//alterar dados de usuario que está no mapeamento
	public void atualizarDadosUsuario(String novoNome, String novaSenha, String novaNacionalidade,
									  String novoSexo, String novoEmail, String novoNivelDeFormacao,
									  String novaInstituicaoDeFormacao, String novaDataNascimento, String login) {
		if (login != null && login.equals(usuarioAutenticado.getLogin())) {
			usuarios.get(login).setNome(novoNome);
			usuarios.get(login).setSenha(novaSenha);
			usuarios.get(login).setNacionalidade(novaNacionalidade);
			usuarios.get(login).setSexo(novoSexo);
			usuarios.get(login).setEmail(novoEmail);
			usuarios.get(login).setNivelDeFormacao(novoNivelDeFormacao);
			usuarios.get(login).setInstituicaoDeFormacao(novaInstituicaoDeFormacao);
			usuarios.get(login).setDataNascimento(novaDataNascimento);
			//notifica();
		}
		notifica();
	}


	////////////////////////////////////////////////////////////////////
	/*
	 * Serviço para autenticar um usuário
	 */
	public boolean autenticarUsuario(String login, String senha) {
		Usuario usuario;
		boolean autenticado = false;
		if (login != null && senha != null) {
			usuario = usuarios.get(login);
			if (usuario != null) {
				if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())){
					usuarioAutenticado = usuario;
					autenticado = true;
				}
			}
		}
		notifica();
		return autenticado;
	}
	
	// verificar se certo login está disponivel, ao tentar criar usuario
	public boolean loginIndisponivel(String login) {
		return usuarios.containsKey(login);
	}
	
	/*
	 * Desloga um usuário do sistema
	 */
	public void deslogarUsuario() {
		usuarioAutenticado = null;
		notifica();
	}
	
	/*
	 * Devolve o usuário autenticado. Se não tiver nenhum usuário autenticado ele devolve null
	 */
	public String getUsuarioAutenticado() {
		if (usuarioAutenticado != null){
			return usuarioAutenticado.getLogin();
		} else {
			return "";
		}
	}

	/*
	 * Registra um observador na lista de observadores
	 */
	public void attachObserver(Observer observer) {
		if (observer != null) {
			observers.add(observer);
		}		
	}
	
	/*
	 * Exclui um observador da lista de observadores
	 */
	public void detachObserver(Observer observer) {
		if (observer != null) {
			observers.remove(observer);
		}
	}
//INÍCIO DAS FUNCIONALIDADES  REFERENTES AO CRUD DO PLANO DE ENSINO

	/*
	 * FUNCAO EXPERIMENTAL: RETORNAR TODOS OS GETS
	 */
	public String[] getDadosPlanoDeEnsino(PlanoDeEnsino planoDeEnsino){
		String[] dados = new String[20];
		dados[0] = planoDeEnsino.getCampus();
		dados[1] = planoDeEnsino.getAno();
		dados[2] = planoDeEnsino.getSemestre();
		dados[3] = planoDeEnsino.getDisciplina().getUnidade();
		dados[4] = planoDeEnsino.getDisciplina().getCurso();
		dados[5] = planoDeEnsino.getDisciplina().getAno();
		dados[6] = planoDeEnsino.getDisciplina().getPeriodo();
		dados[7] = planoDeEnsino.getDisciplina().getNomeDaDisciplina();
		dados[8] = planoDeEnsino.getDisciplina().getCodigoDaDisciplina();
		dados[9] = planoDeEnsino.getDisciplina().getCaraterDaDisciplina();
		dados[10] = planoDeEnsino.getDisciplina().getRegimeDeOfertaDaDisciplina();
		dados[11] = planoDeEnsino.getJustificativa();
		dados[12] = planoDeEnsino.getEmenta();
		dados[13] = planoDeEnsino.getObjetivoGeral();
		dados[14] = planoDeEnsino.getObjetivosEspecificos();
		dados[15] = planoDeEnsino.getMetodologiaDeEnsino();
		dados[16] = planoDeEnsino.getAtividadesDiscentes();
		dados[17] = planoDeEnsino.getSistemaDeAvaliacao();
		dados[18] = planoDeEnsino.getBibliografiaBasicaComplementar();
		return dados; // em cada índice da array tem uma informacao do plano
	}
	public ArrayList<String[]> getCalendario(int numero){
		PlanoDeEnsino planoDeEnsino = this.planoDeEnsino.get(numero-1);
		
		return planoDeEnsino.getDisciplina().getCalendarioDeAtividadesArray();
	}

	/*
	 * MOSTRAR PLANOS
	 */
	public String[] mostrarPlanos(){
		String[] planos =  new String[planoDeEnsino.size()];
		int iterador = 0;
		for(PlanoDeEnsino planoDeEnsino1: planoDeEnsino){
			planos[iterador] = "[" + (iterador + 1) + "]" + " - " + planoDeEnsino1.getDisciplina().getNomeDaDisciplina() + " - " + planoDeEnsino1.getAno() + "." + planoDeEnsino1.getSemestre();
			iterador++;
		}
		return planos;
	}
	/*
	 * INSERE UM NOVO PLANO DE ENSINO(CREATE)
	 */
	public void setPlanoDeEnsino(String campus, String ano, String semestre, String justificativa, String ementa, String objetivoGeral, String objetivosEspecificos, String metodologiaDeEnsino, String atividadesDiscentes, String sistemaDeAvaliacao, String bibliografiaBasicaComplementar,
								 String unidade_id, String curso_id, String ano_id, String periodo_id, String nomeDaDisciplina_id, String codigoDaDisciplina_id, String caraterDaDisciplina_id, String regimeDeOfertaDaDisiciplina_id, ArrayList<String[]> calendarioDeAtividades){

		PlanoDeEnsino planoDeEnsino1 = new PlanoDeEnsino();
		planoDeEnsino1.setCampus(campus);
		planoDeEnsino1.setAno(ano);
		planoDeEnsino1.setSemestre(semestre);
		planoDeEnsino1.setJustificativa(justificativa);
		planoDeEnsino1.setEmenta(ementa);
		planoDeEnsino1.setObjetivoGeral(objetivoGeral);
		planoDeEnsino1.setObjetivosEspecificos(objetivosEspecificos);
		planoDeEnsino1.setMetodologiaDeEnsino(metodologiaDeEnsino);
		planoDeEnsino1.setAtividadesDiscentes(atividadesDiscentes);
		planoDeEnsino1.setSistemaDeAvaliacao(sistemaDeAvaliacao);
		planoDeEnsino1.setBibliografiaBasicaComplementar(bibliografiaBasicaComplementar);
		planoDeEnsino1.getDisciplina().setUnidade(unidade_id);
		planoDeEnsino1.getDisciplina().setCurso(curso_id);
		planoDeEnsino1.getDisciplina().setAno(ano_id);
		planoDeEnsino1.getDisciplina().setPeriodo(periodo_id);
		planoDeEnsino1.getDisciplina().setNomeDaDisciplina(nomeDaDisciplina_id);
		planoDeEnsino1.getDisciplina().setCodigoDaDisciplina(codigoDaDisciplina_id);
		planoDeEnsino1.getDisciplina().setCaraterDaDisciplina(caraterDaDisciplina_id);
		planoDeEnsino1.getDisciplina().setRegimeDeOfertaDaDisciplina(regimeDeOfertaDaDisiciplina_id);
		planoDeEnsino1.getDisciplina().setCalendarioDeAtividades(calendarioDeAtividades);
		planoDeEnsino.add(planoDeEnsino1);
	}
	/*
	 * VISUALIZAR O PLANO DE ENSINO(READ)
	 */
	public String[] visualizarPlano(int numero){ // recebe o numero digitado pelo usuario que deve escolher o plano na funcao mostrar planos pelo numero
		PlanoDeEnsino planoDeEnsino = new PlanoDeEnsino();

		if(numero>=1 && numero<=this.planoDeEnsino.size()){
			planoDeEnsino = this.planoDeEnsino.get(numero-1);
		}
		return getDadosPlanoDeEnsino(planoDeEnsino); // em cada indice da array tem uma informacao do plano
	}
	/*
	 * DELETAR PLANO DE ENSINO(DELETE)
	 */
	public String excluirPlanoDeEnsino(int numero) {
		if(numero>=1 && numero<=this.planoDeEnsino.size()) {
			this.planoDeEnsino.remove(numero-1);
		}
		return "Plano excluído com sucesso!";
	}
	/*
	 * ATUALIZAR PLANO DE ENSINO(UPDATE) --- INCOMPLETO
	 */
	
	public void atualizarPlanoDeEnsino(String campus, String ano, String semestre, String justificativa, String ementa, String objetivoGeral, String objetivosEspecificos, String metodologiaDeEnsino, String atividadesDiscentes, String sistemaDeAvaliacao, String bibliografiaBasicaComplementar,
			 String unidade_id, String curso_id, String ano_id, String periodo_id, String nomeDaDisciplina_id, String codigoDaDisciplina_id, String caraterDaDisciplina_id, String regimeDeOfertaDaDisiciplina_id, ArrayList<String[]> calendarioDeAtividades, int numeroPlano){

		PlanoDeEnsino planoDeEnsino1 = new PlanoDeEnsino();
		planoDeEnsino1.setCampus(campus);
		planoDeEnsino1.setAno(ano);
		planoDeEnsino1.setSemestre(semestre);
		planoDeEnsino1.setJustificativa(justificativa);
		planoDeEnsino1.setEmenta(ementa);
		planoDeEnsino1.setObjetivoGeral(objetivoGeral);
		planoDeEnsino1.setObjetivosEspecificos(objetivosEspecificos);
		planoDeEnsino1.setMetodologiaDeEnsino(metodologiaDeEnsino);
		planoDeEnsino1.setAtividadesDiscentes(atividadesDiscentes);
		planoDeEnsino1.setSistemaDeAvaliacao(sistemaDeAvaliacao);
		planoDeEnsino1.setBibliografiaBasicaComplementar(bibliografiaBasicaComplementar);
		planoDeEnsino1.getDisciplina().setUnidade(unidade_id);
		planoDeEnsino1.getDisciplina().setCurso(curso_id);
		planoDeEnsino1.getDisciplina().setAno(ano_id);
		planoDeEnsino1.getDisciplina().setPeriodo(periodo_id);
		planoDeEnsino1.getDisciplina().setNomeDaDisciplina(nomeDaDisciplina_id);
		planoDeEnsino1.getDisciplina().setCodigoDaDisciplina(codigoDaDisciplina_id);
		planoDeEnsino1.getDisciplina().setCaraterDaDisciplina(caraterDaDisciplina_id);
		planoDeEnsino1.getDisciplina().setRegimeDeOfertaDaDisciplina(regimeDeOfertaDaDisiciplina_id);
		planoDeEnsino1.getDisciplina().setCalendarioDeAtividades(calendarioDeAtividades);
		planoDeEnsino.set(numeroPlano, planoDeEnsino1);
	}	
	
	/*
	 * Informa o total de usuários cadastrados
	 */
	public int getTotalUsuarios() {
		return usuarios.size();
	}
}