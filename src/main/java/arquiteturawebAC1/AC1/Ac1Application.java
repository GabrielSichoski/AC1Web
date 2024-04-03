package arquiteturawebAC1.AC1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Rest.RestClient;

@SpringBootApplication
public class Ac1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);

		RestClient client = new RestClient();

        // Listar todos os alunos
        client.listarAlunos();

        // Buscar aluno por ID
        client.buscarAlunoPorId(1L);

        // Adicionar um novo aluno
        Aluno novoAluno = new Aluno();
        novoAluno.setNome("Novo Aluno");
        novoAluno.setEmail("novoaluno@example.com");
        novoAluno.setRA("12345");
        novoAluno.setNumeroCel("987654321");
        client.adicionarAluno(novoAluno);

        // Atualizar um aluno existente
        Aluno alunoAtualizado = new Aluno();
        alunoAtualizado.setNome("Aluno Atualizado");
        alunoAtualizado.setEmail("atualizado@example.com");
        alunoAtualizado.setRA("54321");
        alunoAtualizado.setNumeroCel("123456789");
        client.atualizarAluno(1L, alunoAtualizado);

        // Deletar um aluno por ID
        client.deletarAluno(1L);
	}

}
