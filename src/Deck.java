import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    // Atributos usando Collection Framework
    private List<Card> deck;
    private List<Card> removedCards;

    // Constructor
    public Deck() {
        deck = new ArrayList<>();
        removedCards = new ArrayList<>();
        inicializarDeck();
    }

    // Inicializa las 52 cartas
    private void inicializarDeck() {

        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {

            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";

            for (String valor : valores) {
                deck.add(new Card(palo, color, valor));
            }
        }
    }

    // Mezclar el deck
    public void shuffle() {
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck.");
    }

    // Mostrar la primera carta
    public void head() {
        if (!deck.isEmpty()) {
            Card carta = deck.remove(0);
            removedCards.add(carta);
            System.out.println(carta);
            System.out.println("Quedan " + deck.size() + " cartas en deck");
        }
    }

    // Seleccionar carta al azar
    public void pick() {
        if (!deck.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(deck.size());
            Card carta = deck.remove(index);
            removedCards.add(carta);
            System.out.println(carta);
            System.out.println("Quedan " + deck.size() + " cartas en deck");
        }
    }

    // Regresar una mano de 5 cartas
    public void hand() {
        if (deck.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = deck.remove(0);
                removedCards.add(carta);
                System.out.println(carta);
            }
            System.out.println("Quedan " + deck.size() + " cartas en deck");
        }
    }

    // MAIN
    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}

