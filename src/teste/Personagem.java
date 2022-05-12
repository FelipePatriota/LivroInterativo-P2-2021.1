package teste;


public class Personagem {

  private String nome;
  private int energia;



  public Personagem(String nome, int energia){

    this.nome = nome;
    this.energia = energia;


  }

  
  public void ajustarEnergia(int variacao){
    if(variacao !=0){
      setEnergia(this.energia + variacao);
      System.out.println("Devido aos acontecimentos, a energia do personagem " + this.nome + " foi para " + this.energia);

    }
  }

  public void setEnergia(int energia){
    this.energia = energia;
    if(energia <= 0){
      System.out.println("0");
    }
  
  }

  public int getEnergia(){
    return this.energia;
  }

  public String getNome(){
    return this.nome;
  }



  

  



  
}  
