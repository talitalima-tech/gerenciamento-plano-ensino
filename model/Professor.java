package model;

import java.util.Date;

//public abstract class Professor {
public class Professor {
    protected String nacionalidade;
    protected String sexo;
    protected String email;
    protected String nivelDeFormacao;
    protected String instituicaoDeFormacao;
    protected String dataNascimento;
    protected Professor() {
        super();
    }

    protected Professor(String nacionalidade, String sexo, String email, String nivelDeFormacao,
                        String instituicaoDeFormacao, String dataNascimento) {
        setNacionalidade(nacionalidade);
        setSexo(sexo);
        setEmail(email);
        setNivelDeFormacao(nivelDeFormacao);
        setInstituicaoDeFormacao(instituicaoDeFormacao);
        setDataNascimento(dataNascimento);
    }

    public void setNacionalidade(String nacionalidade) {
        if (nacionalidade != null)
            this.nacionalidade = nacionalidade;
    }

    //setters
    public void setSexo(String sexo) {
        if (sexo != null)
            this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNivelDeFormacao(String nivelDeFormacao) {
        if (nivelDeFormacao != null)
            this.nivelDeFormacao = nivelDeFormacao;
    }

    public void setInstituicaoDeFormacao(String instituicaoDeFormacao) {
        if (instituicaoDeFormacao != null)
            this.instituicaoDeFormacao = instituicaoDeFormacao;
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento != null)
            this.dataNascimento = dataNascimento;
    }

    //getters
    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public String getNivelDeFormacao() {
        return nivelDeFormacao;
    }

    public String getInstituicaoDeFormacao() {
        return instituicaoDeFormacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }



}
