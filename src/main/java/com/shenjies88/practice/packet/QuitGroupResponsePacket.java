package com.shenjies88.practice.packet;

import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.QUIT_GROUP_RESPONSE;

@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private Boolean success;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
