
public class Ex12StudentTester
{
    public static void main(){
        System.out.println ("********** Question 1 **********\n");

        int[] array1 = {6,6,18,18,-4,-4,12,9,9};
        System.out.println("Checking method findSingle on array [6,6,18,18,-4,-4,12,9,9]\n");
        int studentResult;

        studentResult= Ex12.findSingle(array1);
        System.out.println("Result is: "+studentResult);
        System.out.println();
        
        System.out.println ("********** Question 2 **********\n");
        int[] array2 = {1,4,45,6,0,19};
        int x = 5;
        System.out.println("Checking method smallestSubSum on array [1,4,45,6,0,19] and x=5\n");
        studentResult= Ex12.smallestSubSum(array2,x);
        System.out.println("Result is: "+studentResult);
        System.out.println();

    }
}

