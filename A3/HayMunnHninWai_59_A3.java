//Full Name - Hay Munn Hnin Wai
//Tutorial - T04
//Dear Sir, This is my own work & Kindly check the code below. 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

class LuckyDraw extends JFrame
{
	//private final JTextField jtf;
	private final JButton [] buttonArray;
	private final Icon ic,ic1;
	private final String [] buttonLabel;
	private final String[] LuckyArray = new String [7];     
	private final int [] LuckyNo = new int [7];
	
	private int [] numArray = new int[49];
	
	private void initialisation()                  // For JButton C/W Images 
	{
		Random rand = new Random();
		
		for ( int i = 0; i < numArray.length;i++) //Add Images to Each of Jbuttons 
		{
			if(i % 2 == 0)
			{
				buttonArray[i] = new JButton(ic);     	
			}
			else
			{
				buttonArray[i] = new JButton(ic1);     
			
			}
			add(buttonArray[i]);	 
		}			        
	}
	private void CreateLabel ()                        //Create Labels for Each Button
	{
		for (int i = 0; i < buttonArray.length; i++)
		buttonLabel[i] = String.format("%s",i+1);     //From 1 to 49,Store in buttonLabel Array
	}
	
	private void ShuffleArray()                   // Shuffle Array for both JButton & Label
	{	
		String [] buttonNo = new String [49];
		for (int i = 0; i < buttonArray.length; i++)
		{
			buttonNo[i] = String.format ("%s",i);
			buttonLabel[i] = String.format("%s",i+1);  
				
		}
		List <String>alist = Arrays.asList(buttonNo);
		List <String>alist1 = Arrays.asList(buttonLabel);
		
		Collections.shuffle(alist);           //Shuffle the ButtonArray 
		Collections.shuffle(alist1);          //Shuffle the LabelArray 
	
	}
	private void GetLuckyNo()                 // Get 7 Lucky Nos Array 
	{
		for (int i = 0; i < LuckyArray.length; i++)
		{
			LuckyArray [i] = buttonLabel[i];               // Set ButtonLabel[i] to LuckyArray[i]
			LuckyNo[i] = Integer.parseInt(LuckyArray [i]);  //Convert LuckyArray to Int For Sorting 
			
		}
	}
	public LuckyDraw ()
	{
		super("Good Luck to you");
		setLayout (new GridLayout (7,7));           //Create GridLayout 
		
		//Initialization
		ic = new ImageIcon ("ic.png");               // Import Image1
		ic1 = new ImageIcon ("ic1.png");             // Import Image2
		buttonArray = new JButton[numArray.length];  //Jbutton Length  
		buttonLabel = new String [numArray.length];   // ButtonArray length 
		initialisation();                 //Initial JButton 
		CreateLabel(); 
		ShuffleArray();                  // ShuffleArray for Jbuttons & JLabels 
		
		GetLuckyNo();                   // Get 7 Lucky Nos   
		ShuffleArray();                 
		
		registerEvent(); 
					
	}
	private void registerEvent ()   // Register Event 
	{	
		for (int i = 0; i < numArray.length; i++)
		{
			buttonArray [i].addActionListener (new DriveDemo());
		}
	}
	
	//Private Inner Class to Handle the Events 
	private class DriveDemo implements ActionListener
	{	
		//Reset the list to Clear the Lists and Start Over 
		private void Reset ()
		{
			for (int i = 0; i < buttonArray.length; i++)
			{
				buttonArray[i].setBackground(null);         //Clear Background Colour 
				buttonArray[i].setFont(new Font("Arial",Font.BOLD,12));
				buttonArray[i].setForeground(Color.BLACK);    // Set The ForeGround to Black
			}
		}
		private void SortArray()          //Sorting the LuckyNo Arrays 
		{
			int temp = 0; 
			for (int i = 0; i < LuckyArray.length ; i++) 
			{
				for (int j = i+1; j < LuckyArray.length; j++) 
				{
					if (LuckyNo[i] > LuckyNo[j]) 
					{
						temp = LuckyNo[i];
						LuckyNo[i] = LuckyNo[j];
						LuckyNo[j] = temp;
					}
				}
			}				
		}
		@Override
		public void actionPerformed (ActionEvent e)
		{
			ShuffleArray();
			Reset();
				
			for ( int i = 0; i < numArray.length;i++)    
			{
				for ( int j = 0; j < 7 ; j ++)
				{
					if ((LuckyArray[0].equals (buttonLabel[i])))
					{
						buttonArray[i].setBackground(Color.GREEN);
						buttonArray[i].setFont(new Font("",Font.BOLD,25));
						buttonArray[i].setForeground(Color.RED);
					}
					else if (LuckyArray[j] .equals (buttonLabel[i]))
					{
						buttonArray[i].setBackground(Color.YELLOW);
						buttonArray[i].setFont(new Font("Arial",Font.BOLD,25));
							
					}
						  
				}
					//Set the buttonLabel into the button
				buttonArray[i].setText(buttonLabel[i]); 								
			}
			Icon cg = new ImageIcon ("cg1.gif");    //Import Gif File 	
			int top_prize =  LuckyNo[0];           //Set LuckyNo[0] to Top Price 
			SortArray();
				
			String str = "[";
			for ( int i = 0; i <= 6; i++)
			{
				if( LuckyNo[i] == top_prize) 
				{
					if ( i == 6 )
					str += String.format("]%n");
					
				}	
				else
				{
					if (i<5)
						str += String.format("%d, ",LuckyNo[i]);
					else if (i == 5)
						str += String.format("%d",LuckyNo[i]);
					else
						str += String.format(",%d]%n",LuckyNo[i]);
				}
			} 
			GetLuckyNo();
			str += String.format("Top prize %d",top_prize);
			JOptionPane.showMessageDialog (null, str, "Hope you enjoy the game!",
												 JOptionPane.INFORMATION_MESSAGE,cg);
		}			
	}
}	
class HayMunnHninWai_59_A3
{
	public static void main ( String[] args)
	{
		LuckyDraw d = new LuckyDraw();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setSize(450,500);
		d.setVisible(true);
		
	}
	
}
	
	
	
	