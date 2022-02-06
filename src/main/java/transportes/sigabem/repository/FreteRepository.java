package transportes.sigabem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import transportes.sigabem.domain.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{

}
