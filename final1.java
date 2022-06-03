package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.nio.file.FileSystemAlreadyExistsException;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;

public class final1 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final1 frame = new final1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void judge_the_result(int row,int column) {
		System.out.printf("Step%d:(%d,%d)\n",step,row,column);
		
		/*判斷禁手--雙四*/
		//黑子橫向
		for(int x=row,y=column;y>y-4;y--) {
			if(chess[x][y]!=1) break;
			else sum_black_horizontal++;
		}
		for(int x=row,y=column;y<y+4;y++) {
			if(chess[x][y]!=1) break;
			else sum_black_horizontal++;
		}
	    //黑子縱向
		for(int x=row,y=column;x>x-4;x--) {
			if(chess[x][y]!=1) break;
			else sum_black_vertical++;
		}
		for(int x=row,y=column;x<x+4;x++) {
			if(chess[x][y]!=1) break;
			else sum_black_vertical++;
		}
		//黑子反斜
		for(int x=row,y=column;x>x-4 && y>y-4;x--,y--) {
			if(chess[x][y]!=1) break;
			else sum_black_backslash++;
		}
		for(int x=row,y=column;x<x+4 && y<y+4;x++,y++) {
			if(chess[x][y]!=1) break;
			else sum_black_backslash++;
		}
		//黑子正斜
		for(int x=row,y=column;x>x-4 && y<y+4;x--,y++) {
			if(chess[x][y]!=1) break;
			else sum_black_slash++;
		}
		for(int x=row,y=column;x<x+4 && y>y-4;x++,y--) {
			if(chess[x][y]!=1) break;
			else sum_black_slash++;
		}
		
		// right to left for black
		for(int x=row,y=column;y>y-5;y--) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// right to left  for white
		for(int x=row,y=column;y>y-5;y--) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		// left to right for black
		for(int x=row,y=column;y<y+5;y++) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// left to right for white
		for(int x=row,y=column;y<y+5;y++) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		// calculate the result
		if(sum_black==6) {
			System.out.println("Black win");
			System.exit(0);
		}
		else if(sum_white>5) {
			System.out.println("White win");
			System.exit(0);
		}
		else if(sum_black>6) {
			System.out.println("White win");
			System.exit(0);
		}
		// if no result, reset the sum
		else {
			sum_black=0;
			sum_white=0;
		}
		//雙四判斷
		if(sum_black_horizontal==5) horizontal_four = true;
		if(sum_black_vertical==5) vertical_four = true;
		if(sum_black_backslash==5) backslash_four = true;
		if(sum_black_slash==5) slash_four = true;
		if((horizontal_four&&vertical_four)||(horizontal_four&&backslash_four)||(horizontal_four&&slash_four)||(vertical_four&&backslash_four)||(vertical_four&&slash_four)||(backslash_four&&slash_four)) {
			System.out.println("White win");
			System.exit(0);
		}else {
			sum_black_horizontal = 0;
			sum_black_vertical = 0;
			sum_black_backslash = 0;
			sum_black_slash = 0;
			horizontal_four = false;
			vertical_four = false;
			backslash_four = false;
			slash_four = false;
		}
			
