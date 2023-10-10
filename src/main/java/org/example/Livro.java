package org.example;

import java.time.LocalDateTime;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;
    private LocalDateTime dataEmprestimo;
    private int limiteDiasEmprestimo;

    //Construtor


    public Livro(String titulo, String autor, String isbn, boolean emprestado, LocalDateTime dataEmprestimo, int limiteDiasEmprestimo) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.emprestado = false;
        this.dataEmprestimo = dataEmprestimo;
        this.limiteDiasEmprestimo = limiteDiasEmprestimo;
    }
    // Método para reservar o livro
    public boolean reservar() {
        if (!emprestado) {
            emprestado = true;
            this.dataEmprestimo = LocalDateTime.now();
            return true; // Reserva bem-sucedida
        } else {
            return false; // Já está emprestado
        }
    }

    // Getter para obter o ISBN do livro
    public String getIsbn() {
        return isbn;
    }

    // Getter para verificar se o livro está emprestado
    public boolean isEmprestado() {
        return emprestado;
    }

    // Método para verificar se há atraso na devolução
    public boolean verificarAtrasoDevolucao() {
        if (emprestado) {
            LocalDateTime dataAtual = LocalDateTime.now();
            LocalDateTime limiteDataDevolucao = this.dataEmprestimo.plusDays(this.limiteDiasEmprestimo);

            return dataAtual.isAfter(limiteDataDevolucao); // Verifica se há atraso na devolução
        }
        return false; // O livro não está emprestado
    }

}
