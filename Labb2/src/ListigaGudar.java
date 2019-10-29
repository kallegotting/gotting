public class ListigaGudar {
    public static void main(String[] args) {
        Kedja<String> enKedja = new Kedja<>();
        enKedja.addFirst("Itzamna");
        enKedja.addFirst("Kinich Ahau");
        enKedja.addFirst("Chaac");
        enKedja.addFirst("Bolon Dzacab");
        enKedja.addLast("Bacabs");
        enKedja.addAt(4, "Ek Chuah");
        System.out.println(enKedja.getFirst());
        System.out.println();
        for (String s : enKedja) {
            System.out.println(s);
        }
        System.out.println("Storlek: " + enKedja.getSize());
        enKedja.removeAt(4);
        System.out.println();
        for (String s : enKedja) {
            System.out.println(s);
        }
        System.out.println("Storlek: " + enKedja.getSize());
    }

}
