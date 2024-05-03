import java.util.ArrayList;
import java.util.Scanner;

public class eljuegodelmiedo{

    private static final ArrayList<String> WORD_BANK = new ArrayList<>() {{
        add("brawlhalla");
        add("guitarra");
        add("computer");
        add("amigo");
        add("elephant");
        add("panorama");
        add("hola");
        add("casa");
        add("friend");
        add("estrella");
        add("jazz");
        add("libro");
        add("flibberdygibbetzanywanydoodledoo");
        add("house");
        add("carro");
        add("sol");
        add("agua");
        add("mariposa");
        add("window");
        add("gato");
    }};
    private static final int MAX_LIVES = 12;

    public static void main(String[] args) {
        char[] guessedLetters = new char[26]; 
        int guessedLettersCount = 0;
        int lives = MAX_LIVES;
        boolean won = false;

        System.out.println("bienvenido al hangman ma malo. si pierdes eres de la aldea de la arena");

        String wordToGuess = chooseWord();
        
        while (lives > 0) {
            System.out.println("\nPalabra: " + displayWord(wordToGuess, guessedLetters, guessedLettersCount));
            char guess = getGuess();

            if (containsLetter(guessedLetters, guessedLettersCount, guess)) {
                System.out.println("ya tu pusite eso ");
                continue;
            }

            guessedLetters[guessedLettersCount++] = guess;

            if (wordToGuess.indexOf(guess) == -1) {
                lives--;
                System.out.println("esa no va te quedan" + lives + "vidas wilson");
            } else {
                System.out.println("si esa va");
            }

            if (guessedWord(wordToGuess, guessedLetters, guessedLettersCount)) {
                won = true;
                break;
            }
        }

        if (won) {
            System.out.println("buena wilson la pegate era " + wordToGuess);
        } else {
            System.out.println("te quedate sin vida, la palabra era  " + wordToGuess);
        }
    }

    private static String chooseWord() {
        return WORD_BANK.get((int) (Math.random() * WORD_BANK.size()));
    }

    private static String displayWord(String word, char[] guessedLetters, int guessedLettersCount) {
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            display.append(containsLetter(guessedLetters, guessedLettersCount, letter) ? letter : '_').append(' ');
        }
        return display.toString();
    }

    private static char getGuess() {
        Scanner scanner = new Scanner(System.in);
        char guess;
        do {
            System.out.print("pon una letra");
            String input = scanner.next().toLowerCase();
            guess = input.length() == 1 ? input.charAt(0) : '\0';
            if (!Character.isLetter(guess)) {
                System.out.println("eso no e una letra");
            }
        } while (!Character.isLetter(guess));
        return guess;
    }

    private static boolean containsLetter(char[] letters, int count, char letter) {
        for (int i = 0; i < count; i++) {
            if (letters[i] == letter) {
                return true;
            }
        }
        return false;
    }

    private static boolean guessedWord(String word, char[] guessedLetters, int guessedLettersCount) {
        for (char letter : word.toCharArray()) {
            if (!containsLetter(guessedLetters, guessedLettersCount, letter)) {
                return false;
            }
        }
        return true;
    }
}


