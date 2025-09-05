package ISC;
import java.util.*;
public class SortAlpha {
    String sent;
    int n;
    SortAlpha(){
        sent="";
        n=0;
    }
    void acceptsent(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the sentence in uppercase");
        sent=sc.nextLine();
    }
    void sort(SortAlpha P)
    {
        int i=1; String s1,s2,s="",wrd="";
        StringTokenizer st=new StringTokenizer(sent);
        while(st.hasMoreTokens()){
            s1=st.nextToken();
            StringTokenizer st1=new StringTokenizer(sent);
            while(st1.hasMoreTokens()){
                s2=st1.nextToken();
                if(s1.compareTo(s2)<0)
                s=s2;
            }
           wrd=wrd+s;
        }
       System.out.println(wrd);
    }
    void display()
    {
        System.out.println(sent);
        SortAlpha ob=new SortAlpha();
        
    }
    public static void main(String args[]){

    }
}
