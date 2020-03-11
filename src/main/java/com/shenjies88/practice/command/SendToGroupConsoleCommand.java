package com.shenjies88.practice.command;

import com.shenjies88.practice.interfaces.ConsoleCommand;
import com.shenjies88.practice.packet.GroupMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("输入群id ");
        String groupId = scanner.next();
        System.out.println("输入消息");
        String message = scanner.next();
        channel.writeAndFlush(new GroupMessageRequestPacket(groupId, message));
    }
}
