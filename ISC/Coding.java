package ISC;
import java.util.*;
public class Coding {
    String wrd;
    int len;
    Coding(){       // default constructor
        wrd="";
        len=0;
    } 
    void accept(){            // to accept a word as a string 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the word");
        wrd=sc.nextLine();
        sc.close();
    }

    void find (){
        int i, sm=(int)wrd.charAt(0),lar=(int)wrd.charAt(0);
        char ch;
        for(i=0;i<wrd.length();i++)
        {
            ch=wrd.charAt(i);
            if(sm>ch)
            sm=ch;
            if(lar<ch)
            lar=ch;
            System.out.println(ch+" = "+(int)ch);
        }
        System.out.println("Lowest ASCII code: "+sm);
        System.out.println("Highest ASCII code: "+lar);
    }
    void show(){
        System.out.println("Original word: "+ wrd);
        find();
    }
    public static void main(String args[]){
        Coding ob=new Coding();
        ob.accept();
        ob.show();
    }
}
