package mmb;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegistrationPage extends JFrame implements ActionListener 
{
	JFileChooser filechooser;
	long randomNum;
	JFrame Regpage;
	JLabel backheader,backbody,backfooter,photobody;
	JTextField apno,name,age,house,street,landmark,area,village,po,district,state,pin,mobile,email,introname,introuid,idsub,pan,dl;
	JLabel dispname,dispid;
	JButton newreg,correctreg;
	JButton demographics,photograph,review,demographicsdim,photographdim,reviewdim,generate;
	JPanel regpanel,photopanel,reviewpanel,editpanel;
	JRadioButton male,female;
	JButton photoupload,savephoto,cancel,photoupload1,savephoto1,home,photoupload2;
	JLabel  disphoto,disphoto1,disphoto2;
	static Point mouseDownCompCoords;
	JLabel sample1,sample2,sample3,sample4,sample5;
	
	JTextField uid;
	public RegistrationPage()
	{
		
		regpanel = new JPanel();
		photopanel = new JPanel();
		Regpage = new JFrame("Registration");
		backheader = new JLabel(new ImageIcon(""));
		backbody= new JLabel(new ImageIcon("images\\body1.png"));
		backfooter= new JLabel(new ImageIcon(""));
		photobody= new JLabel(new ImageIcon("images\\body2.png"));
		cancel = new JButton(new ImageIcon("images\\x.png"));
		home= new JButton(new ImageIcon("images\\home.png"));
		//back= new JLabel(new ImageIcon("images\\sample.png"));
		uid=new JTextField("");
		apno=new JTextField();
		name=new JTextField();
		age=new JTextField();
		male= new JRadioButton("Male");
		female= new JRadioButton("Female");
		house=new JTextField();
		street=new JTextField();
		landmark=new JTextField();
		area=new JTextField();
		village=new JTextField();
		po=new JTextField();
		district=new JTextField();
		state=new JTextField();
		pin=new JTextField();
		mobile=new JTextField();
		email=new JTextField();
		introname=new JTextField("Introducer Name");
		introuid=new JTextField("Aadhaar Number");
		idsub=new JTextField();
		pan=new JTextField();
		dl=new JTextField();
		dispname= new JLabel("asfa");
		dispid= new JLabel("sdasa");
		newreg = new JButton(new ImageIcon("images\\newreg.png"));
		correctreg= new JButton(new ImageIcon("images\\correct.png"));
		demographics = new JButton(new ImageIcon("images\\demographics.png"));
		demographicsdim = new JButton(new ImageIcon("images\\demographicsdim.png"));
		photograph= new JButton(new ImageIcon("images\\photograph.png"));
		photographdim= new JButton(new ImageIcon("images\\photographdim.png"));
		review= new JButton(new ImageIcon("images\\review.png"));
		reviewdim= new JButton(new ImageIcon("images\\reviewdim.png"));
		generate= new JButton(new ImageIcon("images\\generate.png"));
		photoupload= new JButton(new ImageIcon("images\\uploadfoot.png"));
		photoupload2= new JButton(new ImageIcon("images\\uploadpalm.png"));
		disphoto= new JLabel();
		savephoto= new JButton(new ImageIcon("images\\save.png"));
		photoupload1= new JButton(new ImageIcon("images\\blank.png"));
		disphoto1= new JLabel();
		disphoto2= new JLabel();
		savephoto1= new JButton(new ImageIcon("images\\save.png"));
		sample1 = new JLabel("Sample 1");
		sample2 = new JLabel("Sample 2");
		sample3 = new JLabel("Sample 3");
		sample4 = new JLabel("Sample 4");
		sample5 = new JLabel("Sample 5");
		
		
		
		
		
		ImageIcon img = new ImageIcon("images\\logo.gif");

		
		Regpage.setIconImage(img.getImage());
		
	}
	
	public void addon1()
	{
		Container c= Regpage.getContentPane();
		
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
		
		Regpage.setSize(971,640);
		Regpage.setLocation(200,50);
		Regpage.setUndecorated(true);
		Regpage.setVisible(true);
		Regpage.setLayout(null); 
		Regpage.setResizable(false);
	    Regpage.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   // Regpage.setIconImage(img.getImage());
	    
	    
	    c.add(cancel);
	    cancel.setBounds(5,5,20,30);
	    cancel.setFocusPainted(false);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.setOpaque(false);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		c.add(home);
		home.setBounds(920,2,49,49);
		home.setFocusPainted(false);
	    home.setMargin(new Insets(0, 0, 0, 0));
	    home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setOpaque(false);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.setToolTipText("back");
		c.add(demographics);
		demographics.setBounds(680,5,100,46);
		
		c.add(demographicsdim);
		
		c.add(photograph);
	    photograph.setBounds(800,5,100,46);
		
	    c.add(photographdim);
        photographdim.setBounds(800,5,100,46);
        photographdim.setVisible(false);
        photographdim.setFocusPainted(false);
        photographdim.setMargin(new Insets(0, 0, 0, 0));
        photographdim.setContentAreaFilled(false);
        photographdim.setBorderPainted(false);
        photographdim.setOpaque(false);
        
	    
	    c.add(regpanel);
		regpanel.setLayout(null);
		regpanel.setBounds(0,0,971,640);
		regpanel.setOpaque(false);
		
		c.add(photopanel);
		photopanel.setLayout(null);
		photopanel.setBounds(0,0,971,640);
		photopanel.setOpaque(false);
		photopanel.setVisible(false);
		
		//regpanel.add(apno);
		//apno.setBounds(275,13,130,20);
		regpanel.add(name);
		name.setBounds(220,171,205,20);
		regpanel.add(age);
		age.setBounds(220,215,35,20);
		
		regpanel.add(male);
		male.setBounds(221,188,55,30);
		male.setFocusPainted(false);
		male.setMargin(new Insets(0, 0, 0, 0));
		male.setContentAreaFilled(false);
		male.setBorderPainted(false);
		male.setOpaque(false);
		
		regpanel.add(female);
		female.setBounds(280,188,70,30);
		female.setFocusPainted(false);
		female.setMargin(new Insets(0, 0, 0, 0));
		female.setContentAreaFilled(false);
		female.setBorderPainted(false);
		female.setOpaque(false);
		
	
		regpanel.add(house);
		house.setBounds(220,278,205,20);
	
		regpanel.add(street);
		street.setBounds(220,303,205,20);

		regpanel.add(landmark);
		landmark.setBounds(220,328,205,20);
		regpanel.add(area);
		area.setBounds(220,353,205,20);
		regpanel.add(village);
		village.setBounds(220,378,205,20);
		regpanel.add(po);
		po.setBounds(220,403,97,20);
		regpanel.add(district);
		
		district.setBounds(327,403,97,20);
		regpanel.add(state);
		state.setBounds(220,428,97,20);
		regpanel.add(pin);
		pin.setBounds(327,428,97,20);
		regpanel.add(mobile);
		mobile.setBounds(220,453,205,20);
		
		regpanel.add(email);
		email.setBounds(220,478,205,20);
		
		regpanel.add(introname);
		introname.setBounds(540,192,150,20);
		regpanel.add(introuid);
		introuid.setBounds(700,192,205,20);
		
		regpanel.add(idsub);
		idsub.setBounds(540,242,150,20);
		
		/*regpanel.add(pan);
		pan.setBounds(540,189,205,20);
		regpanel.add(dl);
		dl.setBounds(540,244,205,20);
		regpanel.add(generate);
		generate.setBounds(542,310,150,46);
		regpanel.add(uid);
		uid.setBounds(542,310,150,46);
		uid.setVisible(false);
		*/
		
		regpanel.add(backbody);
	    backbody.setBounds(0,0,971,640);
		
		
	   
	    regpanel.add(photoupload1);
		photoupload1.setBounds(540,280,232,209);
		photoupload1.setOpaque(false);
		
		regpanel.add(disphoto1);
		disphoto1.setBounds(540,280,232,209);
	    
	    
	    
		//photopanel.add(savephoto);
		//savephoto.setBounds(610,330,150,46);
		//savephoto.setVisible(false);
	    //photopanel.add(photoupload);
	//	photoupload.setBounds(550,50,278,270);
	//	photoupload.setOpaque(false);
		
		//photopanel.add(disphoto);
		disphoto.setBounds(550,50,278,270);
		
		
		c.add(photopanel);
		photopanel.setLayout(null);
	
		photopanel.setBackground(Color.red);
		//photopanel.add(photobody);
		//photobody.setBounds(0,0,971,429);
		

	    photopanel.add(photoupload);
		photoupload.setBounds(140,200,278,270);
		photoupload.setOpaque(false);
		
		photopanel.add(disphoto);
		disphoto.setBounds(140,200,278,270);
	    
	    
			photopanel.add(photoupload2);
			photoupload2.setBounds(550,200,278,270);
			photoupload2.setOpaque(false);
			
			photopanel.add(disphoto2);
			disphoto2.setBounds(550,200,278,270);
		    
		    
		sample1.setBounds(420,100,200,30);
		sample1.setFont(new Font("Seoge UI", Font.PLAIN, 28));
		sample1.setForeground(Color.blue);
		photopanel.add(sample1);
		
		
		
		
		
		
		demographicsdim.setBounds(50,90,100,46);
		demographicsdim.setVisible(false);
		demographicsdim.setFocusPainted(false);
        demographicsdim.setMargin(new Insets(0, 0, 0, 0));
        demographicsdim.setContentAreaFilled(false);
        demographicsdim.setBorderPainted(false);
        demographicsdim.setOpaque(false);
        
        
       
       
        
        
		
	
	    
	    
	    regpanel.add(backbody);
	    backbody.setBounds(0,0,971,640);
	    
	    photopanel.add(photobody);
	   photobody.setBounds(0,0,971,640);
	    
		Regpage.addMouseListener(new MouseListener(){
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
		     
		    Regpage.addMouseMotionListener(new MouseMotionListener(){
		    public void mouseMoved(MouseEvent e) {
		    }
		     
		    public void mouseDragged(MouseEvent e) {
		    Point currCoords = e.getLocationOnScreen();
		    
		    Regpage.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
		    }
		    });
	    
	    home.addActionListener(this);
	    newreg.addActionListener(this);
	    photograph.addActionListener(this);
	    demographics.addActionListener(this);
		generate.addActionListener(this);
		photoupload.addActionListener(this);
		photoupload1.addActionListener(this);
		photoupload2.addActionListener(this);
		savephoto.addActionListener(this);
		male.addActionListener(this);
		female.addActionListener(this);
		cancel.addActionListener(this);
		
		
	}
	
	
	public long generate()
	{
		long maximum=999999999999L;
        long minimum=111111111111L;
        
        randomNum=minimum + (long)(Math.random() * ((maximum - minimum) + 1));
        System.out.println(randomNum); 

		
		return randomNum;
	}
	
	
	
	public static void main(String [] args)
	{
		RegistrationPage rp = new RegistrationPage();
		rp.addon1();
		rp.generate();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==home)
		{
			RegisterTest rt = new RegisterTest();
			rt.RegisterTestinit();
			Regpage.setVisible(false);
		}
		if(e.getSource()==photograph)
		{
			
			regpanel.setVisible(false);
			photopanel.setVisible(true);
			System.out.println("Clicked");
			
		}
		if(e.getSource()==cancel)
		{
			System.exit(0);
		}
		
		if(e.getSource()==demographics)
		{
			
			regpanel.setVisible(true);
			photopanel.setVisible(false);
			System.out.println("Clicked");
			
			
		}
		if(e.getSource()==generate)
		{
			generate.setVisible(false);
			uid.setVisible(true);
			uid.setEditable(false);
			generate();
			uid.setText(String.valueOf(randomNum));
			Font font = new Font("Verdana", Font.BOLD, 16);
			uid.setFont(font);
			
			
		}
		if(e.getSource()==photoupload)
		{
			filechooser= new JFileChooser("C:\\personal_work\\Java_Workspace\\MMB_GUI\\images");
		    filechooser.setDialogTitle("Choose Your Footprint");
		    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    //below codes for select  the file 
		    int returnval=filechooser.showOpenDialog(this);
		    if(returnval==JFileChooser.APPROVE_OPTION)
		    {
		        File file = filechooser.getSelectedFile();
		        BufferedImage bi;
		        try
		        {   //display the image in jlabel
		            bi=ImageIO.read(file);
		            disphoto.setIcon(new ImageIcon(bi));
		            photoupload.setVisible(false);
		            savephoto.setVisible(true);
		        }
		        catch(IOException e1)
		        {

		        }
		        this.pack();
		    }
			
			
		}
		
		if(e.getSource()==photoupload1)
		{
			filechooser= new JFileChooser("C:\\personal_work\\Java_Workspace\\MMB_GUI\\images");
		    filechooser.setDialogTitle("Upload your Photograph");
		    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    //below codes for select  the file 
		    int returnval=filechooser.showOpenDialog(this);
		    if(returnval==JFileChooser.APPROVE_OPTION)
		    {
		        File file = filechooser.getSelectedFile();
		        BufferedImage bi;
		        try
		        {   //display the image in jlabel
		            bi=ImageIO.read(file);
		            disphoto1.setIcon(new ImageIcon(bi));
		            photoupload1.setVisible(false);
		            //savephoto.setVisible(true);
		        }
		        catch(IOException e1)
		        {

		        }
		        this.pack();
		    }
			
			
		}
		if(e.getSource()==photoupload2)
		{
			filechooser= new JFileChooser("C:\\personal_work\\Java_Workspace\\MMB_GUI\\images");
		    filechooser.setDialogTitle("Upload your palmprint");
		    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    //below codes for select  the file 
		    int returnval=filechooser.showOpenDialog(this);
		    if(returnval==JFileChooser.APPROVE_OPTION)
		    {
		        File file = filechooser.getSelectedFile();
		        
		      
		        BufferedImage bi;
		        try
		        {   //display the image in jlabel
		            bi=ImageIO.read(file);
		            BufferedImage dimg =  (BufferedImage) bi.getScaledInstance(300, 300,
		                    Image.SCALE_SMOOTH);
		            ImageIcon imageIcon = new ImageIcon(dimg);
		            disphoto2.setIcon(imageIcon);
		            photoupload2.setVisible(false);
		            //savephoto.setVisible(true);
		        }
		        catch(IOException e1)
		        {

		        }
		        this.pack();
		    }
			
			
		}
		
	      if(e.getSource()==savephoto)     
	      {
	          PrintWriter pw = null ;
	          //JFileChooser filechooser= new JFileChooser();
	         // a.showOpenDialog(null);
	         // System.out.print("path"+a.getSelectedFile());
	          //////////////////file reading and writting////////////////
	          File f = new File(filechooser.getSelectedFile().toString());
	        

	                 try { 
	       	
	         	File sourceFile=new File(filechooser.getSelectedFile().toString());
	         	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile), 4096);
	               File targetFile = new File("C:\\wamp\\www\\aadhaar\\user_db\\"+uid.getText()+".png"); ////////////////////////////////////////////("images\\"+t8.getText()+".png")
	               BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile), 4096);
	               int theChar;
	               while ((theChar = bis.read()) != -1) {
	                  bos.write(theChar);
	               }
	            bos.close();
	            bis.close();
	            System.out.println ("copy done!");
	            JOptionPane.showMessageDialog(null, "Photograph Saved");
	      }
	      catch (Exception ex) 
	      {
	       ex.printStackTrace();
	       //if(uid.getText()==null)
	       //{   
	       JOptionPane.showMessageDialog(null, "Error in saving pgotograph!,Make sure aadhaar number is genrated before saving");
	       //}
	      }  
	                
	                	           
	            
	            ///////////////////////////file reading
	      }
	          
		
			
		// TODO Auto-generated method stub
		
}




}

