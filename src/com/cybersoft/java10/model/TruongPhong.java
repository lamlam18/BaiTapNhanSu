package com.cybersoft.java10.model;

public class TruongPhong extends NhanSu	 {
	//properties
	private int soNhanVien;
	
	
	//getter-setter
	public int getSoNhanVien() {
		return this.soNhanVien;
	}
	
	//constructor
	public TruongPhong() {
		super();
	}
	
	public TruongPhong(int soNhanVien) {
		super();
		soNhanVien = 0;
	}

	public TruongPhong(String hoTen, String maSo, String soDienThoai, float soNgayLam, float luongMotNgay , int soNhanVien) {
		super(hoTen, maSo, soDienThoai, soNgayLam, luongMotNgay);
		this.soNhanVien = soNhanVien;
		
	}
	
	
	
	//methods

}
