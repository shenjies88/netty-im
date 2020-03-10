package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.LOGIN_RESPONSE;

@Data
public class LoginResponsePacket extends Packet {

    private Boolean success;

    private String reason;

    private String userName;

    private String userId;

    public boolean isSuccess() {
        return success;
    }

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
