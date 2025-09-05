package ISC;
import java.util.*;
public class Trans {
    int arr[][],m;
    Trans(int mm){
        m=mm;
        arr=new int [m][m];
    }
    void fillarray(){
        Scanner sc=new Scanner(System.in);
        int i,j;
        System.out.println("Enter the elememts of array");
        for(i=0;i<m;i++)
        {
            for(j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
    }
    void transpose(){
        int i,j;
        int trans[][]=new int[m][m];
        for(i=0;i<m;i++){
            for(j=0;j<m;j++){
                trans[i][j]=arr[j][i];
            }
        }
        System.out.println("Transpose");
        for(i=0;i<m;i++)
        {
            for(j=0;j<m;j++){
                System.out.print(trans[i][j]+" ");
            }
            System.out.println();
        }
    }
    void display()
    {
        int i,j;
        System.out.println("ORIGINAL");
        for(i=0;i<m;i++)
        {
            for(j=0;j<m;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        transpose();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        Trans ob=new Trans(n);
        ob.fillarray();
        ob.display();
        sc.close();
    }
}
