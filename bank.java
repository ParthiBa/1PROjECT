/*Simple operations of bank
*@ author parthiban uthayakumar
*@version bank v0.0.1
*/
import java.io.*;
import java.util.Scanner;
import java.lang.*;
class Sub
{
    public int ano;
    int bal;
    Scanner in=new Scanner(System.in);
    String name,type;
    /* Sub()
    {
     ano=0;
     bal=0;
     name=null;
     type=null;
    }*/

   void getdata()
   {
        System.out.println("enter your name to create an account ");
        name=in.next();
        System.out.println("enter your choice of account");
        System.out.println("1.Savings   2.Current");
        int j=in.nextInt();
        switch(j)
        {
			case 1:
			bal=500;
			type=("SAVINGS");
            case 2:
            bal=300;
            type=("CURRENT");
            default:
            System.out.println("choose only these two options");
        }
    }
  
    void withdraw()
    {
        System.out.println("enter the amount which you want to withdraw from your account");
        int j=in.nextInt();
        int k=bal-j;
        if((k<300)&&(type=="CURRENT"))
        System.out.println("Error: try again :amount which you want to withdraw exceeds minimum balance");
        else if((k<500)&&(type=="SAVINGS"))
        System.out.println("Error: try again :amount which you want to withdraw exceeds minimum balance");
        else
        bal=k;
    }

	void deposit()
    {
      System.out.println("enter the amount that you want depoist in your account");
      int z=in.nextInt();
	  int q=z+bal;
	  if((q<300)&&(type=="CURRENT"))
	  System.out.println("Error: try again :do not enter negative amount");
      else if((q<500)&&(type=="SAVINGS"))
      System.out.println("Error: try again :do not enter negative amount");
       else
       bal=bal+z;
    }
  
    void display()
    {
        if((name!=null)&&(ano!=0)&&(type!=null)&&(bal!=0))
        System.out.println("your name is "+name+"\n account number: "+ano+"\n balance: "+bal);
    }
}

class bank
{
    public static void main(String args[])
    {
        Scanner p=new Scanner(System.in);
        Sub a[]=new Sub[25];
 loop3: for(int i=1;i<24;i++)
        {
            System.out.println("do you want to create an account");
            String e=p.next();
            String g="yes";
            String s="YES";
            if(e.equals(g) || g.equals(s))
            {

                Sub t=new Sub();
                t.ano=i;
                System.out.print(i+"\t");
                t.getdata();
        loop2:  while(true)
                {
				   System.out.println("please choose any of the following");
                   System.out.println("1.withdraw  \n2. deposit \n  3.display information \n 4.exit");
                   int r=p.nextInt();
                   loop1 :  switch(r)
                   {
                       case 1:
                       t.withdraw();
                       continue loop2;
                       case 2:
                       t.deposit();
                       continue loop2;
                       case 3:
                       t.display();
                       break;
                       case 4:
                       break loop2;
                       default:
                       System.out.println("choose from any those four options");
                    }
			    }
                a[i]=t;

		    }
            else
            break loop3;
        }
    }
}

