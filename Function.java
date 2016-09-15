package project;
import java.util.*;

public class Function 
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
             String x1 = "्",x2;
             j = 0;
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 System.out.println ("Index = " + i + " Char = " +array[i] + " Value : " + Marker.get(Character.toString(s.charAt(i))) );
                 if(Marker.get(Character.toString(s.charAt(i)))==0)             //FullVowel
                 {
                     CharMarker.put(Character.toString(s.charAt(i)),"F");  
                    // System.out.println("combined1: "+array[i]);
                     j++;
                 }
                 if(Marker.get(Character.toString(s.charAt(i)))==2)        //Consonant
                 {
                    // System.out.println("combined: "+array[i]+array[i+1]);
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==1)       //Vowel
                     {
                        CharMarker.put(Character.toString(s.charAt(i)),"F");
                        CharMarker.put(Character.toString(s.charAt(i+1)),"F");
                      //  System.out.println("combined2: "+array[i]+array[i+1]);
                        flag = 0;
                     }
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==3)       //consonant + halant
                     {
                         CharMarker.put(Character.toString(s.charAt(i)),"H");
                          CharMarker.put(Character.toString(s.charAt(i+1)),"H");
                       //  System.out.println("combined3: "+array[i]+array[i+1]);
                         flag = 0;
                     }
                     if(flag != 0 && Marker.get(Character.toString(s.charAt(i)))==2)
                     {
                         CharMarker.put(Character.toString(s.charAt(i)),"U");       //consonant + अ
                        // System.out.println("combined4: "+array[i]);
                     }  
                 }
                
             } 
             Set set = CharMarker.entrySet();
             Iterator itr = set.iterator();
             while(itr.hasNext())
             {
                Map.Entry me = (Map.Entry)itr.next();
                System.out.print(me.getKey() + ":");
                System.out.print(me.getValue() + " ");
             }
             System.out.println("");
             //STEP 2
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(Character.toString(array[i]).equals("य") && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                     if((i-1)>=0 && Marker.get(Character.toString(s.charAt(i-1)))==0)
                     {
                         if(Character.toString(s.charAt(i-1)).equals("इ") || Character.toString(s.charAt(i-1)).equals("ई") || Character.toString(s.charAt(i-1)).equals("उ") || Character.toString(s.charAt(i-1)).equals("ऊ")) //FullVowel
                         {
                             CharMarker.put(Character.toString(s.charAt(i)),"F");
                             flag = 0;
                         }
                     }
                     
                 }
                 if(flag != 0 && (i-2)>=0 && Character.toString(array[i]).equals("य") && CharMarker.get(Character.toString(s.charAt(i))).equals("U") )
                 {
                     String temp = Character.toString(s.charAt(i-2)) +Character.toString(s.charAt(i-1));
                     if(temp.equals("रि"))
                     {
                           CharMarker.put(Character.toString(s.charAt(i)),"F");
                     }
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("");
             //STEP3
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if((i-2)>=0 && Character.toString(array[i]).equals("र") && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                     String temp = Character.toString(s.charAt(i-2));
                     if(CharMarker.get(temp).equals("H") && Character.toString(array[i-1]).equals("्") )
                     {
                           CharMarker.put(Character.toString(s.charAt(i)),"F");
                     }
                 }
                 if((i-2)>=0 && Character.toString(array[i]).equals("य") && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                     String temp = Character.toString(s.charAt(i-2));
                     if(CharMarker.get(temp).equals("H") && Character.toString(array[i-1]).equals("्") )
                     {
                           CharMarker.put(Character.toString(s.charAt(i)),"F");
                     }
                 }
                 if((i-2)>=0 && Character.toString(array[i]).equals("ल") && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                     String temp = Character.toString(s.charAt(i-2));
                     if(CharMarker.get(temp).equals("H") && Character.toString(array[i-1]).equals("्") )
                     {
                           CharMarker.put(Character.toString(s.charAt(i)),"F");
                     }
                 }
                 if((i-2)>=0 && Character.toString(array[i]).equals("व") && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                     String temp = Character.toString(s.charAt(i-2));
                     if(CharMarker.get(temp).equals("H") && Character.toString(array[i-1]).equals("्") )
                     {
                           CharMarker.put(Character.toString(s.charAt(i)),"F");
                     }
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("");
             //STEP 4
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if((i+1)<strLen && Marker.get(Character.toString(s.charAt(i+1))) == 0 && Marker.get(Character.toString(s.charAt(i))) == 2 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                         CharMarker.put(Character.toString(s.charAt(i)),"F");
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("");
//             //STEP 5
             flag = 1;
             array[0] = s.charAt(0);
             if(Marker.get(Character.toString(s.charAt(0))) == 2 && CharMarker.get(Character.toString(s.charAt(0))).equals("U"))
             {
                  CharMarker.put(Character.toString(s.charAt(0)),"F");
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n6");
             
             //STEP 6
             array[strLen-1] = s.charAt(strLen-1);
             if(Marker.get(Character.toString(s.charAt(strLen-1))) == 2 && CharMarker.get(Character.toString(s.charAt(strLen-1))).equals("U"))
             {
                  CharMarker.put(Character.toString(s.charAt(strLen-1)),"H");
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n7");
             
             //STEP 7
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
              //   System.out.println(array[i]);
                 if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i))) == 2 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                      if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+1)))==2 && Marker.get(Character.toString(s.charAt(i+2)))==3)
                      {
                          CharMarker.put(Character.toString(s.charAt(i)),"F");
                      }
                      if(i+1 == strLen-1 && Marker.get(Character.toString(s.charAt(i+1)))==2 )
                      {
                          CharMarker.put(Character.toString(s.charAt(i)),"F");
                      }
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n8");
             
             //STEP 8
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i))) == 2 && Marker.get(Character.toString(s.charAt(i+1))) != 3 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                 {
                    if(Marker.get(Character.toString(s.charAt(i-1))) == 0 && Marker.get(Character.toString(s.charAt(i+1))) == 0)    
                    {
                          CharMarker.put(Character.toString(s.charAt(i)),"H");      //fullvowel + fullvowel
                    }
                    if(Marker.get(Character.toString(s.charAt(i-1))) == 0 &&  Marker.get(Character.toString(s.charAt(i+1))) == 2 && CharMarker.get(Character.toString(s.charAt(i+1))).equals("U"))
                    {
                        CharMarker.put(Character.toString(s.charAt(i)),"H");                    //fullvowel + unknown
                    }
                    if(Marker.get(Character.toString(s.charAt(i-1))) == 0 && Marker.get(Character.toString(s.charAt(i+1))) == 2 && CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                    {
                        CharMarker.put(Character.toString(s.charAt(i)),"H");                    //fullvowel + fullconsonant
                    }
                    if(Marker.get(Character.toString(s.charAt(i-1))) == 2 && CharMarker.get(Character.toString(s.charAt(i-1))).equals("F") && Marker.get(Character.toString(s.charAt(i+1))) == 0)
                    {
                        CharMarker.put(Character.toString(s.charAt(i)),"H");                    //fullconsonant + fullvowel 
                    }
                    if(Marker.get(Character.toString(s.charAt(i-1))) == 2 && CharMarker.get(Character.toString(s.charAt(i-1))).equals("F") &&  Marker.get(Character.toString(s.charAt(i+1))) == 2 && CharMarker.get(Character.toString(s.charAt(i+1))).equals("U"))
                    {
                         CharMarker.put(Character.toString(s.charAt(i)),"H");                    //fullconsonant + unknown
                    }
                    if(Marker.get(Character.toString(s.charAt(i-1))) == 2 && CharMarker.get(Character.toString(s.charAt(i-1))).equals("F") &&  Marker.get(Character.toString(s.charAt(i+1))) == 2 && CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                    {
                         CharMarker.put(Character.toString(s.charAt(i)),"H");                    //fullconsonant + fullconsonant
                    }
                    else
                        CharMarker.put(Character.toString(s.charAt(i)),"F");
                 }
             }
              for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
                System.out.println("\n After SCHWA Removal");
             
             int k = 0;
             for (i=0 ;i < strLen ; i++)
             {
                 if(Marker.get(Character.toString(s.charAt(i)))==0 || Marker.get(Character.toString(s.charAt(i)))==2 ) //vowel or consonant
                 {
                     if(Marker.get(Character.toString(s.charAt(i)))==0)
                     {
                         answer[k] = s.charAt(i);                                   //fullvowel
                         k++;
                     }
                     if(CharMarker.get(Character.toString(s.charAt(i))).equals("F") && Marker.get(Character.toString(s.charAt(i)))==2)
                     {
                         if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("F") && Marker.get(Character.toString(s.charAt(i+1)))==1)
                         {
                             answer[k] = s.charAt(i);                               //consonant + matraa
                             k++;
                             answer[k] = s.charAt(i+1);
                             k++;
                         }
                         if(Marker.get(Character.toString(s.charAt(i+1)))!=1)
                         {
                             answer[k] = s.charAt(i);                               //consonant + "अ"
                             k++;
                         }
                     }
                     if(CharMarker.get(Character.toString(s.charAt(i))).equals("H") && Marker.get(Character.toString(s.charAt(i)))==2)
                     {  
                             answer[k] = s.charAt(i);                              
                             k++;
                             answer[k] = x1.charAt(0);                                     //consonant + "्"
                             k++;
                     }
                 }
             }
             for (i=0 ;i < answer.length ; i++)
             {
                 System.out.print(answer[i]);
             }
    }
}
