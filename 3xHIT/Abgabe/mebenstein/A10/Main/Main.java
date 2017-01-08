package Main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Michael Ebenstein		
 * @version 16-12-2016
 */

public class Main {
	
	
	public static void main(String[] args) {
		char[][] raster= new char[(int)(Math.random()*20)][(int)(Math.random()*20)];
		
		for(int i = 0; i < raster.length;++i){
			for(int j = 0; j < raster[i].length;++j){
				raster[i][j] = Math.random()<0.5?'-':'o';
			}
		}
		
		printBeautiful(raster);
		
		raster = rotate(raster);
		
		printBeautiful(raster);
		
		raster = rotate(raster,3);
		
		printBeautiful(raster);
	}
	
	public static char[][] rotate(char[][] arr,int times){
		
		for(int i = 0; i < times;++i){
			arr = rotate(arr);
		}
		
		return arr;
	}
	
	public static char[][] rotate(char[][] arr){
		
		int width = arr[0].length;
		int height = arr.length;
		
		char[][] buffer = new char[width][height];
		
		for(int i = 0; i < height;++i){
			for(int j = 0; j < width;++j)
				buffer[j][i] = arr[height-i-1][j];
				
		}
		
		return buffer;
	}
	
	public static void printBeautiful(char[][] arr){
		for(char[] ch:arr){
			for(char c:ch){
				System.out.print(c+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
