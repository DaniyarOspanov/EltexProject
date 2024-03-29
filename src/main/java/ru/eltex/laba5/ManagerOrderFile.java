package ru.eltex.laba5;

import ru.eltex.laba2.Order;
import ru.eltex.laba2.Orders;

import java.io.*;
import java.util.Iterator;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {
    public static final String BIN_PATH = "/home/scrubi19/Dropbox/EltexJava-Bulatov/Labs/target/binary.bin";

    ManagerOrderFile() {
        target = new File(BIN_PATH);
    }

    @Override
    public Order readByID(UUID id) {
        Order order = null;
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(BIN_PATH))) {
            if (!target.exists()) {
                return null;
            } else {
                order = (Order) oos.readObject();
                if (!order.getUUID().equals(id)) {
                    order = null;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveByID(Order order) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BIN_PATH)))
        {
            if (target.exists()) {
                 oos.writeObject(order);
            } else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public Orders readAll() {
        Orders orders = null;
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(BIN_PATH))) {
            if (!target.exists()) {
                return null;
            }
            orders = (Orders) oos.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BIN_PATH))) {
            if (target.exists()) {
                oos.writeObject(orders);
                oos.flush();
            } else {
                System.out.println("File is not exist. Trying to create new file");
                target.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
