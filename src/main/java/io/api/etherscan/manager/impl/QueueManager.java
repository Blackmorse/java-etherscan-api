package io.api.etherscan.manager.impl;

import io.api.etherscan.manager.IQueueManager;

import java.util.concurrent.*;

/**
 * Queue implementation With size and reset time as params
 * 
 * @see IQueueManager
 *
 * @author GoodforGod
 * @since 30.10.2018
 */
public class QueueManager implements IQueueManager {

    public static final QueueManager DEFAULT_KEY_QUEUE = new QueueManager(1, 6);
    public static final QueueManager PERSONAL_KEY_QUEUE = new QueueManager(5, 1);

    private final Semaphore semaphore;

    public QueueManager(int queueSize, int queueResetTimeInSec) {
        this(queueSize, queueResetTimeInSec, queueResetTimeInSec);
    }

    public QueueManager(int queueSize, int queueResetTimeInSec, int delayInSec) {
        this.semaphore = new Semaphore(queueSize);
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(releaseLocks(queueSize), delayInSec, queueResetTimeInSec, TimeUnit.SECONDS);
    }

    @Override
    public void takeTurn() {
        semaphore.acquireUninterruptibly();
    }

    private Runnable releaseLocks(int toRelease) {
        return () -> semaphore.release(toRelease);
    }
}
