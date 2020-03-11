package com.shenjies88.practice.packet;

import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.JOIN_GROUP_RESPONSE;

@Data
public class JoinGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private String reason;

    public boolean isSuccess() {
        return success;
    }

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
