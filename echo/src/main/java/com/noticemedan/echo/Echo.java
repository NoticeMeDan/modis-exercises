package com.noticemedan.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Echo {
    public static void main(String[] args) {
        System.out.println("Starting server");
        Echo.run();
    }

    private static void run() {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1", 7007));
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            buffer.clear();
            channel.receive(buffer);
            System.out.println(String.format("Received: %s", new String(buffer.array(), StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
