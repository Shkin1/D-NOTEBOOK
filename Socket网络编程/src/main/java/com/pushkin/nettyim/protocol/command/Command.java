package com.pushkin.nettyim.protocol.command;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 14:28
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface Command {
    byte LOGIN_REQUEST = 1;
    Byte LOGIN_RESPONSE = 2;
}
