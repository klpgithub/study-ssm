package com.study.common.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {

	// 文件类
	static class Document {
		private String title;
		private String content;

		public Document(String title, String content) {
			super();
			this.title = title;
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public String getTitle() {
			return title;
		}
	}

	static class PrintQueue {
		// 用于描述打印机的空闲状态,true为空闲,false为工作状态
		private boolean[] freePrinters;
		// 用于控制同步访问freePrinters
		private Lock printersLock;
		// 定义最大打印机数目
		private int MAX_PRINTER = 3;
		// 定义一个信号量对象
		private final Semaphore semaphore;

		public PrintQueue() {
			semaphore = new Semaphore(MAX_PRINTER);
			freePrinters = new boolean[MAX_PRINTER];

			// 初始化打印机状态
			for (int i = 0; i < MAX_PRINTER; i++) {
				freePrinters[i] = true;
			}
			printersLock = new ReentrantLock();
		}

		// 利用信号量进行流量控制的经典“三段论”
		public void print(Document document) {
			try {
				semaphore.acquire();
				int printerID = getPrinter();
				System.out.println("No." + printerID + " is working now : Title => " + document.getTitle()
						+ ";Content => " + document.getContent());
				// 模拟一个耗时操作
				Thread.sleep(1000);
				System.out.println("No." + printerID + "'s work is done!");
				// 注意,完成任务后一定重置打印机为空闲状态,方便接收后续任务
				freePrinters[printerID] = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}

		// 利用锁修改资源的经典"三段式"
		private int getPrinter() {
			int ret = -1;
			try {
				printersLock.lock();
				// 查找到空闲的打印机序号
				for (int i = 0; i < freePrinters.length; i++) {
					if (true == freePrinters[i]) {
						ret = i;
						freePrinters[i] = false;
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				printersLock.unlock();
			}
			return ret;
		}
	}

	static class PrintTask implements Runnable {
		private PrintQueue printQueue;
		private Document document;

		public PrintTask(PrintQueue printQueue, Document document) {
			super();
			this.printQueue = printQueue;
			this.document = document;
		}

		@Override
		public void run() {
			printQueue.print(document);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		PrintQueue queue = new PrintQueue();

		int THREAD_COUNT = 20;
		// 为了模拟效果，这里理论上创建了可同时并发的20个线程
		ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
		// 以固定的并发流量处理打印任务

		for (int i = 0; i < THREAD_COUNT; i++) {
			Document document = new Document("Title " + i, "Content " + i);
			threadPool.execute(new PrintTask(queue, document));
		}
		threadPool.shutdown();
	}

}
