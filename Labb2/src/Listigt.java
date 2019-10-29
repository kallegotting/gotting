public class Listigt {
    public static void main(String[] args) {
        Kedja lista = new Kedja();
        lista.addFirst("Albin");
        lista.addFirst("Kalle");
        lista.addFirst("Lisa");

        System.out.println(lista.getFirst());

        lista.removeFirst();
        System.out.println(lista.getFirst());

    }
}
