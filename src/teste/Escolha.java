package teste;

public class Escolha {
  private String textoDigitado;
  private String textoMostrado;
  private Capitulo proximo;

  

  //construtor Escolha
  public Escolha(String textoDigitado, String textoMostrado, Capitulo proximo) {
    this.textoDigitado = textoDigitado;
    this.textoMostrado = textoMostrado;
    this.proximo = proximo;
  }    
  //get do texto digitado
  public String getTextoDigitado() {
    return textoDigitado;
  }
  //get do texto mostrado
  public String getTextoMostrado() {
    return textoMostrado;
  }
  //get do proximo
  public Capitulo getProximo() {
    return proximo;
  }
  
}