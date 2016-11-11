package com.example.suporte01.app1;

/**
 * Created by Suporte01 on 11/11/2016.
 */

public class EstabelecimentoModel {
    private String NomeFantasia;
    private String Descricao;
    private String Endereco;
    private String Logo;
    private String ImagemPrincipal;
    private String CategoriaEstabelecimento;
    private String CategoriasPratos;
    private String Id;

    public String getNomeFantasia() {
        return NomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.NomeFantasia = nomeFantasia;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        this.Logo = logo;
    }

    public String getImagemPrincipal() {
        return ImagemPrincipal;
    }

    public void setImagemPrincipal(String imagemPrincipal) {
        this.ImagemPrincipal = imagemPrincipal;
    }

    public String getCategoriaEstabelecimento() {
        return CategoriaEstabelecimento;
    }

    public void setCategoriaEstabelecimento(String categoriaEstabelecimento) {
        this.CategoriaEstabelecimento = categoriaEstabelecimento;
    }

    public String getCategoriasPratos() {
        return CategoriasPratos;
    }

    public void setCategoriasPratos(String categoriasPratos) {
        this.CategoriasPratos = categoriasPratos;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }
}
