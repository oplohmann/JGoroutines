package org.objectscape.jgoroutine;

import org.fusesource.hawtdispatch.Dispatch;
import org.fusesource.hawtdispatch.internal.DispatcherConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.objectscape.jgoroutines.AsyncUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: Oliver Plohmann
 * Date: 09.06.2013
 */
public class GoroutineTest implements AsyncUtils {

    @Test
    public void sumAsync() throws InterruptedException
    {
        BlockingQueue<Integer> channel = new LinkedBlockingQueue<>();

        async(()->
        {
            int result = 0;
            for(int i = 0; i < 100000000; i++) {
                result = result + i;
            }

            channel.add(result);
        });

        int sum = channel.take();
        System.out.println("The sum is: " + sum);
    }

    @After
    public void tearDown() throws InterruptedException
    {
        DispatcherConfig.getDefaultDispatcher().shutdown();
    }

}