		// down to up for black
		for(int x=row,y=column;x>x-5;x--) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// down to up for white
		for(int x=row,y=column;x>x-5;x--) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		// up to down for black
		for(int x=row,y=column;x<x+5;x++) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// up to down for white
		for(int x=row,y=column;x<x+5;x++) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		if(sum_black==6) {
			System.out.println("Black win");
			System.exit(0);
		}
		else if(sum_white>5) {
			System.out.println("White win");
			System.exit(0);
		}
		else if(sum_black>6) {
			System.out.println("White win");
			System.exit(0);
		}
		// if no result, reset the sum
		else {
			sum_black=0;
			sum_white=0;
		}
		// "\"down to up for black
		for(int x=row,y=column;x>x-5 && y>y-5;x--,y--) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// "\"down to up for white
		for(int x=row,y=column;x>x-5 && y>y-5;x--,y--) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		// "\"up to down for black
		for(int x=row,y=column;x<x+5 && y<y+5;x++,y++) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// "\"up to down for white
		for(int x=row,y=column;x<x+5 && y<y+5;x++,y++) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		if(sum_black==6) {
			System.out.println("Black win");
			System.exit(0);
		}
		else if(sum_white>5) {
			System.out.println("White win");
			System.exit(0);
		}
		else if(sum_black>6) {
			System.out.println("White win");
			System.exit(0);
		}
		// if no result, reset the sum
		else {
			sum_black=0;
			sum_white=0;
		}
		// "/"down to up for black
		for(int x=row,y=column;x>x-5 && y<y+5;x--,y++) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// "/" down to up for white
		for(int x=row,y=column;x>x-5 && y<y+5;x--,y++) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		// "/" up to down for black
		for(int x=row,y=column;x<x+5 && y>y-5;x++,y--) {
			if(chess[x][y]==0 || chess[x][y]==2) {
				break;
			}
			else if(chess[x][y]==1) {
				sum_black+=1;
			}
		}
		// "/" up to down for white
		for(int x=row,y=column;x<x+5 && y>y-5;x++,y--) {
			if(chess[x][y]==0 || chess[x][y]==1) {
				break;
			}
			else if(chess[x][y]==2) {
				sum_white+=1;
			}
		}
		if(sum_black==6) {
			System.out.println("Black win");
			System.exit(0);
		}
		else if(sum_white>5) {
			System.out.println("White win");
			System.exit(0);
		}
		else if(sum_black>6) {
			System.out.println("White win");
			System.exit(0);
		}
		// if no result, reset the sum
		else {
			sum_black=0;
			sum_white=0;
		}
	}
	private int step=0; // count the steps
	public int chess[][] = new int[14][14];
	private int sum_white=0; // count if one line goes to 5
	private int sum_black=0;
	private int sum_black_horizontal=0; 
	private int sum_black_vertical=0;
	private int sum_black_slash=0;
	private int sum_black_backslash=0;
	boolean horizontal_four = false;
    boolean vertical_four = false;
    boolean slash_four = false;
    boolean backslash_four = false;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public final1() {
		// initialize the board
		// 0 and 13 are the borderline
		for(int i=0;i<14;i++) {
			for(int j=0;j<14;j++) {
				chess[i][j]=0;
			}
		}
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
	
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 638); 
		getContentPane().setLayout(null);
		
		JButton btnNewButton1_1 = new JButton("");
		btnNewButton1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][1]==0) { // only can click once
					step+=1; 
					if(step%2==0) {
						chess[1][1]=2; // white 
						btnNewButton1_1.setBackground(Color.white);
					}
					else {
						chess[1][1]=1; // black
						btnNewButton1_1.setBackground(Color.black);
					}
					judge_the_result(1,1);
				}
			}
		});
		btnNewButton1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_1.setBounds(6, 6, 40, 40);
		getContentPane().add(btnNewButton1_1);
		
		JButton btnNewButton1_2 = new JButton("");
		btnNewButton1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][2]=2;  
						btnNewButton1_2.setBackground(Color.white);
					}
					else {
						chess[1][2]=1; 
						btnNewButton1_2.setBackground(Color.black);
					}
					judge_the_result(1,2);
				}
			}
		});
		btnNewButton1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_2.setBounds(46, 6, 40, 40);
		getContentPane().add(btnNewButton1_2);
		
		JButton btnNewButton1_3 = new JButton("");
		btnNewButton1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][3]=2;  
						btnNewButton1_3.setBackground(Color.white);					
					}
					else {
						chess[1][3]=1; 
						btnNewButton1_3.setBackground(Color.black);
					}
					judge_the_result(1,3);
				}
			}
		});
		btnNewButton1_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_3.setBounds(86, 6, 40, 40);
		getContentPane().add(btnNewButton1_3);
		
		JButton btnNewButton1_4 = new JButton("");
		btnNewButton1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][4]=2;  
						btnNewButton1_4.setBackground(Color.white);						
					}
					else {
						chess[1][4]=1; 
						btnNewButton1_4.setBackground(Color.black);
					}
					judge_the_result(1,4);
				}
			}
		});
		btnNewButton1_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_4.setBounds(126, 6, 40, 40);
		getContentPane().add(btnNewButton1_4);
		
		JButton btnNewButton1_5 = new JButton("");
		btnNewButton1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][5]=2; 
						btnNewButton1_5.setBackground(Color.white);
					}
					else {
						chess[1][5]=1; 
						btnNewButton1_5.setBackground(Color.black);						
					}
					judge_the_result(1,5);
				}
			}
		});
		btnNewButton1_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_5.setBounds(166, 6, 40, 40);
		getContentPane().add(btnNewButton1_5);
		
		JButton btnNewButton1_6 = new JButton("");
		btnNewButton1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][6]=2;  
						btnNewButton1_6.setBackground(Color.white);
					}
					else {
						chess[1][6]=1; 
						btnNewButton1_6.setBackground(Color.black);
					}
					judge_the_result(1,6);
				}
			}
		});
		btnNewButton1_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_6.setBounds(206, 6, 40, 40);
		getContentPane().add(btnNewButton1_6);
		
		JButton btnNewButton1_7 = new JButton("");
		btnNewButton1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][7]=2;  
						btnNewButton1_7.setBackground(Color.white);
					}
					else {
						chess[1][7]=1; 
						btnNewButton1_7.setBackground(Color.black);
					}
					judge_the_result(1,7);
				}
			}
		});
		btnNewButton1_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_7.setBounds(246, 6, 40, 40);
		getContentPane().add(btnNewButton1_7);
		
		JButton btnNewButton1_8 = new JButton("");
		btnNewButton1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][8]=2;  
						btnNewButton1_8.setBackground(Color.white);
					}
					else {
						chess[1][8]=1; 
						btnNewButton1_8.setBackground(Color.black);
					}
					judge_the_result(1,8);
				}
			}
		});
		btnNewButton1_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_8.setBounds(286, 6, 40, 40);
		getContentPane().add(btnNewButton1_8);
		
		JButton btnNewButton1_9 = new JButton("");
		btnNewButton1_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][9]=2;  
						btnNewButton1_9.setBackground(Color.white);
					}
					else {
						chess[1][9]=1; 
						btnNewButton1_9.setBackground(Color.black);
					}
					judge_the_result(1,9);
				}
			}
		});
		btnNewButton1_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_9.setBounds(326, 6, 40, 40);
		getContentPane().add(btnNewButton1_9);
		
		JButton btnNewButton1_10 = new JButton("");
		btnNewButton1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][10]=2;  
						btnNewButton1_10.setBackground(Color.white);
					}
					else {
						chess[1][10]=1; 
						btnNewButton1_10.setBackground(Color.black);
					}
					judge_the_result(1,10);
				}
			}
		});
		btnNewButton1_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_10.setBounds(366, 6, 40, 40);
		getContentPane().add(btnNewButton1_10);
		
		JButton btnNewButton2_1 = new JButton("");
		btnNewButton2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][1]=2;  
						btnNewButton2_1.setBackground(Color.white);
					}
					else {
						chess[2][1]=1; 
						btnNewButton2_1.setBackground(Color.black);
					}
					judge_the_result(2,1);
				}
			}
		});
		btnNewButton2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_1.setBounds(6, 46, 40, 40);
		getContentPane().add(btnNewButton2_1);
		
		JButton btnNewButton2_2 = new JButton("");
		btnNewButton2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][2]=2;  
						btnNewButton2_2.setBackground(Color.white);
					}
					else {
						chess[2][2]=1; 
						btnNewButton2_2.setBackground(Color.black);
					}
					judge_the_result(2,2);
				}
			}
		});
		btnNewButton2_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_2.setBounds(46, 46, 40, 40);
		getContentPane().add(btnNewButton2_2);
		
		JButton btnNewButton2_3 = new JButton("");
		btnNewButton2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][3]=2;  
						btnNewButton2_3.setBackground(Color.white);
					}
					else {
						chess[2][3]=1; 
						btnNewButton2_3.setBackground(Color.black);
					}
					judge_the_result(2,3);
				}
			}
		});
		btnNewButton2_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_3.setBounds(86, 46, 40, 40);
		getContentPane().add(btnNewButton2_3);
		
		JButton btnNewButton2_4 = new JButton("");
		btnNewButton2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][4]=2;  
						btnNewButton2_4.setBackground(Color.white);
					}
					else {
						chess[2][4]=1; 
						btnNewButton2_4.setBackground(Color.black);
					}
					judge_the_result(2,4);
				}
			}
		});
		btnNewButton2_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_4.setBounds(126, 46, 40, 40);
		getContentPane().add(btnNewButton2_4);
		
		JButton btnNewButton2_5 = new JButton("");
		btnNewButton2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][5]=2;  
						btnNewButton2_5.setBackground(Color.white);
					}
					else {
						chess[2][5]=1; 
						btnNewButton2_5.setBackground(Color.black);
					}
					judge_the_result(2,5);
				}
			}
		});
		btnNewButton2_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_5.setBounds(166, 46, 40, 40);
		getContentPane().add(btnNewButton2_5);
		
		JButton btnNewButton2_6 = new JButton("");
		btnNewButton2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][6]=2;  
						btnNewButton2_6.setBackground(Color.white);
					}
					else {
						chess[2][6]=1; 
						btnNewButton2_6.setBackground(Color.black);
					}
					judge_the_result(2,6);
				}
			}
		});
		btnNewButton2_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_6.setBounds(206, 46, 40, 40);
		getContentPane().add(btnNewButton2_6);
		
		JButton btnNewButton2_7 = new JButton("");
		btnNewButton2_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][7]=2;  
						btnNewButton2_7.setBackground(Color.white);
					}
					else {
						chess[2][7]=1; 
						btnNewButton2_7.setBackground(Color.black);
					}
					judge_the_result(2,7);
				}
			}
		});
		btnNewButton2_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_7.setBounds(246, 46, 40, 40);
		getContentPane().add(btnNewButton2_7);
		
		JButton btnNewButton2_8 = new JButton("");
		btnNewButton2_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][8]=2;  
						btnNewButton2_8.setBackground(Color.white);
					}
					else {
						chess[2][8]=1; 
						btnNewButton2_8.setBackground(Color.black);
					}
					judge_the_result(2,8);
				}
			}
		});
		btnNewButton2_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_8.setBounds(286, 46, 40, 40);
		getContentPane().add(btnNewButton2_8);
		
		JButton btnNewButton2_9 = new JButton("");
		btnNewButton2_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][9]=2;  
						btnNewButton2_9.setBackground(Color.white);
					}
					else {
						chess[2][9]=1; 
						btnNewButton2_9.setBackground(Color.black);
					}
					judge_the_result(2,9);
				}
			}
		});
		btnNewButton2_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_9.setBounds(326, 46, 40, 40);
		getContentPane().add(btnNewButton2_9);
		
		JButton btnNewButton2_10 = new JButton("");
		btnNewButton2_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][10]=2;  
						btnNewButton2_10.setBackground(Color.white);
					}
					else {
						chess[2][10]=1; 
						btnNewButton2_10.setBackground(Color.black);
					}
					judge_the_result(2,10);
				}
			}
		});
		btnNewButton2_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_10.setBounds(366, 46, 40, 40);
		getContentPane().add(btnNewButton2_10);
		
		JButton btnNewButton3_1 = new JButton("");
		btnNewButton3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][1]=2;  
						btnNewButton3_1.setBackground(Color.white);
					}
					else {
						chess[3][1]=1; 
						btnNewButton3_1.setBackground(Color.black);
					}
					judge_the_result(3,1);
				}
			}
		});
		btnNewButton3_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_1.setBounds(6, 86, 40, 40);
		getContentPane().add(btnNewButton3_1);
		
		JButton btnNewButton3_2 = new JButton("");
		btnNewButton3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][2]=2;  
						btnNewButton3_2.setBackground(Color.white);
					}
					else {
						chess[3][2]=1; 
						btnNewButton3_2.setBackground(Color.black);
					}
					judge_the_result(3,2);
				}
			}
		});
		btnNewButton3_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_2.setBounds(46, 86, 40, 40);
		getContentPane().add(btnNewButton3_2);
		
		JButton btnNewButton3_3 = new JButton("");
		btnNewButton3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][3]=2;  
						btnNewButton3_3.setBackground(Color.white);
					}
					else {
						chess[3][3]=1; 
						btnNewButton3_3.setBackground(Color.black);
					}
					judge_the_result(3,3);
				}
			}
		});
		btnNewButton3_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_3.setBounds(86, 86, 40, 40);
		getContentPane().add(btnNewButton3_3);
		
		JButton btnNewButton3_4 = new JButton("");
		btnNewButton3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][4]=2;  
						btnNewButton3_4.setBackground(Color.white);
					}
					else {
						chess[3][4]=1; 
						btnNewButton3_4.setBackground(Color.black);
					}
					judge_the_result(3,4);
				}
			}
		});
		btnNewButton3_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_4.setBounds(126, 86, 40, 40);
		getContentPane().add(btnNewButton3_4);
		
		JButton btnNewButton3_5 = new JButton("");
		btnNewButton3_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][5]=2;  
						btnNewButton3_5.setBackground(Color.white);
					}
					else {
						chess[3][5]=1; 
						btnNewButton3_5.setBackground(Color.black);
					}
					judge_the_result(3,5);
				}
			}
		});
		btnNewButton3_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_5.setBounds(166, 86, 40, 40);
		getContentPane().add(btnNewButton3_5);
		
		JButton btnNewButton3_6 = new JButton("");
		btnNewButton3_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][6]=2;  
						btnNewButton3_6.setBackground(Color.white);
					}
					else {
						chess[3][6]=1; 
						btnNewButton3_6.setBackground(Color.black);
					}
					judge_the_result(3,6);
				}
			}
		});
		btnNewButton3_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_6.setBounds(206, 86, 40, 40);
		getContentPane().add(btnNewButton3_6);
		
		JButton btnNewButton3_7 = new JButton("");
		btnNewButton3_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][7]=2;  
						btnNewButton3_7.setBackground(Color.white);
					}
					else {
						chess[3][7]=1; 
						btnNewButton3_7.setBackground(Color.black);
					}
					judge_the_result(3,7);
				}
			}
		});
		btnNewButton3_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_7.setBounds(246, 86, 40, 40);
		getContentPane().add(btnNewButton3_7);
		
		JButton btnNewButton3_8 = new JButton("");
		btnNewButton3_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][8]=2;  
						btnNewButton3_8.setBackground(Color.white);
					}
					else {
						chess[3][8]=1; 
						btnNewButton3_8.setBackground(Color.black);
					}
					judge_the_result(3,8);
				}
			}
		});
		btnNewButton3_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_8.setBounds(286, 86, 40, 40);
		getContentPane().add(btnNewButton3_8);
		
		JButton btnNewButton3_9 = new JButton("");
		btnNewButton3_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][9]=2;  
						btnNewButton3_9.setBackground(Color.white);
					}
					else {
						chess[3][9]=1; 
						btnNewButton3_9.setBackground(Color.black);
					}
					judge_the_result(3,9);
				}
			}
		});
		btnNewButton3_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_9.setBounds(326, 86, 40, 40);
		getContentPane().add(btnNewButton3_9);
		
		JButton btnNewButton3_10 = new JButton("");
		btnNewButton3_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][10]=2;  
						btnNewButton3_10.setBackground(Color.white);
					}
					else {
						chess[3][10]=1; 
						btnNewButton3_10.setBackground(Color.black);
					}
					judge_the_result(3,10);
				}
			}
		});
		btnNewButton3_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_10.setBounds(366, 86, 40, 40);
		getContentPane().add(btnNewButton3_10);
		
		JButton btnNewButton4_1 = new JButton("");
		btnNewButton4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][1]=2;  
						btnNewButton4_1.setBackground(Color.white);
					}
					else {
						chess[4][1]=1; 
						btnNewButton4_1.setBackground(Color.black);
					}
					judge_the_result(4,1);
				}
			}
		});
		btnNewButton4_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_1.setBounds(6, 126, 40, 40);
		getContentPane().add(btnNewButton4_1);
		
		JButton btnNewButton4_2 = new JButton("");
		btnNewButton4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][2]=2;  
						btnNewButton4_2.setBackground(Color.white);
					}
					else {
						chess[4][2]=1; 
						btnNewButton4_2.setBackground(Color.black);
					}
					judge_the_result(4,2);
				}
			}
		});
		btnNewButton4_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_2.setBounds(46, 126, 40, 40);
		getContentPane().add(btnNewButton4_2);
		
		JButton btnNewButton4_3 = new JButton("");
		btnNewButton4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][3]=2;  
						btnNewButton4_3.setBackground(Color.white);
					}
					else {
						chess[4][3]=1; 
						btnNewButton4_3.setBackground(Color.black);
					}
					judge_the_result(4,3);
				}
			}
		});
		btnNewButton4_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_3.setBounds(86, 126, 40, 40);
		getContentPane().add(btnNewButton4_3);
		
		JButton btnNewButton4_4 = new JButton("");
		btnNewButton4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][4]=2;  
						btnNewButton4_4.setBackground(Color.white);
					}
					else {
						chess[4][4]=1; 
						btnNewButton4_4.setBackground(Color.black);
					}
					judge_the_result(4,4);
				}
			}
		});
		btnNewButton4_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_4.setBounds(126, 126, 40, 40);
		getContentPane().add(btnNewButton4_4);
		
		JButton btnNewButton4_5 = new JButton("");
		btnNewButton4_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][5]=2;  
						btnNewButton4_5.setBackground(Color.white);
					}
					else {
						chess[4][5]=1; 
						btnNewButton4_5.setBackground(Color.black);
					}
					judge_the_result(4,5);
				}
			}
		});
		btnNewButton4_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_5.setBounds(166, 126, 40, 40);
		getContentPane().add(btnNewButton4_5);
		
		JButton btnNewButton4_6 = new JButton("");
		btnNewButton4_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][6]=2;  
						btnNewButton4_6.setBackground(Color.white);
					}
					else {
						chess[4][6]=1; 
						btnNewButton4_6.setBackground(Color.black);
					}
					judge_the_result(4,6);
				}
			}
		});
		btnNewButton4_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_6.setBounds(206, 126, 40, 40);
		getContentPane().add(btnNewButton4_6);
		
		JButton btnNewButton4_7 = new JButton("");
		btnNewButton4_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][7]=2;  
						btnNewButton4_7.setBackground(Color.white);
					}
					else {
						chess[4][7]=1; 
						btnNewButton4_7.setBackground(Color.black);
					}
					judge_the_result(4,7);
				}
			}
		});
		btnNewButton4_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_7.setBounds(246, 126, 40, 40);
		getContentPane().add(btnNewButton4_7);
		
		JButton btnNewButton4_8 = new JButton("");
		btnNewButton4_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][8]=2;  
						btnNewButton4_8.setBackground(Color.white);
					}
					else {
						chess[4][8]=1; 
						btnNewButton4_8.setBackground(Color.black);
					}
					judge_the_result(4,8);
				}
			}
		});
		btnNewButton4_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_8.setBounds(286, 126, 40, 40);
		getContentPane().add(btnNewButton4_8);
		
		JButton btnNewButton4_9 = new JButton("");
		btnNewButton4_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][9]=2;  
						btnNewButton4_9.setBackground(Color.white);
					}
					else {
						chess[4][9]=1; 
						btnNewButton4_9.setBackground(Color.black);
					}
					judge_the_result(4,9);
				}
			}
		});
		btnNewButton4_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_9.setBounds(326, 126, 40, 40);
		getContentPane().add(btnNewButton4_9);
		
		JButton btnNewButton4_10 = new JButton("");
		btnNewButton4_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][10]=2;  
						btnNewButton4_10.setBackground(Color.white);
					}
					else {
						chess[4][10]=1; 
						btnNewButton4_10.setBackground(Color.black);
					}
					judge_the_result(4,10);
				}
			}
		});
		btnNewButton4_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_10.setBounds(366, 126, 40, 40);
		getContentPane().add(btnNewButton4_10);
		
		JButton btnNewButton5_1 = new JButton("");
		btnNewButton5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][1]=2;  
						btnNewButton5_1.setBackground(Color.white);
					}
					else {
						chess[5][1]=1; 
						btnNewButton5_1.setBackground(Color.black);
					}
					judge_the_result(5,1);
				}
			}
		});
		btnNewButton5_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_1.setBounds(6, 166, 40, 40);
		getContentPane().add(btnNewButton5_1);
		
		JButton btnNewButton5_2 = new JButton("");
		btnNewButton5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][2]=2;  
						btnNewButton5_2.setBackground(Color.white);
					}
					else {
						chess[5][2]=1; 
						btnNewButton5_2.setBackground(Color.black);
					}
					judge_the_result(5,2);
				}
			}
		});
		btnNewButton5_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_2.setBounds(46, 166, 40, 40);
		getContentPane().add(btnNewButton5_2);
		
		JButton btnNewButton5_3 = new JButton("");
		btnNewButton5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][3]=2;  
						btnNewButton5_3.setBackground(Color.white);
					}
					else {
						chess[5][3]=1; 
						btnNewButton5_3.setBackground(Color.black);
					}
					judge_the_result(5,3);
				}
			}
		});
		btnNewButton5_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_3.setBounds(86, 166, 40, 40);
		getContentPane().add(btnNewButton5_3);
		
		JButton btnNewButton5_4 = new JButton("");
		btnNewButton5_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][4]=2;  
						btnNewButton5_4.setBackground(Color.white);
					}
					else {
						chess[5][4]=1; 
						btnNewButton5_4.setBackground(Color.black);
					}
					judge_the_result(5,4);
				}
			}
		});
		btnNewButton5_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_4.setBounds(126, 166, 40, 40);
		getContentPane().add(btnNewButton5_4);
		
		JButton btnNewButton5_5 = new JButton("");
		btnNewButton5_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][5]=2;  
						btnNewButton5_5.setBackground(Color.white);
					}
					else {
						chess[5][5]=1; 
						btnNewButton5_5.setBackground(Color.black);
					}
					judge_the_result(5,5);
				}
			}
		});
		btnNewButton5_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_5.setBounds(166, 166, 40, 40);
		getContentPane().add(btnNewButton5_5);
		
		JButton btnNewButton5_6 = new JButton("");
		btnNewButton5_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][6]=2;  
						btnNewButton5_6.setBackground(Color.white);
					}
					else {
						chess[5][6]=1; 
						btnNewButton5_6.setBackground(Color.black);
					}
					judge_the_result(5,6);
				}
			}
		});
		btnNewButton5_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_6.setBounds(206, 166, 40, 40);
		getContentPane().add(btnNewButton5_6);
		
		JButton btnNewButton5_7 = new JButton("");
		btnNewButton5_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][7]=2;  
						btnNewButton5_7.setBackground(Color.white);
					}
					else {
						chess[5][7]=1; 
						btnNewButton5_7.setBackground(Color.black);
					}
					judge_the_result(5,7);
				}
			}
		});
		btnNewButton5_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_7.setBounds(246, 166, 40, 40);
		getContentPane().add(btnNewButton5_7);
		
		JButton btnNewButton5_8 = new JButton("");
		btnNewButton5_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][8]=2;  
						btnNewButton5_8.setBackground(Color.white);
					}
					else {
						chess[5][8]=1; 
						btnNewButton5_8.setBackground(Color.black);
					}
					judge_the_result(5,8);
				}
			}
		});
		btnNewButton5_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_8.setBounds(286, 166, 40, 40);
		getContentPane().add(btnNewButton5_8);
		
		JButton btnNewButton5_9 = new JButton("");
		btnNewButton5_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][9]=2;  
						btnNewButton5_9.setBackground(Color.white);
					}
					else {
						chess[5][9]=1; 
						btnNewButton5_9.setBackground(Color.black);
					}
					judge_the_result(5,9);
				}
			}
		});
		btnNewButton5_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_9.setBounds(326, 166, 40, 40);
		getContentPane().add(btnNewButton5_9);
		
		JButton btnNewButton5_10 = new JButton("");
		btnNewButton5_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][10]=2;  
						btnNewButton5_10.setBackground(Color.white);
					}
					else {
						chess[5][10]=1; 
						btnNewButton5_10.setBackground(Color.black);
					}
					judge_the_result(5,10);
				}
			}
		});
		btnNewButton5_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_10.setBounds(366, 166, 40, 40);
		getContentPane().add(btnNewButton5_10);
		
		JButton btnNewButton6_1 = new JButton("");
		btnNewButton6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][1]=2;  
						btnNewButton6_1.setBackground(Color.white);
					}
					else {
						chess[6][1]=1; 
						btnNewButton6_1.setBackground(Color.black);
					}
					judge_the_result(6,1);
				}
			}
		});
		btnNewButton6_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_1.setBounds(6, 206, 40, 40);
		getContentPane().add(btnNewButton6_1);
		
		JButton btnNewButton6_2 = new JButton("");
		btnNewButton6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][2]=2;  
						btnNewButton6_2.setBackground(Color.white);
					}
					else {
						chess[6][2]=1; 
						btnNewButton6_2.setBackground(Color.black);
					}
					judge_the_result(6,2);
				}
			}
		});
		btnNewButton6_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_2.setBounds(46, 206, 40, 40);
		getContentPane().add(btnNewButton6_2);
		
		JButton btnNewButton6_3 = new JButton("");
		btnNewButton6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][3]=2;  
						btnNewButton6_3.setBackground(Color.white);
					}
					else {
						chess[6][3]=1; 
						btnNewButton6_3.setBackground(Color.black);
					}
					judge_the_result(6,3);
				}
			}
		});
		btnNewButton6_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_3.setBounds(86, 206, 40, 40);
		getContentPane().add(btnNewButton6_3);
		
		JButton btnNewButton6_4 = new JButton("");
		btnNewButton6_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][4]=2;  
						btnNewButton6_4.setBackground(Color.white);
					}
					else {
						chess[6][4]=1; 
						btnNewButton6_4.setBackground(Color.black);
					}
					judge_the_result(6,4);
				}
			}
		});
		btnNewButton6_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_4.setBounds(126, 206, 40, 40);
		getContentPane().add(btnNewButton6_4);
		
		JButton btnNewButton6_5 = new JButton("");
		btnNewButton6_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][5]=2;  
						btnNewButton6_5.setBackground(Color.white);
					}
					else {
						chess[6][5]=1; 
						btnNewButton6_5.setBackground(Color.black);
					}
					judge_the_result(6,5);
				}
			}
		});
		btnNewButton6_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_5.setBounds(166, 206, 40, 40);
		getContentPane().add(btnNewButton6_5);
		
		JButton btnNewButton6_6 = new JButton("");
		btnNewButton6_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][6]=2;  
						btnNewButton6_6.setBackground(Color.white);
					}
					else {
						chess[6][6]=1; 
						btnNewButton6_6.setBackground(Color.black);
					}
					judge_the_result(6,6);
				}
			}
		});
		btnNewButton6_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_6.setBounds(206, 206, 40, 40);
		getContentPane().add(btnNewButton6_6);
		
		JButton btnNewButton6_7 = new JButton("");
		btnNewButton6_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][7]=2;  
						btnNewButton6_7.setBackground(Color.white);
					}
					else {
						chess[6][7]=1; 
						btnNewButton6_7.setBackground(Color.black);
					}
					judge_the_result(6,7);
				}
			}
		});
		btnNewButton6_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_7.setBounds(246, 206, 40, 40);
		getContentPane().add(btnNewButton6_7);
		
		JButton btnNewButton6_8 = new JButton("");
		btnNewButton6_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][8]=2;  
						btnNewButton6_8.setBackground(Color.white);
					}
					else {
						chess[6][8]=1; 
						btnNewButton6_8.setBackground(Color.black);
					}
					judge_the_result(6,8);
				}
			}
		});
		btnNewButton6_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_8.setBounds(286, 206, 40, 40);
		getContentPane().add(btnNewButton6_8);
		
		JButton btnNewButton6_9 = new JButton("");
		btnNewButton6_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][9]=2;  
						btnNewButton6_9.setBackground(Color.white);
					}
					else {
						chess[6][9]=1; 
						btnNewButton6_9.setBackground(Color.black);
					}
					judge_the_result(6,9);
				}
			}
		});
		btnNewButton6_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_9.setBounds(326, 206, 40, 40);
		getContentPane().add(btnNewButton6_9);
		
		JButton btnNewButton6_10 = new JButton("");
		btnNewButton6_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][10]=2;  
						btnNewButton6_10.setBackground(Color.white);
					}
					else {
						chess[6][10]=1; 
						btnNewButton6_10.setBackground(Color.black);
					}
					judge_the_result(6,10);
				}
			}
		});
		btnNewButton6_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_10.setBounds(366, 206, 40, 40);
		getContentPane().add(btnNewButton6_10);
		
		JButton btnNewButton7_1 = new JButton("");
		btnNewButton7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][1]=2;  
						btnNewButton7_1.setBackground(Color.white);
					}
					else {
						chess[7][1]=1; 
						btnNewButton7_1.setBackground(Color.black);
					}
					judge_the_result(7,1);
				}
			}
		});
		btnNewButton7_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_1.setBounds(6, 246, 40, 40);
		getContentPane().add(btnNewButton7_1);
		
		JButton btnNewButton7_2 = new JButton("");
		btnNewButton7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][2]=2;  
						btnNewButton7_2.setBackground(Color.white);
					}
					else {
						chess[7][2]=1; 
						btnNewButton7_2.setBackground(Color.black);
					}
					judge_the_result(7,2);
				}
			}
		});
		btnNewButton7_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_2.setBounds(46, 246, 40, 40);
		getContentPane().add(btnNewButton7_2);
		
		JButton btnNewButton7_3 = new JButton("");
		btnNewButton7_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][3]=2;  
						btnNewButton7_3.setBackground(Color.white);
					}
					else {
						chess[7][3]=1; 
						btnNewButton7_3.setBackground(Color.black);
					}
					judge_the_result(7,3);
				}
			}
		});
		btnNewButton7_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_3.setBounds(86, 246, 40, 40);
		getContentPane().add(btnNewButton7_3);
		
		JButton btnNewButton7_4 = new JButton("");
		btnNewButton7_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][4]=2;  
						btnNewButton7_4.setBackground(Color.white);
					}
					else {
						chess[7][4]=1; 
						btnNewButton7_4.setBackground(Color.black);
					}
					judge_the_result(7,4);
				}
			}
		});
		btnNewButton7_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_4.setBounds(126, 246, 40, 40);
		getContentPane().add(btnNewButton7_4);
		
		JButton btnNewButton7_5 = new JButton("");
		btnNewButton7_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][5]=2;  
						btnNewButton7_5.setBackground(Color.white);
					}
					else {
						chess[7][5]=1; 
						btnNewButton7_5.setBackground(Color.black);
					}
					judge_the_result(7,5);
				}
			}
		});
		btnNewButton7_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_5.setBounds(166, 246, 40, 40);
		getContentPane().add(btnNewButton7_5);
		
		JButton btnNewButton7_6 = new JButton("");
		btnNewButton7_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][6]=2;  
						btnNewButton7_6.setBackground(Color.white);
					}
					else {
						chess[7][6]=1; 
						btnNewButton7_6.setBackground(Color.black);
					}
					judge_the_result(7,6);
				}
			}
		});
		btnNewButton7_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_6.setBounds(206, 246, 40, 40);
		getContentPane().add(btnNewButton7_6);
		
		JButton btnNewButton7_7 = new JButton("");
		btnNewButton7_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][7]=2;  
						btnNewButton7_7.setBackground(Color.white);
					}
					else {
						chess[7][7]=1; 
						btnNewButton7_7.setBackground(Color.black);
					}
					judge_the_result(7,7);
				}
			}
		});
		btnNewButton7_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_7.setBounds(246, 246, 40, 40);
		getContentPane().add(btnNewButton7_7);
		
		JButton btnNewButton7_8 = new JButton("");
		btnNewButton7_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][8]=2;  
						btnNewButton7_8.setBackground(Color.white);
					}
					else {
						chess[7][8]=1; 
						btnNewButton7_8.setBackground(Color.black);
					}
					judge_the_result(7,8);
				}
			}
		});
		btnNewButton7_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_8.setBounds(286, 246, 40, 40);
		getContentPane().add(btnNewButton7_8);
		
		JButton btnNewButton7_9 = new JButton("");
		btnNewButton7_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][9]=2;  
						btnNewButton7_9.setBackground(Color.white);
					}
					else {
						chess[7][9]=1; 
						btnNewButton7_9.setBackground(Color.black);
					}
					judge_the_result(7,9);
				}
			}
		});
		btnNewButton7_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_9.setBounds(326, 246, 40, 40);
		getContentPane().add(btnNewButton7_9);
		
		JButton btnNewButton7_10 = new JButton("");
		btnNewButton7_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][10]=2;  
						btnNewButton7_10.setBackground(Color.white);
					}
					else {
						chess[7][10]=1; 
						btnNewButton7_10.setBackground(Color.black);
					}
					judge_the_result(7,10);
				}
			}
		});
		btnNewButton7_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_10.setBounds(366, 246, 40, 40);
		getContentPane().add(btnNewButton7_10);
		
		JButton btnNewButton8_1 = new JButton("");
		btnNewButton8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][1]=2;  
						btnNewButton8_1.setBackground(Color.white);
					}
					else {
						chess[8][1]=1; 
						btnNewButton8_1.setBackground(Color.black);
					}
					judge_the_result(8,1);
				}
			}
		});
		btnNewButton8_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_1.setBounds(6, 286, 40, 40);
		getContentPane().add(btnNewButton8_1);
		
		JButton btnNewButton8_2 = new JButton("");
		btnNewButton8_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][2]=2;  
						btnNewButton8_2.setBackground(Color.white);
					}
					else {
						chess[8][2]=1; 
						btnNewButton8_2.setBackground(Color.black);
					}
					judge_the_result(8,2);
				}
			}
		});
		btnNewButton8_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_2.setBounds(46, 286, 40, 40);
		getContentPane().add(btnNewButton8_2);
		
		JButton btnNewButton8_3 = new JButton("");
		btnNewButton8_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][3]=2;  
						btnNewButton8_3.setBackground(Color.white);
					}
					else {
						chess[8][3]=1; 
						btnNewButton8_3.setBackground(Color.black);
					}
					judge_the_result(8,3);
				}
			}
		});
		btnNewButton8_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_3.setBounds(86, 286, 40, 40);
		getContentPane().add(btnNewButton8_3);
		
		JButton btnNewButton8_4 = new JButton("");
		btnNewButton8_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][4]=2;  
						btnNewButton8_4.setBackground(Color.white);
					}
					else {
						chess[8][4]=1; 
						btnNewButton8_4.setBackground(Color.black);
					}
					judge_the_result(8,4);
				}
			}
		});
		btnNewButton8_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_4.setBounds(126, 286, 40, 40);
		getContentPane().add(btnNewButton8_4);
		
		JButton btnNewButton8_5 = new JButton("");
		btnNewButton8_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][5]=2;  
						btnNewButton8_5.setBackground(Color.white);
					}
					else {
						chess[8][5]=1; 
						btnNewButton8_5.setBackground(Color.black);
					}
					judge_the_result(8,5);
				}
			}
		});
		btnNewButton8_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_5.setBounds(166, 286, 40, 40);
		getContentPane().add(btnNewButton8_5);
		
		JButton btnNewButton8_6 = new JButton("");
		btnNewButton8_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][6]=2;  
						btnNewButton8_6.setBackground(Color.white);
					}
					else {
						chess[8][6]=1; 
						btnNewButton8_6.setBackground(Color.black);
					}
					judge_the_result(8,6);
				}
			}
		});
		btnNewButton8_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_6.setBounds(206, 286, 40, 40);
		getContentPane().add(btnNewButton8_6);
		
		JButton btnNewButton8_7 = new JButton("");
		btnNewButton8_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][7]=2;  
						btnNewButton8_7.setBackground(Color.white);
					}
					else {
						chess[8][7]=1; 
						btnNewButton8_7.setBackground(Color.black);
					}
					judge_the_result(8,7);
				}
			}
		});
		btnNewButton8_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_7.setBounds(246, 286, 40, 40);
		getContentPane().add(btnNewButton8_7);
		
		JButton btnNewButton8_8 = new JButton("");
		btnNewButton8_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][8]=2;  
						btnNewButton8_8.setBackground(Color.white);
					}
					else {
						chess[8][8]=1; 
						btnNewButton8_8.setBackground(Color.black);
					}
					judge_the_result(8,8);
				}
			}
		});
		btnNewButton8_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_8.setBounds(286, 286, 40, 40);
		getContentPane().add(btnNewButton8_8);
		
		JButton btnNewButton8_9 = new JButton("");
		btnNewButton8_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][9]=2;  
						btnNewButton8_9.setBackground(Color.white);
					}
					else {
						chess[8][9]=1; 
						btnNewButton8_9.setBackground(Color.black);
					}
					judge_the_result(8,9);
				}
			}
		});
		btnNewButton8_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_9.setBounds(326, 286, 40, 40);
		getContentPane().add(btnNewButton8_9);
		
		JButton btnNewButton8_10 = new JButton("");
		btnNewButton8_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][10]=2;  
						btnNewButton8_10.setBackground(Color.white);
					}
					else {
						chess[8][10]=1; 
						btnNewButton8_10.setBackground(Color.black);
					}
					judge_the_result(8,10);
				}
			}
		});
		btnNewButton8_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_10.setBounds(366, 286, 40, 40);
		getContentPane().add(btnNewButton8_10);
		
		JButton btnNewButton9_1 = new JButton("");
		btnNewButton9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][1]=2;  
						btnNewButton9_1.setBackground(Color.white);
					}
					else {
						chess[9][1]=1; 
						btnNewButton9_1.setBackground(Color.black);
					}
					judge_the_result(9,1);
				}
			}
		});
		btnNewButton9_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_1.setBounds(6, 326, 40, 40);
		getContentPane().add(btnNewButton9_1);
		
		JButton btnNewButton9_2 = new JButton("");
		btnNewButton9_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][2]=2;  
						btnNewButton9_2.setBackground(Color.white);
					}
					else {
						chess[9][2]=1; 
						btnNewButton9_2.setBackground(Color.black);
					}
					judge_the_result(9,2);
				}
			}
		});
		btnNewButton9_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_2.setBounds(46, 326, 40, 40);
		getContentPane().add(btnNewButton9_2);
		
		JButton btnNewButton9_3 = new JButton("");
		btnNewButton9_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][3]=2;  
						btnNewButton9_3.setBackground(Color.white);
					}
					else {
						chess[9][3]=1; 
						btnNewButton9_3.setBackground(Color.black);
					}
					judge_the_result(9,3);
				}
			}
		});
		btnNewButton9_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_3.setBounds(86, 326, 40, 40);
		getContentPane().add(btnNewButton9_3);
		
		JButton btnNewButton9_4 = new JButton("");
		btnNewButton9_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][4]=2;  
						btnNewButton9_4.setBackground(Color.white);
					}
					else {
						chess[9][4]=1; 
						btnNewButton9_4.setBackground(Color.black);
					}
					judge_the_result(9,4);
				}
			}
		});
		btnNewButton9_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_4.setBounds(126, 326, 40, 40);
		getContentPane().add(btnNewButton9_4);
		
		JButton btnNewButton9_5 = new JButton("");
		btnNewButton9_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][5]=2;  
						btnNewButton9_5.setBackground(Color.white);
					}
					else {
						chess[9][5]=1; 
						btnNewButton9_5.setBackground(Color.black);
					}
					judge_the_result(9,5);
				}
			}
		});
		btnNewButton9_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_5.setBounds(166, 326, 40, 40);
		getContentPane().add(btnNewButton9_5);
		
		JButton btnNewButton9_6 = new JButton("");
		btnNewButton9_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][6]=2;  
						btnNewButton9_6.setBackground(Color.white);
					}
					else {
						chess[9][6]=1; 
						btnNewButton9_6.setBackground(Color.black);
					}
					judge_the_result(9,6);
				}
			}
		});
		btnNewButton9_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_6.setBounds(206, 326, 40, 40);
		getContentPane().add(btnNewButton9_6);
		
		JButton btnNewButton9_7 = new JButton("");
		btnNewButton9_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][7]=2;  
						btnNewButton9_7.setBackground(Color.white);
					}
					else {
						chess[9][7]=1; 
						btnNewButton9_7.setBackground(Color.black);
					}
					judge_the_result(9,7);
				}
			}
		});
		btnNewButton9_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_7.setBounds(246, 326, 40, 40);
		getContentPane().add(btnNewButton9_7);
		
		JButton btnNewButton9_8 = new JButton("");
		btnNewButton9_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][8]=2;  
						btnNewButton9_8.setBackground(Color.white);
					}
					else {
						chess[9][8]=1; 
						btnNewButton9_8.setBackground(Color.black);
					}
					judge_the_result(9,8);
				}
			}
		});
		btnNewButton9_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_8.setBounds(286, 326, 40, 40);
		getContentPane().add(btnNewButton9_8);
		
		JButton btnNewButton9_9 = new JButton("");
		btnNewButton9_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][9]=2;  
						btnNewButton9_9.setBackground(Color.white);
					}
					else {
						chess[9][9]=1; 
						btnNewButton9_9.setBackground(Color.black);
					}
					judge_the_result(9,9);
				}
			}
		});
		btnNewButton9_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_9.setBounds(326, 326, 40, 40);
		getContentPane().add(btnNewButton9_9);
		
		JButton btnNewButton9_10 = new JButton("");
		btnNewButton9_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][10]=2;  
						btnNewButton9_10.setBackground(Color.white);
					}
					else {
						chess[9][10]=1; 
						btnNewButton9_10.setBackground(Color.black);
					}
					judge_the_result(9,10);
				}
			}
		});
		btnNewButton9_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_10.setBounds(366, 326, 40, 40);
		getContentPane().add(btnNewButton9_10);
		
		JButton btnNewButton10_1 = new JButton("");
		btnNewButton10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][1]=2;  
						btnNewButton10_1.setBackground(Color.white);
					}
					else {
						chess[10][1]=1; 
						btnNewButton10_1.setBackground(Color.black);
					}
					judge_the_result(10,1);
				}
			}
		});
		btnNewButton10_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_1.setBounds(6, 366, 40, 40);
		getContentPane().add(btnNewButton10_1);
		
		JButton btnNewButton10_2 = new JButton("");
		btnNewButton10_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][2]=2;  
						btnNewButton10_2.setBackground(Color.white);
					}
					else {
						chess[10][2]=1; 
						btnNewButton10_2.setBackground(Color.black);
					}
					judge_the_result(10,2);
				}
			}
		});
		btnNewButton10_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_2.setBounds(46, 366, 40, 40);
		getContentPane().add(btnNewButton10_2);
		
		JButton btnNewButton10_3 = new JButton("");
		btnNewButton10_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][3]=2;  
						btnNewButton10_3.setBackground(Color.white);
					}
					else {
						chess[10][3]=1; 
						btnNewButton10_3.setBackground(Color.black);
					}
					judge_the_result(10,3);
				}
			}
		});
		btnNewButton10_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_3.setBounds(86, 366, 40, 40);
		getContentPane().add(btnNewButton10_3);
		
		JButton btnNewButton10_4 = new JButton("");
		btnNewButton10_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][4]=2;  
						btnNewButton10_4.setBackground(Color.white);
					}
					else {
						chess[10][4]=1; 
						btnNewButton10_4.setBackground(Color.black);
					}
					judge_the_result(10,4);
				}
			}
		});
		btnNewButton10_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_4.setBounds(126, 366, 40, 40);
		getContentPane().add(btnNewButton10_4);
		
		JButton btnNewButton10_5 = new JButton("");
		btnNewButton10_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][5]=2;  
						btnNewButton10_5.setBackground(Color.white);
					}
					else {
						chess[10][5]=1; 
						btnNewButton10_5.setBackground(Color.black);
					}
					judge_the_result(10,5);
				}
			}
		});
		btnNewButton10_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_5.setBounds(166, 366, 40, 40);
		getContentPane().add(btnNewButton10_5);
		
		JButton btnNewButton10_6 = new JButton("");
		btnNewButton10_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][6]=2;  
						btnNewButton10_6.setBackground(Color.white);
					}
					else {
						chess[10][6]=1; 
						btnNewButton10_6.setBackground(Color.black);
					}
					judge_the_result(10,6);
				}
			}
		});
		btnNewButton10_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_6.setBounds(206, 366, 40, 40);
		getContentPane().add(btnNewButton10_6);
		
		JButton btnNewButton10_7 = new JButton("");
		btnNewButton10_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][7]=2;  
						btnNewButton10_7.setBackground(Color.white);
					}
					else {
						chess[10][7]=1; 
						btnNewButton10_7.setBackground(Color.black);
					}
					judge_the_result(10,7);
				}
			}
		});
		btnNewButton10_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_7.setBounds(246, 366, 40, 40);
		getContentPane().add(btnNewButton10_7);
		
		JButton btnNewButton10_8 = new JButton("");
		btnNewButton10_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][8]=2;  
						btnNewButton10_8.setBackground(Color.white);
					}
					else {
						chess[10][8]=1; 
						btnNewButton10_8.setBackground(Color.black);
					}
					judge_the_result(10,8);
				}
			}
		});
		btnNewButton10_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_8.setBounds(286, 366, 40, 40);
		getContentPane().add(btnNewButton10_8);
		
		JButton btnNewButton10_9 = new JButton("");
		btnNewButton10_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][9]=2;  
						btnNewButton10_9.setBackground(Color.white);
					}
					else {
						chess[10][9]=1; 
						btnNewButton10_9.setBackground(Color.black);
					}
					judge_the_result(10,9);
				}
			}
		});
		btnNewButton10_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_9.setBounds(326, 366, 40, 40);
		getContentPane().add(btnNewButton10_9);
		
		JButton btnNewButton10_10 = new JButton("");
		btnNewButton10_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][10]=2;  
						btnNewButton10_10.setBackground(Color.white);
					}
					else {
						chess[10][10]=1; 
						btnNewButton10_10.setBackground(Color.black);
					}
					judge_the_result(10,10);
				}
			}
		});
		btnNewButton10_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_10.setBounds(366, 366, 40, 40);
		getContentPane().add(btnNewButton10_10);
		
		JButton btnNewButton1_11 = new JButton("");
		btnNewButton1_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][11]=2;  
						btnNewButton1_11.setBackground(Color.white);
					}
					else {
						chess[1][11]=1; 
						btnNewButton1_11.setBackground(Color.black);
					}
					judge_the_result(1,11);
				}
			}
		});
		btnNewButton1_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_11.setBounds(406, 6, 40, 40);
		getContentPane().add(btnNewButton1_11);
		
		JButton btnNewButton1_12 = new JButton("");
		btnNewButton1_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[1][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[1][12]=2;  
						btnNewButton1_12.setBackground(Color.white);
					}
					else {
						chess[1][12]=1; 
						btnNewButton1_12.setBackground(Color.black);
					}
					judge_the_result(1,12);
				}
			}
		});
		btnNewButton1_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton1_12.setBounds(446, 6, 40, 40);
		getContentPane().add(btnNewButton1_12);
		
		JButton btnNewButton2_11 = new JButton("");
		btnNewButton2_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][11]=2;  
						btnNewButton2_11.setBackground(Color.white);
					}
					else {
						chess[2][11]=1; 
						btnNewButton2_11.setBackground(Color.black);
					}
					judge_the_result(2,11);
				}
			}
		});
		btnNewButton2_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_11.setBounds(406, 46, 40, 40);
		getContentPane().add(btnNewButton2_11);
		
		JButton btnNewButton2_12 = new JButton("");
		btnNewButton2_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[2][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[2][12]=2;  
						btnNewButton2_12.setBackground(Color.white);
					}
					else {
						chess[2][12]=1; 
						btnNewButton2_12.setBackground(Color.black);
					}
					judge_the_result(2,12);
				}
			}
		});
		btnNewButton2_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton2_12.setBounds(446, 46, 40, 40);
		getContentPane().add(btnNewButton2_12);
		
		JButton btnNewButton3_11 = new JButton("");
		btnNewButton3_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][11]=2;  
						btnNewButton3_11.setBackground(Color.white);
					}
					else {
						chess[3][11]=1; 
						btnNewButton3_11.setBackground(Color.black);
					}
					judge_the_result(3,11);
				}
			}
		});
		btnNewButton3_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_11.setBounds(406, 86, 40, 40);
		getContentPane().add(btnNewButton3_11);
		
		JButton btnNewButton3_12 = new JButton("");
		btnNewButton3_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[3][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[3][12]=2;  
						btnNewButton3_12.setBackground(Color.white);
					}
					else {
						chess[3][12]=1; 
						btnNewButton3_12.setBackground(Color.black);
					}
					judge_the_result(3,12);
				}
			}
		});
		btnNewButton3_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton3_12.setBounds(446, 86, 40, 40);
		getContentPane().add(btnNewButton3_12);
		
		JButton btnNewButton4_11 = new JButton("");
		btnNewButton4_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][11]=2;  
						btnNewButton4_11.setBackground(Color.white);
					}
					else {
						chess[4][11]=1; 
						btnNewButton4_11.setBackground(Color.black);
					}
					judge_the_result(4,11);
				}
			}
		});
		btnNewButton4_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_11.setBounds(406, 126, 40, 40);
		getContentPane().add(btnNewButton4_11);
		
		JButton btnNewButton4_12 = new JButton("");
		btnNewButton4_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[4][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[4][12]=2;  
						btnNewButton4_12.setBackground(Color.white);
					}
					else {
						chess[4][12]=1; 
						btnNewButton4_12.setBackground(Color.black);
					}
					judge_the_result(4,12);
				}
			}
		});
		btnNewButton4_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton4_12.setBounds(446, 126, 40, 40);
		getContentPane().add(btnNewButton4_12);
		
		JButton btnNewButton5_11 = new JButton("");
		btnNewButton5_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][11]=2;  
						btnNewButton5_11.setBackground(Color.white);
					}
					else {
						chess[5][11]=1; 
						btnNewButton5_11.setBackground(Color.black);
					}
					judge_the_result(5,11);
				}
			}
		});
		btnNewButton5_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_11.setBounds(406, 166, 40, 40);
		getContentPane().add(btnNewButton5_11);
		
		JButton btnNewButton5_12 = new JButton("");
		btnNewButton5_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[5][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[5][12]=2;  
						btnNewButton5_12.setBackground(Color.white);
					}
					else {
						chess[5][12]=1; 
						btnNewButton5_12.setBackground(Color.black);
					}
					judge_the_result(5,12);
				}
			}
		});
		btnNewButton5_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton5_12.setBounds(446, 166, 40, 40);
		getContentPane().add(btnNewButton5_12);
		
		JButton btnNewButton6_11 = new JButton("");
		btnNewButton6_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][11]=2;  
						btnNewButton6_11.setBackground(Color.white);
					}
					else {
						chess[6][11]=1; 
						btnNewButton6_11.setBackground(Color.black);
					}
					judge_the_result(6,11);
				}
			}
		});
		btnNewButton6_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_11.setBounds(406, 206, 40, 40);
		getContentPane().add(btnNewButton6_11);
		
		JButton btnNewButton6_12 = new JButton("");
		btnNewButton6_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[6][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[6][12]=2;  
						btnNewButton6_12.setBackground(Color.white);
					}
					else {
						chess[6][12]=1; 
						btnNewButton6_12.setBackground(Color.black);
					}
					judge_the_result(6,12);
				}
			}
		});
		btnNewButton6_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton6_12.setBounds(446, 206, 40, 40);
		getContentPane().add(btnNewButton6_12);
		
		JButton btnNewButton7_11 = new JButton("");
		btnNewButton7_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][11]=2;  
						btnNewButton7_11.setBackground(Color.white);
					}
					else {
						chess[7][11]=1; 
						btnNewButton7_11.setBackground(Color.black);
					}
					judge_the_result(7,11);
				}
			}
		});
		btnNewButton7_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_11.setBounds(406, 246, 40, 40);
		getContentPane().add(btnNewButton7_11);
		
		JButton btnNewButton7_12 = new JButton("");
		btnNewButton7_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[7][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[7][12]=2;  
						btnNewButton7_12.setBackground(Color.white);
					}
					else {
						chess[7][12]=1; 
						btnNewButton7_12.setBackground(Color.black);
					}
					judge_the_result(7,12);
				}
			}
		});
		btnNewButton7_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton7_12.setBounds(446, 246, 40, 40);
		getContentPane().add(btnNewButton7_12);
		
		JButton btnNewButton8_11 = new JButton("");
		btnNewButton8_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][11]=2;  
						btnNewButton8_11.setBackground(Color.white);
					}
					else {
						chess[8][11]=1; 
						btnNewButton8_11.setBackground(Color.black);
					}
					judge_the_result(8,11);
				}
			}
		});
		btnNewButton8_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_11.setBounds(406, 286, 40, 40);
		getContentPane().add(btnNewButton8_11);
		
		JButton btnNewButton8_12 = new JButton("");
		btnNewButton8_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[8][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[8][12]=2;  
						btnNewButton8_12.setBackground(Color.white);
					}
					else {
						chess[8][12]=1; 
						btnNewButton8_12.setBackground(Color.black);
					}
					judge_the_result(8,12);
				}
			}
		});
		btnNewButton8_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton8_12.setBounds(446, 286, 40, 40);
		getContentPane().add(btnNewButton8_12);
		
		JButton btnNewButton9_11 = new JButton("");
		btnNewButton9_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][11]=2;  
						btnNewButton9_11.setBackground(Color.white);
					}
					else {
						chess[9][11]=1; 
						btnNewButton9_11.setBackground(Color.black);
					}
					judge_the_result(9,11);
				}
			}
		});
		btnNewButton9_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_11.setBounds(406, 326, 40, 40);
		getContentPane().add(btnNewButton9_11);
		
		JButton btnNewButton9_12 = new JButton("");
		btnNewButton9_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[9][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[9][12]=2;  
						btnNewButton9_12.setBackground(Color.white);
					}
					else {
						chess[9][12]=1; 
						btnNewButton9_12.setBackground(Color.black);
					}
					judge_the_result(9,12);
				}
			}
		});
		btnNewButton9_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton9_12.setBounds(446, 326, 40, 40);
		getContentPane().add(btnNewButton9_12);
		
		JButton btnNewButton10_11 = new JButton("");
		btnNewButton10_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][11]=2;  
						btnNewButton10_11.setBackground(Color.white);
					}
					else {
						chess[10][11]=1; 
						btnNewButton10_11.setBackground(Color.black);
					}
					judge_the_result(10,11);
				}
			}
		});
		btnNewButton10_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_11.setBounds(406, 366, 40, 40);
		getContentPane().add(btnNewButton10_11);
		
		JButton btnNewButton10_12 = new JButton("");
		btnNewButton10_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[10][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[10][12]=2;  
						btnNewButton10_12.setBackground(Color.white);
					}
					else {
						chess[10][12]=1; 
						btnNewButton10_12.setBackground(Color.black);
					}
					judge_the_result(10,12);
				}
			}
		});
		btnNewButton10_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton10_12.setBounds(446, 366, 40, 40);
		getContentPane().add(btnNewButton10_12);
		
		JButton btnNewButton11_1 = new JButton("");
		btnNewButton11_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][1]=2;  
						btnNewButton11_1.setBackground(Color.white);
					}
					else {
						chess[11][1]=1; 
						btnNewButton11_1.setBackground(Color.black);
					}
					judge_the_result(11,1);
				}
			}
		});
		btnNewButton11_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_1.setBounds(6, 406, 40, 40);
		getContentPane().add(btnNewButton11_1);
		
		JButton btnNewButton11_2 = new JButton("");
		btnNewButton11_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][2]=2;  
						btnNewButton11_2.setBackground(Color.white);
					}
					else {
						chess[11][2]=1; 
						btnNewButton11_2.setBackground(Color.black);
					}
					judge_the_result(11,2);
				}
			}
		});
		btnNewButton11_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_2.setBounds(46, 406, 40, 40);
		getContentPane().add(btnNewButton11_2);
		
		JButton btnNewButton11_3 = new JButton("");
		btnNewButton11_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][3]=2;  
						btnNewButton11_3.setBackground(Color.white);
					}
					else {
						chess[11][3]=1; 
						btnNewButton11_3.setBackground(Color.black);
					}
					judge_the_result(11,3);
				}
			}
		});
		btnNewButton11_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_3.setBounds(86, 406, 40, 40);
		getContentPane().add(btnNewButton11_3);
		
		JButton btnNewButton11_4 = new JButton("");
		btnNewButton11_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][4]=2;  
						btnNewButton11_4.setBackground(Color.white);
					}
					else {
						chess[11][4]=1; 
						btnNewButton11_4.setBackground(Color.black);
					}
					judge_the_result(11,4);
				}
			}
		});
		btnNewButton11_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_4.setBounds(126, 406, 40, 40);
		getContentPane().add(btnNewButton11_4);
		
		JButton btnNewButton11_5 = new JButton("");
		btnNewButton11_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][5]=2;  
						btnNewButton11_5.setBackground(Color.white);
					}
					else {
						chess[11][5]=1; 
						btnNewButton11_5.setBackground(Color.black);
					}
					judge_the_result(11,5);
				}
			}
		});
		btnNewButton11_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_5.setBounds(166, 406, 40, 40);
		getContentPane().add(btnNewButton11_5);
		
		JButton btnNewButton11_6 = new JButton("");
		btnNewButton11_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][6]=2;  
						btnNewButton11_6.setBackground(Color.white);
					}
					else {
						chess[11][6]=1; 
						btnNewButton11_6.setBackground(Color.black);
					}
					judge_the_result(11,6);
				}
			}
		});
		btnNewButton11_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_6.setBounds(206, 406, 40, 40);
		getContentPane().add(btnNewButton11_6);
		
		JButton btnNewButton11_7 = new JButton("");
		btnNewButton11_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][7]=2;  
						btnNewButton11_7.setBackground(Color.white);
					}
					else {
						chess[11][7]=1; 
						btnNewButton11_7.setBackground(Color.black);
					}
					judge_the_result(11,7);
				}
			}
		});
		btnNewButton11_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_7.setBounds(246, 406, 40, 40);
		getContentPane().add(btnNewButton11_7);
		
		JButton btnNewButton11_8 = new JButton("");
		btnNewButton11_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][8]=2;  
						btnNewButton11_8.setBackground(Color.white);
					}
					else {
						chess[11][8]=1; 
						btnNewButton11_8.setBackground(Color.black);
					}
					judge_the_result(11,8);
				}
			}
		});
		btnNewButton11_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_8.setBounds(286, 406, 40, 40);
		getContentPane().add(btnNewButton11_8);
		
		JButton btnNewButton11_9 = new JButton("");
		btnNewButton11_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][9]=2;  
						btnNewButton11_9.setBackground(Color.white);
					}
					else {
						chess[11][9]=1; 
						btnNewButton11_9.setBackground(Color.black);
					}
					judge_the_result(11,9);
				}
			}
		});
		btnNewButton11_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_9.setBounds(326, 406, 40, 40);
		getContentPane().add(btnNewButton11_9);
		
		JButton btnNewButton11_10 = new JButton("");
		btnNewButton11_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][10]=2;  
						btnNewButton11_10.setBackground(Color.white);
					}
					else {
						chess[11][10]=1; 
						btnNewButton11_10.setBackground(Color.black);
					}
					judge_the_result(11,10);
				}
			}
		});
		btnNewButton11_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_10.setBounds(366, 406, 40, 40);
		getContentPane().add(btnNewButton11_10);
		
		JButton btnNewButton12_1 = new JButton("");
		btnNewButton12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][1]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][1]=2;  
						btnNewButton12_1.setBackground(Color.white);
					}
					else {
						chess[12][1]=1; 
						btnNewButton12_1.setBackground(Color.black);
					}
					judge_the_result(12,1);
				}
			}
		});
		btnNewButton12_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_1.setBounds(6, 446, 40, 40);
		getContentPane().add(btnNewButton12_1);
		
		JButton btnNewButton12_2 = new JButton("");
		btnNewButton12_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][2]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][2]=2;  
						btnNewButton12_2.setBackground(Color.white);
					}
					else {
						chess[12][2]=1; 
						btnNewButton12_2.setBackground(Color.black);
					}
					judge_the_result(12,2);
				}
			}
		});
		btnNewButton12_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_2.setBounds(46, 446, 40, 40);
		getContentPane().add(btnNewButton12_2);
		
		JButton btnNewButton12_3 = new JButton("");
		btnNewButton12_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][3]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][3]=2;  
						btnNewButton12_3.setBackground(Color.white);
					}
					else {
						chess[12][3]=1; 
						btnNewButton12_3.setBackground(Color.black);
					}
					judge_the_result(12,3);
				}
			}
		});
		btnNewButton12_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_3.setBounds(86, 446, 40, 40);
		getContentPane().add(btnNewButton12_3);
		
		JButton btnNewButton12_4 = new JButton("");
		btnNewButton12_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][4]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][4]=2;  
						btnNewButton12_4.setBackground(Color.white);
					}
					else {
						chess[12][4]=1; 
						btnNewButton12_4.setBackground(Color.black);
					}
					judge_the_result(12,4);
				}
			}
		});
		btnNewButton12_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_4.setBounds(126, 446, 40, 40);
		getContentPane().add(btnNewButton12_4);
		
		JButton btnNewButton12_5 = new JButton("");
		btnNewButton12_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][5]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][5]=2;  
						btnNewButton12_5.setBackground(Color.white);
					}
					else {
						chess[12][5]=1; 
						btnNewButton12_5.setBackground(Color.black);
					}
					judge_the_result(12,5);
				}
			}
		});
		btnNewButton12_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_5.setBounds(166, 446, 40, 40);
		getContentPane().add(btnNewButton12_5);
		
		JButton btnNewButton12_6 = new JButton("");
		btnNewButton12_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][6]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][6]=2;  
						btnNewButton12_6.setBackground(Color.white);
					}
					else {
						chess[12][6]=1; 
						btnNewButton12_6.setBackground(Color.black);
					}
					judge_the_result(12,6);
				}
			}
		});
		btnNewButton12_6.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_6.setBounds(206, 446, 40, 40);
		getContentPane().add(btnNewButton12_6);
		
		JButton btnNewButton12_7 = new JButton("");
		btnNewButton12_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][7]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][7]=2;  
						btnNewButton12_7.setBackground(Color.white);
					}
					else {
						chess[12][7]=1; 
						btnNewButton12_7.setBackground(Color.black);
					}
					judge_the_result(12,7);
				}
			}
		});
		btnNewButton12_7.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_7.setBounds(246, 446, 40, 40);
		getContentPane().add(btnNewButton12_7);
		
		JButton btnNewButton12_8 = new JButton("");
		btnNewButton12_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][8]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][8]=2;  
						btnNewButton12_8.setBackground(Color.white);
					}
					else {
						chess[12][8]=1; 
						btnNewButton12_8.setBackground(Color.black);
					}
					judge_the_result(12,8);
				}
			}
		});
		btnNewButton12_8.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_8.setBounds(286, 446, 40, 40);
		getContentPane().add(btnNewButton12_8);
		
		JButton btnNewButton12_9 = new JButton("");
		btnNewButton12_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][9]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][9]=2;  
						btnNewButton12_9.setBackground(Color.white);
					}
					else {
						chess[12][9]=1; 
						btnNewButton12_9.setBackground(Color.black);
					}
					judge_the_result(12,9);
				}
			}
		});
		btnNewButton12_9.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_9.setBounds(326, 446, 40, 40);
		getContentPane().add(btnNewButton12_9);
		
		JButton btnNewButton12_10 = new JButton("");
		btnNewButton12_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][10]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][10]=2;  
						btnNewButton12_10.setBackground(Color.white);
					}
					else {
						chess[12][10]=1; 
						btnNewButton12_10.setBackground(Color.black);
					}
					judge_the_result(12,10);
				}
			}
		});
		btnNewButton12_10.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_10.setBounds(366, 446, 40, 40);
		getContentPane().add(btnNewButton12_10);
		
		JButton btnNewButton11_11 = new JButton("");
		btnNewButton11_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][11]=2;  
						btnNewButton11_11.setBackground(Color.white);
					}
					else {
						chess[11][11]=1; 
						btnNewButton11_11.setBackground(Color.black);
					}
					judge_the_result(11,11);
				}
			}
		});
		btnNewButton11_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_11.setBounds(406, 406, 40, 40);
		getContentPane().add(btnNewButton11_11);
		
		JButton btnNewButton11_12 = new JButton("");
		btnNewButton11_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[11][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[11][12]=2;  
						btnNewButton11_12.setBackground(Color.white);
					}
					else {
						chess[11][12]=1; 
						btnNewButton11_12.setBackground(Color.black);
					}
					judge_the_result(11,12);
				}
			}
		});
		btnNewButton11_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton11_12.setBounds(446, 406, 40, 40);
		getContentPane().add(btnNewButton11_12);
		
		JButton btnNewButton12_11 = new JButton("");
		btnNewButton12_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][11]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][11]=2;  
						btnNewButton12_11.setBackground(Color.white);
					}
					else {
						chess[12][11]=1; 
						btnNewButton12_11.setBackground(Color.black);
					}
					judge_the_result(12,11);
				}
			}
		});
		btnNewButton12_11.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_11.setBounds(406, 446, 40, 40);
		getContentPane().add(btnNewButton12_11);
		
		JButton btnNewButton12_12 = new JButton("");
		btnNewButton12_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chess[12][12]==0) { 
					step+=1; 
					if(step%2==0) {
						chess[12][12]=2;  
						btnNewButton12_12.setBackground(Color.white);
					}
					else {
						chess[12][12]=1; 
						btnNewButton12_12.setBackground(Color.black);
					}
					judge_the_result(12,12);
				}
			}
		});
		btnNewButton12_12.setBackground(Color.LIGHT_GRAY);
		btnNewButton12_12.setBounds(446, 446, 40, 40);
		getContentPane().add(btnNewButton12_12);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setBounds(6, 496, 300, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("★特殊規則★");
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(6, 527, 300, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("長連：落子點黑方不得連格超過五格");
		
	}
}
