package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Command;
import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private List<String> userIdList;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
