import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;
class calculatorpanel extends JPanel
{
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastcommand;
    private boolean start;
    
     private class InsertAction implements ActionListener
     {
      public void actionPerformed(ActionEvent event)
      {
       String input=event.getActionCommand();
       if(start)
        {
        display.setText("");
        start=false;
        }
	      display.setText(display.getText()+input);
	   }
	}
	
	private class CommandAction implements ActionListener
	{
	public void actionPerformed(ActionEvent event)
	 {
	  String command=event.getActionCommand();
	  if(start)
	  {
	     if(command.equals("-"))
		 {
		 display.setText(command);
		 start=false;
		 }
		 else
		 lastcommand=command;
	  }
	  else
	  {
	  calculate(Double.parseDouble(display.getText()));
	  lastcommand=command;
	  start=true;
	  }
     }
    }	
	
	public void calculate( double x)
	{
	 if(lastcommand.equals("+"))
	 result+=x;
	 else if (lastcommand.equals("-"))
	 result-=x;
	 else if (lastcommand.equals("*"))
	 result*=x;
	 else if (lastcommand.equals("/"))
	 result/=x;
	 else if (lastcommand.equals("sin"))
	 result=Math.sin(x);
	 else if (lastcommand.equals("cos"))
	 result=Math.cos(x);
	 else if (lastcommand.equals("tan"))
	 result=Math.tan(x);
	 else if (lastcommand.equals("log"))
	 result=Math.log(x);
	 else if (lastcommand.equals("sqrt"))
	 result=Math.sqrt(x);
	 else if (lastcommand.equals("exp"))
	 result=Math.exp(x);
	 else if (lastcommand.equals("atan"))
	 result=Math.atan(x);
	 else if (lastcommand.equals("c"))
	 result='0';
	 
	 display.setText("" + result);
	}
	
  public calculatorpanel()
  {
  setLayout(new BorderLayout());
   result='0';
   lastcommand="=";
   start=true;
   display=new JButton("0");
   display.setEnabled(false);
   add(display,BorderLayout.NORTH);
   
   ActionListener insert=new InsertAction();
   ActionListener  command=new CommandAction();
   
   panel=new JPanel();
   panel.setLayout(new GridLayout(6,4));
   
   addButton("7",insert);
   addButton("8",insert);
   addButton("9",insert);
   addButton("/",command);
   
   addButton("4",insert);
   addButton("5",insert);
   addButton("6",insert);
   addButton("*",command);
   
   addButton("1",insert);
   addButton("2",insert);
   addButton("3",insert);
   addButton("-",command);
   
   addButton("0",insert);
   addButton(".",insert);
   addButton("=",command);
   addButton("+",command);
   
   addButton("sin",command);
   addButton("cos",command);
   addButton("tan",command);
   addButton("log",command);
   
   addButton("sqrt",command);
   addButton("exp",command);
   addButton("atan",command);
   addButton("c",command);
   
   add(panel,BorderLayout.CENTER);
 }
  
   
   private void addButton (String label,ActionListener listener)
   {
   JButton button=new JButton(label);
   button.addActionListener(listener);
   panel.add(button);
   }

 }
 
 class calculatorframe extends JFrame
 { 
   public calculatorframe()
   {
    setTitle("calculator");
	calculatorpanel panel=new calculatorpanel();
	add(panel);
	pack();
  }
  }
  
public class calculator
{
public static void main(String args[])
{
EventQueue.invokeLater(new Runnable()
{
public void run()
{
calculatorframe frame =new calculatorframe();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
});
}
}
