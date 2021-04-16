package br.com.bandtec.lutalivreac2.repository;

import br.com.bandtec.lutalivreac2.classes.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    List<Lutador> findAll();

//    @Query("from lutador where vida > 0.0")
    List<Lutador> findByVidaGreaterThan(Double vida);

    @Transactional
    @Modifying
    @Query(value = "update lutador l set concentracoes_realizadas = concentracoes_realizadas + 1 where l.id =:id", nativeQuery = true)
    void updateLutadorConcentracao(@Param("id") Integer id);

}
