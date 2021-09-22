public class SnowFlake {
    //机器ID，由于占五位，所以最大值是31
    private long workId;
    //数据中心ID，由于占五位，所以最大值是31
    private long dateCenterId;
    //序列号
    private long sequence;
    //初始时间戳
    private long initTimestamp=1585644268888L;
    //上一次生成雪花id时的时间戳
    private long lastTimestamp=1L;
    //机器ID所占的比特位数，可调整，机器ID和数据中心ID比特位数之和为10就好
    private long workIdBits=5L;
    //数据中心ID所占的比特位数，可调整
    private long dateCenterIdBits=5L;
    //序列号所占的比特位数
    private long sequenceBits=12L;
    //机器ID的最大值，31
    private long maxWorkId=-1L ^ (-1L << workIdBits);
    //数据中心ID的最大值，31
    private long maxDateCenterId=-1L^(-1L << dateCenterIdBits);
    //序列号的最大值4095
    private long maxSequence=-1L^(-1L << sequenceBits);
    //代表序列号、机器ID、数据中心ID从第几位开始，用于后面运算生成雪花id
    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workIdBits;
    private long timestampLeftShift = sequenceBits + workIdBits + dateCenterIdBits;

    //初始化三大数值
    public SnowFlake(long workerId, long datacenterId, long sequence) {

        // 检查机房id和机器id是否超过31 不能小于0
        if (workerId > maxWorkId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0",maxWorkId));
        }

        if (datacenterId > maxDateCenterId || datacenterId < 0) {

            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0",maxDateCenterId));
        }
        this.workId = workerId;
        this.dateCenterId = datacenterId;
        this.sequence = sequence;
    }


    //核心方法，生成雪花id
    public synchronized long nextId(){
        long nowTimeStamp = getNowTimeStamp();
        //当前时间小于上次生成id的时间，说明时间错乱
        if (nowTimeStamp<lastTimestamp){
            System.err.printf(
                    "clock is moving backwards. Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                            lastTimestamp - initTimestamp));
        }
        if (nowTimeStamp==lastTimestamp){
            //如果sequence等于0，说明当前生成的序列号超过了序列号的最大值，
            // 系统进入等待，直到下一毫秒才继续生产id
            sequence=(sequence+1)&maxSequence;
            if (sequence==0){
                //系统进入循环等待，直到进入下一毫秒
                nowTimeStamp = timeNextMills();
            }
        }else {
            sequence=0;
        }
        //更新上一次生产雪花id的时间
        lastTimestamp=nowTimeStamp;
        //最核心的二进制运算操作，生成64bit的雪花id
                //将当前时间戳-初始化时间戳，再往左移相应的位数
        return ((nowTimeStamp-initTimestamp)<<timestampLeftShift)
                //将机器id左移相应的位数
                | (workId << workerIdShift)
                //将数据中心id左移相应的位数
                | (dateCenterId << datacenterIdShift)
                //将序列号左移相应的位数
                | sequence;
    }

    public long getNowTimeStamp(){
        return System.currentTimeMillis();
    }

    public long timeNextMills(){
        long curMills = System.currentTimeMillis();
        while (curMills==lastTimestamp){
            curMills = System.currentTimeMillis();
        }
        return curMills;
    }

    public long getWorkId() {
        return workId;
    }

    public long getDateCenterId() {
        return dateCenterId;
    }
}
