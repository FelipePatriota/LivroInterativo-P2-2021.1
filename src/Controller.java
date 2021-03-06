import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controller {

    private Capitulo raiz;
    @FXML
    private ImageView imagemQuadro;

    @FXML
    private Button botaoIniciar;

    @FXML
    private ButtonBar botoesEscolha;

    @FXML
    private TextArea textoCapitulo;
    /** 
     * Método que inicializa o controller após o arquivo fxml ter sido carregado
     */
    @FXML
    void iniciarHistoria(ActionEvent event) 
    {
        LeitorDeDados leitor = new LeitorDeDados();

        Map<String, Personagem> personagens = leitor.carregarPersonagens("Dados/Personagens.txt");
        Map<String, Capitulo> capitulos = leitor.carregarCapitulos("Dados/Capitulos.txt", personagens);
        System.out.println("Carregamento finalizado\n\n...\n\n");

        raiz = capitulos.get("raiz");
        mostrarCapitulo(raiz);
        
        botaoIniciar.setVisible(false);

    }
    /**
     * Método que mostra o capitulo atual
     * @param capitulo
     */

    private void mostrarCapitulo(Capitulo capitulo)
    {
        mostrarTextoCapitulo(capitulo.getTexto());
        mostrarEscolhas(capitulo.getEscolhas());
    }
    /**
     * Método que mostra o texto do capitulo
     */
    public void mostrarTextoCapitulo(String texto) 
    {
        textoCapitulo.setText(texto);
    }
    /**
     * Método que mostra as escolhas do capitulo
     */
    public void mostrarEscolhas(ArrayList<Escolha> escolhas)
    {
        botoesEscolha.setPadding(new Insets(10));
        botoesEscolha.getButtons().clear();


        /** 
         * Cria um evento para cada escolha
         */
         
        for (int i = 0; i < escolhas.size(); i++) {

            botaoEscolha botao = new botaoEscolha(escolhas.get(i));
            botao.setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override
                public void handle(ActionEvent event) {
                    mostrarCapitulo(botao.getEscolha().getProximo());
                    System.out.println("Assets/"+botao.getEscolha().getTextoDigitado()+".jpeg");

                    String idImagem = "Assets/"+botao.getEscolha().getTextoDigitado()+".png";
                    
                    imagemQuadro.setImage(new Image(new File(idImagem).toURI().toString()));
                    
                }
                
            });
            botoesEscolha.getButtons().add(botao);

        }
        
    }



    
}