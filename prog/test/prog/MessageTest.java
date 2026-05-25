package prog;

import prog.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {

        Message message = new Message(
                0,
                "+27718693002",
                "Hi Mike"
        );

        assertEquals(
                "Message ready to send.",
                message.checkMessageLength()
        );
    }

    @Test
    public void testRecipientCorrectlyFormatted() {

        Message message = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                message.checkRecipientCell()
        );
    }

    @Test
    public void testSendMessage() {

        Message message = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Message successfully sent.",
                message.sentMessage(1)
        );
    }
}