package Projects;

import java.util.*;
public class Suduko_Solver 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        // char board[][]= new char[9][9];
        // System.out.println("Enter the Number of Suduko and Empty space as '.'");
        // for(int i=0;i<9;i++)
        // {
        //     for(int j=0;j<9;j++)
        //     {
        //         board[i][j]= in.next().charAt(0);   
        //     }
        // }

        char board[][]={
    {'5','3','.','.','7','.','.','.','.'},
    {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2','8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'}};

    helper(board, 0, 0);
}
    

    static void helper(char [][]board , int row , int col)
    {
        if(col==board.length)
        {
            row++;
            col=0;
        }

        if(row==board.length)
        {
            System.out.println("your answer is: ");
            printans(board);
            return;
        }
        

       if(board[row][col]=='.')
       {
        for(int i=1;i<10;i++)
        {
            char ch = (char)(i+'0');
            if(issafe(board,row,col , ch))
            {
                board[row][col]=ch;
                helper(board, row, col+1);
                board[row][col]='.';
            }
        }
       }
       else
       {
        helper(board, row, col+1);
       }

    }

    static boolean issafe(char [][]board, int row , int col,char ch)
    {
        char ele=ch;
       for(int i=0;i<board.length;i++)
       {
         if(board[row][i]==ele)
         {
            return false;
         }
       }

       for(int j=0;j<board.length;j++)
       {
        if(board[j][col]==ele)
        {
            return false;
        }
       }

       int sr = (row / 3) * 3;
       int sc = (col / 3) * 3;

       for (int i = sr; i < sr + 3; i++) 
       {
           for (int j = sc; j < sc + 3; j++) 
           {
               if (board[i][j] == ele) 
               {
                   return false;
               }
           }
       }

       return true;
    }

    static void printans(char[][] board) {
    System.out.println("╔═══════════╦═══════════╦═══════════╗");
    for (int i = 0; i < 9; i++) {
        System.out.print("║");
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.')
                System.out.print("   ");
            else
                System.out.print(" " + board[i][j] + " ");

            if ((j + 1) % 3 == 0)
                System.out.print("║");
            else
                System.out.print("|");
        }
        System.out.println();

        if (i == 2 || i == 5)
            System.out.println("╠═══════════╬═══════════╬═══════════╣");
        else if (i != 8)
            System.out.println("╟───┼───┼───╫───┼───┼───╫───┼───┼───╢");
    }
    System.out.println("╚═══════════╩═══════════╩═══════════╝");
  }
  }
