/**
 * @file Odev9_Yakub_Subaşı
 *
 * @description Program çalıştırıldığında kullanıcı tarafından tanımlanmış 2 farklı dosyadan 2 adet BST veri yapısı oluşturulur.
 * Ve oluşturulan 2 veri yapısı belli kurallar dahilinde bir birleri ile yarışılar.
 *
 * @assignment Ödev 9
 *
 * @date Kodu 23.05.2022 tarihinde yazıldı.
 *
 * @author YAKUB SUBAŞI -  yakub5896@gmail.com
 */



public class Main {

    public static void main(String[] args) {
        FileMenager fileMenager = new FileMenager();

        String text1 = fileMenager.readTextFromFile("src/oyuncu1.txt");
        String text2 = fileMenager.readTextFromFile("src/oyuncu2.txt");

        
        BinarySearchTree bts1 = stringToBTS(text1);
        BinarySearchTree bts2 = stringToBTS(text2);

        Game game = new Game(bts1, bts2);
        game.run();

    }

    private static BinarySearchTree stringToBTS(String text1) {
        BinarySearchTree bts1 = new BinarySearchTree();
        String[] numbers = text1.split("#");
        for (String number : numbers) {
            bts1.insert(Integer.parseInt(number));
        }
        return bts1;
    }

}
