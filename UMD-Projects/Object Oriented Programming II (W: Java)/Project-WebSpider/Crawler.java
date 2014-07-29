import java.net.*;
import java.io.*;

public class Crawler {

	public static void main(String[] args) {

		MyQueue<URL> linkQueue = new MyQueue<URL>();
		MyQueue<URL> picQueue = new MyQueue<URL>();
		MySet<URL> beenThere = new MySet<URL>();
		MySet<URL> doneThat = new MySet<URL>();

		final int MAX_NUM_EXTRACTORS = 5; // Change this to whatever you want

		ExtractorThread[] extractors = new ExtractorThread[MAX_NUM_EXTRACTORS];

		new SlideShowGUI(picQueue);
		new CrawlerGUI(linkQueue, picQueue, beenThere, doneThat, extractors);
		URL testURL;

		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < extractors.length; i++) {
				if (extractors[i] == null || !extractors[i].isAlive()) {
					synchronized (linkQueue) {
						while (linkQueue.size() == 0) {
							try {
								linkQueue.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					synchronized (extractors) {

						while (true) {
							testURL = linkQueue.dequeue();
							URLConnection testURLConn;
							if (testURL != null) {
								try {
									testURLConn = testURL.openConnection();
									testURLConn.connect();

									if (testURLConn.getContentType()
											.startsWith("text/html")) {
										extractors[i] = new ExtractorThread(
												testURL, picQueue, picQueue,
												doneThat, doneThat);
										extractors[i].start();
										break;
									}

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}
					}
				}
			}
		}

	}
}
