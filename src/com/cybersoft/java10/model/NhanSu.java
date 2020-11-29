package com.cybersoft.java10.model;

import java.util.Scanner;

public class NhanSu  {
	//properties
	protected String hoTen;
	protected String maSo;
	protected String soDienThoai;
	protected float  soNgayLam;
	protected float  luongMotNgay;
	
	//getter-setter
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public float getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	public String getMaSo() {
		return maSo;
	}
	
	//construcstor
	public NhanSu() {
		hoTen			= "";
		maSo			= "";
		soDienThoai		= "";
		soNgayLam		= 22;
		luongMotNgay	= 100;
	}
	


	public NhanSu(String hoTen , String maSo , String soDienThoai , float soNgayLam , float luongMotNgay) {
		this.hoTen			= hoTen;
		this.maSo			= maSo;
		this.soDienThoai	= soDienThoai;
		this.soNgayLam		= soNgayLam;
		this.luongMotNgay	= luongMotNgay;
	}
	
	//methods
	public float tinhLuong() {
		return soNgayLam * luongMotNgay;
	}
	
	public void nhapThongTin(Scanner sc) {
		System.out.println("Mời nhập tên nhân sự: ");
		this.hoTen = sc.nextLine();
		System.out.println("Mời nhập mã số nhân sự: ");
		this.maSo = sc.nextLine();
		System.out.println("Mời nhập số điện thoại nhân sự: ");
		this.soDienThoai = sc.nextLine();
		System.out.println("Mời nhập số ngày làm: ");
		this.soNgayLam = Float.parseFloat(sc.nextLine());
		System.out.println("Mời nhập lương một ngày: ");
		this.luongMotNgay = Float.parseFloat(sc.nextLine());
	}
	
	public void inThongTin() {
		System.out.println("Tên nhân sự: " + this.hoTen);
		System.out.println("Mã số: " + this.maSo);
		System.out.println("Số điện thoại: " + this.soDienThoai);
		System.out.println("Số ngày làm: " + this.soNgayLam);
		System.out.println("Lương một ngày" + this.luongMotNgay);
	}



}
