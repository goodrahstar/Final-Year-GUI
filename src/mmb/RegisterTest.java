
package mmb;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class RegisterTest extends JFrame implements ActionListener, MouseListener
{

	JFrame RFrame;
	JButton register,test,registerb,testb,cancel,home;
	Container c;
	JLabel back,rtext,ttext;
	LoginFrame lf;
	static Point mouseDownCompCoords;
	
	
	
	
	public RegisterTest()
	{
		RFrame = new JFrame("Register");
		register =new JButton(new ImageIcon("images\\left1.png"));
		test = new JButton(new ImageIcon("images\\right1.png"));
		registerb =new JButton(new ImageIcon("images\\left2.png"));
		testb = new JButton(new ImageIcon("images\\right2.png"));
		cancel = new JButton(new ImageIcon("images\\x.png"));
		back= new JLabel(new ImageIcon("images\\back2.png"));
		home= new JButton(new ImageIcon("images\\home.png"));
		rtext = new JLabel("Register");
		ttext = new JLabel("Test");
		ImageIcon img = new ImageIcon("images\\logo.gif");

		
		RFrame.setIconImage(img.getImage());
	
		
		
	}
	
	
	public void RegisterTestinit()
	{
		
		 	c = RFrame.getContentPane();
			RFrame.setSize(600,400);
			RFrame.setLocation(300,200);
			RFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Windows".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception e) 
			{
			    // If Nimbus is not available, you can set the GUI to another look and feel.
			}
			
			
			
			RFrame.setResizable(false);
			RFrame.setUndecorated(true);
			RFrame.setVisible(true);
			c.setBackground(Color.white);
			c.setLayout(null);
			
			c.add(register);
			register.setFocusPainted(false);
			register.setMargin(new Insets(0, 0, 0, 0));
			register.setContentAreaFilled(false);
			register.setBorderPainted(false);
			register.setOpaque(false);
	        //close.setVisible(false);
			register.setToolTipText("Register");
		    register.setBounds(84,110,88,200);
		    
		    c.add(cancel);
		    cancel.setBounds(2,2,20,30);
		    cancel.setFocusPainted(false);
			cancel.setMargin(new Insets(0, 0, 0, 0));
			cancel.setContentAreaFilled(false);
			cancel.setBorderPainted(false);
			cancel.setOpaque(false);
			cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        //close.setVisible(false);
		    
			c.add(home);
			home.setBounds(558,-8,49,49);
			home.setFocusPainted(false);
		    home.setMargin(new Insets(0, 0, 0, 0));
		    home.setContentAreaFilled(false);
			home.setBorderPainted(false);
			home.setOpaque(false);
			home.setCursor(new Cursor(Cursor.HAND_CURSOR));
			home.setToolTipText("back");
			
			
		    rtext.setForeground(Color.black);
		    rtext.setBounds(100,342,100,30);
		    c.add(rtext);
		    
		    ttext.setForeground(Color.black);
		    ttext.setBounds(470,342,100,30);
		    c.add(ttext);
		    
		    
		    c.add(test);
		    test.setBounds(450,110,81,200);
		    test.setFocusPainted(false);
			test.setMargin(new Insets(0, 0, 0, 0));
			test.setContentAreaFilled(false);
			test.setBorderPainted(false);
			test.setOpaque(false);
	        //close.setVisible(false);
			test.setToolTipText("Test");
			
			
			c.add(registerb);
			registerb.setFocusPainted(false);
			registerb.setMargin(new Insets(0, 0, 0, 0));
			registerb.setContentAreaFilled(false);
			registerb.setBorderPainted(false);
			registerb.setOpaque(false);
	        //close.setVisible(false);
			registerb.setToolTipText("Register");
		    registerb.setBounds(71,100,110,250);
		    registerb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    registerb.setVisible(false);
		    
		    c.add(testb);
		    testb.setBounds(440,100,101,250);
		    testb.setFocusPainted(false);
			testb.setMargin(new Insets(0, 0, 0, 0));
			testb.setContentAreaFilled(false);
			testb.setBorderPainted(false);
			testb.setOpaque(false);
	        //close.setVisible(false);
			testb.setToolTipText("Test");
			testb.setVisible(false);
			testb.setCursor(new Cursor(Cursor.HAND_CURSOR));
			c.add(back);
			back.setBounds(0,0,600,400);
			    
			RFrame.addMouseListener(new MouseListener(){
			    public void mouseReleased(MouseEvent e) {
			    mouseDownCompCoords = null;
			    }
			    public void mousePressed(MouseEvent e) {
			    mouseDownCompCoords = e.getPoint();
			    }
			    public void mouseExited(MouseEvent e) {
			    }
			    public void mouseEntered(MouseEvent e) {
			    }
			    public void mouseClicked(MouseEvent e) {
			    }
			    });
			     
			    RFrame.addMouseMotionListener(new MouseMotionListener(){
			    public void mouseMoved(MouseEvent e) {
			    }
			     
			    public void mouseDragged(MouseEvent e) {
			    Point currCoords = e.getLocationOnScreen();
			    
			    RFrame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			    }
			    });
			    
			
		    register.addMouseListener(this);
		    register.addActionListener(this);
		    
		    registerb.addMouseListener(this);
		    registerb.addActionListener(this);
		    
		    
		    test.addMouseListener(this);
		    test.addActionListener(this);
		    
		    testb.addMouseListener(this);
		    testb.addActionListener(this);
		    
		    
		    home.addActionListener(this);
		    
		    cancel.addActionListener(this);
			
	}
	public static void main(String argsp[])
	{
		RegisterTest rt = new RegisterTest();
		rt.RegisterTestinit();
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent a) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent a) 
	{
		if(a.getSource()==register)
		{
			register.setVisible(false);
			registerb.setVisible(true);
			
		}
		
		if(a.getSource()==test)
		{
			test.setVisible(false);
			testb.setVisible(true);
			
		}
	}


	@Override
	public void mouseExited(MouseEvent a) 
	{

		if(a.getSource()==registerb)
		{
			registerb.setVisible(false);
			register.setVisible(true);
			
		}
		
		if(a.getSource()==testb)
		{
			testb.setVisible(false);
			test.setVisible(true);
			
		}
		

		
	}


	@Override
	public void mousePressed(MouseEvent a)
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent a)
	{
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==home)
		{
			LoginFrame lf= new LoginFrame();
			lf.addon();
			JOptionPane.showMessageDialog(lf, "You have been successfully logged out.");
			RFrame.setVisible(false);
		}
		if(ae.getSource()==registerb)
		{
			RegistrationPage rp = new RegistrationPage();
			rp.addon1();
			RFrame.setVisible(false);
		}
		
		if(ae.getSource()==cancel)
		{
			System.exit(0);
		}
		
	}
	
	


}
