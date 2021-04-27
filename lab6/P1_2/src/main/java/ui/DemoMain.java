package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;

public class DemoMain {
    /**
     * demonstrates a client for ramdom euromillions bets
     */
    public static void main(String[] args) {
        CuponEuromillions thisWeek = new CuponEuromillions();
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

    }
}
