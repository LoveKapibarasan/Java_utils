import BaseClasses.Present;
import Enums.Decorations;
import Factory.PresentFactory;


public class Main {
    public static void main(String[] args) {
        Present p1 = PresentFactory.getInstance().createInBag(Decorations.CARDS);
        Present p2 = PresentFactory.getInstance().createInBox(Decorations.STICKERS, Decorations.TRINKETS);
        Present p3 = PresentFactory.getInstance().createInBox(Decorations.RIBBONS);
        p1.printToConsole();  // present in bag with card
        p2.printToConsole();  // boxed present with stickers with trinkets
        p3.printToConsole();  // boxed present with ribbon
    }
}

	/*
	1st version
	    new PresentInBagWithCard().printToConsole();
		new BoxedPresentWithStickersWithTrinkets().printToConsole();
		new BoxedPresentWithRibbon().printToConsole();
	2nd version
	    BaseClasses.Present p1 = new DecorationImplementationClasses.CardDecorator(new SubBaseClasses.PresentInBag());
		BaseClasses.Present p2 = new DecorationImplementationClasses.TrinketDecorator(new DecorationImplementationClasses.StickerDecorator(new SubBaseClasses.BoxedPresent()));
		BaseClasses.Present p3 = new DecorationImplementationClasses.RibbonDecorator(new SubBaseClasses.BoxedPresent());
		and unnecessary inherited classes are deleted.

	OCP (Open Closed Principle)
	It is easy to extend and does not require any changes to existing classes.
	DRY (Don't Repeat Yourself)

	3rd version
	    Present p1 = Present.builder().inBag().withCard().build();
		Present p2 = Present.builder().inBox().withSticker().withTrinket().build();
		Present p3 = Present.builder().inBox().withRibbon().build();
	 */