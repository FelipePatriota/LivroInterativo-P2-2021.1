public class Personagem {

  private String nome;
  private int energia;


  /**
   * Construtor da classe Personagem.
   * @param nome
   * @param energia
   */
  public Personagem(String nome, int energia){

    this.nome = nome;
    this.energia = energia;


  }


  /**
   * Método que ajusta a energia do personagem.
   * @param variacao
   */
  public void ajustarEnergia(int variacao){
    if(variacao !=0){
      setEnergia(this.energia + variacao);
      System.out.println("Devido aos acontecimentos, a energia do personagem " + 
      this.nome + " foi para " + this.energia);

    }
  }

  /**
   * Método que retorna a energia do personagem.
   * @param energia
   */
  public void setEnergia(int energia){
    this.energia = energia;
    if(energia <= 0){
      System.out.println("0");
    }
  
  }
  /**
   * Método que retorna a energia do personagem.
   * @return
   */
  public int getEnergia(){
    return this.energia;
  }
  /**
   * Método que retorna o nome do personagem.
   * @return
   */
  public String getNome(){
    return this.nome;
  }
  
}  
