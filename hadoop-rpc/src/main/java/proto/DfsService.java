package proto;

import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/6/28 22:19
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface  DfsService extends VersionedProtocol {

    /**
     * 版本号
     */
    long versionID= 123L;

    String mkDir(String path);
}
