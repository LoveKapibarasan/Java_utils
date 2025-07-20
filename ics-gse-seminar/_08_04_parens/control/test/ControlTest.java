import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControlTest {
    private MockContext mockContext;
    private Control instance;

    @Before public void setUp() {
        mockContext = new MockContext();
        instance = new Control(new DummyLogger(),
                new MockTokenStreamProducer(mockContext),
                new MockTokenStreamConsumer(mockContext),
                new MockTreeProducer(mockContext),
                new MockTreeConsumer(mockContext));
    }

    @Test
    public void testRun() {
        instance.run();
        assertEquals(List.of(MockContext.PRODUCE_TOKEN_STREAM,
                MockContext.CONSUME_TOKEN_STREAM, MockContext.PRODUCE_TREE,
                MockContext.CONSUME_TREE), mockContext.getActions());
    }
}
