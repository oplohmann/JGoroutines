package org.objectscape.jgoroutines;

import org.fusesource.hawtdispatch.Dispatch;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Nutzer
 * Date: 09.06.13
 * Time: 09:20
 * To change this template use File | Settings | File Templates.
 */
public interface AsyncUtils {

    default public void async(Runnable runnable) {
        Dispatch.getGlobalQueue().execute(runnable);
    }

    default public void asyncAfter(long duration, TimeUnit unit, Runnable runnable) {
        Dispatch.getGlobalQueue().executeAfter(duration, unit, runnable);
    }

}
