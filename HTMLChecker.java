import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
   Write a program that checks whether a sequence of HTML tags
   is properly nested. For each opening tag, such as <p>, there
   must be a closing tag </p>. A tag such as <p> may have other
   tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>

   The inner tags must be closed before the outer ones.
   Your program should process a file containing tags.
   For simplicity, assume that the tags are separated by
   spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
   public static void main(String[] args)
   {
      String filename = "TagSample1.html";
      Stack<String> stack = new Stack<>();
      boolean isProper = true;
      try (Scanner in = new Scanner(new File(filename)))
      {
         //Theres no text and that there are only tags in the file
         while (in.hasNext() && isProper == true)
         {
        
           String tag = in.next();
           if (tag.equals("<>"))
           {
               stack.push(tag);
            }
            if (tag.equals("</>"))
            {
               if (stack.empty())
               {
                  System.out.println("Does not work");
                  isProper = false;
               }
               else
               {
               stack.pop()
            }
            
            }
            
            }
            if (stack.empty())
            {
               System.out.println("It works");
            }
            else
            {
               System.out.println("Fudge");
            }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Cannot open: " + filename);
      }
      
    
   }
   

   
}
