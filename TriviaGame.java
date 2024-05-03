import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TriviaGame {
    public static void main(String[] args) {
        ArrayList<Question> questionBank = initializeQuestionBank();
        Collections.shuffle(questionBank);

        int score = 0;
        int questionsAsked = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Trivia Game!");

        while (questionsAsked < 10) {
            Question currentQuestion = questionBank.get(questionsAsked);

            System.out.println("Category: " + currentQuestion.getCategory());
            System.out.println(currentQuestion.getQuestion());

            try {
                System.out.print("Your answer (True/False): ");
                String userAnswer = scanner.nextLine().toLowerCase();

                if (userAnswer.equals("true") || userAnswer.equals("false")) {
                    if (currentQuestion.checkAnswer(userAnswer)) {
                        System.out.println("Correct!\n");
                        score++;
                    } else {
                        System.out.println("Incorrect.\n");
                    }
                    questionsAsked++;
                } else {
                    System.out.println("Invalid input. Please enter 'True' or 'False'.\n");
                }

            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.\n");
                scanner.nextLine();
            }
        }

        System.out.println("Game Over!");
        System.out.println("Your score: " + score);

        if (score >= 7) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Sorry, you didn't meet the win condition. Better luck next time!");
        }

        scanner.close();
    }

    private static ArrayList<Question> initializeQuestionBank() {
        ArrayList<Question> questionBank = new ArrayList<>();

        questionBank.add(new Question("The main objective in Fortnite Battle Royale is to collect the most resources.", "false", "Fortnite"));
        questionBank.add(new Question("In Fortnite's Save the World mode, players fight against each other in a PvP format.", "false", "Fortnite"));
        questionBank.add(new Question("Fortnite matches can have up to 100 players competing against each other.", "true", "Fortnite"));
        questionBank.add(new Question("Tilted Towers is a location in Fortnite known for its peaceful surroundings.", "false", "Fortnite"));
        questionBank.add(new Question("Each Fortnite character has a unique signature move.", "false", "Fortnite"));
        questionBank.add(new Question("The storm in Fortnite Battle Royale represents a safe zone for players.", "false", "Fortnite"));
        questionBank.add(new Question("Building structures is not a crucial aspect of Fortnite gameplay.", "false", "Fortnite"));
        questionBank.add(new Question("There is a Fortnite character whose primary weapon is a bow.", "false", "Fortnite"));
        questionBank.add(new Question("The shrinking playable area in Fortnite is known as the 'Circle'or 'Zone'", "true", "Fortnite"));
        questionBank.add(new Question("The storm's eye in Fortnite determines the location of supply drops.", "false", "Fortnite"));
        questionBank.add(new Question("The main objective in Brawlhalla is to be the last player standing.", "false", "Brawlhalla"));
        questionBank.add(new Question("Brawlhalla matches can have up to 8 players competing simultaneously.", "true", "Brawlhalla"));
        questionBank.add(new Question("There is a Brawlhalla character known for their proficiency in using a bow.", "true", "Brawlhalla"));
        questionBank.add(new Question("In Brawlhalla, each character has 6 signature moves", "true", "Brawlhalla"));
        questionBank.add(new Question("There are 10 ranks in Brawlhalla.", "false", "Brawlhalla"));
        questionBank.add(new Question("Brawlhalla incorporates different weapon types into its combat system.", "true", "Brawlhalla"));
        questionBank.add(new Question("Mammoth coins can be obtained for free in brawlhalla", "false", "Brawlhalla"));
        questionBank.add(new Question("There are 2 different ranked game modes available in Brawlhalla, 1v1 and 2v2", "true", "Brawlhalla"));
        questionBank.add(new Question("In Brawlhalla, you gain elo by winning ranked games", "true", "Brawlhalla"));
        questionBank.add(new Question("In Brawlhalla, each legend has 22 stat points that are distributed among Strength, Speed, Defense, and Dexterity", "True", "Brawlhalla"));

        return questionBank;
    }
}

class Question {
    private String question;
    private String answer;
    private String category;

    public Question(String question, String answer, String category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getCategory() {
        return category;
    }

    public boolean checkAnswer(String userAnswer) {
        return answer.equals(userAnswer.toLowerCase());
    }
}
