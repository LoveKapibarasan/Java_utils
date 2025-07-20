package DecorationImplementationClasses;

import BaseClasses.Present;
import Decorators.PresentDecorator;

public class StickerDecorator extends PresentDecorator {
    public StickerDecorator(Present basePresent) {
        super(basePresent);
    }

    @Override
    public String getDescription() {
        return basePresent.getDescription() + " with sticker";
    }
}
