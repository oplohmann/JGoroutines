package org.objectscape.jgoroutines;

import org.fusesource.hawtdispatch.Dispatch;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Oliver Plohmann
 * Date: 09.06.2013
 */
public interface AsyncUtils {

    default public void async(Runnable runnable) {
        Dispatch.getGlobalQueue().execute(runnable);
    }

    default public void asyncAfter(long duration, TimeUnit unit, Runnable runnable) {
        Dispatch.getGlobalQueue().executeAfter(duration, unit, runnable);
    }

}
