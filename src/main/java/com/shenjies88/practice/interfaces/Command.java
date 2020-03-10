package com.shenjies88.practice.interfaces;

public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

    Byte CREATE_GROUP_REQUEST = 5;

    Byte CREATE_GROUP_RESPONSE = 6;

    Byte QUIT_GROUP_REQUEST = 7;

    Byte QUIT_GROUP_RESPONSE = 8;

    Byte JOIN_GROUP_REQUEST = 9;

    Byte JOIN_GROUP_RESPONSE = 10;

    Byte LIST_GROUP_MEMBERS_REQUEST = 11;

}