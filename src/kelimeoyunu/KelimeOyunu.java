
package kelimeoyunu;

import com.sun.javafx.geom.transform.BaseTransform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Selim Metehan AKTAS
 */
public class KelimeOyunu {

   
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       sorular oyunSoruları = new sorular();
       Timer zaman = new Timer();
       int soruSayisi = 1 ;
       int toplananPuan = 0 ;
       int random ;
       int timer = 0 ;
       
       for(int i = 0 ; i < 14 ; i++){
           
           int kelimeBoyutu = oyunSoruları.sorular[i][0].length();
           char[] kelime = oyunSoruları.sorular[i][0].toCharArray();
           int puan = kelimeBoyutu * 100 ;
           
           System.out.println("////////\\\\\\\\ " + soruSayisi + ".Soru" + "////////\\\\\\\\");
           
           char[] hayaletKelime = new char[kelimeBoyutu];
           for (int k = 0; k <kelimeBoyutu; k ++) {
               hayaletKelime[k] = '-' ;
           }
           
           System.out.println(Arrays.toString(hayaletKelime) + "(" + oyunSoruları.sorular[i][1] + ")");
           
           
           List<String> randomList = new ArrayList<>();
           String harfAl = null ;
           
           do {
               boolean x = false ;
               String harfAlayım = null ;
               System.out.println("Harf Almak İstiyorsanız klavyeden (h) Tahmin Hakkı Kullanmak İstiyorsanız (t) Girişi Yapınız! ");
               harfAl = input.next();
           
               while (!x) {
                   if (harfAl.equals("h") || harfAl.equals("t")) {
                       x = true;
                       break;
                   }
                   else{
                       System.err.println("EKSİK VEYA HATALI GİRİŞ YAPTINIZ!");
                       System.out.println("Harf Almak İstiyorsanız klavyeden (h) Tahmin Hakkı Kullanmak İstiyorsanız (t) Girişi Yapınız! ");
                       harfAl = input.next();
                   }
               }
               
               harfAlayım=harfAl ;
               if(harfAlayım != null &&  harfAlayım.equals("h")) {
                   timer++ ;
                   puan = puan - 100 ;
                   boolean alayım = false;
                   while(!alayım){
                       random = (int) Math.round(Math.random() * (kelimeBoyutu - 1 ));
                       if (randomList.size() == 0 ) {
                           randomList.add(String.valueOf(random));
                           hayaletKelime[random] = kelime[random]; 
                           System.out.println(Arrays.toString(hayaletKelime));
                           break;
                       }
                       else {
                           for(int k = 0;   k < randomList.size() ; k++ ){
                               if(randomList.contains(String.valueOf(random))) {
                                   random = (int) Math.round(Math.random() * (kelimeBoyutu - 1));
                               } else {
                                   randomList.add(String.valueOf(random));
                                   hayaletKelime[random] = kelime[random];
                                   System.out.println(Arrays.toString(hayaletKelime));
                                   alayım = true;
                                   break;
                               }
                           }
                       }
                   }
               }
             
             else if (harfAlayım != null && harfAlayım.equals("t")) {
                   System.out.println("Yapmış Olduğunuz Tahmini Yazınız.");
                   String tahmin = input.next();
                   tahmin = tahmin.toUpperCase();
                   if (tahmin.equals(oyunSoruları.sorular[i][0])) {
                       System.out.println("Tahmininiz Doğrudur! Puan Durumunuz :"  + puan );
                       break;
                   }
                   else {
                     System.out.println("Yanlış Tahmin! Sonraki Tur Daha Dikkatli Olun! Bu Sorudan Puan Kazanamadınız. ");
                     System.out.println("Doğru Kelime"  +   oyunSoruları.sorular[i][0]);
                     puan = 0 ;
                     break ;
                     }
             }
           
                                                
           
           
       } while(harfAl.equals("h") && harfAl != null );
               
           int p = puan ;
           toplananPuan = toplananPuan + p ;
           soruSayisi++ ;
       }
        
        System.out.println(" ///////////////****\\\\\\\\\\\\\\\\ ");
        System.out.println("OYUN SONA ERDİ , KATILDIĞINIZ İÇİN TEŞEKKÜR EDERİZ!");
        System.out.println("BU OYUNDA TOPLADIĞINIZ PUAN :" + toplananPuan + " !TEBRİKLER! ");
        
    }
    
}
