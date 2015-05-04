package yieldstreet.test.packet;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class PacketValidatorTest extends TestCase {

    @Parameterized.Parameter(value = 0)
    public String testName;
    @Parameterized.Parameter(value = 1)
    public Packet packet;


    @Parameterized.Parameters(name="{0}")
    public static Collection<Object[]> prepare() throws IOException {
        URL testPath = Resources.getResource("packet-test.txt");
        return  Resources.readLines(testPath, Charsets.US_ASCII)
                .stream()
                .map((line) -> {
                    Packet packet = Packet.from(line.replace("|", ""));
                    return new Object[]{"Sequence" + Integer.toHexString(packet.sequence), packet};
                }).collect(Collectors.toList());
    }

    @Test
    public void testChecksum() throws Exception {
        assertEquals(Integer.toHexString(packet.checksum),
                Integer.toHexString(PacketValidator.calcChecksum(packet)));
    }
}