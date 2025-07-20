public class Client {
    public static void main(String[] args) {
        String s = "ThiS iS a CaSE sEnSiTiVe STRing";
        CharByCharProcessor p = new CharByCharProcessor(Character::toUpperCase);
        System.out.println(p.process(s));
        p.setStrategy(Character::toLowerCase);
        System.out.println(p.process(s));
    }
}
