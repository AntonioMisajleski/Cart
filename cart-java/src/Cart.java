
import java.util.Arrays;

public class Cart {

    private Product[] products;
    private int brProducti;

    public Cart() {
        products = new Product[10];
        brProducti = 0;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" + "products=" + Arrays.toString(products) + '}';
    }

    public void addProduct(Product p) {

        if (brProducti == 10) {
            Product[] productsTemp = new Product[brProducti * 2];
            int i = 0;
            for (Product c : products) {
                productsTemp[i] = c;
                i++;
            }
            products = productsTemp;
            products[brProducti++] = p;
        } else {
            products[brProducti++] = p;
        }


    }


    public void printByCategory(String k) {
        boolean flag = false;
        for (int i = 0; i < brProducti; i++) {
            if (products[i].getKategorija().equals(k)) {
                System.out.println(products[i]);
                flag = true;
            }
        }

        if (flag == false) {
            System.out.println("Nema takov produkt");
        }
    }

    public float getTotalPrice() {
        float total = 0;
        for (int i = 0; i < brProducti; i++) {
            total += products[i].getCena();

        }


        return total;
    }

    public void printPaymentReceipt() {

        SLL<Product> temp = new SLL<>();

        for (int i = 0; i < brProducti; i++) {

            temp.insertLast(products[i]);

        }
        SLLNode<Product> pok = temp.getFirst();

        int count = 1;
        while (pok != null) {
            SLLNode<Product> pok1 = pok.succ;
            count = 1;
            while (pok1 != null) {

                if (pok.element.getIme().equals(pok1.element.getIme())) {
                    temp.delete(pok1);
                    count++;

                }

                pok1 = pok1.succ;
            }
            System.out.println("Ime na produkt: " + pok.element.getIme() + " Kolicina: " + count + " Edinecna cena: " + pok.element.getCena() + " DEN" + " Cena so DDV: " + ((pok.element.getCena() * count) + (pok.element.getCena() * count) * 0.18) + " DEN");

            pok = pok.succ;
        }

    }

    public static void sort(SLL<Product> list) {
        SLLNode<Product> k1 = list.getFirst();
        while (k1 != null) {
            SLLNode<Product> k2 = list.getFirst();
            while (k2 != null) {
                if (k1.element.getCena() < k2.element.getCena()) {

                    Product temp = k1.element;
                    k1.element = k2.element;
                    k2.element = temp;
                }
                k2 = k2.succ;
            }
            k1 = k1.succ;
        }
    }

    public void getCheapestN(int n) {
        SLL<Product> temp = new SLL<>();

        for (int i = 0; i < brProducti; i++) {

            temp.insertLast(products[i]);

        }

        sort(temp);
//          SLLNode<Product> pok = temp.getFirst();
//          SLLNode<Product> pok1 = pok;
//          while (pok!=null){
//
//            if(pok1.succ!=null) {
//                if (pok.element.getIme().equals(pok1.succ.element.getIme())) {
//                    temp.delete(pok1);
//
//                }
//                pok1=pok1.succ;
//            }
//            pok=pok.succ;
//        } ova zavisi od baranjeto ako treba bez duplikati se koristi ovaj kod

        SLLNode<Product> pok = temp.getFirst();

        int count = 0;
        SLL<Product> temp1 = new SLL<>();
        while (pok != null) {
            count++;
            if (count <= n) {
                temp1.insertLast(pok.element);
            }
            pok = pok.succ;

        }


        System.out.println(temp1);
    }
}





