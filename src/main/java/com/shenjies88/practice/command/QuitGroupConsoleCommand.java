package com.shenjies88.practice.command;

import com.shenjies88.practice.interfaces.ConsoleCommand;
import com.shenjies88.practice.packet.QuitGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class QuitGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("输入群聊id");
        String groupId = scanner.next();
        channel.writeAndFlush(new QuitGroupRequestPacket(groupId));
    }
}
