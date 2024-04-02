package arquiteturawebAC1.AC1.Repository;

import arquiteturawebAC1.AC1.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
