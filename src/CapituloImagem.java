import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class CapituloImagem extends Capitulo {
    private String imagem;
    
    /**
     * Construtor da classe Capitulo.
     * @param personagens
     * @param escaneadorDoArquivo
     */
    public CapituloImagem(
        Map<String, Personagem> personagens,
        Scanner escaneadorDoArquivo)
    {
        super();
        this.lerCapitulo(personagens, escaneadorDoArquivo);
        this.escolhas = new ArrayList<Escolha>(); 
    }
    /**
     * Método leitor de capitulos recebe um mapa de personagens e um scanner de arquivo,
     */
    protected void lerCapitulo(Map<String, Personagem> personagens, Scanner escaneadorDoArquivo) 
    {
        super.lerCapitulo(personagens, escaneadorDoArquivo);

        escaneadorDoArquivo.nextLine(); // IMAGEM
        String linha = escaneadorDoArquivo.nextLine();
        this.imagem = "";
        while (!linha.equals("IMAGEM_FIM")) {
            this.imagem = imagem + "\n" + linha;            
            linha = escaneadorDoArquivo.nextLine();
        }
    }
    /**
     * Método que retorna a imagem do capitulo
     */
    protected void mostrar() 
    {
        System.out.println();
        System.out.println(" . . . ");
        System.out.println(this.imagem);
        super.mostrar();
    }    


   
    
}