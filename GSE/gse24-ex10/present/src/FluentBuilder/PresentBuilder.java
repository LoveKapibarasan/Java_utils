package FluentBuilder;

import BaseClasses.Present;
import DecorationImplementationClasses.CardDecorator;
import DecorationImplementationClasses.RibbonDecorator;
import DecorationImplementationClasses.StickerDecorator;
import DecorationImplementationClasses.TrinketDecorator;
import Decorators.BoxedPresent;
import Decorators.PresentInBag;

public class PresentBuilder {
    private Present present;

    // Private Constructor
    private PresentBuilder() {
    }

    // new
    public static PresentBuilder builder() {
        return new PresentBuilder();
    }

    public PresentBuilder inBox() {
        this.present = new BoxedPresent();
        return this;
    }

    public PresentBuilder inBag() {
        this.present = new PresentInBag();
        return this;
    }

    public PresentBuilder withRibbon() {
        this.present = new RibbonDecorator(present);
        return this;
    }

    public PresentBuilder withSticker() {
        this.present = new StickerDecorator(present);
        return this;
    }

    public PresentBuilder withCard() {
        this.present = new CardDecorator(present);
        return this;
    }

    public PresentBuilder withTrinket() {
        this.present = new TrinketDecorator(present);
        return this;
    }

    public Present build() {
        return this.present;
    }
}
