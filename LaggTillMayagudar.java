package Labb2;

import java.util.NoSuchElementException;

public class LaggTillMayagudar {
    public static void main(String[] args) throws NoSuchElementException {
        KedjaNy<Mayagud> gudar = new KedjaNy<>();
        gudar.addInOrder(new Mayagud("Chac", "Regn och åska", "Chaac är mestadels"));
        gudar.addInOrder(new Mayagud("Ah Puch", "Döden", "Ah Puch gillar"));
        gudar.addInOrder(new Mayagud("Bolon Dzacab", "Förfader", "Bolon Dzacab är en förfadersgud"));

        System.out.println(gudar.getSize());

        for (Mayagud m: gudar){
            System.out.println(m.getNamn() + " (" + m.getTypAvGud() + ")");
        }

        System.out.println();

        if (gudar.contains(new Mayagud("Chac"))){
            System.out.println("Hittades");
        }else {
            System.out.println("Fanns inte");
        }

        if (gudar.contains(new Mayagud("Itzama"))){
            System.out.println("Hittades");
        }else{
            System.out.println("Fanns inte");
        }
    }
}
