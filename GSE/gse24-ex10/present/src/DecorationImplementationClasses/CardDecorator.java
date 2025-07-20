package DecorationImplementationClasses;

import BaseClasses.Present;
import Decorators.PresentDecorator;

public class CardDecorator extends PresentDecorator {
    public CardDecorator(Present delegate) {
        super(delegate);
    }

    @Override
    public String getDescription() {
        return basePresent.getDescription() + " with card";
    }
}
