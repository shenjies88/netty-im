package com.shenjies88.practice.command;

import com.shenjies88.practice.packet.MessageRequestPacket;
import com.shenjies88.practice.interfaces.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
