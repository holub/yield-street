package yieldstreet.test.packet;

import junit.framework.TestCase;
import org.junit.Test;

public class PacketFilterTest extends TestCase {

    @Test
    public void testPacketFilter() {
        Packet[] packs = {
                Packet.from("000000010000000100000000"),
                Packet.from("000000020000000000000000"),
                Packet.from("000000030000000300000000")};

        assertEquals(2, PacketFilter.filterValid(packs).length);
    }

}