package br.edu.dio.santander;

import java.util.Scanner;

public class ContaTerminal {
    private static final String FAVOR = "Por favor, ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(FAVOR.concat("digite seu nome"));
        String nomeCliente = scanner.nextLine();

        System.out.println(FAVOR.concat("digite sua agência"));
        String agencia = scanner.nextLine();

        System.out.println(FAVOR.concat("digite seu número da conta"));
        int conta = scanner.nextInt();

        System.out.println(FAVOR.concat("digite seu saldo"));
        double saldo = scanner.nextDouble();

        System.out.println("Olá ".concat(nomeCliente) + ", obrigado por criar uma conta em nosso banco, " +
                "sua agência é ".concat(agencia) + ", conta ".concat(conta + "") + " e seu saldo "
                .concat("R$" + saldo) + " já está disponível para saque");
    }
}
