package com.murex.retail.experience.Accessory;

import com.murex.retail.experience.Accessory.abstractAccessory;

public class concreteKeyboard extends abstractAccessory implements Keyboard {
    public concreteKeyboard(String id, String category, String name, String brand, String dimension, String color, int price, int quantity) {
        super(id, category, name, brand, dimension, color, price, quantity);

    }
}
