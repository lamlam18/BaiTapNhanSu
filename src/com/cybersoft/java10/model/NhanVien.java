package com.cybersoft.java10.model;

public class NhanVien extends NhanSu {
	//properties
	private String maTruongPhong;
	
	//getter-setter
	public String gettruongPhong() {
		return this.maTruongPhong;
	}
	
	public void settruongPhong(String truongPhong) {
		this.maTruongPhong = truongPhong;
	}
	
	//constructor
	public NhanVien() {
		super();
	}
	
	public NhanVien(String truongPhong) {
		super();
		this.maTruongPhong = truongPhong;
	}
	
	public NhanVien(String hoTen, String maSo, String soDienThoai, float soNgayLam, float luongMotNgay , String truongPhong) {
		super(hoTen, maSo, soDienThoai, soNgayLam, luongMotNgay);
		this.maTruongPhong = truongPhong;
	}
	
	//methods
	@Override
	public float tinhLuong() {
		return super.tinhLuong();
		
	}

}
