public class pattern_4 {
    public static void main(String [] agrs){
        int i,j;
        char ch='A';
        for(i=1;i<=4;i++)
        {
            for(j=1;j<=i;j++)
            {
                System.out.print(ch++);
            }
            System.out.println("");
        }
    }
}
