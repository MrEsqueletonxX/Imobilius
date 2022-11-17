package br.com.imobilius.model.interfaces;

import java.util.Date;

public interface ImoveisCasaVendidos {
    Long getCod_Imovel();
    String getTitulo();
    String getDescricao();
    String getNome_Rua();
    Integer getNumero_Imovel();
    String getComplemento();
    String getBairro();
    String getZona();
    Float getValor();
    Float getArea_Total();
    String getStatus_Imovel();
    Integer getQuartos();
    Integer getBanheiros();
    Boolean getGaragem();
    String getTipo_Aquisicao();
    Date getData_Criacao();
    
}
