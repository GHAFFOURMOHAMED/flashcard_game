import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class FlashCard {
    private String question;
    private String answer;

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

class Deck {
    List<FlashCard> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void addCard(FlashCard card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public FlashCard drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
}

 class FlashCardGame {
    private Deck deck;
    private Player player;

    public FlashCardGame(String playerName) {
        this.deck = new Deck();
        this.player = new Player(playerName);
    }

    public void addFlashCard(String question, String answer) {
        deck.addCard(new FlashCard(question, answer));
    }

    public void startGame() {
        deck.shuffle();
        Scanner scanner = new Scanner(System.in);

        for (FlashCard card : deck.cards) {
            System.out.println("Question: " + card.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(card.getAnswer())) {
                System.out.println("Correct!");
                player.increaseScore();
            } else {
                System.out.println("Incorrect. The correct answer is: " + card.getAnswer());
            }
        }

        System.out.println("Game over. Your score: " + player.getScore());
    }

    public static void main(String[] args) {
        FlashCardGame game = new FlashCardGame("Player1");
        game.addFlashCard("What is 2 + 2?", "4");
        game.addFlashCard("What is the capital of France?", "Paris");
        game.addFlashCard("What is the chemical symbol for water?", "H2O");
        game.addFlashCard("Who wrote 'Romeo and Juliet'?", "Shakespeare");
        game.addFlashCard("What is the largest planet in our solar system?", "Jupiter");
        game.addFlashCard("What is the powerhouse of the cell?", "Mitochondria");


        game.startGame();
    }
}
