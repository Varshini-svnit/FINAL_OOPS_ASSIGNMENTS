package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] answerButtons;
    private ButtonGroup buttonGroup;
    private JButton submitButton, nextButton, finishButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private ArrayList<Question> questions;

    public QuizApp() {
        // Create and set up the frame
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize questions
        questions = new ArrayList<>();
        loadQuestions();

        // Create the question label
        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        // Create the panel for radio buttons (answer choices)
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));

        answerButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();

        // Create answer options
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JRadioButton("");
            answerButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            buttonGroup.add(answerButtons[i]);
            answerPanel.add(answerButtons[i]);
        }
        add(answerPanel, BorderLayout.CENTER);

        // Create buttons (Submit, Next, Finish)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        buttonPanel.add(submitButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        buttonPanel.add(nextButton);

        finishButton = new JButton("Finish");
        finishButton.addActionListener(new FinishButtonListener());
        buttonPanel.add(finishButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Display the first question
        showQuestion(currentQuestionIndex);
    }

    // Load questions and answers into the quiz
    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", "Paris", "London", "Rome", "Berlin", "Paris"));
        questions.add(new Question("Which language is this quiz written in?", "Java", "Python", "C++", "Ruby", "Java"));
        questions.add(new Question("What is 2 + 2?", "3", "4", "5", "6", "4"));
        questions.add(new Question("What is the largest ocean?", "Atlantic", "Indian", "Arctic", "Pacific", "Pacific"));
        questions.add(new Question("Who developed Java?", "Microsoft", "Oracle", "Sun Microsystems", "Apple", "Sun Microsystems"));
    }

    // Show the current question and options
    private void showQuestion(int index) {
        Question question = questions.get(index);
        questionLabel.setText(question.getQuestion());
        String[] options = question.getOptions();
        
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(options[i]);
            answerButtons[i].setSelected(false);
        }
    }

    // Check if the selected answer is correct
    private boolean isAnswerCorrect() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        for (int i = 0; i < 4; i++) {
            if (answerButtons[i].isSelected() && answerButtons[i].getText().equals(currentQuestion.getCorrectAnswer())) {
                return true;
            }
        }
        return false;
    }

    // Submit button action listener
    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (isAnswerCorrect()) {
                score++;
            }
            JOptionPane.showMessageDialog(QuizApp.this, "Your answer has been submitted.");
        }
    }

    // Next button action listener
    private class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentQuestionIndex < questions.size() - 1) {
                currentQuestionIndex++;
                showQuestion(currentQuestionIndex);
            } else {
                JOptionPane.showMessageDialog(QuizApp.this, "You have reached the last question.");
            }
        }
    }

    // Finish button action listener
    private class FinishButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(QuizApp.this, "Your final score is: " + score + " out of " + questions.size());
            System.exit(0);  // Close the application
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizApp().setVisible(true);
            }
        });
    }

    // Inner class to represent each question
    class Question {
        private String question;
        private String[] options = new String[4];
        private String correctAnswer;

        public Question(String question, String option1, String option2, String option3, String option4, String correctAnswer) {
            this.question = question;
            this.options[0] = option1;
            this.options[1] = option2;
            this.options[2] = option3;
            this.options[3] = option4;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
