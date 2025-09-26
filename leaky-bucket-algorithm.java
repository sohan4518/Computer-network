//--------A PROGRAM FOR COGESTION CONTROL USING A LEAKY BUCKET ALGORTHM-----------

package leaky;

import java.util.*;

public class Leaky {

  public static void main(String[] args) {

    int i;
    int a[]=new int[20];

    int b=0,sent,recv;

    Scanner in=new Scanner(System.in);

    System.out.println("Enter the number of packets:");

    int n=in.nextInt();

    System.out.println("Enter the bucket capacity:");

    int bc=in.nextInt();

    System.out.println("Enter the output rate:");

    int rate=in.nextInt();

    System.out.println("Enter the size of packets:");

    for(i=1;i<=n;i++)

    a[i]=in.nextInt();

    System.out.println("CLOCK \t PACKET SIZE \t ACCEPT\t SENT\t REMAINING");

    for(i=1;i<=n;i++){

      if(a[i]!=0){

        if(b+a[i]>bc)

          recv=-1;

        else

        {

          recv=a[i];

          b+=a[i];

        }

      }

      else

        recv=0;

      if(b!=0){

        if(b<rate){

          sent=b;

          b=0;

        }

        else

        {

          sent=rate;

          b=b-rate;

        }

      }

      else

        sent=0;

      if(recv==-1)

        System.out.println(i+"\t\t"+a[i] +"\t dropped \t"+ sent+"\t"+b);

      else

        System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t"+sent+"\t"+b);

    }

  }

}
