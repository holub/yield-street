package yieldstreet.test.packet;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class Packet {
    final int sequence;
    final int checksum;
    final int len;
    final byte[] data;

    public Packet(int sequence, int checksum, int len, byte[] data) {
        this.sequence = sequence;
        this.checksum = checksum;
        this.len = len;
        this.data = data;
    }

    public static Packet from(byte[] packet) {
        //Preconditions.checkArgument(packet.length >= 9, "Broken header");
        ByteArrayDataInput ps = ByteStreams.newDataInput(packet);

        int seq = ps.readInt();
        int chk = ps.readInt();
        int len = ps.readInt();
        byte[] data = new byte[len]; // Is len always correct?
        ps.readFully(data);

        return new Packet(seq, chk, len, data);
    }

    /**
     * @throws IllegalArgumentException if the input is not a valid encoded string according to this encoding.
     */
    public static Packet from(String packet) {
        return from(javax.xml.bind.DatatypeConverter.parseHexBinary(packet));
    }

    public int getSequence() {
        return sequence;
    }

    public int getChecksum() {
        return checksum;
    }

    public byte[] getData() {
        return data;
    }
}
