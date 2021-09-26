package biblioteca;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class BibliotecaApp {

	public static void main(String[] args) {
		
	Scanner read = new Scanner(System.in);


	System.out.println("Selecione a opcao desejada:\n1 - Fazer novo Empréstimo de Livro");
	System.out.println("2 - Visualizar\n3 - Devolver\n4 - Sair\n:  ");
	String opcao = read.nextLine();
	System.out.println("================================================");
	
	switch (opcao) {
	case "1":
		System.out.println("Qual o seu nome? ");
		String nome = read.nextLine();
		System.out.println("Insira o numero da sua matrícula: ");
		String matricula = read.nextLine();
		System.out.println("Nome do livro: ");
		String titulo = read.nextLine();
		DateFormat formata = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Data do empréstimo: ");
		Date dataEmprestimo = null;
		 
		try {
			dataEmprestimo = formata.parse(read.nextLine().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Autor do livro: ");
		String autor = read.nextLine();
		System.out.println("Quantas páginas o livro possui: ");
		int numeroPaginas = read.nextInt();
		Aluno aluno = new Aluno(matricula, nome);
		Emprestimo emprestimo = new Emprestimo(aluno, titulo, dataEmprestimo, autor, numeroPaginas);
		break;
		
		
	case "2":
		
		break;
	case "3":
		break;
	case "4":
		break;
		
	default:
		System.out.println("Escolha uma opção válida.");
		break;
		
	
	} while (opcao != "4");
	
	read.close();

	}
	
}
