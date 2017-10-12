import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        int n;
        n = fs.nextInt();
        MyStructure arra = new MyStructure();
       // System.out.println(arra.getSize());
        for (int i = 0; i < n; i++) {
            int k = fs.nextInt();
            if(k == 1) {
                //try {

                    arra.add(fs.nextInt());
               //} catch (ArrayIndexOutOfBoundsException e){
                  //  System.out.println("Вылез братка, как же так" + " " + e.getStackTrace());
              //  }
            } else System.out.println(arra.delete());


            }
        // System.out.println(arra);

        }
    }

