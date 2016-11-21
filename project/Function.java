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
                     CharMarker.put(Character.toString(s.charAt(i)),"F");  
                    // System.out.println("combined1: "+array[i]);
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
                      //  System.out.println("combined2: "+array[i]+array[i+1]);
                        flag = 0;
                     }
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==3)       //consonant + halant
                     {
                       //  CharMarker.put(Character.toString(s.charAt(i)),"H");
                       //  CharMarker.put(Character.toString(s.charAt(i+1)),"H");
                         CharMarker.put(Character.toString(s.charAt(i))+Character.toString(s.charAt(i+1)),"H");
                       //  System.out.println("combined3: "+array[i]+array[i+1]);
                         flag = 0;
                     }
                     if(flag != 0)
                     {
                         CharMarker.put(Character.toString(s.charAt(i)),"U");       //consonant + अ
                        // System.out.println("combined4: "+array[i]);
                     }  
                 }
             } 
//             Set set = CharMarker.entrySet();
//             Iterator itr = set.iterator();
//             while(itr.hasNext())
//             {
//                Map.Entry me = (Map.Entry)itr.next();
//                System.out.print(me.getKey() + ":");
//                System.out.print(me.getValue() + " ");
//             }
//             System.out.println("\n2");
             //STEP 2-------------------------------------------------------------------------------------------
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1))) != 1 && Character.toString(array[i]).equals("य") && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
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
                 if(flag != 0 && (i-2)>=0 && i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1))) != 1 && Character.toString(array[i]).equals("य") && CharMarker.get(Character.toString(s.charAt(i))).equals("U") )
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
             System.out.println("\n3");
             //STEP3-----------------------------------------------------------------------------------------------
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(Character.toString(array[i]).equals("य")) 
                 {
                     if(i== strLen)
                     {
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1))) != 1)
                     {  
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                 }
                 if(Character.toString(array[i]).equals("र")) 
                 {
                     if(i== strLen)
                     {
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1))) != 1)
                     {  
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                 }
                 if(Character.toString(array[i]).equals("ल")) 
                 {
                     if(i== strLen)
                     {
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1))) != 1)
                     {  
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                 }
                 if(Character.toString(array[i]).equals("व")) 
                 {
                     if(i== strLen)
                     {
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1))) != 1)
                     {  
                         if(i-2>=0 && CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {   
                            String temp = Character.toString(s.charAt(i-2));
                            if(Marker.get(temp) == 2  && Character.toString(array[i-1]).equals("्") )
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"F");
                            }
                        }
                     }
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n4");
             //STEP 4--------------------------------------------------------------------------------------------
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(Marker.get(Character.toString(s.charAt(i))) == 2)
                 {
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) == 0)
                     {  
                         if(CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {
                            CharMarker.put(Character.toString(s.charAt(i)),"F");
                        }
                     }
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n5");
//           //STEP 5---------------------------------------------------------------------------------------
             flag = 1;
             for (i=0 ;i < strLen && flag!=0; i++)
             {
                 array[i] = s.charAt(i);      
                 if(Marker.get(Character.toString(s.charAt(i))) == 2)
                 {
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1)))!= 1)
                     {  
                         if(CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {
                            CharMarker.put(Character.toString(s.charAt(i)),"F");
                            flag = 0;
                        }
                     }
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1)))== 1)
                     {
                         flag = 0;
                     }      
                 }
                 if(Marker.get(Character.toString(s.charAt(i))) == 0)
                 {
                     flag = 0;
                 }        
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n6"); 
             //STEP 6--------------------------------------------------------------------------------------
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
             //STEP 7------------------------------------------------------------------------------------------
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(Marker.get(Character.toString(s.charAt(i))) == 2)
                 {
                     if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+1))) == 2 &&  Marker.get(Character.toString(s.charAt(i+2))) == 3)
                     {  
                         if(CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {
                            CharMarker.put(Character.toString(s.charAt(i)),"F");
                        }
                     }
                     if(i+1 == strLen-1 && Marker.get(Character.toString(s.charAt(i+1))) == 2 && CharMarker.get(Character.toString(s.charAt(i+1))).equals("H"))
                     {  
                         if(CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {
                            CharMarker.put(Character.toString(s.charAt(i)),"F");
                        }
                     }                   
                 }
             }
             for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.println("\n8");
             //STEP 8--------------------------------------------------------------------------------------
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 array[i] = s.charAt(i);
                 if(Marker.get(Character.toString(s.charAt(i))) == 2)
                 {
                     if(i+1 < strLen && Marker.get(Character.toString(s.charAt(i+1))) != 3 && Marker.get(Character.toString(s.charAt(i+1)))!=1)
                     { 
                         if(CharMarker.get(Character.toString(s.charAt(i))).equals("U"))
                        {
                            if(i-1>=0 && Marker.get(Character.toString(s.charAt(i-1))) == 0 && Marker.get(Character.toString(s.charAt(i+1))) == 0)    
                            {
                                  CharMarker.put(Character.toString(s.charAt(i)),"H");      //fullvowel + fullvowel
                                  flag = 0;
                            }
                            if(i-1>=0 && Marker.get(Character.toString(s.charAt(i-1))) == 0 && Marker.get(Character.toString(s.charAt(i+1))) == 2)
                            {                               
                                if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+2))) != 3 && Marker.get(Character.toString(s.charAt(i+2)))!=1)
                                { 
                                    if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("U") || CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                                   {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  
                                       flag = 0;
                                   }
                                }                                              //fullvowel + unknown/NewFullConsonant
                                if(i+2 == strLen)
                                { 
                                    if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("U") || CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                                   {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H"); 
                                       flag = 0;
                                   }
                                }
                            }
                            if(i-1>=0 && Marker.get(Character.toString(s.charAt(i-1))) == 0 && Marker.get(Character.toString(s.charAt(i+1))) == 2)
                            {                               
                                if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+2))) == 1)
                                {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  //fullvowel + matraconsonant
                                       flag = 0;
                                }
                            }
                            if(i-2>=0 && Marker.get(Character.toString(s.charAt(i-2))) == 2 && Marker.get(Character.toString(s.charAt(i-1))) == 1 && Marker.get(Character.toString(s.charAt(i+1))) == 0)
                            {        
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  //matraconsonant + fullvowel
                                       flag = 0;
                            }
                            if(i-2>=0 && Marker.get(Character.toString(s.charAt(i-2))) == 2 && Marker.get(Character.toString(s.charAt(i-1))) == 1 && Marker.get(Character.toString(s.charAt(i+1))) == 2)
                            {        
                                       if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+2))) != 3 && Marker.get(Character.toString(s.charAt(i+2)))!=1)
                                { 
                                    if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("U") || CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                                   {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  
                                       flag = 0;
                                   }
                                }                                              //matraconsonant + unknown/NewFullConsonant
                                if(i+1 == strLen-1)
                                { 
                                    if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("U") || CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                                   {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H"); 
                                       flag = 0;
                                   }
                                }
                            }
                            if(i-2>=0 && Marker.get(Character.toString(s.charAt(i-2))) == 2 && Marker.get(Character.toString(s.charAt(i-1))) == 1 && Marker.get(Character.toString(s.charAt(i+1))) == 2)
                            {        
                                 if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+2))) == 1)
                                {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  //matraconsonant + matraconsonant
                                       flag = 0;
                                }
                            }
                            if(i-1>=0 && Marker.get(Character.toString(s.charAt(i-1))) == 2 && Marker.get(Character.toString(s.charAt(i+1))) == 0)
                            {        
                                if(CharMarker.get(Character.toString(s.charAt(i-1))).equals("F"))
                                {
                                    CharMarker.put(Character.toString(s.charAt(i)),"H");
                                    flag = 0;
                                }  //fullconsonant + fullvowel
                            }
                            if(i-1>=0 && Marker.get(Character.toString(s.charAt(i-1))) == 2 &&CharMarker.get(Character.toString(s.charAt(i-1))).equals("F") && Marker.get(Character.toString(s.charAt(i+1))) == 2)
                            {        
                                if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+2))) != 3 && Marker.get(Character.toString(s.charAt(i+2)))!=1)
                                { 
                                    if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("U") || CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                                   {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  
                                       flag = 0;
                                   }
                                }                                              //fullconsonant + unknown/NewFullConsonant
                                if(i+1 == strLen-1)
                                { 
                                    if(CharMarker.get(Character.toString(s.charAt(i+1))).equals("U") || CharMarker.get(Character.toString(s.charAt(i+1))).equals("F"))
                                   {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H"); 
                                       flag = 0;
                                   }
                                }
                            }
                            if(i-1>=0 && Marker.get(Character.toString(s.charAt(i-1))) == 2 &&CharMarker.get(Character.toString(s.charAt(i-1))).equals("F") && Marker.get(Character.toString(s.charAt(i+1))) == 2)
                            {        
                                 if(i+2 < strLen && Marker.get(Character.toString(s.charAt(i+2))) == 1)
                                {
                                       CharMarker.put(Character.toString(s.charAt(i)),"H");  //fullconsonant + matraconsonant
                                       flag = 0;
                                }
                            }
                            else if(flag==1)
                                CharMarker.put(Character.toString(s.charAt(i)),"F");
                        }
                     }                
                 }
             }
              for ( String key : CharMarker.keySet() ) 
             {
                System.out.print( key + ":" + CharMarker.get(key) + " ");
             }
             System.out.print("After SCHWA Removal : ");
             int k = 0;
             for (i=0 ;i < strLen ; i++)
             {
                 flag = 1;
                 System.out.println(s.charAt(i));
               //  array[i] = s.charAt(i);
                 if(Marker.get(Character.toString(s.charAt(i)))==0)             //FullVowel
                 {
                     answer[k] = s.charAt(i);                                   //fullvowel
                     k++;
                 }
                 if(Marker.get(Character.toString(s.charAt(i)))==2)        //Consonant
                 {
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==1)       //MatraVowel
                     {
                        answer[k] = s.charAt(i);
                        k++;
                        answer[k] = s.charAt(i+1);
                        k++;
                        flag = 0;
                     }
                     if((i+1)< strLen && Marker.get(Character.toString(s.charAt(i+1)))==3)       //consonant + halant
                     {
                        answer[k] = s.charAt(i);
                        k++;
                        answer[k] = s.charAt(i+1);
                        k++;
                        flag = 0;
                     }
                     if(flag != 0)
                     {
                         if(CharMarker.get(Character.toString(s.charAt(i))).equals("F"))
                         {
                             answer[k] = s.charAt(i);
                             k++;
                         }
                         else if(CharMarker.get(Character.toString(s.charAt(i))).equals("H"))
                         {
                             answer[k] = s.charAt(i);
                             k++;
                             answer[k] = x1.charAt(0);
                             k++;
                         }
                     }  
                 }
             }
             answer[k] = dummy.charAt(0);
             String ans = new String(answer);
             for (i=0 ;i < ans.length() && ans.charAt(i) != dummy.charAt(0) ; i++)
             {
                 System.out.print(answer[i]);
             }
             System.out.println("");
             
             for (i=0 ;i < ans.length() && ans.charAt(i) != dummy.charAt(0) ; i++)
             {
                 System.out.print("char : " + ans.charAt(i) + "\n");
             }
             System.out.print("Syllable Boundary: ");
             
             k = 0;
             strLen = answer.length;
             for (i=0 ; ans.charAt(i) != dummy.charAt(0) && i < strLen ; i++)
             {
                 flag = 0;
               //  array[i] = s.charAt(i);
              //    System.out.print("char : " + ans.charAt(i) + "\n");
                 if(Marker.get(Character.toString(answer[i]))==0)     //FullVowel
                 {
                     Syllable[k] = answer[i];                               
                     k++;
                     if(ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && (i+2)< strLen &&  Marker.get(Character.toString(answer[i+1]))==2 && Marker.get(Character.toString(answer[i+2]))==1)       
                     {                                                                         //FullVowel + MatraConsonant
                        Syllable[k] = '-';              //break
                        k++;
                        flag=1;
                     }
                     if(ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && (i+2)< strLen && Marker.get(Character.toString(answer[i+1]))==2 && Marker.get(Character.toString(answer[i+2]))!=3 && Marker.get(Character.toString(answer[i+2]))!=1)       
                     {                                                                         //FullVowel + Consonant(FULL)
                         if(CharMarker.get(Character.toString(answer[i+1])).equals("F"))
                         {
                               Syllable[k] = '-';              //break
                               k++;
                               flag=1;
                         }
                     }
                     if((i+2)== strLen && Marker.get(Character.toString(answer[i+1]))==2)       
                     {                                                                         //FullVowel + LastConsonant(FULL)
                         if(CharMarker.get(Character.toString(answer[i+1])).equals("F"))
                         {
                               Syllable[k] = '-';              //break
                               k++;
                               flag=1;
                         }
                     }
                 }
                 if(Marker.get(Character.toString(answer[i]))==2)        //Consonant
                 {
                     Syllable[k] = answer[i];
                     k++;
                     if(i!=0 && ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && (i+2)< strLen &&  Marker.get(Character.toString(answer[i+1]))==3 && Marker.get(Character.toString(answer[i+2]))==0) 
                     {
                                                                            //consonantHalant(H)+Vowel
                           Syllable[k] = '-';
                           k++;
                           flag=1;
                      
                     }
                     if(ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && (i+2)<strLen &&  Marker.get(Character.toString(answer[i+1]))==2 && Marker.get(Character.toString(answer[i+2]))!=3 && Marker.get(Character.toString(answer[i+2]))!=1) //consonant(F)+consonant(F)
                     {
                        if(CharMarker.get(Character.toString(answer[i])).equals("F") && CharMarker.get(Character.toString(answer[i+1])).equals("F"))
                        {
                            Syllable[k] = '-';
                            k++;
                            flag=1;
                        }
                     }
                     if(i!=0 && ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && ans.charAt(i+3) != dummy.charAt(0) && (i+3)<strLen &&  Marker.get(Character.toString(answer[i+1]))==3 && Marker.get(Character.toString(answer[i+2]))==2 && Marker.get(Character.toString(answer[i+3]))!=3 && Marker.get(Character.toString(answer[i+3]))!=1) 
                     {
                        if(CharMarker.get(Character.toString(answer[i+2])).equals("F") && i!=0) //consonantHalant(H)+consonant(F)
                        {
                            Syllable[k] = '-';
                            k++;
                            flag=1;
                        }
                     }
                     if(ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && (i+2)<strLen &&  Marker.get(Character.toString(answer[i+1]))==2 && Marker.get(Character.toString(answer[i+2]))==1) //consonant(F)+matraConsonant(F)
                     {
                        if(CharMarker.get(Character.toString(answer[i])).equals("F"))
                        {
                            Syllable[k] = '-';
                            k++;
                            flag=1;
                        }
                     }
                     if(i!=0 && ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && ans.charAt(i+3) != dummy.charAt(0) && ans.charAt(i+3) != dummy.charAt(0) && (i+3)<strLen &&  Marker.get(Character.toString(answer[i+1]))==3 && Marker.get(Character.toString(answer[i+2]))==2 && Marker.get(Character.toString(answer[i+3]))==1) //consonantHalant(H)+matraConsonant(F)
                     {  
                            Syllable[k] = '-';
                            k++;
                            flag=1;
                      }
                      if(ans.charAt(i+1) != dummy.charAt(0) && (i+1)< strLen &&  Marker.get(Character.toString(answer[i+1]))==1)       //Matraconsonant
                      {
                            Syllable[k] = answer[i+1];
                            k++;
                            if(ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && ans.charAt(i+3) != dummy.charAt(0) && (i+3)<strLen &&  Marker.get(Character.toString(answer[i+2]))==2 && Marker.get(Character.toString(answer[i+3]))!=3 && Marker.get(Character.toString(answer[i+3]))!=1) //matraconsonant+consonant
                           {
                               if(CharMarker.get(Character.toString(answer[i+2])).equals("F"))
                               {
                                   Syllable[k] = '-';
                                   k++;
                                   flag=1;
                               }
                           }
                           if(ans.charAt(i+1) != dummy.charAt(0) && ans.charAt(i+2) != dummy.charAt(0) && ans.charAt(i+3) != dummy.charAt(0) && (i+3)<strLen &&  Marker.get(Character.toString(answer[i+2]))==2 && Marker.get(Character.toString(answer[i+3]))==1) //matraconsonant+matraconsonant
                           {
                                Syllable[k] = '-';
                                k++;
                                flag=1;
                           }
                      }
                      if(ans.charAt(i+1) != dummy.charAt(0) && (i+1)< strLen &&  Marker.get(Character.toString(answer[i+1]))==3 && ans.charAt(i+2) != dummy.charAt(0)&&flag!=1)       //Matraconsonant
                      {
                            Syllable[k] = answer[i+1];
                            k++;
                      }
                 }
//                 for (j=0 ;j < Syllable.length ; j++)
//                {
//                     System.out.print(Syllable[j]);
//                }
//                System.out.println("");
             } 
             for (i=0 ;i < Syllable.length ; i++)
             {
                 System.out.print(Syllable[i]);
             }
             System.out.println("");
    }
}
