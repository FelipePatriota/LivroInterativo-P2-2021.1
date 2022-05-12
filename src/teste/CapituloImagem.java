package teste;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CapituloImagem extends Capitulo {
  private String imagem = "";

  public CapituloImagem(Map<String, Personagem> personagens, Scanner escaneadorDoConsole, Scanner escaneadorDeArquivo){

    super();
    this.LerCapitulo(personagens, escaneadorDeArquivo);
    this.escaneador = escaneadorDoConsole;
    this.escolhas = new ArrayList<Escolha>();

  }

  protected void LerCapitulo(Map<String, Personagem> personagens, Scanner escaneadorDeArquivo) {
    super.LerCapitulo(personagens, escaneadorDeArquivo);

    escaneadorDeArquivo.nextLine(); //Texto
    String linha = escaneadorDeArquivo.nextLine();
    while(!linha.equals("IMAGEM_FIM")){
      
      this.imagem = imagem + "\n" + linha;
      linha = escaneadorDeArquivo.nextLine();
      

    }
  }  

  protected void mostrar(){
    System.out.println(this.imagem);
    System.out.println("---");
    super.mostrar();
  }  

}
