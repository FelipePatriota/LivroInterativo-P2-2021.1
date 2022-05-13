package teste;


public class Personagem {

  private String nome;
  private int energia;


  //construtor Personagem
  public Personagem(String nome, int energia){

    this.nome = nome;
    this.energia = energia;


  }

  // Metodo que ajusta a energia do personagem
  public void ajustarEnergia(int variacao){
    if(variacao !=0){
      setEnergia(this.energia + variacao);
      System.out.println("Devido aos acontecimentos, a energia do personagem " + this.nome + " foi para " + this.energia);

    }
  }

  // set e get da energia
  public void setEnergia(int energia){
    this.energia = energia;
    if(energia <= 0){
      System.out.println("0");
    }
  
  }

  public int getEnergia(){
    return this.energia;
  }
  //get do nome
  public String getNome(){
    return this.nome;
  }



  

  



  
}  
