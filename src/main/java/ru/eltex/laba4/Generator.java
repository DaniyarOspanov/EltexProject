package ru.eltex.laba4;

import ru.eltex.laba1.*;
import ru.eltex.laba2.*;

public class Generator extends ACheck {

    public Generator(Credentials user, Orders orders) {
        super(user, orders);
    }

    public Generator(Orders orders) {
        super(orders);
    }

    public void Off() {
        fRun = false;
    }

    public void Waiting() {
        fWaiting = true;
    }

    @Override
    public void run() {
        while (fRun) {
            int i = (int) (Math.random() * 2);
            Drink[] drink;

            ShoppingCart cart = new ShoppingCart<>();
            synchronized (cart) {
                switch (i) {
                    case 0:
                        int p = (int) (Math.random() * 3);
                        drink = new Tea[p];
                        for (int j = 0; j < p; j++) {
                            drink[j] = new Tea();
                            drink[j].create();
                            cart.add(drink[j]);
                        }
                        break;
                    case 1:
                        int d = (int) (Math.random() * 3);
                        drink = new Coffee[d];
                        for (int k = 0; k < d; k++) {
                            drink[k] = new Coffee();
                            drink[k].create();
                            cart.add(drink[k]);
                        }
                }
                orders.offer(cart, user);
            }

            if (fWaiting) {
                try {
                    synchronized (this) {
                        wait();
                        fWaiting=false;
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
