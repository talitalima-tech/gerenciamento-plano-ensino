package model;

//ESSA CLASSE REPRESENTA UMA ENTIDADE
/*
 * Classe de entidade: plano de ensino
 */

public class PlanoDeEnsino {
    private String campus;
    private String ano;
    private String semestre;
    private Disciplina disciplina = new Disciplina();
    private String justificativa;
    private String ementa;
    private String objetivoGeral;
    private String objetivosEspecificos;
    private String metodologiaDeEnsino;
    private String atividadesDiscentes;
    private String sistemaDeAvaliacao;
    private String bibliografiaBasicaComplementar;

    //
    //inicio dos gets e sets de Plano de ensino
    //

    public String getCampus(){
        return campus;
    }
    public void setCampus(String campus){
        if(campus != null){
            this.campus = campus;
        }
    }
    public String getAno(){
        return ano;
    }
    public void setAno(String ano){
    	this.ano = ano;
    }
    public String getSemestre(){
        return semestre;
    }
    public void setSemestre(String semestre){
    	this.semestre = semestre;
    }
    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        if(justificativa != null){
            this.justificativa = justificativa;
        }
    }
    public String getEmenta(){
        return this.ementa;
    }
    public void setEmenta(String ementa){
        if(ementa != null){
            this.ementa = ementa;
        }
    }
    public String getObjetivoGeral(){
        return this.objetivoGeral;
    }
    public void setObjetivoGeral(String objetivoGeral){
        if(objetivoGeral != null){
            this.objetivoGeral = objetivoGeral;
        }
    }
    public String getObjetivosEspecificos(){
        return this.objetivosEspecificos;
    }
    public void setObjetivosEspecificos(String objetivosEspecificos){
        if(objetivosEspecificos != null){
            this.objetivosEspecificos = objetivosEspecificos;
        }
    }
    public String getMetodologiaDeEnsino(){
        return this.metodologiaDeEnsino;
    }
    public void setMetodologiaDeEnsino(String metodologiaDeEnsino){
        if(metodologiaDeEnsino != null){
            this.metodologiaDeEnsino = metodologiaDeEnsino;
        }
    }
    public String getAtividadesDiscentes(){
        return this.atividadesDiscentes;
    }
    public void setAtividadesDiscentes(String atividadesDiscentes){
        if(atividadesDiscentes != null){
            this.atividadesDiscentes = atividadesDiscentes;
        }
    }
    public String getSistemaDeAvaliacao(){
        return this.sistemaDeAvaliacao;
    }
    public void setSistemaDeAvaliacao(String sistemaDeAvaliacao){
        if(sistemaDeAvaliacao != null){
            this.sistemaDeAvaliacao = sistemaDeAvaliacao;
        }
    }
    public String getBibliografiaBasicaComplementar(){
        return this.bibliografiaBasicaComplementar;
    }
    public void setBibliografiaBasicaComplementar(String bibliografiaBasicaComplementar){
        if(bibliografiaBasicaComplementar != null){
            this.bibliografiaBasicaComplementar = bibliografiaBasicaComplementar;
        }
    }
    public Disciplina getDisciplina(){
        return this.disciplina; //cuidado com esse metodo, pois ele retorna um objeto e as views nao podem acessar objetos
    }
    //
    //fim dos gets e sets de Plano de ensino
    //
}
