package com.java.designpatterns.adaptor;

public class AdaptorPattern {

    public static void main(String[] args) {

        OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();
        CoffeeTouchscreenAdapter coffeeTouchscreenAdapter = new CoffeeTouchscreenAdapter(oldCoffeeMachine);
        coffeeTouchscreenAdapter.chooseFirstSelection();
        coffeeTouchscreenAdapter.chooseSecondSelection();
    }

}
