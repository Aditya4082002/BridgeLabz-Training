package com.junit_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceUtilstest {
	PerformanceUtils performanceUtils = new PerformanceUtils();
	
	@Test
	@Timeout(2)
	 void testLongRunningTaskTimeout() throws InterruptedException {
        performanceUtils.longRunningTask();
    }
}
