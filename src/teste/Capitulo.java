package teste;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Capitulo {
  Scanner sc = new Scanner(System.in);

  private String texto = "";
  private Personagem personagem1;
  private Personagem personagem2; 
  private int variacaoEnergiaPersonagem1;
  private int variacaoEnergiaPersonagem2; 
  protected Scanner escaneador;
  protected ArrayList<Escolha> escolhas;

  public Capitulo(String texto, Personagem personagem1,Personagem personagem2, int variacaoEnergiaPersonagem1, int variacaoEnergiaPersonagem2, Scanner escaneador){
    this.texto = texto;
    this.personagem1 = personagem1;
    this.personagem2 = personagem2;
    this.variacaoEnergiaPersonagem1 = variacaoEnergiaPersonagem1;
    this.variacaoEnergiaPersonagem2 = variacaoEnergiaPersonagem2;

    
  }
 
  public Capitulo(Map<String, Personagem> personagens, Scanner escaneadorDoConsole, Scanner escaneadorDeArquivo){
    this.LerCapitulo(personagens, escaneadorDeArquivo);
    this.escaneador = escaneadorDoConsole;
    this.escolhas = new ArrayList<Escolha>();
    
  }

  public Capitulo(){
    this.texto = "";
    this.escolhas = new ArrayList<Escolha>();
  }
 
  protected void LerCapitulo(Map<String, Personagem> personagens, Scanner escaneadorDeArquivo) {

    escaneadorDeArquivo.nextLine();// Personagem
    String idPersonagem1 = escaneadorDeArquivo.nextLine(); //ID do personagem
    String idPersonagem2 = escaneadorDeArquivo.nextLine(); //ID do personagem
    this.personagem1 = personagens.get(idPersonagem1);
    this.personagem2 = personagens.get(idPersonagem2);

    escaneadorDeArquivo.nextLine(); //Texto
    String linha = escaneadorDeArquivo.nextLine();
    while(!linha.equals("VARIACOES")){
      
      if(linha.equals(idPersonagem1)){
        texto = texto + personagem1.getNome();
      }
      else if (linha.equals(idPersonagem2)){
        texto = texto + personagem2.getNome();
      }
      else{
        texto = texto + linha;
      }
      linha = escaneadorDeArquivo.nextLine();
      
    }
    this.variacaoEnergiaPersonagem1 = Integer.parseInt(escaneadorDeArquivo.nextLine());
    this.variacaoEnergiaPersonagem2 = Integer.parseInt(escaneadorDeArquivo.nextLine());//Energia
  }

  public void adcionarEscolha(Escolha escolha){
    escolhas.add(escolha);
    
  }

  public void executar(){

    mostrar();

    if(escolhas.size() > 0){
      int idCapituloEscolhido = escolher();
      escolhas.get(idCapituloEscolhido).getProximo().executar();
    }
    else{
      System.out.println("Sua aventura acabou");
    }
  }

  protected void mostrar(){
    System.out.println(texto);
    personagem1.ajustarEnergia(variacaoEnergiaPersonagem1);
    personagem2.ajustarEnergia(variacaoEnergiaPersonagem2);

      for(int i = 0; i < escolhas.size(); i++){
        System.out.println(" - " + escolhas.get(i).getTextoMostrado());

       // int escolha = escolher();
       // escolhas.get(escolha).getProximo().mostrar(); 
      }

      System.out.println();
      System.out.println("---");
      System.out.println();
    }

  public int escolher(){


    int opcaoEscolhida = 0;
    String escolha;
    boolean escolhaValida = false;

  while(!escolhaValida){
    
    System.out.println("");
    System.out.println("Escolha uma opção: ");
    escolha = escaneador.nextLine();
    for(int i = 0; i < escolhas.size(); i++){
      if(escolha.equalsIgnoreCase(escolhas.get(i).getTextoDigitado())){
        escolhaValida = true;
        opcaoEscolhida = i;
      }
    }
      
    if(!escolhaValida){

        System.out.println("Escolha inválida");
      }
  }

    return opcaoEscolhida;
  }                 
  


}









