package yieldstreet.test.packet;

import java.util.Arrays;

public class PacketFilter {

    /**
     * filter valid Packets only
     */
    public static Packet[] filterValid(Packet... packets) {
        return Arrays.stream(packets)
                .filter(PacketValidator::isValid)
                .toArray(Packet[]::new);
    }
}
