package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Command;
import com.shenjies88.practice.interfaces.Packet;
import io.netty.channel.group.ChannelGroup;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private List<String> userNameList;

    private ChannelGroup channelGroup;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
