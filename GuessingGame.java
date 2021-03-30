import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
JTextField field;
JButton guess, playAgain;
JLabel prompt, feedback, lastGuess;

Random r;
int randomNum;

GuessingGame (){
  r = new Random();
  randomNum = r.nextInt(99)+1;

  JFrame frame = new JFrame("Guessing Game"); 
  frame.setLayout(new FlowLayout()); 
  frame.setSize(240, 120); 

  field = new JTextField(10);
  field.setActionCommand("myTF"); 

  guess = new JButton("Guess"); 
  playAgain = new JButton("Play Again"); 

 field.addActionListener(this); 
 guess.addActionListener(this); 
 playAgain.addActionListener(this); 

 prompt = new JLabel("Enter your guess: "); 
 feedback = new JLabel(""); 
 lastGuess = new JLabel(""); 

 frame.add(prompt);
 frame.add(field);
 frame.add(guess);
 frame.add(feedback);
 frame.add(lastGuess);
 frame.add(playAgain);

 frame.setVisible(true);

}
 public void actionPerformed (ActionEvent ae) {
   if (ae.getActionCommand().equals("Guess")){
    int userInt = Integer.parseInt(field.getText());

    if (userInt < randomNum){
      feedback.setText("Too low!");

    }
    else if (userInt > randomNum){
      feedback.setText("Too high!");
    }
    else {
      feedback.setText("You got it!");
      
    }
    lastGuess.setText("Last guess was " + userInt);
  }
  else if (ae.getActionCommand().equals("Play Again")){
    randomNum = r.nextInt(100)+1;
    prompt.setText("Enter your guess: "); 
    feedback.setText("");
   lastGuess.setText(""); 
   field.setText("");

  }
  else {
    feedback.setText("You pressed Enter. Please press the guess button.");
  }
 }


}