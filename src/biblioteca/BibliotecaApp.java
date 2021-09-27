package biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BibliotecaApp {

  public static void main(String[] args) {

    DateFormat formata = new SimpleDateFormat("dd/mm/yyyy");
    Scanner read = new Scanner(System.in);
    String opcao = null;
    Emprestimo emprestimo = null;

    while (opcao != "4") {
      System.out.println("Selecione a opcao desejada:\n1 - Fazer novo Empréstimo de Livro");
      System.out.println("2 - Visualizar\n3 - Devolver\n4 - Sair\n:  ");
      opcao = read.nextLine();
      System.out.println("================================================");

      switch (opcao) {
        case "1":
          System.out.println("Qual o seu nome? ");
          String nome = read.nextLine();
          System.out.println("Insira o numero da sua matrícula: ");
          String matricula = read.nextLine();
          System.out.println("Nome do livro: ");
          String titulo = read.nextLine();

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
          emprestimo = new Emprestimo(aluno, titulo, dataEmprestimo, autor, numeroPaginas);
          break;

        case "2":
          if (emprestimo != null) {
            System.out.println("Você tem um empréstimo pendente!\n" + emprestimo.imprimir());
          } else {
            System.out.println("Voce não tem nenhum empréstimo!");
          }
          break;
        case "3":
          if (emprestimo != null) {
            Date dataDevolucao = null;
            System.out.println("Informe a data da devolução: ");
            try {
              dataDevolucao = formata.parse(read.nextLine().toString());
            } catch (ParseException e) {
              e.printStackTrace();
            }
            emprestimo.devolver(emprestimo, dataDevolucao);
          }
          break;
        case "4":
          System.exit(0);
          break;

        default:
          System.out.println("Escolha uma opção válida.");
          break;
      }
    }

    read.close();

    read.close();
  }
}
