package arquiteturawebAC1.AC1.Service;

import java.util.List;

import arquiteturawebAC1.AC1.Model.Aluno;

public interface AlunoService {
    List<Aluno> listarTodos();
    Aluno buscarPorId(Long id);
    Aluno salvar(Aluno aluno);
    Aluno atualizar(Long id, Aluno alunoAtualizado);
    void deletar(Long id);
}
