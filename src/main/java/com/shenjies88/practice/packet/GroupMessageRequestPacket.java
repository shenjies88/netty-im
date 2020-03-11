package com.shenjies88.practice.packet;

import com.shenjies88.practice.interfaces.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.GROUP_MESSAGE_REQUEST;

@Data
@AllArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;

    private String message;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
