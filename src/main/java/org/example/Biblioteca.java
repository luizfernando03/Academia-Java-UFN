package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Livro> catalogo;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        catalogo.add(livro);
    }

    // Método para remover um livro do catálogo
    public void removerLivro(String isbn) {
        catalogo.removeIf(livro -> livro.getIsbn().equals(isbn));
    }

    // Método para buscar livros por título
    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : catalogo)
            if (livro.getTitulo().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        return livrosEncontrados;
    }

    // Método para emprestar um livro
    public boolean emprestarLivro(String isbn) {
        for (Livro livro : catalogo) {
            if (livro.getIsbn().equals(isbn)) {
                if (livro.isEmprestado()) {
                    return livro.reservar(); // Tenta reservar o livro
                } else {
                    return false; // Livro já está emprestado
                }
            }
        }
        return false; // Livro não encontrado
    }


        // Método para devolver um livro
        public boolean devolverLivro(String isbn) {
            for (Livro livros : catalogo) {
                if (livros.getIsbn().equals(isbn) && livros.isEmprestado()) {
                    livros.devolver(); // Usando o método devolver da classe Livro
                    return true; // Livro devolvido com sucesso
                }
            }
            return false; // Livro não encontrado ou não emprestado
        }

    // Método para listar todos os livros
    public List<Livro> listarLivros() {
        return catalogo;
    }

    // Método para listar os livros atualmente emprestados
    public List<Livro> listarLivrosEmprestados() {
        List<Livro> livrosEmprestados = new ArrayList<>();
        for (Livro livro : catalogo) {
            if (livro.isEmprestado()) {
                livrosEmprestados.add(livro);
            }

        }
        return livrosEmprestados;
    }
    public Livro obterLivroPorISBN(String isbn) {
        for (Livro livro : catalogo) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public void solicitarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ISBN do livro que deseja emprestar: ");
        String isbn = scanner.nextLine();

        Livro livro = obterLivroPorISBN(isbn);
        if (livro != null) {
            if (emprestarLivro(isbn)) {
                System.out.println("Livro solicitado com sucesso: " + livro.getTitulo());
            } else {
                System.out.println("O livro com ISBN " + isbn + " não está disponível para empréstimo.");
            }
        } else {
            System.out.println("Livro com ISBN " + isbn + " não encontrado na biblioteca.");
        }


    }

}


