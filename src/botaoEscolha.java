import javafx.scene.control.Button;

public class botaoEscolha extends Button {

    private Escolha escolha;
    public Object getEscolhas;
    /**
     * Construtor da classe botaoEscolha
     * @param escolha
     */
    public botaoEscolha( Escolha escolha) {


        super(escolha.getTextoDigitado());
        this.escolha = escolha;
    }
    /**
     * Método que retorna a escolha do botao
     */
    public Escolha getEscolha() {
        return this.escolha;
    }

}
