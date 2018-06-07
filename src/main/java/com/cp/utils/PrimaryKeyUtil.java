package com.cp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO  支持高并发
 * @auther: liufeng
 * @Date: 2017/8/29 11:09
 */
public class PrimaryKeyUtil {

	/***************************************************************************
	 * 初始化主键值
	 **************************************************************************/

	// 配合组建主键，每次工程重启后初始化为0
	private static AtomicInteger NO = new AtomicInteger(1);

	private static int getNO() {
		NO.compareAndSet(9999, 0);
		return NO.incrementAndGet();
	}

	/***************************************************************************
	 * 获取主键值
	 **************************************************************************/

	/*
	 * 一般表主键,并发量大的数据表采用
	 */
	public static String getTableID() {
		String dateTime = new SimpleDateFormat("yyMMddHHmmss")
				.format(new Date()) + ((10000l + getNO()) + "").substring(1);
		return dateTime;
	}


	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 1000; i++) {
			exe.submit(() ->{
			int j = 0;
			while (j < 10){
				System.out.println(PrimaryKeyUtil.getTableID());
				j++;
				try {
					TimeUnit.MICROSECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			});
		}
	}

}
