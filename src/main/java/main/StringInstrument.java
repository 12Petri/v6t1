package main;

public class StringInstrument extends Instrument {
    protected int stringsAmount;

    public StringInstrument(String manufacturer, int price, int stringsAmount) {
        super(manufacturer, price);
        this.stringsAmount = stringsAmount;
    }

    public void tune() {
        System.out.println(manufacturer + " soittimesta viritettiin " + stringsAmount + " kieltä!");
    }
}
