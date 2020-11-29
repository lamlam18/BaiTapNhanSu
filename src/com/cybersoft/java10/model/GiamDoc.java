package com.cybersoft.java10.model;

public class GiamDoc extends NhanSu {
	//properties
	private float coPhan;
	
	
	//getter-setter
	public float getcoPhan() {
		return this.coPhan;
	}
	
	//constructor
	public GiamDoc() {
		super();
	}
	
	public GiamDoc(float coPhan) {
		super();
		this.coPhan = coPhan;
	}

	public GiamDoc(String hoTen, String maSo, String soDienThoai, float soNgayLam, float luongMotNgay , float coPhan) {
		super(hoTen, maSo, soDienThoai, soNgayLam, luongMotNgay);
		this.coPhan = coPhan;
	}
	
	
	
	//methods
	
}
