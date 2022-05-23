import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    BinarySearchTree gamer1;
    BinarySearchTree gamer2;
    int gamer1Score = 0;
    int gamer2Score = 0;


    public int turn = 0;

    // to check has any player won 5 rounds in a row
    int gamer1üstüsewin = 0;
    int gamer2üstüsewin = 0;


    Game(BinarySearchTree gamer1, BinarySearchTree gamer2) {
        this.gamer1 = gamer1;
        this.gamer2 = gamer2;
    }



    void run(){

        while (turn<21 && gamer1üstüsewin<5 && gamer2üstüsewin<5) {
            turn();
            while (true){
                System.out.println("Devam (D)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("D")   || input.equals("d")){
                break;
                 }
            }
        }
        if (gamer1üstüsewin>=5){
            System.out.println("****************************************************************\n" +
                    "5 Kere üst üste galip geldiği için Oyuncu1 kazandı \n" +"****************************************************************");
        }
        else if (gamer2üstüsewin>=5){
            System.out.println("****************************************************************\n" +
                    "5 Kere üst üste galip geldiği için Oyuncu2 kazandı \n" +"****************************************************************");
        }
        else if (turn>=21){
            if (gamer1Score>gamer2Score){
                System.out.println("****************************************************************\n" +
                        "Oyuncu1 kazandı \n" +"****************************************************************");
            }
            else if (gamer1Score<gamer2Score){
                System.out.println("****************************************************************\n" +
                        "Oyuncu2 kazandı \n" +"****************************************************************");
            }
            else {
                System.out.println("****************************************************************\n" +
                        "Berabere \n" +"****************************************************************");
            }
        }
    }








    void turn(){
        turn++;

        System.out.println("Oyuncu1 ağacı post order gezinti sonucu:");
        gamer1.postOrder();
        System.out.println("\nOyuncu1 ağacı toplam soy sayısı: " + gamer1.totalChildrenNumberofAllNodes());
        System.out.println("*************************");
        System.out.println("Oyuncu2 ağacı post order gezinti sonucu:");
        gamer2.postOrder();
        System.out.println("\nOyuncu2 ağacı toplam soy sayısı: " + gamer2.totalChildrenNumberofAllNodes());

        if (gamer1.totalChildrenNumberofAllNodes() < gamer2.totalChildrenNumberofAllNodes()) {
            gamer1Score++;
            System.out.println("============= Oyuncu 1 kazandı! =============");
            System.out.println("Tur " + turn + ": Toplam Skor!");
            System.out.println("Oyuncu1 skoru: " + gamer1Score);
            System.out.println("Oyuncu2 skoru: " + gamer2Score);
            gamer1.insert(gamer2.findMax(gamer2.root).key);
            gamer2.deleteMax(gamer2.root);
            gamer2.insert(gamer1.root.key);
            gamer1.deleteRoot(gamer1.root);
            gamer1üstüsewin++;
            gamer2üstüsewin = 0;
        } else if (gamer1.totalChildrenNumberofAllNodes() > gamer2.totalChildrenNumberofAllNodes()) {
            gamer2Score++;
            System.out.println("============= Oyuncu 2 kazandı! =============");
            System.out.println("Tur " + turn + ": Toplam Skor!");
            System.out.println("Oyuncu1 skoru: " + gamer1Score);
            System.out.println("Oyuncu2 skoru: " + gamer2Score);
            gamer2.insert(gamer1.findMax(gamer1.root).key);
            gamer1.deleteMax(gamer1.root);
            gamer1.insert(gamer2.root.key);
            gamer2.deleteRoot(gamer2.root);
            gamer2üstüsewin++;
            gamer1üstüsewin = 0;

        } else {
            System.out.println("===============Aynı sayıda soyluk var===============\n Oyuncu1'in kökü Oyuncu2'ye, Oyuncu2'nin kökü Oyuncu1'e gönderiliyor.");
            System.out.println("Tur " + turn + ": Toplam Skor!");
            System.out.println("Oyuncu1 skoru: " + gamer1Score);
            System.out.println("Oyuncu2 skoru: " + gamer2Score);
            gamer2.insert(gamer1.root.key);
            gamer1.deleteRoot(gamer1.root);
            gamer1.insert(gamer2.root.key);
            gamer2.deleteRoot(gamer2.root);
        }



    }



}
