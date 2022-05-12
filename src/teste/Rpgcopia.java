package teste;
import java.util.Map;
import java.util.Scanner;


public class Rpgcopia {
    static int escolha = 0;

    public static void main(String[] args) throws Exception {
        Scanner escaneadorDoConsole = new Scanner(System.in, "UTF-8");
        LeitorDeDados leitor = new LeitorDeDados();

        Map<String, Personagem> personagens = leitor.carregarPersonagens("Personagens.txt");
        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("Capitulos.txt", personagens, escaneadorDoConsole);

        Capitulo raiz = capitulos.get("Raiz");
        raiz.executar();

        escaneadorDoConsole.close();


    }    

}