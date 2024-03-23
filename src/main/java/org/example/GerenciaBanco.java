package org.example;

import java.util.Scanner;

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario;
        ContaBancaria conta = null;
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Nova Conta");
            System.out.println("2. Exibir Informações da Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Nome do Usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Usuário: ");
                    String cpf = scanner.nextLine();
                    usuario = new Usuario(nome, cpf);
                    conta = new ContaBancaria(usuario);
                    System.out.println("Conta criada com sucesso.");
                    break;
                case 2:
                    if (conta != null) {
                        conta.exibirInformacoes();
                    } else {
                        System.out.println("Nenhuma conta encontrada. Por favor, crie uma conta primeiro.");
                    }
                    break;
                case 3:
                    if (conta != null) {
                        System.out.print("Informe o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    } else {
                        System.out.println("Nenhuma conta encontrada. Por favor, crie uma conta primeiro.");
                    }
                    break;
                case 4:
                    if (conta != null) {
                        System.out.print("Informe o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    } else {
                        System.out.println("Nenhuma conta encontrada. Por favor, crie uma conta primeiro.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    static class Usuario {
        private String nome;
        private String cpf;

        public Usuario(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }
    }

    static class ContaBancaria {
        private Usuario usuario;
        private double saldo;

        public ContaBancaria(Usuario usuario) {
            this.usuario = usuario;
            this.saldo = 0.0;
        }

        public void exibirInformacoes() {
            System.out.println("Titular: " + usuario.getNome());
            System.out.println("CPF do Titular: " + usuario.getCpf());
            System.out.println("Saldo: " + saldo);
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("O valor de depósito deve ser positivo.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && saldo >= valor) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        }
    }

}