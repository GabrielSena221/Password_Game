package jogo_da_senha;

import java.util.Random;
import java.util.Scanner;

public class Interacao {

	public static void main(String[] args) {
		
		//Declaração de Variáveis
		Scanner ler = new Scanner(System.in);
		int[] senha = new int[4];
		int[] tentativa = new int[4];
		

		//Interação
		System.out.println("Digite seu nome:");
		String jogador = ler.nextLine();
		System.out.println("Olá, "+jogador+"!");
		System.out.println("Você tem 10 tentativas para acertar uma senha de 4 dígitos de 1 a 6. Boa sorte!");
		preenche(senha);
		
		
		//Jogo
		for(int i=0; i<10; i++) {
			for (int j=0; j<tentativa.length; j++) {
				tentativa[j] = ler.nextInt();
			}
			System.out.print("Tentativa: ");
			mostra(tentativa);
			int [] resultados = new int[2];
			resultados = digitocorreto(tentativa, senha);
			int dc=resultados[0];
			int dpc=resultados[1];
			System.out.print("Dígitos na posição correta: ");
			System.out.println(dpc);
			System.out.print("Dígitos deslocados: ");
			System.out.println(dc);
			mostra(senha);
			if (dpc == 4 && dc == 0) {
				System.out.println("Parabéns, você ganhou!");
				break;
			}
		}
		System.out.println("Que pena, você perdeu!");
		ler.close();
	}
	
	
	//Funções
	
	public static int[] preenche (int[] x) {
		Random rand = new Random();
		for(int i=0; i<x.length; i++) {
			x[i] = rand.nextInt(1,6);
		}
		return x;	
	}
	
	public static void mostra(int[] x) {
		for (int i=0; i<x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static void mostratexto(String[] x) {
		for (int i=0; i<x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println(" ");
	}
	
	public static int[] digitocorreto(int[] x, int[] y) {
		//Variáveis
		
		int dc=0;
		int dpc=0;
		boolean [] temp = new boolean[4];
		int[]resultados = new int[2];
		
		//Operações
		for (int i=0; i<x.length; i++) {
			for(int j=0; j<y.length; j++) {	
				if (x[i] == y[j] && temp[i] == false) {
					if(i==j){
					 dpc++;
					 temp[j] = true;
					}
					else if(temp[j] == false){
						dc++;
					}
				}	
			}
		}	
		resultados[0] = dc;
		resultados[1] = dpc;
		dc = 0;
		dpc = 0;
		return resultados;
		
		
	}

}
