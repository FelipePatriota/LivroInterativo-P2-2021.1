package teste;

public class Escolha {
  private String textoDigitado;
  private String textoMostrado;
  private Capitulo proximo;

  


  public Escolha(String textoDigitado, String textoMostrado, Capitulo proximo) {
    this.textoDigitado = textoDigitado;
    this.textoMostrado = textoMostrado;
    this.proximo = proximo;
  }    

  public String getTextoDigitado() {
    return textoDigitado;
  }

  public String getTextoMostrado() {
    return textoMostrado;
  }
  
  public Capitulo getProximo() {
    return proximo;
  }
  
}