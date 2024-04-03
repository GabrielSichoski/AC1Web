package arquiteturawebAC1.AC1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        @SuppressWarnings("null")
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            return alunoOptional.get();
        } else {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
    }
    

    @SuppressWarnings("null")
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        @SuppressWarnings("null")
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setRA(alunoAtualizado.getRA());
            aluno.setNumeroCel(alunoAtualizado.getNumeroCel());
            return alunoRepository.save(aluno);
        } else {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
    }

    @SuppressWarnings("null")
    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
        alunoRepository.deleteById(id);
    }
    
}
