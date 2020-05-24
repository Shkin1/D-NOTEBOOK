package com.pushkin.nettyim.protocol.response;

import com.pushkin.nettyim.protocol.Packet;

import static com.pushkin.nettyim.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 16:36
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
