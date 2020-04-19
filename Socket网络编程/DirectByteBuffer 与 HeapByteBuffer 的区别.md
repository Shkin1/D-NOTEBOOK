它们 ByteBuffer 分配内存的两种方式。HeapByteBuffer 顾名思义其内存空间在 JVM 的 heap（堆）上分配，可以看做是 jdk 对于 byte[] 数组的封装；
而 DirectByteBuffer 则直接利用了系统接口进行内存申请，其内存分配在c heap 中，这样就减少了内存之间的拷贝操作，如此一来，在使用 DirectByteBuffer 时，
系统就可以直接从内存将数据写入到 Channel 中，而无需进行 Java 堆的内存申请，复制等操作，提高了性能。既然如此，为什么不直接使用 DirectByteBuffer，
还要来个 HeapByteBuffer？原因在于， DirectByteBuffer 是通过full gc来回收内存的，DirectByteBuffer会自己检测情况而调用 system.gc()，
但是如果参数中使用了 DisableExplicitGC 那么就无法回收该快内存了，-XX:+DisableExplicitGC标志自动将 System.gc() 调用转换成一个空操作，
就是应用中调用 System.gc() 会变成一个空操作，那么如果设置了就需要我们手动来回收内存了，所以DirectByteBuffer使用起来相对于完全托管于 java 内存管理的Heap ByteBuffer 来说更复杂一些，
如果用不好可能会引起OOM。Direct ByteBuffer 的内存大小受 -XX:MaxDirectMemorySize JVM 参数控制（默认大小64M），
在 DirectByteBuffer 申请内存空间达到该设置大小后，会触发 Full GC。 
