package model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

//ESSA CLASSE REPRESENTA UMA ENTIDADE
/*
 * Classe de entidade: Identificacao
 */
public class Disciplina {
    private String unidade;
    private String curso;
    private String ano;
    private String periodo;
    private String nomeDaDisciplina;
    private String codigoDaDisciplina;
    private String caraterDaDisciplina;
    private String regimeDeOfertaDaDisciplina;
    private ArrayList<String[]> calendarioDeAtividades = new ArrayList<>();
    //e informacaoAula como valor.

    //
    //INICIO DOS GETS E SETS DA CLASSE IDENTIFICACAO
    //

    public String getUnidade(){
        return this.unidade;
    }
    public void setUnidade(String unidade){
        if(unidade != null){
            this.unidade = unidade;
        }
    }
    public String getCurso(){
        return this.curso;
    }
    public void setCurso(String curso){
        if(curso != null){
            this.curso = curso;
        }
    }
    public String getAno(){
        return this.ano;
    }
    public void setAno(String ano){
    	this.ano = ano;
    }
    public String getNomeDaDisciplina(){
        return this.nomeDaDisciplina;
    }
    public void setNomeDaDisciplina(String nomeDaDisciplina){
        if(nomeDaDisciplina != null){
            this.nomeDaDisciplina = nomeDaDisciplina;
        }
    }
    public String getCodigoDaDisciplina(){
        return this.codigoDaDisciplina;
    }
    public void setCodigoDaDisciplina(String codigoDaDisciplina){
        if(codigoDaDisciplina != null){
            this.codigoDaDisciplina = codigoDaDisciplina;
        }
    }
    public String getCaraterDaDisciplina(){
        return this.caraterDaDisciplina;
    }
    public void setCaraterDaDisciplina(String caraterDaDisciplina){
        if(caraterDaDisciplina !=  null){
            this.caraterDaDisciplina = caraterDaDisciplina;
        }
    }
    public String getRegimeDeOfertaDaDisciplina(){
        return this.regimeDeOfertaDaDisciplina;
    }
    public void setRegimeDeOfertaDaDisciplina(String regimeDeOfertaDaDisciplina){
        if(regimeDeOfertaDaDisciplina != null){
            this.regimeDeOfertaDaDisciplina = regimeDeOfertaDaDisciplina;
        }
    }
    public String getPeriodo(){
        return this.periodo;
    }
    public void setPeriodo(String periodo){
    	this.periodo = periodo;
    }
    //getcalendariodeatividades retornando uma arrayList de array(para o update)
    public ArrayList<String[]> getCalendarioDeAtividadesArray(){
    	ArrayList<String[]> calendario = new ArrayList<>();
    	for(String[] obj: calendarioDeAtividades){
        	String[] campo = new String[3];
    		campo[0] = obj[0];
    		campo[1] = obj[1];
    		campo[2] = obj[2];
    		calendario.add(campo);
    	}
    	return calendario;
    }

    public void setCalendarioDeAtividades(ArrayList<String[]> calendarioDeAtividades){
        //passa a data como chave e cria um objeto InformacaoAula passando a descricao e quantidade de horas da aula
        for(String[] obj: calendarioDeAtividades) {
        	this.calendarioDeAtividades.add(obj);
        }
    }

    //
    //FIM DOS GETS E SETS DA CLASSE IDENTIFICACAO
    //
}
