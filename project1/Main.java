package project1;

import java.util.*;
import java.io.*;

public class Main 
{
    public static void main(String[] args) 
    {
             Helper obj = new Helper();
             obj.MarkChar();
             String a = "प्रियतम";
             for (int i=0 ;i < a.length() ; i++)
             {
                 System.out.println(a.charAt(i));
             }
             obj.RemoveSchwa(a);
    }
}
