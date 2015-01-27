package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.tyan.ai.frame.context.Context;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Context context = new Context();
		while (true) {
			String str = br.readLine();
			if ("bye".equals(str)) {
				break;
			}
			System.out.println(context.question(str));
		}
	}
}
