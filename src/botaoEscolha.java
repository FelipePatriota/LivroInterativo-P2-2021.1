
import javafx.scene.control.Button;

public class botaoEscolha extends Button {

    private Escolha escolha;
    public Object getEscolhas;

    public botaoEscolha( Escolha escolha) {


        super(escolha.getTextoDigitado());
        this.escolha = escolha;
    }

    public Escolha getEscolha() {
        return this.escolha;
    }

}
