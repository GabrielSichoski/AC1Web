package arquiteturawebAC1.AC1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable(value = "id") Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok().body(aluno);
    }

        @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = alunoService.atualizar(id, alunoAtualizado);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable(value = "id") Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
