package javaParse;

import Thread.dateThread;
import Thread.timeThread;
import UI.coronaUI;

public class main {

public static void main(String[] args) {
		Thread date = new Thread(new dateThread());
		Thread time = new Thread(new timeThread());
		date.start();
		time.start();
		}
	}
