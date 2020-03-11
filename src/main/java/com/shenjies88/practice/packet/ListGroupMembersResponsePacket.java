package com.shenjies88.practice.packet;

import com.shenjies88.practice.impl.Session;
import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import java.util.List;

import static com.shenjies88.practice.interfaces.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
