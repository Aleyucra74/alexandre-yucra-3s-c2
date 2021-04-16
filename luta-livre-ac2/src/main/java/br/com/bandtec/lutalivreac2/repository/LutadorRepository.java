package br.com.bandtec.lutalivreac2.repository;

import br.com.bandtec.lutalivreac2.classes.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    List<Lutador> findAll();

//    @Query("from lutador where vida > 0.0")
    List<Lutador> findByVidaGreaterThan(Double vida);

    @Modifying
    @Query("update lutador l set l.concentracoes_realizadas = l.concentracoes_realizadas + 1 where id=:id")
    List<Lutador> alteracaoLutadores(Integer id);

}
