package biblioteca;

import java.util.Date;
import java.util.Scanner;

public class Emprestimo {

	private String titulo, autor;
	private Date dataEmprestimo, dataDevolucao;
	private int numeroPaginas;
	public Aluno aluno;
	Scanner read = new Scanner(System.in);
	
	public Emprestimo() {
		
	}
	

	
	public Emprestimo(Aluno aluno, String titulo, Date dataEmprestimo, String autor, int numeroPaginas) {
		this.aluno = aluno;
		this.titulo = titulo;
		this.dataEmprestimo = dataEmprestimo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
		this.dataDevolucao = null;
	}
	
	public void visualizar() {
		;
	}
	
	public void devolver(Emprestimo emprestimo, Date dataDevolucao) {
		long diferenca = ((((dataDevolucao.getTime() - dataEmprestimo.getTime())
				/ 1000 ) / 60 ) / 60) / 24;
		
		if (diferenca < 3) {
			System.out.println("Devolução concluída com Sucesso!");
		} else {
			System.out.println("Para devolver o livro, você precisa pagar uma multa "
					+ "no valor de: " + (diferenca - 3) * 2);
			System.out.println("A multa foi paga? caso sim, digite \"sim\"");
			String opt = read.nextLine().toLowerCase();
			if (opt == "sim") {
				System.out.println("Devolução concluída com Sucesso!");
				clean(emprestimo);
				
			} else {
				System.out.println("Pague a multa para poder devolver o livro!");
			}
		}
	}
	
	
	
	public void clean(Emprestimo emprestimo) {
		emprestimo.aluno.setMatricula("");
		emprestimo.aluno.setNome("");
		emprestimo.setAutor("");
		emprestimo.setTitulo("");
		emprestimo.setDataDevolucao(null);
		emprestimo.setDataEmprestimo(null);
		emprestimo.setNumeroPaginas(0);
	}

	public String imprimir() {
		String dados = "";
		dados += "Titulo: " + "\nLivro emprestado por: " + aluno.getNome() +titulo + "\nData do Empréstimo: " + dataEmprestimo;
		if (dataDevolucao != null) {
			dados += "\nData da Devolução: " + dataDevolucao;
		}
		if (autor != null && numeroPaginas != 0) {
			dados += "\nAutor: " + autor + "\nNúmero de Páginas: " + numeroPaginas;
		}
				
		return dados;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	

	
	
	
	
	
	
}
