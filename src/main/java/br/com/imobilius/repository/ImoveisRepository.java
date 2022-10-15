package br.com.imobilius.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.imobilius.model.Imoveis;
import br.com.imobilius.model.interfaces.ImoveisApartamento;
import br.com.imobilius.model.interfaces.ImoveisCasa;
import br.com.imobilius.model.interfaces.ImoveisView;
import br.com.imobilius.model.interfaces.MediaValorBairro;
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
	
	@Query(value = "select * from Imoveis where status_imovel = 'Vendido'", nativeQuery = true)
	public List<Imoveis> findImoveisVendidos();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Disponível' and tipo_aquisicao = 'Venda'", nativeQuery = true)
	public List<Imoveis> findImoveisVendendo();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Disponível' and tipo_aquisicao = 'Aluguel'", nativeQuery = true)
	public List<Imoveis> findImoveisAluguelDisponivel();
	
	@Query(value = "select * from Imoveis where status_imovel = 'Alugando' and tipo_aquisicao = 'Aluguel'", nativeQuery = true)
	public List<Imoveis> findImoveisAluguelAlugando();
	
	@Query(value = "select * from QuantidadePorBairro", nativeQuery = true)
	public List<QuantidadePorBairro> quantidadePorBairro();
	
	@Query(value = "select * from QuantidadePorZona", nativeQuery = true)
	public List<QuantidadePorZona> quantidadePorZona();
	
	@Query(value = "select * from MediaValorBairro", nativeQuery = true)
	public List<MediaValorBairro> mediaValorBairro();
	
	@Query(value = "select * from MediaValorZona", nativeQuery = true)
	public List<MediaValorZona> mediaValorZona();

	public List<Imoveis> findByIdImovel(Long idImovel);

	public List<Imoveis> findByBanheiros(int banheiros);

	public List<Imoveis> findByQuartos(int quartos);

	//public List<Imoveis> findByQuartosBanheiros(int quartos, int banheiros);

	public List<Imoveis> findByGaragem(boolean garagem);
}
