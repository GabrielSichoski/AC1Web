package arquiteturawebAC1.AC1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    @Override
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setRA(alunoAtualizado.getRA());
        aluno.setNumeroCel(alunoAtualizado.getNumeroCel());

        return alunoRepository.save(aluno);
    }

    @Override
    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
        alunoRepository.deleteById(id);
    }
}
