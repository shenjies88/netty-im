package com.shenjies88.practice.utils;

import com.shenjies88.practice.impl.Session;
import com.shenjies88.practice.interfaces.Attributes;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginUtil {

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    // userId -> channel 的映射
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();


    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String toUserId) {
        return userIdChannelMap.get(toUserId);
    }
}