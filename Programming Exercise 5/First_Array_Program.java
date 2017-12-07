/*
 * Program: First Array Program
 * File: First_Array_Program.java
 * Summary: Multidimensional array takes characters from a file and stores them in Row major,
 *          rearranges them in Column major and displays new single line.
 * Author: Vincent Christaldi
 * Date: 12/06/2017
*/
package first_array_program;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class First_Array_Program 
{
    //main method
    public static void main(String[] args) 
    {
        //declare first array
        char[][] character_Array;
        //declare variable to hold text from file
        String whole_Text = "";
        
        //begin try to open file and read it
        try
        {
            //create new reader
            BufferedReader br = new BufferedReader(new FileReader("c:\\Precious_Text.txt"));
            //while there are data to process
            while(true)
            {
                String Reader = "";
                int count = 0;
                //read the line
                Reader = br.readLine();
                //if end of line break while
                if(Reader == null)
                    break;
                //otherwise append text to whole_Text
               whole_Text += Reader;
            }
            br.close(); //close file
        }
        //catch error if needed
        catch(IOException err)
        {
            err.printStackTrace();
        }
        
        //call to fill array
       character_Array = FillArray(whole_Text);
       
       //output array 
       display_Array(character_Array);       
    }
    
    //fill array method
    public static char[][] FillArray(String whole_Text)
    {
        //set counter variable
        int text_Limit = 0;
        //create the actual array
        char[][] character_Array = new char[20][45];
                //start loop from outside(row) to inside (column)
                for(int Row = 0; Row != 20; ++Row)
                {
                    for(int Column = 0; Column != 45; ++Column)
                    {
                        //if there are still characters to process
                        if(text_Limit < whole_Text.length())
                        {
                            character_Array[Row][Column] = whole_Text.charAt(text_Limit);
                            ++text_Limit;
                        }
                        else
                        {
                            //if all characters have been processed and array is not filled
                            character_Array[Row][Column] = '@';
                        }
                    }
                }
        //return the now filled array        
        return character_Array;
    }
    
    //method to display the array
    private static void display_Array(char[][] character_Array)
    {
        //create a new variable to hold the new phrase
        String new_Text = "";
        
        //reverse outer and inner loop to pull from column then row.
        for(int Column = 0; Column != 45; ++Column)
        {
            for(int Row = 0; Row != 20; ++Row)
            {
                //append the characters to new_Text variable
                new_Text += character_Array[Row][Column];
            }
        }
        //display result on console
        System.out.println(new_Text);
    }
}
