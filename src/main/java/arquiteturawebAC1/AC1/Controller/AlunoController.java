package arquiteturawebAC1.AC1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Repository.AlunoRepository;
import arquiteturawebAC1.AC1.Service.AlunoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/")
    public ResponseEntity<List<Aluno>> listarTodosAlunos() {
        List<Aluno> alunos = alunoService.listarTodos();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome) {
        List<Aluno> alunos = alunoRepository.findByNomeContainingIgnoreCase(nome);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok().body(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorEmail(@PathVariable String email) {
        List<Aluno> alunos = alunoRepository.findByEmail(email);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok().body(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/NumeroCel/{NumeroCel}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNumeroCel(@PathVariable String NumeroCel) {
        List<Aluno> alunos = alunoRepository.findByNumeroCel(NumeroCel);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok().body(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ra/{ra}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRA(@PathVariable String ra) {
        List<Aluno> alunos = alunoRepository.findByRA(ra);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok().body(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = alunoService.atualizar(id, alunoAtualizado);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable(value = "id") Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
