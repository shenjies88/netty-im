package com.shenjies88.practice.packet;

import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.JOIN_GROUP_REQUEST;

@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
