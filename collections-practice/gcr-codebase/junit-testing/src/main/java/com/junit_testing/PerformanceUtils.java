package com.junit_testing;

public class PerformanceUtils {
	public String longRunningTask() throws InterruptedException{
		Thread.sleep(3000);
		return "task completed";
	}
}
