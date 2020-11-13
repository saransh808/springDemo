package com.example.demo.commonConstants;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CommonInitialisers {
	@Scheduled(cron = "0 0 10 * * ?")
	public void printInLoop() {
//		for(;;) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Progress...");
//		}
	}
}
