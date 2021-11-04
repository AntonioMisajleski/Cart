
import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Cart g = new Cart();
        System.out.println("Vnesi broj na produkti");
        int x = input.nextInt();
        System.out.println("Vnesi produkti format: (Ime Kategorija Cena)");
        for (int j = 0; j < x; j++) {
            Product z = new Product();

            z.setIme(input.next());
            z.setKategorija(input.next());
            z.setCena(input.nextFloat());
            g.addProduct(z);
        }
        System.out.println("Vo kosnicata imate:");
        g.printPaymentReceipt();
        System.out.println("Vkupnata cena e bez DDV: " + g.getTotalPrice() + " " + "Vkupnata cena so DDV: " + (g.getTotalPrice() + (g.getTotalPrice() * 0.18)));
        System.out.println("Baraj produkt po kategorija");
        System.out.println("Vnesi kategorija");
        String cat = input.next();
        g.printByCategory(cat);

        System.out.println("Vnesi kolku najevtini produkti sakas da vidish vo kosnica");
        int r = input.nextInt();
        System.out.println("Pogledni gi " + r + " najevtinite produkti");
        g.getCheapestN(r);


    }


}

