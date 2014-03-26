package mmb;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.beans.Statement;
import java.sql.DriverManager;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;




public class LoginFrame extends JFrame implements ActionListener
{
	InetAddress ip;
	JFrame one;
	JLabel back;
	JLabel version;
	JLabel Uid,Upassword;
	JTextField Utext;
	JPasswordField pass;
	JButton login,cancel;
	JLabel ipa,time;
	String Ip,timenow;
	static Point mouseDownCompCoords;
	JLabel mainlogon,mainlogoh;
	
	
	
	
	public LoginFrame() 
	{
	one = new JFrame("MMMB Login");
	back= new JLabel(new ImageIcon("images\\back.png"));
	mainlogon= new JLabel(new ImageIcon("images\\bio.gif"));
	mainlogoh= new JLabel(new ImageIcon("images\\bio.gif"));
	
	
	//ImageIcon gifImage = new ImageIcon(new URL());
    //mainlogon = new JLabel(gifImage);
	
     //back= new JLabel(new ImageIcon(getClass().getResource("sample.jpg")));
	
	
	//p1chips = new JLabel(new ImageIcon("images\\data\\chipsvalue.png"));
	//version = new JLabel("A thought of Dr Pervez Ahmed");
	//opid= new JLabel("Operator ID");
	Uid= new JLabel("Operator ID");
    Upassword= new JLabel("Password");
	Utext= new JTextField();
	
	pass = new JPasswordField();
	login =new JButton(new ImageIcon("images\\login1.jpg"));
	cancel = new JButton(new ImageIcon("images\\x.png"));
	ipa = new JLabel();
	time = new JLabel();
	ImageIcon img = new ImageIcon("images\\logo.gif");

	
	one.setIconImage(img.getImage());
	
	//JComboBox patternList = new JComboBox(patternExamples);
	
	}
	
	
	
	
	
	public void addon()
	{
	Container c= one.getContentPane();
	
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
	
	
	//ImageIcon img = new ImageIcon("images//logo4.png");
//	one.setIconImage(img.getImage());
	
	one.setSize(600,400);
	one.setLocation(300,200);
	one.setUndecorated(true);
	one.setVisible(true);
    one.setLayout(null); 
    
   // c.add(version);
    //version.setBounds(5,370,300,30);
    //version.setForeground(Color.black);
   getip();
   //datentime();
   
   

	    
	    
	   
   
   
   
   
  // ActionListener timerListener = new ActionListener()  
   //{  
     //  public void actionPerformed(ActionEvent e)  
      // {  
       	GregorianCalendar calendar = new GregorianCalendar();
   		Date d = new Date();
   		Date now = calendar.getTime();

   		timenow=now.toString();
   		System.out.println(timenow);
   		time = new JLabel(timenow);
   		
    //   }  
   //};  
  
   ipa = new JLabel(Ip);
   c.add(ipa);
   ipa.setBounds(55,300,300,30);
  // ipa.setForeground(Color.white);
   
   
   time = new JLabel(timenow);
   c.add(time);
   time.setBounds(54,330,300,30);
  // time.setForeground(Color.white);
   
   
   
   // Timer timer = new Timer(1000, timerListener);  
    //to make sure it doesn't wait one second at the start  
  // timer.setInitialDelay(0);  
  // timer.start();  
  // c.add(time);
  // time.setBounds(55,300,300,30);
   
   
   mainlogon.setBounds(60,100,141,176);
   c.add(mainlogon);
    
    
    c.add(Uid);
    Uid.setBounds(350,130,100,30);
    Uid.setForeground(Color.black);
    c.add(Utext);
    Utext.setBounds(350,140,100,30);
    Utext.setForeground(Color.black);
    
    c.add(Upassword);
    Upassword.setBounds(350,200,100,30);
    Upassword.setForeground(Color.black);
    
    c.add(Utext);
    Utext.setBounds(350,171,230,30);
    
    
    
    
    c.add(pass);
    pass.setBounds(350,231,230,30);
    
    
    c.add(login);
    login.setBounds(351,274,73,30);
    login.setCursor(new Cursor(Cursor.HAND_CURSOR));
    c.add(cancel);
    cancel.setBounds(20,2,73,30);
    cancel.setBounds(2,2,20,30);
    cancel.setFocusPainted(false);
	cancel.setMargin(new Insets(0, 0, 0, 0));
	cancel.setContentAreaFilled(false);
	cancel.setBorderPainted(false);
	cancel.setOpaque(false);
	cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    
    
    
    c.add(back);
    back.setBounds(0,0,600,400);
    
    
	
	
    	one.addMouseListener(new MouseListener(){
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
	     
	    one.addMouseMotionListener(new MouseMotionListener(){
	    public void mouseMoved(MouseEvent e) {
	    }
	     
	    public void mouseDragged(MouseEvent e) {
	    Point currCoords = e.getLocationOnScreen();
	    
	    one.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	    }
	    });
	    
    
    
	
	
	cancel.addActionListener(this);
	login.addActionListener(this);
	}
	
	public String getip()
	{
	
		try {
			 
			ip = InetAddress.getLocalHost();
			
	 
			NetworkInterface internet = NetworkInterface.getByInetAddress(ip);
	 
			//byte mac [] = internet.getHardwareAddress();
			
			
	 
			//StringBuilder sb = new StringBuilder();
			//for (int i = 0; i < mac.length; i++) {
			//	sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ?""  : ""));		
		//	}
		//	System.out.println(sb.toString());
		Ip=ip.toString();
	 
		} catch (UnknownHostException e) {
	 
			Ip="Not Connected";
			e.printStackTrace();
	 
		} catch (SocketException e){
	 
			e.printStackTrace();
	 
		}
	 
	 		
		return Ip;
		
	}
	
	
	
	
	public boolean matchpassword()
	{
		
		
		
		return true; 
	}
	
	
	
	
	
	public static void main(String args[]) 
	{
	LoginFrame lf= new LoginFrame();
	lf.addon();
	//al.datentime();
		
		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent a) 
	{
		
        if (a.getSource()==login)
        {
        
        	String oid=Utext.getText();
        	
        	String Opass=pass.getText();
        	
        	System.out.println(oid+Opass);
        	
        	if(oid.equals("admin") && Opass.equals("specta"))
        	{
        	
        		RegisterTest rt = new RegisterTest();
        		rt.RegisterTestinit();
        		one.setVisible(false);
        	}
        	else
        	{
        		
        		JOptionPane.showMessageDialog(null, "Wrong Id or Password. Try again !");
        	}
        	
    		
					
		
        }
		
		
		if(a.getSource()==cancel)
		{
			System.exit(0);
		}
		//if(a.getSource()==login)
	//	{
		//	System.out.println("clicked");
		//	RegistrationPage rp = new RegistrationPage();
		//	rp.addon1();
			
	//	}
	
	
	
	}

	
	
	
}
