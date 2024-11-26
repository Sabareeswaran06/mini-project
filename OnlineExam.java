import java.util.Scanner;
public class OnlineExam {
 static class Question {
        private String question;
        private String[] choices;
        private int correctAnswer;
 public Question(String question, String[] choices, int correctAnswer) {
            this.question = question;
            this.choices = choices;
            this.correctAnswer = correctAnswer;
        }
  public String getQuestion() {
            return question;
        }
public String[] getChoices() {
            return choices;
        }
 public int getCorrectAnswer() {
            return correctAnswer;
        }
    }
static class Exam {
        private Question[] questions;
        private int score;
        public Exam(Question[] questions) {
            this.questions = questions;
            this.score = 0;
        }
 public void startExam() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < questions.length; i++) {
                Question q = questions[i];
                System.out.println("Question " + (i + 1) + ": " + q.getQuestion());
                String[] choices = q.getChoices();
                for (int j = 0; j < choices.length; j++) {
                    System.out.println((j + 1) + ". " + choices[j]);
                }

                System.out.print("Enter your answer (1-4): ");
                int userAnswer = scanner.nextInt();

                if (userAnswer == q.getCorrectAnswer()) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer was: " + choices[q.getCorrectAnswer() - 1] + "\n");
                }
            }
            displayResult();
        }
        private void displayResult() {
            System.out.println("Exam Over!");
            System.out.println("Your final score: " + score + "/" + questions.length);
        }
    }

    public static void main(String[] args) {
        Question[] questions = new Question[]{
            new Question("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 3),
            new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 2),
            new Question("Who wrote 'Romeo and Juliet'?",
                new String[]{"Shakespeare", "Dickens", "Hemingway", "Austen"}, 1),
            new Question("What is the largest ocean on Earth?",
                new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 4)
        };

        Exam exam = new Exam(questions);
        exam.startExam();
    }
}
