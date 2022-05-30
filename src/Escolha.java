

public class Escolha {
  private String textoDigitado;
  private String textoMostrado;
  private Capitulo proximo;

  


  /**
   * Construtor da classe Escolha.
   * @param textoDigitado
   * @param textoMostrado
   * @param proximo
   */
  public Escolha(String textoDigitado, String textoMostrado, Capitulo proximo) {
    this.textoDigitado = textoDigitado;
    this.textoMostrado = textoMostrado;
    this.proximo = proximo;
  }    


  /**
   * Método que retorna o texto digitado.
   * @return
   */
  public String getTextoDigitado() {
    return textoDigitado;
  }

  /**
   * Método que retorna o texto mostrado.
   * @return
   */
  public String getTextoMostrado() {
    return textoMostrado;
  }
  
  /**
   * Método que retorna o proximo capitulo.
   * @return
   */
  public Capitulo getProximo() {
    return proximo;
  }
  
}