package com.example.myapplication32;

import java.util.ArrayList;

public class Matrix {
	private double [] Xs;
	private int Size;
	private ArrayList<double[]> array;

	public Matrix(double[] Xs,int Size) {
		this.Xs=Xs;
		this.Size=Size+1;

	}
	public double [][] getMatrix() {
		double [][] ma=new double[this.Xs.length][this.Xs.length+1];
		int l=0;
		System.out.println(Xs.length/Size);
		for(int i=0;i<Xs.length/Size;i++) {
			for(int j=0;j<(this.Xs.length/Size)+1;j++) {
				ma[i][j]=Xs[l];
				l++;
				System.out.print(ma[i][j]+"\t");
			}
			System.out.println();
		}
		
		return ma;
	}

}
