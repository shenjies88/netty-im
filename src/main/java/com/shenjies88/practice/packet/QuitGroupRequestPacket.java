package com.shenjies88.practice.packet;

import com.shenjies88.practice.interfaces.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.QUIT_GROUP_REQUEST;

@Data
@AllArgsConstructor
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
