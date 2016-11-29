package project1;
import java.util.*;

public class Helper 
{
    HashMap <String,Integer>  Marker = new HashMap <String,Integer>();
    HashMap <String,String> CharMarker = new HashMap <String,String>();
    
    public void MarkChar()
    {
        Marker.put("अ",0);
        Marker.put("आ",0);
        Marker.put("इ",0);
        Marker.put("ई",0);
        Marker.put("उ",0);
        Marker.put("ऊ",0);
        Marker.put("ए",0);
        Marker.put("ऐ",0);
        Marker.put("ओ",0);
        Marker.put("औ",0);
        Marker.put("ऋ",0);
        
        Marker.put("ा",1);
        Marker.put("ि",1);
        Marker.put("ी",1);
        Marker.put("ु",1);
        Marker.put("ू",1);
        Marker.put("े",1);
        Marker.put("ै",1);
        Marker.put("ो",1);
        Marker.put("ौ",1);
        Marker.put("ृ",1);
        Marker.put("ं",1);
   
        Marker.put("क",2);
        Marker.put("ख",2);
        Marker.put("ग",2);
        Marker.put("घ",2);
        Marker.put("ङ",2);
        Marker.put("च",2);
        Marker.put("छ",2);
        Marker.put("ज",2);
        Marker.put("झ",2);
        Marker.put("ञ",2);
        Marker.put("ट",2);
        Marker.put("ठ",2);
        Marker.put("ड",2);
        Marker.put("ढ",2);
        Marker.put("ण",2);
        Marker.put("त",2);
        Marker.put("थ",2);
        Marker.put("द",2);
        Marker.put("ध",2);
        Marker.put("न",2);
        Marker.put("प",2);
        Marker.put("फ",2);
        Marker.put("ब",2);
        Marker.put("भ",2);
        Marker.put("म",2);
        Marker.put("य",2);
        Marker.put("र",2);
        Marker.put("ल",2);
        Marker.put("व",2);
        Marker.put("श",2);
        Marker.put("ष",2);
        Marker.put("स",2);
        Marker.put("ह",2);
        
        Marker.put("्",3);
    }
    public void RemoveSchwa(String s)
    {
             mark(s);
    }
    public void mark(String s)
    {
             int strLen = s.length(),flag,i,j;
             char array[] = new char[strLen];
             char answer[] = new char[100];
             char[] Syllable = new char[100];
             String x1 = "्",x2;
             String dummy = "$";
             j = 0;
             System.out.println("Before SCHWA removal : "+s);
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 System.out.println ("Index = " + i + " Char = " +array[i] + " Value : " + Marker.get(Character.toString(s.charAt(i))) );
                 if(Marker.get(Character.toString(s.charAt(i)))==0)             //FullVowel
                 {
                     answer[j] = s.charAt(i);
                     CharMarker.put(Character.toString(s.charAt(i)),"F");  
                    // System.out.println("combined1: "+array[i]);
                     j++;
                     answer[j] = '-';
                     j++;
                 }
                 if(Marker.get(Character.toString(s.charAt(i)))==2)        //Consonant
                 {
                    // System.out.println("combined: "+array[i]+array[i+1]);
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==1)       //Vowel
                     {
                     //   CharMarker.put(Character.toString(s.charAt(i)),"F");
                     //   CharMarker.put(Character.toString(s.charAt(i+1)),"F");
                        CharMarker.put(Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1)),"F");
                        answer[j] = s.charAt(i);
                        j++;
                        answer[j] = s.charAt(i+1);
                        j++;
                        answer[j] = '-';
                        j++;
                      //  System.out.println("combined2: "+array[i]+array[i+1]);
                        flag = 0;
                     }
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==3)       //consonant + halant
                     {
                       //  CharMarker.put(Character.toString(s.charAt(i)),"H");
                       //  CharMarker.put(Character.toString(s.charAt(i+1)),"H");
                         CharMarker.put(Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1)),"H");
                         answer[j] = s.charAt(i);
                         j++;
                         answer[j] = '-';
                         j++;
                       //  System.out.println("combined3: "+array[i]+array[i+1]);
                         flag = 0;
                     }
                     if(flag != 0)
                     {
                         CharMarker.put(Character.toString(s.charAt(i)),"U");
                         answer[j] = s.charAt(i);
                         j++;
                         answer[j] = '-';
                         j++;
                         //consonant + अ
                        // System.out.println("combined4: "+array[i]);
                     }  
                 }
             } 
             for (i=0 ;i < answer.length ; i++)
             {
                 System.out.print(answer[i]);
             }
             System.out.println("");
    }
}
