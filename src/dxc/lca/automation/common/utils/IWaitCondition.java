package dxc.lca.automation.common.utils;

/**
 * Interface of an object that checks the the condition of waiting method.
 * @author ttran223
 */
public interface IWaitCondition {
	/**
	 * check if 
	 * @return <code>boolean</code> <code>true</code> when the wait condition is satisfied. Otherwise, return <code>false</code>.
	 */
	boolean matchCondition();
}

