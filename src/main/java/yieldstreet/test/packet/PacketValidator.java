package yieldstreet.test.packet;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.UnsignedBytes;

public class PacketValidator {

    public static boolean isValid(Packet packet) {
        return calcChecksum(packet) == packet.checksum;
    }

    /**
     * This method was created according to the spec
     */
    public static int calcChecksum(Packet packet) {
        int checksum = packet.sequence;

        ByteArrayDataInput dis = ByteStreams.newDataInput(packet.getData());
        int len = packet.len;
        int shft = 24;
        while(len > 0 || shft != 24) {
            int current = len > 0
                    ? UnsignedBytes.toInt(dis.readByte())
                    : 0xAB;
            checksum ^= current << shft;
            len--;
            shft = shft == 0 ? 24 : shft-8;
        }

        return checksum;
    }

    /**
     * This checksum satisfy most of received test cases
     */
    public static int calcChecksumReverseEngineering(Packet packet) {
        int checksumOriginal = calcChecksum(packet) - 1;
        int checksum = 0;
        for(byte i = 0; i < 4; i++) {
            checksum ^= ((checksumOriginal >>> i*8) & 0xff) << ((3-i)*8);
        }

        return checksum;
    }
}
