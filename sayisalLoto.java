import java.util.*;
public class sayisalLoto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        double anaBakiye = 500 ;
        int count = 0 ;
        int[] dizi = new int[5];
        int[] tahmin = new int[5];

        System.out.println("KURAL : \n 1) Minimum bahis tutarı 20 tl dir.  \n 2) 5 sayı girilmelidir. \n 3) Sayı 0 ve 50 arasında olmalıdır. \n 4) Aynı sayı birden fazla kez çıkabilir.");
        System.out.println();
        System.out.println("ANA BAKİYENİZ : " + anaBakiye + "TL");
        System.out.println();
        int secim = 0;

        while (secim!=4){

            for (int i = 0 ; i < dizi.length ; i++){
                dizi[i]= rand.nextInt(51);
            }

            Arrays.sort(dizi);


            System.out.print("1) Bakiye göster. \n2) Para yatır/çek. \n3) Loto oyna. \n4) Çıkış yap \nYapmak istediğiniz işlemi seçiniz : ");
            secim = input.nextInt();

            if (secim == 4 ){
                System.out.println("Güle Güle ! ");
            }

            while (secim < 1 || secim > 4 ){
                System.out.print("Yanlış seçim girdiniz lütfen tekrar deneyiniz : ");
                secim = input.nextInt();
            }

            switch (secim){

                case 1 :
                    System.out.println("Bakiyeniz " + anaBakiye + " tl'dir.");
                    break;

                case 2 :
                    System.out.println(" 1) Para yatır \n 2) Para çek \n Yapmak istediğiniz işlemi giriniz : ");
                    int cashBack = input.nextInt();
                    if (cashBack==1){
                        System.out.print("Yatırmak istediğiniz tutarı girin : ");
                        int cashIn = input.nextInt();
                        anaBakiye += cashIn;
                        System.out.println("Bakiyeniz " + anaBakiye + " tl'dir. ");
                    }
                    else if (cashBack==2){
                        System.out.print("Çekmek istediğiniz tutarı girin : \n Çıkış yapmak");
                        int cashOut = input.nextInt();
                        anaBakiye -= cashOut;
                        System.out.println("Bakiyeniz " + anaBakiye + " tl'dir. ");
                    }
                    else {
                        System.out.println("Yanlış seçim girdiniz. Tekrar deneyin !");
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Bahis ücretini giriniz : ");
                    int bet = input.nextInt();
                    System.out.println();

                    while (bet<20){
                        System.out.print("Bahis ücreti minimum 20 tl olmalıdır. Lütfen tekrar bahis ücreti giriniz : ");
                        bet= input.nextInt();
                    }
                    while (bet>anaBakiye){
                        System.out.println("Yeterli bakiyeniz bulunmamaktadır. Lütfen tekrar bahis ücreti giriniz : ");
                        bet=input.nextInt();
                    }

                    for (int j = 0 ; j<dizi.length ; j++){
                        System.out.print((j+1) + ". sayıyı giriniz : ");
                        tahmin[j] = input.nextInt();
                        if (tahmin[j]>50 || tahmin[j]<0){
                            System.out.println(" DİKKAT : Sayılar 0 ve 50 arasında olmalıdır, bir sonraki yalnış girişinizde bir hakkınız kaybolacaktır ! ");
                            System.out.print((j+1) + ". sayıyı giriniz : " );
                            tahmin[j] = input.nextInt();
                        }
                    }

                    Arrays.sort(tahmin);
                    System.out.println(Arrays.toString(tahmin));

                    for (int l : dizi){
                        for (int k = 0 ; k< dizi.length ; k++){
                            if (l == tahmin[k]){
                                count++;
                            }
                        }
                    }

                    if (count > 0)
                        System.out.println("TEBRİKLER " + count + " doğru tahmin yaptınız !");

                    else{
                        System.out.println("Maalesef doğru tahmin yapamadınız..");
                        anaBakiye-=bet;
                    }



                    switch (count){
                        case 1 :
                            System.out.println(bet*1.5 + " TL kazandınız ! ");
                            anaBakiye +=bet*1.5;
                            System.out.println("Yeni bakiye : " + anaBakiye);
                            break;

                        case 2:
                            System.out.println((((bet*2)+50)) + " TL kazandınız ! ");
                            anaBakiye += ((bet*2) + 50);
                            System.out.println("Yeni bakiye : " + anaBakiye);
                            break;

                        case 3:
                            System.out.println((bet*4) + " TL kazandınız ! ");
                            anaBakiye += bet*4;
                            System.out.println("Yeni bakiye : " + anaBakiye);
                            break;

                        case 4:
                            System.out.println((bet*8) + " TL kazandınız ! ");
                            anaBakiye += bet*8;
                            System.out.println("Yeni bakiye : " + anaBakiye);
                            break;

                        case 5:
                            System.out.println((bet*18) + " TL kazandınız ! ");
                            anaBakiye += bet*18;
                            System.out.println("Yeni bakiye : " + anaBakiye);
                            break;

                        default:
                            System.out.println();
                    }
                    System.out.println("TALİHLİ SAYILAR : " + Arrays.toString(dizi));
            }
            count=0;
        }
    }
}