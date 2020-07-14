package com.kazuma.quizapplication;

import java.awt.HeadlessException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class QuizJFrame extends javax.swing.JFrame
{

    public QuizJFrame()
    {
	initComponents();
	initQuestionOrder();
	//userGraphicJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thumbs-up.jpg")));
    }
    private int questionIndex = 0;
    private final String[] questionBank =
    {
	"What is the Capital Of Australia?",
	"Who scored the final goal of the Euro 2012 Championships?",
	"Which of these are not a county in Ireland?",
	"Who won the Premier League in 2019/2020?",
	"What is the Capital of Nigeria?",
	"Which of these is not a city in USA?",
	"Which is the hottest planet?",
	"Where is the Eiffel Tower Located in?",
	"Who is the Prime Minister Of Ireland?",
	"Who is the President of the United States?"
    };
    private final int[] questionOrder = new int[questionBank.length];

    private void initQuestionOrder()
    {
	for (int index = 0; index < questionOrder.length; index++)
	{
	    questionOrder[index] = index;
	}
    }
    private final String[][] questionBankAnswers =
    {
	{
	    "Perth", "Canberra", "Adelaide", "Sydney"
	},
	{
	    "David Silva", "Juan Mata", "Cristiano Ronaldo", "Antonio Di Natalie"
	},
	{
	    "Limerick", "Dublin", "Manchester", "Cork"
	},
	{
	    "Manchester City", "Manchester United", "Liverpool", "Chelsea"
	},
	{
	    "Lagos", "Port-Harcourt", "Abuja", "Calabar"
	},
	{
	    "Warri", "New York", "Chicago", "Los Angeles"
	},
	{
	    "Venus", "Mercury", "Saturn", "Earth"
	},
	{
	    "Madrid", "London", "Orlando", "Paris"
	},
	{
	    "Michael Martin", "Mohammed Buhari", "Prince Charles", "Boris Johnson"
	},
	{
	    "Barack Obama", "The Rock", "Donald Trump", "Hillary CLinton"
	}
    };
    private final String[] questionBankCorrectAnswers =
    {
	"Canberra",
	"Juan Mata",
	"Manchester",
	"Liverpool",
	"Abuja",
	"Warri",
	"Venus",
	"Paris",
	"Michael Martin",
	"Donald Trump"
    };
    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    //
    //  Event Handler Methods
    //
    private void startQuiz()
    {
	startButton.setEnabled(false);
	randomizeQuestionOrder();
	loadNextQuestion();
    }

    private void randomizeQuestionOrder()
    {
	Stackoverflow.fisherYatesShuffleArray(questionOrder);
    }

    private void quitQuizProgram()
    {
	int response = JOptionPane.showConfirmDialog(this, "Do you wish to quit? ", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	if (response == JOptionPane.YES_OPTION)
	{
	    System.exit(0);
	}
    }

    private void checkAnswer()
    {
	boolean answerIsCorrect = false;
	for (String answer : questionBankCorrectAnswers)
	{
	    answerIsCorrect = selectAnswerComboBox.getSelectedItem() == answer;
	    if (answerIsCorrect)
	    {
		break;
	    }
	}

	if (answerIsCorrect)
	{
	    correctAnswers++;
	    answerChoiceTextField.setText("Correct Answer !!");
	}
	else
	{
	    wrongAnswers++;
	    answerChoiceTextField.setText("Wrong Answer !!");
	}
	nextQuestionButton.setEnabled(true);
	checkAnswerButton.setEnabled(false);
    }

    private void loadNextQuestion()
    {
	checkAnswerButton.setEnabled(true);
	answerChoiceTextField.setText("");
	if (questionIndex < questionBank.length)
	{
	    int questionNumber = questionOrder[questionIndex];
	    questionJTextField.setText(questionBank[questionNumber]);
	    selectAnswerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(questionBankAnswers[questionNumber]));
	    if (questionIndex == 4)
	    {
		String output = "<html>Thanks for Taking the quiz.<br />"
			+ "Number of questions answered = " + (questionIndex + 1) + "<br />"
			+ "Number of Correct answers = " + correctAnswers + "<br />"
			+ "Number of Incorrect answers = " + wrongAnswers + "</html>";
		JOptionPane.showMessageDialog(this, output);

	    }
	    questionIndex++;
	    nextQuestionButton.setEnabled(false);
	}
	else
	{
	    String output = "<html>Thanks for Taking the quiz.<br />"
		    + "Number of questions answered = " + (questionIndex + 1) + "<br />"
		    + "Number of Correct answers = " + correctAnswers + "<br />"
		    + "Number of Incorrect answers = " + wrongAnswers + "</html>";
	    JOptionPane.showMessageDialog(this, output);
	    finishQuiz();
	    JOptionPane.showMessageDialog(this, "All questions answered.");
	    finishQuiz();
	}
    }

    private void finishQuiz() throws HeadlessException
    {
	correctAnswers = 0;
	wrongAnswers = 0;
	questionIndex = 0;
	questionJTextField.setText("");
	selectAnswerComboBox.setModel(new DefaultComboBoxModel());
	startButton.setEnabled(true);
	nextQuestionButton.setEnabled(false);
	checkAnswerButton.setEnabled(false);
    }

    public static void main(String args[])
    {
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		new QuizJFrame().setVisible(true);
	    }
	});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        controlsJPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();
        checkAnswerButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        questionJPanel = new javax.swing.JPanel();
        questionJLabel = new javax.swing.JLabel();
        selectAnswerJLabel = new javax.swing.JLabel();
        questionJTextField = new javax.swing.JTextField();
        selectAnswerComboBox = new javax.swing.JComboBox<>();
        answerChoiceTextField = new javax.swing.JTextField();
        userGraphicJLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        languageMenu = new javax.swing.JMenu();
        englishMenuItem = new javax.swing.JMenuItem();
        frenchMenuItem = new javax.swing.JMenuItem();
        germanMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("General knowledge quiz");

        controlsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controls", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));

        startButton.setText("Start");
        startButton.setToolTipText("click on the start button to start");
        startButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startButtonActionPerformed(evt);
            }
        });

        nextQuestionButton.setText("Next Question");
        nextQuestionButton.setEnabled(false);
        nextQuestionButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextQuestionButtonActionPerformed(evt);
            }
        });

        checkAnswerButton.setText("Check Answer");
        checkAnswerButton.setEnabled(false);
        checkAnswerButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkAnswerButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.setToolTipText("Click to quit and finish");
        quitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlsJPanelLayout = new javax.swing.GroupLayout(controlsJPanel);
        controlsJPanel.setLayout(controlsJPanelLayout);
        controlsJPanelLayout.setHorizontalGroup(
            controlsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsJPanelLayout.createSequentialGroup()
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAnswerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        controlsJPanelLayout.setVerticalGroup(
            controlsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(startButton)
                .addComponent(nextQuestionButton)
                .addComponent(checkAnswerButton)
                .addComponent(quitButton))
        );

        questionJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Quiz"));

        questionJLabel.setText("Question");

        selectAnswerJLabel.setText("Select Answer");

        questionJTextField.setEditable(false);

        answerChoiceTextField.setEditable(false);

        javax.swing.GroupLayout questionJPanelLayout = new javax.swing.GroupLayout(questionJPanel);
        questionJPanel.setLayout(questionJPanelLayout);
        questionJPanelLayout.setHorizontalGroup(
            questionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionJPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(questionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectAnswerJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(questionJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(questionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(questionJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(selectAnswerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerChoiceTextField))
                .addContainerGap())
        );
        questionJPanelLayout.setVerticalGroup(
            questionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionJPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(questionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionJLabel)
                    .addComponent(questionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(questionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectAnswerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectAnswerJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(answerChoiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileMenu.setText("File");
        menuBar.add(fileMenu);

        languageMenu.setText("language");

        englishMenuItem.setText("english");
        englishMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                englishMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(englishMenuItem);

        frenchMenuItem.setText("french");
        frenchMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                frenchMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(frenchMenuItem);

        germanMenuItem.setText("german");
        languageMenu.add(germanMenuItem);

        menuBar.add(languageMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controlsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userGraphicJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userGraphicJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(questionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
	startQuiz();
    }//GEN-LAST:event_startButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
	quitQuizProgram();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void checkAnswerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAnswerButtonActionPerformed
	checkAnswer();
    }//GEN-LAST:event_checkAnswerButtonActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
	loadNextQuestion();
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void englishMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_englishMenuItemActionPerformed
    {//GEN-HEADEREND:event_englishMenuItemActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_englishMenuItemActionPerformed

    private void frenchMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_frenchMenuItemActionPerformed
    {//GEN-HEADEREND:event_frenchMenuItemActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_frenchMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerChoiceTextField;
    private javax.swing.JButton checkAnswerButton;
    private javax.swing.JPanel controlsJPanel;
    private javax.swing.JMenuItem englishMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem frenchMenuItem;
    private javax.swing.JMenuItem germanMenuItem;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JLabel questionJLabel;
    private javax.swing.JPanel questionJPanel;
    private javax.swing.JTextField questionJTextField;
    private javax.swing.JButton quitButton;
    private javax.swing.JComboBox<String> selectAnswerComboBox;
    private javax.swing.JLabel selectAnswerJLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel userGraphicJLabel;
    // End of variables declaration//GEN-END:variables

}
