package aula01;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AppElevadorLista {
	
	static Scanner ler = new Scanner(System.in);

	static List<Elevador> elevadores = new ArrayList();
	
	public static void main(String[] args) {
	
		int opcao = 0;
		
		do {
		System.out.println();
		System.out.println("=-=-= MENU DE OPÇÕES =-=-=\n"
						+  "1 - Cadastrar Elevador\n"
						+  "2 - Consultar Elevador\n"
						+  "3 - Alterar Elevador\n"
						+  "4 - Listar Elevador\n"
						+  "0 - Finalizar");
		
		System.out.print("Digite a opção:");
		opcao = ler.nextInt();
		System.out.println();
		
		switch(opcao) {
			case 1:
				CadastrarElevador();
				break;
			case 2:
				ConsultarElevador();
				break;
			case 3:
				AlterarElevador();
				break;
			case 4:
				ListarElevador();
				break;
			case 5:
				excluirElevador();
				break;
			case 0:
				System.out.println("=-=-=Programa Finalizado=-=-=");
				break;
			default:
				System.out.println("OPÇÃO INVALIDA!! FAVOR DIGITAR UM NÚMERO VALIDO");
				break;
		
		}
		
		}while(opcao !=0);		
		ler.close();

		
	}
	
	public static Elevador PesquisarIdElevador(int idElevador) {
		
		for (Elevador elevador : elevadores) {
			if (elevador.getIdElevador() == idElevador ) {
				return elevador;
			}
		}
		
		return null;		
	}
	
	public static void CadastrarElevador() {
		System.out.println("=-=-= CADASTRAR ELEVADOR =-=-=");
				
		System.out.print("Digite o ID do elevador:");
		int idElevador = ler.nextInt();
		
		if(PesquisarIdElevador(idElevador) != null) {
			System.out.println("=-=-= ID já Cadastrado =-=-=");
			return;
		}
		
		System.out.print("Digite o limite do Elevador:");
		int limitePessoas= ler.nextInt();
				
		elevadores.add(new Elevador(idElevador, limitePessoas));	
		
		System.out.println(">> Cadastro Realizado <<\n");
		
	}
		
	
	public static void ConsultarElevador() {
		System.out.println("=-=-= Consultar Elevador =-=-=");
		
		if (elevadores.size() == 0) {
			System.out.println(">> Lista Vazia <<\n");
			return;
		}
		
		System.out.print("Digite o ID do Elevador:");
		int idElevador = ler.nextInt();
		System.out.println();
		
		Elevador elevadorEncontrado = PesquisarIdElevador(idElevador);
		
		if(elevadorEncontrado == null) {
			System.out.println("=-=-= Código não Cadastrado =-=-=");
			return;
		}
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.printf("Limite de Pessoas: %d \n", elevadorEncontrado.getLimitePessoas());
		System.out.printf("Status Elevador..: %s \n", elevadorEncontrado.getStatus());
		System.out.println(">> Consulta Realizada <<");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
		
	
	public static void AlterarElevador() {
		
		System.out.println("=-=-= Alterar Elevador =-=-=");
		
		if (elevadores.size() == 0) {
			System.out.println(">> Lista Vazia <<\n");
			return;
		}
		
		System.out.print("Digite o ID do Elevador:");
		int idElevador = ler.nextInt();
		
		Elevador elevadorEncontrado = PesquisarIdElevador(idElevador);
		
		if (elevadorEncontrado == null) {
			System.out.println("=-=-= ID não encontrado =-=-=");
			return;
		}
		System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		System.out.printf("Limite de Pessoas: %d \n", elevadorEncontrado.getLimitePessoas());
		System.out.printf("Status Elevador..: %s \n", elevadorEncontrado.getStatus());
		System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		char Confirma;
		do{
    		System.out.print("Você tem certeza que deseja alterar? [S/N]: ");
    		
    		Confirma = ler.next().charAt(0);
    		Confirma = Character.toUpperCase(Confirma);
    		
    		if(Confirma != 'S' && Confirma != 'N'){
    		    System.out.println("OPÇÃO INVALIDA!!!");
    		    continue;
    		}
    		break;
		}while (true);
		
		if(Confirma == 'S'){
		    System.out.print("Digite o novo limite do Elevador:");
		    int limitePessoas = ler.nextInt();
		
		    elevadorEncontrado.setLimitePessoas(limitePessoas);
		    System.out.println("=-=-= Alteração Realizada Com Sucesso =-=-=");
		}
		else{
	        System.out.println("=-=-= Alteração Cancelada =-=-=");
		}
	
	
		
	}
	
	public static void excluirElevador() {
		System.out.println("\n*** Exclusão de Elevador ***\n");
		
		if (elevadores.size() == 0) {
			System.out.println(">> Lista Vazia <<\n");
			return;
		}
		
		System.out.print("Identificador...: ");
		int idElevador = ler.nextInt();
		
		Elevador elevadorEncontrado = PesquisarIdElevador(idElevador);
		
		if (elevadorEncontrado == null) {
			System.out.println(">> Identificador não cadastrado <<");
			return;
		}
		
		System.out.printf("Limite de Pessoas: %d \n", elevadorEncontrado.getLimitePessoas());
		System.out.printf("Status Elevador..: %s \n", elevadorEncontrado.getStatus());

		char confirma;
		do {
			System.out.print("Confirma Exclusão [S/N]");
			ler.nextLine();
			confirma = ler.nextLine().charAt(0);
			confirma = Character.toUpperCase(confirma);
			if (confirma!='S' && confirma!='N') {
				System.out.println("Opção inválida!!!");
				continue;
			}
			break;

		} while (true);
		if (confirma == 'S') {
			elevadores.remove(elevadorEncontrado);
			System.out.println(">> Exclusão realizada <<\n");
		}
		else {
			System.out.println(">> Exclusão cancelada <\n");			
		}
		
	}
		
	public static void ListarElevador() {
		System.out.println("\n =-=-= Lista de Elevadores =-=-= \n");
		
		if (elevadores.size() == 0) {
			System.out.println(">> Lista Vazia <<\n");
			return;
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("id ▸ Status            ▸ Limite Pessoas");
		System.out.println("----------------------------------------------------------------");
		
		for (Elevador elevador : elevadores) {
			System.out.printf("%2d ▸ %-20s   ▸ %d\n", 
					elevador.getIdElevador(),
					elevador.getStatus(),
					elevador.getLimitePessoas());
			
		}
		System.out.println("----------------------------------------------------------------");
	}
}
