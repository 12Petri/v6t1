// Valikkorakenne edellisistä tehtävistä.

package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Instrument> instruments = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää soitin\r\n" + //
                                "2) Listaa soittimet\r\n" + //
                                "3) Viritä kielisoittimet\r\n" + //
                                "4) Soita rumpuja\r\n" + //
                                "0) Lopeta ohjelma");
    
    if(sc.hasNext()) {
            int i = 0;
            String stringInput = sc.nextLine();
            i = Integer.parseInt(stringInput);
                                
        switch (i) {
            case 1:
                System.out.println("Minkä soittimen haluat lisätä? 1) Kitara, 2) Viulu, 3) Rummut");
                int type = Integer.parseInt(sc.nextLine());
                System.out.println("Anna valmistajan nimi:");
                String manufacturer = sc.nextLine();
                System.out.println("Anna hinta euroina:");
                int price = Integer.parseInt(sc.nextLine());

                if (type == 1) {
                    instruments.add(new Guitar(manufacturer, price));
                }
                else if (type == 2) {
                    instruments.add(new Violin(manufacturer, price));
                }
                else if (type == 3) {
                    instruments.add(new Drum(manufacturer, price));
                }
                else {
                    System.out.println("Virheellinen soitinvalinta.");
                    continue;
                }
                System.out.println("Soitin lisätty listaan!");
                break;
            case 2:
                if (instruments.isEmpty()) {
                    System.out.println("Ei lisättyjä soittimia.");
                }
                for (Instrument instrument : instruments) {
                    System.out.println(instrument.getDetails());
                    }
                break;
            case 3:
                for (Instrument instrument : instruments) {
                    if (instrument instanceof StringInstrument) {
                        ((StringInstrument) instrument).tune();
                    }
                }
                break;
            case 4:
                for (Instrument instrument : instruments) {
                    if (instrument instanceof Drum) {
                        ((Drum) instrument).playBeat();
                    }
                }
                break;
            case 0:
                System.out.println("Kiitos ohjelman käytöstä.");
                exit = true;
                break;
            default:
                System.out.println("Syöte oli väärä");
                break;
            }
        }

    }
    sc.close();
    }
}
