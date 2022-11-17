package br.com.imobilius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.imobilius.model.Imoveis;
import br.com.imobilius.model.interfaces.ImoveisApartamento;
import br.com.imobilius.model.interfaces.ImoveisApartamentoAlugando;
import br.com.imobilius.model.interfaces.ImoveisApartamentoAluguelDisponivel;
import br.com.imobilius.model.interfaces.ImoveisApartamentoVendendo;
import br.com.imobilius.model.interfaces.ImoveisApartamentoVendidos;
import br.com.imobilius.model.interfaces.ImoveisCasa;
import br.com.imobilius.model.interfaces.ImoveisCasaAlugando;
import br.com.imobilius.model.interfaces.ImoveisCasaAluguelDisponivel;
import br.com.imobilius.model.interfaces.ImoveisCasaVendendo;
import br.com.imobilius.model.interfaces.ImoveisCasaVendidos;
import br.com.imobilius.model.interfaces.ImoveisView;
import br.com.imobilius.model.interfaces.MediaValorApartamentosPorBairro;
import br.com.imobilius.model.interfaces.MediaValorBairro;
import br.com.imobilius.model.interfaces.MediaValorCasasPorBairro;
import br.com.imobilius.model.interfaces.MediaValorZona;
import br.com.imobilius.model.interfaces.QuantidadePorBairro;
import br.com.imobilius.model.interfaces.QuantidadePorZona;

public interface ImoveisRepository extends JpaRepository<Imoveis,Long> {
	@Query(value = "select * from ImoveisView", nativeQuery = true)
	public List<ImoveisView> listAllImoveisResumida();

	public List<Imoveis> findByBairro(String bairro);
	
	public List<Imoveis> findByZona(String zona);
	
	@Query(value = "select * from ImoveisCasa", nativeQuery = true)
	public List<ImoveisCasa> listImoveisCasa();
	
	@Query(value = "select * from ImoveisApartamento", nativeQuery = true)
	public List<ImoveisApartamento> listImoveisApartamento();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Vendido' and tipo_aquisicao = 'Venda'", nativeQuery = true)
	public List<Imoveis> findImoveisVendidos();
	
	@Query(value = "select * from ImoveisCasaVendidos", nativeQuery = true)
	public List<ImoveisCasaVendidos> findImoveisCasaVendidos();
	
	@Query(value = "select * from ImoveisApartamentoVendidos", nativeQuery = true)
    public List<ImoveisApartamentoVendidos> findImoveisApartamentoVendidos();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Disponível' and tipo_aquisicao = 'Venda'", nativeQuery = true)
	public List<Imoveis> findImoveisVendendo();
	
	@Query(value = "select * from ImoveisCasaVendendo", nativeQuery = true)
    public List<ImoveisCasaVendendo> findImoveisCasaVendendo();
	
	@Query(value = "select * from ImoveisApartamentoVendendo", nativeQuery = true)
    public List<ImoveisApartamentoVendendo> findImoveisApartamentoVendendo();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Disponível' and tipo_aquisicao = 'Aluguel'", nativeQuery = true)
	public List<Imoveis> findImoveisAluguelDisponivel();
	
	@Query(value = "select * from ImoveisCasaAluguelDisponivel", nativeQuery = true)
    public List<ImoveisCasaAluguelDisponivel> findImoveisCasaAluguelDisponivel();
	
	@Query(value = "select * from ImoveisApartamentoAluguelDisponivel", nativeQuery = true)
    public List<ImoveisApartamentoAluguelDisponivel> findImoveisApartamentoAluguelDisponivel();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Alugando' and tipo_aquisicao = 'Aluguel'", nativeQuery = true)
	public List<Imoveis> findImoveisAluguelAlugando();
	
	@Query(value = "select * from ImoveisCasaAlugando", nativeQuery = true)
    public List<ImoveisCasaAlugando> findImoveisCasaAluguelAlugando();
	
	@Query(value = "select * from ImoveisApartamentoAlugando", nativeQuery = true)
    public List<ImoveisApartamentoAlugando> findImoveisApartamentoAluguelAlugando();
	
	@Query(value = "select * from QuantidadePorBairro", nativeQuery = true)
	public List<QuantidadePorBairro> quantidadePorBairro();
	
	@Query(value = "select * from QuantidadePorZona", nativeQuery = true)
	public List<QuantidadePorZona> quantidadePorZona();
	
	@Query(value = "select * from MediaValorBairro", nativeQuery = true)
	public List<MediaValorBairro> mediaValorBairro();
	
	@Query(value = "select * from MediaValorCasasPorBairro", nativeQuery = true)
	public List<MediaValorCasasPorBairro> mediaValorCasasPorBairro();
	
	@Query(value = "select * from MediaValorApartamentosPorBairro", nativeQuery = true)
    public List<MediaValorApartamentosPorBairro> mediaValorApartamentosPorBairro();
	
	@Query(value = "select * from MediaValorZona", nativeQuery = true)
	public List<MediaValorZona> mediaValorZona();
	
	@Query(value = "select distinct i.tipo_aquisicao, i.status_imovel, count(*) as quantidade "
	        + "from Imoveis i "
	        + "where i.bairro = :bairro"
	        + "group by tipo_aquisicao, status_imovel", nativeQuery = true)
	public List<Imoveis> findDisponibilidadeImoveisPorBairro(@Param("bairro") String bairro);

	public List<Imoveis> findByIdImovel(Long idImovel);

	public List<Imoveis> findByBanheiros(int banheiros);

	public List<Imoveis> findByQuartos(int quartos);

	//public List<Imoveis> findByQuartosBanheiros(int quartos, int banheiros);

	public List<Imoveis> findByGaragem(boolean garagem);
}
