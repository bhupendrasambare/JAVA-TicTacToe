import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.ActionEvent;

public class TTT  implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_Pannel = new JPanel();
	JPanel button_Pannel = new JPanel();
	JLabel lable = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean one_turn;
	
	TTT(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		lable.setBackground(new Color(56,56,56));
		lable.setForeground(new Color(25,255,0));
		lable.setFont(new Font(Font.SANS_SERIF, Font.BOLD,40));
		lable.setHorizontalAlignment(JLabel.CENTER);
		lable.setText("Tic Tac Toe");
		lable.setOpaque(true);

		title_Pannel.setLayout(new BorderLayout());
		title_Pannel.setBounds(0,0,600,100);
		
		button_Pannel.setLayout(new GridLayout(3,3));
		button_Pannel.setBackground(new Color(150,150,50));
		
		for(int i=0;i<9;i++){
			buttons[i] = new JButton();
			button_Pannel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setForeground(new Color(245,66,66));
		}


		title_Pannel.add(lable);
		frame.add(title_Pannel,BorderLayout.NORTH);
		frame.add(button_Pannel);

		fristTurn();

	}
	@Override 
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++){
			if(e.getSource()==buttons[i]){
				if(one_turn){
					if(buttons[i].getText()==""){
						buttons[i].setForeground(new Color(255,65,65));
						buttons[i].setText("X");
						one_turn = !one_turn;
						lable.setText("O turn");
						check();
					}
				}else{
					if(buttons[i].getText()==""){
						buttons[i].setForeground(new Color(0,0,225));
						buttons[i].setText("O");
						one_turn = !one_turn;
						lable.setText("X turn");
						check();
					}
				}
			}
		}
	}

	public void fristTurn() {
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		if(random.nextInt(2)==0){
			one_turn=true;
			lable.setText("X turn");
		}
		else{
			one_turn=true;
			lable.setText("O turn");
		}
	}
	
	public void check() {
		if(
			(buttons[0].getText() == "O") &&
			(buttons[1].getText() == "O") &&
			(buttons[2].getText() == "O") 
		){
			oWin(0,1,2);
		}
		if(
			(buttons[3].getText() == "O") &&
			(buttons[4].getText() == "O") &&
			(buttons[5].getText() == "O") 
		){
			oWin(3,4,5);
		}
		if(
			(buttons[6].getText() == "O") &&
			(buttons[7].getText() == "O") &&
			(buttons[8].getText() == "O") 
		){
			oWin(6,7,8);
		}
		if(
			(buttons[0].getText() == "O") &&
			(buttons[4].getText() == "O") &&
			(buttons[8].getText() == "O") 
		){
			oWin(0,4,8);
		}if(
			(buttons[2].getText() == "O") &&
			(buttons[4].getText() == "O") &&
			(buttons[6].getText() == "O") 
		){
			oWin(2,4,6);
		}
		if(
				(buttons[0].getText() == "O") &&
						(buttons[3].getText() == "O") &&
						(buttons[6].getText() == "O")
		){
			oWin(0,3,6);
		}
		if(
				(buttons[1].getText() == "O") &&
						(buttons[4].getText() == "O") &&
						(buttons[7].getText() == "O")
		){
			oWin(1,4,7);
		}
		if(
				(buttons[8].getText() == "O") &&
						(buttons[5].getText() == "O") &&
						(buttons[2].getText() == "O")
		){
			oWin(2,5,8);
		}
		if(
			(buttons[0].getText() == "X") &&
			(buttons[1].getText() == "X") &&
			(buttons[2].getText() == "X") 
		){
			xWin(0,1,2);
		}
		if(
			(buttons[3].getText() == "X") &&
			(buttons[4].getText() == "X") &&
			(buttons[5].getText() == "X") 
		){
			xWin(3,4,5);
		}
		if(
			(buttons[6].getText() == "X") &&
			(buttons[7].getText() == "X") &&
			(buttons[8].getText() == "X") 
		){
			xWin(6,7,8);
		}
		if(
			(buttons[0].getText() == "X") &&
			(buttons[4].getText() == "X") &&
			(buttons[8].getText() == "X") 
		){
			xWin(0,4,8);
		}if(
			(buttons[2].getText() == "X") &&
			(buttons[4].getText() == "X") &&
			(buttons[6].getText() == "X") 
		){
			xWin(2,4,6);
		}
		if(
				(buttons[0].getText() == "O") &&
						(buttons[3].getText() == "O") &&
						(buttons[6].getText() == "O")
		){
			xWin(0,3,6);
		}
		if(
				(buttons[1].getText() == "O") &&
						(buttons[4].getText() == "O") &&
						(buttons[7].getText() == "O")
		){
			xWin(1,4,7);
		}
		if(
				(buttons[8].getText() == "O") &&
						(buttons[5].getText() == "O") &&
						(buttons[2].getText() == "O")
		){
			xWin(2,5,8);
		}
	}
	
	public void xWin(int a, int b, int c) {
		buttons[a].setBackground(new Color(120,240,66));
		buttons[b].setBackground(new Color(120,240,66));
		buttons[c].setBackground(new Color(120,240,66));
		for(int i=0;i<9;i++){
			buttons[i].setEnabled(false);
		}
		lable.setText("X wins");
	}
	
	public void oWin(int a, int b, int c) {
		buttons[a].setBackground(new Color(120,240,66));
		buttons[b].setBackground(new Color(120,240,66));
		buttons[c].setBackground(new Color(120,240,66));
		for(int i=0;i<9;i++){
			buttons[i].setEnabled(false);
		}
		lable.setText("O wins");
		
	}
}
