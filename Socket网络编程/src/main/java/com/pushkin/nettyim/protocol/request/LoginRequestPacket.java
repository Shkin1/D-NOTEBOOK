package com.pushkin.nettyim.protocol.request;

import com.pushkin.nettyim.protocol.Packet;

import static com.pushkin.nettyim.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 14:29
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class LoginRequestPacket extends Packet {
    private String userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
