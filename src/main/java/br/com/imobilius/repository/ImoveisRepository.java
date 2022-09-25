package br.com.imobilius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.imobilius.model.Imoveis;

public interface ImoveisRepository extends JpaRepository<Imoveis,Long> {
	
//	@Query(value =
//			"select i.cod_imovel, c.titulo, c.descricao, i.numero_imovel, i.complemento, i.bairro, i.zona, i.valor, i.area_total, i.status, i.tipo_aquisicao "
//			+ "from Imoveis i "
//			+ "left join Categoria c "
//			+ "on (i.cod_categoria = c.cod_categoria)",
//	nativeQuery = true)
//	public List<Imoveis> listAllImoveisResumida();
	
	@Query(value = "select * from ImoveisResumo", nativeQuery = true)
	public List<Imoveis> listAllImoveisResumida();
}