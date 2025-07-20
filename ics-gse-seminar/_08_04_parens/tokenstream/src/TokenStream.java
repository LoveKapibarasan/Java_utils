import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TokenStream {
    private final List<Token> tokens;

    public TokenStream() {
        tokens = new ArrayList<>();
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public List<Token> getTokens() {
        return Collections.unmodifiableList(tokens);
    }
}
