//import jdk.swing.interop.SwingInterOpUtils;
//import java.util.Arrays;
import java.util.Scanner;



public class RecursiveMazeFill {


    public static char[][] dungeon = new char[10][10];


    static int youX;
    static int youY;
    static int currentX;
    static int currentY;
   // static int prevCurrentX;
   // static int prevCurrentY;
    static int isEmpty = 0;


    public static void fill(int y, int x)
    {

        currentX=x;
        currentY=y;
     // prevCurrentX = currentX;
      //prevCurrentY = currentY;




        if (isEmpty == 1) {       // Base case
            return;
        }





        if (dungeon[currentY][currentX] == 'Y') {           // if the current spot is the Y, change that to $
            dungeon[currentY][currentX] = '$';
        }



        if (dungeon[currentY][currentX] == '.') {           // if current spot it an empty room ('.'), change it to a $
            dungeon[currentY][currentX] = '$';

        }


        if (dungeon[currentY][currentX] == '*')          //if it's a star or a dollar sign, don't go any further and just return
        {
            return;
        }

        //System.out.println(Arrays.deepToString(dungeon));




            if (currentY>0 &&
                    (dungeon[currentY - 1][currentX] == '.')  )    // up      ^
            {
                fill(currentY - 1, currentX);
               // if (currentY<10)
                currentY += 1;
            }


            if (currentX<10 &&
                    (dungeon[currentY][currentX + 1] == '.') )        // right   -->
            {
                fill(currentY, currentX + 1);
               // if (currentX>0)
                currentX -= 1;
            }


            if (currentY<10 &&
                    (dungeon[currentY + 1][currentX] == '.')   )      // down    V
            {
                fill(currentY + 1, currentX);
              //  if (currentY>0)
                currentY -= 1;
            }

            if (currentX>0 &&
                    (dungeon[currentY][currentX - 1] == '.')   )         // left   <--
            {
                fill(currentY, currentX-1);
              //  if (currentX<10)
                currentX += 1;
            }


        if ((currentY == youY ) && (currentX == youX)) {
            isEmpty = 1;

        }


        //  currentX = prevCurrentX;
      //  currentY= prevCurrentY;

    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String line;            //setting some local variables
        int i = 0;
        int j = 0;



        for (i = 0; i < 10; i++)   // filling the dungeon array
        {

            line = sc.next();

            for (j = 0; j < 10; j++) {
                dungeon[i][j] = line.charAt(j);

                if (dungeon[i][j] == 'Y')     // if you find Y, mark down it's x,y coordinates
                {
                    youX = j;
                    youY = i;
                }
            }


        }

      //  System.out.println("youX = " + youX + "\nyouY = " + youY);

       // System.out.println("BEGINNING DUNGEON: ");
      //  System.out.println(Arrays.deepToString(dungeon));


        fill(youY, youX);            // calling our recursive function

       // System.out.println("FINAL DUNGEON: ");
        for (i = 0; i < 10; i++)   // filling the dungeon array
        {

            for (j = 0; j < 10; j++) {
                System.out.print(dungeon[i][j]);

            }
            System.out.println();

            // System.out.println(Arrays.deepToString(dungeon));

        }

    }

}


/*

Example input:

**********
*.*...*.**
*Y*.*..*.*
*.*.*...**
*..****.**
*........*
********.*
**.....***
*..***...*
**********





 */