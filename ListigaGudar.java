package Labb2;


import java.util.NoSuchElementException;

public class ListigaGudar {
    public static void main(String[] args) throws NoSuchElementException {
        KedjaNy<String> enKedja = new KedjaNy<>();
        enKedja.addFirst("Kalle");
        enKedja.addFirst("Pelle");
        enKedja.addFirst("Bosse");
        enKedja.addFirst("Herman");
        enKedja.addFirst("Johan");
        enKedja.addFirst("Bengt");
        enKedja.addAt(3, "Roland");

        System.out.println(enKedja.getHuvud());
        System.out.println();


        for (String s: enKedja){
            System.out.println(s);
        }

        System.out.println("Storlek: " + enKedja.getSize());
        enKedja.removeAt(3);
        System.out.println();
        for (String s: enKedja){
            System.out.println(s);
        }
        System.out.println("Storlek: " + enKedja.getSize());
    }
}
