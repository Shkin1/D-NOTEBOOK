package proto;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/28 22:36
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class DfsServiceImpl implements DfsService {
    public String mkDir(String path) {
        return "mkdir "+ path;
    }

    public long getProtocolVersion(String s, long l) throws IOException {
        return versionID;
    }

    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return null;
    }
}
