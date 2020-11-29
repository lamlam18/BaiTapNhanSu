package com.cybersoft.java10.controler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.cybersoft.java10.model.GiamDoc;
import com.cybersoft.java10.model.NhanSu;
import com.cybersoft.java10.model.NhanVien;
import com.cybersoft.java10.model.TruongPhong;

public class QuanLyNhanSu {
	//properties
	private List<NhanSu> dsNhanSu;
	
	//constructor
	public QuanLyNhanSu() {
		dsNhanSu = new ArrayList<NhanSu>();
	}
	
	//methods
	public boolean them(NhanSu nhanSu) {
		return dsNhanSu.add(nhanSu);
	}
	
	public boolean xoa(String maSo) {
		if(maSo == null || "".equals(maSo))
			return false;
		for (NhanSu nhanSu : dsNhanSu) {
			if(maSo.equalsIgnoreCase(nhanSu.getMaSo())) {
				dsNhanSu.remove(nhanSu);
				return true;
			}
		}
		// chạy hết danh sách k tìm thấy nhân sự thì return false
		return false;
	}
	
	public void inDsNhanSu() {
		System.out.println("DANH SÁCH NHÂN SỰ:");
		for (NhanSu nhanSu : dsNhanSu) {
			nhanSu.inThongTin();
		}
	}

	public double tinhTongLuongCongTy() {
		double total = 0;
		for (NhanSu nhanSu : dsNhanSu) {
			total += nhanSu.tinhLuong();
		
		}
		System.out.println("Tổng lương công ty là: " + total);
		return total;
		// TODO Auto-generated method stub
		
	}

	public NhanSu timNhanVienLuongCao() {
		// TODO Auto-generated method stub
		if (dsNhanSu.size() < 1) 
			return null;
		
		List<NhanSu> dsNhanVien = new ArrayList<NhanSu>();
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu instanceof NhanVien) 
				dsNhanVien.add(nhanSu);
		}
		if (dsNhanVien.size() < 1)
			return null;
		List<NhanSu> dsNhanVienLuongCao = new ArrayList<NhanSu>();
		
		NhanSu max = dsNhanVien.get(0);
		for (NhanSu nhanSu : dsNhanVien) {
			if (max.tinhLuong() <= nhanSu.tinhLuong()) { 
				max = nhanSu;
				dsNhanVienLuongCao.add(nhanSu);
			}	
		}
		System.out.println("Nhân viên có lương cao nhất là: ");
		for (NhanSu nhanSu : dsNhanVienLuongCao) {
			nhanSu.inThongTin();
		}
		
		return max;
	}

	public TruongPhong timTruongPhongNvNhieu() {
		// TODO Auto-generated method stub
			if (dsNhanSu.size() < 1)
				return null;
			
			List<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
			for (NhanSu nhanSu : dsNhanSu) {
				if (nhanSu instanceof TruongPhong)
					dsTruongPhong.add((TruongPhong) nhanSu);
			}
			
			if (dsTruongPhong.size() < 1)
				return null;
			List<TruongPhong> dsMaxTruongPhong = new ArrayList<TruongPhong>();
			TruongPhong max = dsTruongPhong.get(0);
			for (TruongPhong truongPhong : dsTruongPhong) {
				if (max.getSoNhanVien() <= truongPhong.getSoNhanVien()) {
					max = truongPhong;
					dsMaxTruongPhong.add(truongPhong);
				}
			}
			System.out.println("Trưởng phòng có nhân viên dưới quyền nhiều nhất: ");
			for (TruongPhong truongPhong : dsMaxTruongPhong) {
				truongPhong.inThongTin();
			}
		
		return max;
	}
//	public void xuatDSTheoAbc() {
//		System.out.println("Thông tin tất cả nhân viên: ");
//		Collections.sort(dsNhanSu);;
//		for (NhanSu nhanSu : dsNhanSu) {
//			nhanSu.inThongTin();
//		}
//		
//		// TODO Auto-generated method stub
//		
//	}

	public GiamDoc tinGiamDocCPNhieu() {
		// TODO Auto-generated method stub
		if (dsNhanSu.size() < 1)
			return null;
		
		List<GiamDoc> dsGiamDoc = new ArrayList<GiamDoc>();
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu instanceof GiamDoc)
				dsGiamDoc.add((GiamDoc) nhanSu);
		}
		
		if (dsGiamDoc.size() < 1)
			return null;
		
		List<GiamDoc> dsMaxGiamDoc = new ArrayList<GiamDoc>();
		GiamDoc max = dsGiamDoc.get(0);
		for (GiamDoc giamDoc : dsGiamDoc) {
			if (giamDoc.getcoPhan() >= max.getcoPhan()) {
				max = giamDoc;
				dsMaxGiamDoc.add(giamDoc);
			}
			System.out.println("ahihi");
		}
		System.out.println("Danh sách giám đốc có cổ phần nhiều: ");
		for (GiamDoc giamDoc : dsMaxGiamDoc) {
			giamDoc.inThongTin();
		}
					
		return max;
	}

//	public String tinhXuatLuongGiamDoc(float loiNhuanThang) {
//		// TODO Auto-generated method stub
//		if (dsNhanSu.size() < 1)
//			return null;
//		
//		List<GiamDoc> dsGiamDoc = new ArrayList<GiamDoc>();
//		for (NhanSu nhanSu : dsNhanSu) {
//			if (nhanSu instanceof GiamDoc)
//				dsGiamDoc.add((GiamDoc) nhanSu);
//		}
//		
//		if (dsGiamDoc.size() < 1)
//			return null;
//		
//		for (GiamDoc giamDoc : dsGiamDoc) {
//			float bonus = loiNhuanThang * giamDoc.getcoPhan();
//			System.out.println("Lương của giám đốc " + giamDoc.getHoTen() + " là: " + (giamDoc.tinhLuong() + bonus));
//		}
//		return "";
//	}

	public GiamDoc tinhXuatLuongGiamDoc(float loiNhuanThang) {
		// TODO Auto-generated method stub
		
		if (dsNhanSu.size() < 1)
			return null;
		
		List<GiamDoc> dsGiamDoc = new ArrayList<GiamDoc>();
		for (NhanSu nhanSu : dsNhanSu) {
			if (nhanSu instanceof GiamDoc)
				dsGiamDoc.add((GiamDoc) nhanSu);
		}
		
		if (dsGiamDoc.size() < 1)
			return null;
		
		for (GiamDoc giamDoc : dsGiamDoc) {
			float bonus = loiNhuanThang * giamDoc.getcoPhan();
			System.out.println("Lương của giám đốc " + giamDoc.getHoTen() + " là: " + (giamDoc.tinhLuong() + bonus));
		}
		return null;
		
	}

	

	
}

