package org.example;

import java.time.Duration;
import java.time.LocalDateTime;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;
    private LocalDateTime dataEmprestimo;
    private int limiteDiasEmprestimo;

    //Construtor
    public Livro(String titulo, String autor, String isbn, int limiteDiasEmprestimo) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.emprestado = false;
        this.dataEmprestimo = null;  //Inicialmente não emprestado
        this.limiteDiasEmprestimo = limiteDiasEmprestimo;
    }


    // Método para reservar o livro
    public boolean reservar() {
        if (emprestado) {
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

            if (dataAtual.isAfter(limiteDataDevolucao)) {
                long diasAtraso = Duration.between(limiteDataDevolucao, dataAtual).toDays();
                System.out.println("Atraso na devolução de " + diasAtraso + " dias.");
                return true;
            }
        }
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void devolver() {
        emprestado = false;
        this.dataEmprestimo = null; //  Reiniciar a data de emprestimo ao devolver
    }

    public String exibirInfo() {
        String statusEmprestado = emprestado ? "Emprestado" : "Disponível";
        String info = "Título: " + titulo + "\nAutor: " + autor + "\nISBN: " + isbn + "\nStatus: " + statusEmprestado;
        if (emprestado){
            info += "\ndata de Emprestimo: " + this.dataEmprestimo;

        }
        return info;

    }
}