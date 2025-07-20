package Decorators;

import BaseClasses.Present;

public abstract class PresentDecorator extends Present {
    protected final Present basePresent;

    protected PresentDecorator(Present basePresent) {
        this.basePresent = basePresent;
    }
}
