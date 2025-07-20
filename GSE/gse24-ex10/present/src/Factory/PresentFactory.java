package Factory;

import BaseClasses.Present;
import DecorationImplementationClasses.CardDecorator;
import DecorationImplementationClasses.RibbonDecorator;
import DecorationImplementationClasses.StickerDecorator;
import DecorationImplementationClasses.TrinketDecorator;
import Decorators.BoxedPresent;
import Decorators.PresentInBag;
import Enums.Decorations;

// singleton + factory
public class PresentFactory {
    private final static PresentFactory instance = new PresentFactory();

    //to enforce singleton
    private PresentFactory() {
    }

    public static PresentFactory getInstance() {
        return instance;
    }

    // Box or Bag??
    public Present createInBox(Decorations... decorations) {
        return createPresent(new BoxedPresent(), decorations);
    }

    public Present createInBag(Decorations... decorations) {
        return createPresent(new PresentInBag(), decorations);
    }

    // Decorations?
    public Present createPresent(Present present, Decorations... decorations) {
        // enum <=> switch
        for (Decorations d : decorations) {
            present =
                    switch (d) {
                        case RIBBONS -> new RibbonDecorator(present);
                        case STICKERS -> new StickerDecorator(present);
                        case TRINKETS -> new TrinketDecorator(present);
                        case CARDS -> new CardDecorator(present);
                    };
        }
        return present;
    }
}
