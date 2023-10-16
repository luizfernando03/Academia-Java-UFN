package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando alguns livros
        Livro livro1 = new Livro  ("Java para junior", "L.F. MOURA", "001", 14);
        Livro livro2 = new Livro("Espantando a sindrome do impostor", "L.F.M. Barbosa ", "002", 10);
        Livro livro3 = new Livro("Java um novo mundo", "Luiz Fernando de Moura Barbosa", "003", 7);

        // Adicionando os livros à biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        // Realizando operações na biblioteca
        biblioteca.emprestarLivro("001");
        biblioteca.emprestarLivro("002");
        biblioteca.devolverLivro("003");

        // Listando todos os livros
        System.out.println("Todos os livros na biblioteca:");
        List<Livro> todosLivros = biblioteca.listarLivros();
        for (Livro livro : todosLivros) {
            System.out.println("Título: " + livro.getTitulo() + ", ISBN: " + livro.getIsbn() +
                    ", Emprestado: " + (livro.isEmprestado() ? "Sim" : "Não"));
        }

        // Listando os livros emprestados
        System.out.println("\nLivros atualmente emprestados:");
        List<Livro> livrosEmprestados = biblioteca.listarLivrosEmprestados();
        for (Livro livro : livrosEmprestados) {
            System.out.println("Título: " + livro.getTitulo() + ", ISBN: " + livro.getIsbn());
        }
    }
}