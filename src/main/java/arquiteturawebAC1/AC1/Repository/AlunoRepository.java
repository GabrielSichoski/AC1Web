package arquiteturawebAC1.AC1.Repository;

import arquiteturawebAC1.AC1.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
     // Método para buscar por ID
     Aluno findById(long id);
    
     // Método para buscar por nome
     List<Aluno> findByNomeContainingIgnoreCase(String nome);
     
     // Método para buscar por email
     List<Aluno> findByEmail(String email);
     
     // Método para buscar por número de celular
     List<Aluno> findByNumeroCel(String numeroCel);
     
     // Método para buscar por RA
     List<Aluno> findByRA(String ra);
}
