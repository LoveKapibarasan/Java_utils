package DecorationImplementationClasses;

import BaseClasses.Present;
import Decorators.PresentDecorator;

public class RibbonDecorator extends PresentDecorator {
    public RibbonDecorator(Present basePresent) {
        super(basePresent);
    }


    @Override
    public String getDescription() {
        return basePresent.getDescription() + " with ribbon";
    }

}
