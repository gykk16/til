package dev.glory.solid.i;

import dev.glory.solid.i.separeted.BearCleaner;
import dev.glory.solid.i.separeted.BearFeeder;

public class BearCarer implements BearCleaner, BearFeeder {

    @Override
    public void washTheBear() {
        // wash bear
    }

    @Override
    public void feedTheBear() {
        // feed bear
    }

}
