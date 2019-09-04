package ru.eltex.laba1;

import java.util.Random;

public class RandValue {
    private String[] NameTea = {"Assam", "Greenfield", "Lipton", "29", "Richard", "AhmadTea"};
    private String[] NameCoffee = {"bushido", "Черная Карта", "Nescafe", "Nespresso", "Klimbo", "Lavazza", "Живой кофе"};
    private String[] Provider = {"KDV", "Nestlea", "JFK", "TME"};
    private String[] Country = {"England", "China", "Russia", "Germany", "Spain"};
    private String[] TypeBox = {"box", "package", "bunch"};
    private String[] GrainType = {"Арабика", "Робуста"};

    private Random rand = new Random();

    String RandNameTea() {
        return NameTea[rand.nextInt(NameTea.length)];
    }
    String RandNameCoffee() {
        return NameCoffee[rand.nextInt(NameCoffee.length)];
    }
    String RandProvider() {
        return Provider[rand.nextInt(Provider.length)];
    }
    String RandCountry() {
        return Country[rand.nextInt(Country.length)];
    }
    String RandTypeBox() {
        return TypeBox[rand.nextInt(TypeBox.length)];
    }
    String RandGrainType() {
        return GrainType[rand.nextInt(GrainType.length)];
    }
}
