package dxc.lca.automation.common.utils;

import java.util.concurrent.TimeUnit;

public class WaitUtils<R> {
	static final int _DEFAULT_INTERVAL = 200;

	/**
	 * 
	 * @param condition
	 * @param timeOut
	 * @param checkDuration
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean waitFor(IWaitCondition condition, int timeOut, int checkDuration) throws InterruptedException {
		int count = 0;
		while (count <= timeOut) {
			if (condition.matchCondition()) {
				return true;
			}
			TimeUnit.MILLISECONDS.sleep(checkDuration);
			count+= checkDuration;
		}

		return false;
	}
	
	public static boolean waitFor(IWaitCondition condition, int timeOut) throws InterruptedException {	
		return waitFor(condition, timeOut, _DEFAULT_INTERVAL);
	}
}
