/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.cefsa.exercicio_1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class Principal {

    public static void main(String[] args){
        Usuario[] usuarios = new Usuario[5];
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in); 
        int i = 0;
        
        try
        {       
            for (Usuario usuario : usuarios)
            {
                usuario = new Usuario();
                int idade;

                System.out.println("Digite o nome do " +(i+1) +"º usuário: ");
                usuario.nome = scanner.next();

                System.out.println("Digite a data de nascimento de " +usuario.nome +": ");
                usuario.nascimento = LocalDate.parse(scanner.next(), formatoData);
                idade = Period.between(usuario.nascimento, LocalDate.now()).getYears();

                System.out.println("Digite uma senha: ");
                usuario.senha = Criptografia.criptografar(scanner.next());
                
                System.out.println(usuario.nome);
                System.out.println(idade);
                System.out.println("(Ignorando LGPD)Sua senha criptografada é: " +usuario.senha);
                i++;
            }
        }
        catch(Exception erro)
        {
            System.out.println("Algo que você digitou causou uma exceção..\n"
                    + "Por favor, passe o seguinte erro para o administrador:\n"
                    + erro);
        }
    }
}
