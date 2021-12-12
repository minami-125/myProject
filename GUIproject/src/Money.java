import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.text.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Money extends JFrame{
	
	JButton jb1, jb2;
	DecimalFormat df1=new DecimalFormat("###,###");
	DecimalFormat df2=new DecimalFormat("###,###.##");
	String cur1[]= {"USD", "JPY","EUR","KRW"};
	JComboBox fi1 = new JComboBox(cur1);
	JComboBox fi2 = new JComboBox(cur1);
	Color yellow = new Color(245, 223,77);
	Color grey = new Color(147, 149,151);
	JDialog dialog = new JDialog();

	class Exchange extends JDialog{
		Exchange(){
			Container c=getContentPane();
			setTitle("Exchange");
			c.setLayout(null);
			c.setBackground(grey);
			setSize(600, 400);
			setResizable(false);
			ImageIcon arrow = new ImageIcon("downarrow.png");
			Image img = arrow.getImage();
			Image resize = img.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
			ImageIcon arrow1 = new ImageIcon(resize);
			JLabel arro = new JLabel(arrow1);
			arro.setBounds(130, 110, 80, 80);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일");
			Date date = new Date();
			JLabel cho=new JLabel("Date: "+dateformat.format(date));
			cho.setBounds(50, 30, 150, 25);
			cho.setForeground(yellow);
			fi1.setBounds(80, 80, 60, 25);
			JButton push = new JButton("Exchange");
			push.setBackground(yellow);
			push.setFocusable(false);
			push.setBounds(85, 250, 95, 25);
			JButton reset = new JButton("Reset");
			reset.setBackground(yellow);
			reset.setFocusable(false);
			reset.setBounds(190, 250, 70, 25);
			JTextField in1=new JTextField(15);
			in1.setBounds(160, 80, 100, 25);
			fi2.setBounds(80, 200, 60, 25);
			JTextField in2=new JTextField(15);
			in2.setBounds(160, 200, 100, 25);
			in2.setEditable(false);
			
			JMenuBar menu = new JMenuBar();
			JMenu move = new JMenu("Move");
			JMenuItem home = new JMenuItem("Home");
			JMenuItem rate = new JMenuItem("Interest");
			JMenu close = new JMenu("Close");
			JMenuItem cur = new JMenuItem("Close current page");
			JMenuItem shut = new JMenuItem("Close All");
			setJMenuBar(menu);
			menu.add(move);
			menu.add(close);
			move.add(home);
			move.add(rate);
			close.add(cur);
			close.add(shut);
			
			rate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Interest dialog= new Interest();
					dialog.setVisible(true);
					dispose();
				}	});

			home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Money back = new Money();
					back.setVisible(true);
					dispose();
				}	});
			
			cur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}	});
			
			shut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			JLabel notice =new JLabel("<html>"+"*참고*"+"<br>"+"JPY: 100엔 단위로 입력"+"<br>"+"KRW: 1000원 단위로 입력"+"</html>");
			notice.setBounds(280, 80, 300, 150);
			notice.setForeground(yellow);
			
			c.add(cho);
			c.add(fi1);
			c.add(in1);
			c.add(arro);
			c.add(push);
			c.add(reset);
			c.add(fi2);
			c.add(in2);
			c.add(notice);
			
			push.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int a=fi1.getSelectedIndex();
				    int b=fi2.getSelectedIndex();
				       String str1=cur1[a];
				       String str2=cur1[b];
					double n=Double.parseDouble(in1.getText());
							
							switch (str1) {
							case "USD":
								if(str2.equals("JPY")){
									in2.setText(String.valueOf((df2.format(n*105.73))));
								}
								if (str2.equals("EUR")) {
									in2.setText(String.valueOf(df2.format(n*0.83)));
								}
								if(str2.equals("KRW")) {
									in2.setText(String.valueOf(df2.format(n*1107.00)));
								}
								break;
							case "JPY": 
								if(str2.equals("USD")){
									in2.setText(String.valueOf(df2.format((n*0.95)/100)));
								} else if (str2.equals("EUR")) {
									in2.setText(String.valueOf(df2.format((n*0.78)/100)));
								} else if(str2.equals("KRW")) {
									in2.setText(String.valueOf(df2.format((n*1047.01)/100)));
								}
								break;
							case "EUR":
								if(str2.equals("USD")){
									in2.setText(String.valueOf(df2.format(n*1.21)));
								} else if (str2.equals("JPY")) {
									in2.setText(String.valueOf(df2.format(n*127.58)));
								} else if(str2.equals("KRW")) {
									in2.setText(String.valueOf(df2.format(n*1335.76)));
								}
								break;
							case "KRW": 
								if(str2.equals("USD")){
									in2.setText(String.valueOf(df2.format(n*0.90))); 
								} else if (str2.equals("JPY")) {
									in2.setText(String.valueOf(df2.format(n*95.51)));
								} else if(str2.equals("EUR")) {
									in2.setText(String.valueOf(df2.format(n*0.75)));
								}
								break;
						}	}	});
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					in1.setText(" ");
					in2.setText(" ");
				}	});	}
			
		
	}
	class Interest extends JDialog{
		Interest(){
			Container c =getContentPane();
			setTitle("Interest");
			setSize(750, 400);
			setResizable(false);
			c.setLayout(null);
			c.setBackground(grey);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일");
			Date date = new Date();
			JLabel cho=new JLabel("Date: "+dateformat.format(date));
			cho.setBounds(50, 30, 150, 25);
			cho.setForeground(yellow);
			JRadioButton a=new JRadioButton("예금");
			a.setBackground(grey);
			a.setBounds(70, 70, 70, 30);
			a.setForeground(yellow);
			JRadioButton b=new JRadioButton("적금");
			b.setBackground(grey);
			b.setBounds(160, 70, 100, 30);
			b.setForeground(yellow);
			ButtonGroup group = new ButtonGroup();
			group.add(a);
			group.add(b);
			
			JLabel ja1 = new JLabel("예치기간(개월)");
			ja1.setBounds(70, 120, 90, 25);
			ja1.setForeground(yellow);
			JTextField jt1 = new JTextField(15);
			jt1.setBounds(170, 120, 90, 25);
			JLabel ja2 = new JLabel("입금액");
			ja2.setBounds(70, 160, 90, 25);
			ja2.setForeground(yellow);
			JTextField jt2 = new JTextField(15);
			jt2.setBounds(170, 160, 90, 25);
			JLabel ja3 = new JLabel("연이자율");
			ja3.setBounds(70, 200, 90, 25);
			ja3.setForeground(yellow);
			JTextField jt3 = new JTextField(15);
			jt3.setBounds(170, 200, 90, 25);
			
	
			JButton calc = new JButton("Calc");
			calc.setBackground(yellow);
			calc.setFocusable(false);
			calc.setBounds(200, 250, 80, 25);
			JButton res = new JButton("Reset");
			res.setBackground(yellow);
			res.setFocusable(false);
			res.setBounds(300, 250, 80, 25);
			
			JLabel ja4 = new JLabel("원금합계");
			ja4.setBounds(280, 120, 90, 25);
			ja4.setForeground(yellow);
			JTextField jt4 = new JTextField(15);
			jt4.setEditable(false);
			jt4.setBounds(380, 120, 90, 25);
			JLabel ja5 = new JLabel("세후이자");
			ja5.setBounds(280, 160, 90, 25);
			ja5.setForeground(yellow);
			JTextField jt5 = new JTextField(15);
			jt5.setEditable(false);
			jt5.setBounds(380, 160, 90, 25);
			JLabel ja6 = new JLabel("만기지급액");
			ja6.setBounds(280, 200, 90, 25);
			ja6.setForeground(yellow);
			JTextField jt6 = new JTextField(15);
			jt6.setEditable(false);
			jt6.setBounds(380, 200, 90, 25);

			JMenuBar menu = new JMenuBar();
			JMenu move = new JMenu("Move");
			JMenuItem home = new JMenuItem("Home");
			JMenuItem exc = new JMenuItem("Exchange");
			JMenu close = new JMenu("Close");
			JMenuItem cur = new JMenuItem("Close current page");
			JMenuItem shut = new JMenuItem("Close All");
			setJMenuBar(menu);
			menu.add(move);
			menu.add(close);
			move.add(home);
			move.add(exc);
			close.add(cur);
			close.add(shut);
			
			exc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Exchange dialog= new Exchange();
					dialog.setVisible(true);
					dispose();
				}	});

			home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Money back = new Money();
					back.setVisible(true);
					dispose();
				}	});
			
			cur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}	});
			
			shut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			JLabel notice =new JLabel("<html>"+"*참고*"+"<br>"+"예/적금: 단리"+"<br>"+"세금: 일반과세 15.4% 적용"+"</html>");
			notice.setBounds(500, 90, 300, 150);
			notice.setForeground(yellow);
			
			c.add(a);
			c.add(b);
			c.add(ja1);
			c.add(jt1);
			c.add(ja2);
			c.add(jt2);
			c.add(ja3);
			c.add(jt3);
			c.add(calc);
			c.add(res);
			c.add(ja4);
			c.add(jt4);
			c.add(ja5);
			c.add(jt5);
			c.add(ja6);
			c.add(jt6);
			c.add(notice);
			c.add(cho);
			 
			calc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean s1=a.isSelected();
					if(s1==true) {
						int y=Integer.parseInt(jt1.getText());//예치기간
						int m=Integer.parseInt(jt2.getText()); //월 적립액
						double r=Double.parseDouble(jt3.getText()); //연이자
						int hap=(int)(m*(r*0.01)*(y/12)*0.864);
						jt4.setText(String.valueOf(df1.format(m))); //원급합계
						jt5.setText(String.valueOf(df1.format(hap))); //이자
						jt6.setText(String.valueOf(df1.format(m+hap))); //만기 지급액	
					}else{
						int yy=Integer.parseInt(jt1.getText());//예치기간
						int mm=Integer.parseInt(jt2.getText()); //월 적립액
						double rr=Double.parseDouble(jt3.getText()); //연이자
						int month=mm*yy;
						int rate=(int)((mm*((rr*0.01)/12)*(yy*(yy+1))/2)*.846);
						jt4.setText(String.valueOf(df1.format(month)));
						jt5.setText(String.valueOf(df1.format(rate))); //이자15.4%
						jt6.setText(String.valueOf(df1.format(rate+month))); //만기 지급액	
					} } });
			
			
			res.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jt1.setText("");
					jt2.setText("");
					jt3.setText("");
					jt4.setText("");
					jt5.setText("");
					jt6.setText("");
				}	});	}	}
	
	Money(){
		setTitle("Exchange & Interest Calculator");
		setSize(620, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		c.setBackground(grey);
		ImageIcon welcome=new ImageIcon("unnamed.png");
		JLabel image = new JLabel(welcome);
		image.setBounds(50, 60, 500, 150);
		
		jb1=new JButton("Exchange");
		jb1.setBackground(yellow);
		jb1.setFocusable(false);
		jb1.setBounds(170, 250, 100, 45);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exchange exc=new Exchange();
				exc.setVisible(true);
			}	});
		
		jb2=new JButton("Interest");
		jb2.setBackground(yellow);
		jb2.setFocusable(false);
		jb2.setBounds(300, 250, 100, 45);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interest i = new Interest();
				i.setVisible(true);
			}	});
		
		c.add(image);
		c.add(jb1);
		c.add(jb2);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Money();

	}

}
