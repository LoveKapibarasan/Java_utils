package DecorationImplementationClasses;

import BaseClasses.Present;
import Decorators.PresentDecorator;

public class TrinketDecorator extends PresentDecorator {
    public TrinketDecorator(Present delegate) {
        super(delegate);
    }

    @Override
    public String getDescription() {
        return basePresent.getDescription() + " with trinket";
    }
}
