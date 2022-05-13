package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeitorDeDados {

  //Método que carrega os personagens recebe como parametro o nome do arquivo e retorna um mapa de personagens
  public HashMap<String, Personagem> carregarPersonagens(String caminho) {
    HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();

    File arquivo = new File(caminho);
    try {
      Scanner escaneador = new Scanner(arquivo);

      System.out.println("Carregando personagens...");
      int i = 0;
      while (escaneador.hasNextLine()) {
        i++;
        String id = escaneador.nextLine(); // ID
        String nome = escaneador.nextLine();// Nome
        int energia = Integer.parseInt(escaneador.nextLine());// Energia

        escaneador.nextLine(); // \n
        System.out.println("Personagem " + i);

        personagens.put(id, new Personagem(nome, energia));

      }
      escaneador.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return personagens;

  }
  //Método que carrega os capitulos recebendo o caminho do arquivo e o mapa de personagens e retorna um arraylist de capitulos
  public HashMap<String, Capitulo> carregarCapitulos(String caminho, Map<String, Personagem> personagens,
      Scanner escaneadorDoConsole) {

    HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();

    File arquivo = new File(caminho);
    try {
      Scanner escaneadorDeArquivo = new Scanner(arquivo, "UTF-8");

      System.out.println("Carregando capitulos...");
      String linha = escaneadorDeArquivo.nextLine();
      while (escaneadorDeArquivo.hasNextLine()) {

        if (linha.equals("CAPITULO")||linha.equals("CAPITULO_COM_IMAGEM")) {

          escaneadorDeArquivo.nextLine();
          String id = escaneadorDeArquivo.nextLine(); // ID
          
          if (linha.equals("CAPITULO")) {
            capitulos.put(id, new Capitulo(personagens, escaneadorDoConsole, escaneadorDeArquivo));
          } else if (linha.equals("CAPITULO_COM_IMAGEM")) {
            capitulos.put(id, new CapituloImagem(personagens, escaneadorDoConsole, escaneadorDeArquivo));
          }

          System.out.println("Capitulo " + id);
          escaneadorDeArquivo.nextLine();// \n

        } else if (linha.equals("ESCOLHA")) {
          LerEscolha(capitulos, escaneadorDeArquivo);

        }
        linha = escaneadorDeArquivo.nextLine();
      }
      escaneadorDeArquivo.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("Erro ao ler arquivo");
    }

    return capitulos;

  }
  //Método que lê as escolhas do arquivo e retorna um arraylist de escolhas
  private void LerEscolha(HashMap<String, Capitulo> capitulos, Scanner escaneadorDeArquivo) {

    escaneadorDeArquivo.nextLine(); // DE
    String idCapituloDe = escaneadorDeArquivo.nextLine(); // ID
    escaneadorDeArquivo.nextLine(); // PARA
    String idCapituloPara = escaneadorDeArquivo.nextLine(); // PARA
    escaneadorDeArquivo.nextLine(); // TEXTO DIGITADO
    String textoDigitado = escaneadorDeArquivo.nextLine(); // ID
    escaneadorDeArquivo.nextLine(); // TEXTO MOSTRADO
    String textoMostrado = escaneadorDeArquivo.nextLine(); // ID

    capitulos.get(idCapituloDe)
        .adcionarEscolha(new Escolha(textoDigitado, textoMostrado, capitulos.get(idCapituloPara)));

  }

}
