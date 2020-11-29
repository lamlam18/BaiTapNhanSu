package com.cybersoft.java10.view;

import java.util.Scanner;
import java.util.Collections;


import com.cybersoft.java10.controler.QuanLyNhanSu;
import com.cybersoft.java10.model.GiamDoc;
import com.cybersoft.java10.model.NhanSu;
import com.cybersoft.java10.model.NhanVien;
import com.cybersoft.java10.model.TruongPhong;

public class CongTy {
	// properties
	private QuanLyNhanSu quanLyNhanSu;
	private String maSoThue;
	private String tenCongTy;
	private float doanhThuThang;

	// constructor
	public CongTy() {
		quanLyNhanSu = new QuanLyNhanSu();
	}

	public void mainFunc() {
		// TODO Auto-generated method stub
		/*
		 * Ứng dụng quản lý nhân sự
		 */
		Scanner sc = new Scanner(System.in);
		int luaChon;
		boolean tiepTucChay = true;
		taoDummyData();

		do {
			luaChon = inMenu(sc);
			switch (luaChon) {
			case 0:
				tiepTucChay = false;
				System.out.println("Đang thoát chương trình");

				break;

			case 1:
				nhapThongTin(sc);
				break;

			case 3:
				System.out.println("Mời chọn loại nhân sự: \n\t1.Nhân viên \t2.Trưởng phong \t3.Giám đốc");
				System.out.println("Lựa chọn");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					NhanVien nhanVien = new NhanVien();
					nhanVien.nhapThongTin(sc);
					if (quanLyNhanSu.them(nhanVien)) {
						System.out.println("Thêm nhân viên thành công");
					} else
						System.out.println("Thêm nhân viên thất bại");
					break;
				case 2:
					TruongPhong truongPhong = new TruongPhong();
					truongPhong.nhapThongTin(sc);
					if (quanLyNhanSu.them(truongPhong)) {
						System.out.println("Thêm trưởng phòng thành công");
					} else
						System.out.println("Thêm trưởng phòng thất bại");
					break;

				case 3:
					GiamDoc giamDoc = new GiamDoc();
					giamDoc.nhapThongTin(sc);
					if (quanLyNhanSu.them(giamDoc)) {
						System.out.println("Thêm giám đốc thành công");
					} else
						System.out.println("Thêm giám đốc thất bại");
					break;
				}
				break;
			case 4:// xóa nhân sự
				String maSo = null;
				System.out.println("Mời nhập mã muốn xóa: ");
				maSo = sc.nextLine();
				if (quanLyNhanSu.xoa(maSo)) {
					System.out.println("Xóa nhân sự thành công");
				}
				else {
					System.out.println("Xóa nhân sự thất bại");
				}
				break;

			case 5:
				quanLyNhanSu.inDsNhanSu();
				break;
				
			case 6:	//tính xuất lương toàn công ty
				quanLyNhanSu.tinhTongLuongCongTy();
				break;
				
			case 7:	
				NhanSu maxNhanVien = quanLyNhanSu.timNhanVienLuongCao();
				if (maxNhanVien == null) {
					System.out.println("Không có nhân viên nào trong công ty");
					break;
				}
				
				break;
			
			case 8:
				TruongPhong maxTruongPhong = quanLyNhanSu.timTruongPhongNvNhieu();
				if (maxTruongPhong == null) {
					System.out.println("Không có trưởng phòng trong nhân sự");
				}
				break;
				
//			case 9:
//				quanLyNhanSu.xuatDSTheoAbc();
//				break;
			
			case 11:	
				GiamDoc maxGiamDoc = quanLyNhanSu.tinGiamDocCPNhieu();
				if (maxGiamDoc == null) {
					System.out.println("Không có nhân sự hoặc giám đốc trong công ty.");
				}
				break;
				
			case 12:	
				System.out.println("Mời nhập doanh thu tháng của công ty: ");
				doanhThuThang = Float.parseFloat(sc.nextLine());
				float loiNhuanThang = (float) (doanhThuThang - quanLyNhanSu.tinhTongLuongCongTy());
				
				GiamDoc luongGiamDoc =  quanLyNhanSu.tinhXuatLuongGiamDoc(loiNhuanThang);
				if (luongGiamDoc == null) 
					System.out.println("Không có nhân sự hoặc giám đốc trong công ty.");

		default:
			System.out.println("Lựa chọn không hợp lệ");
			break;
			}

		} while (tiepTucChay);

	}

	public int inMenu(Scanner sc) {
		// TODO Auto-generated method stub
		int spaceNum = 20;
		System.out.println(
				String.format("%" + spaceNum + "s", "") + "QUẢN LÝ NHÂN SỰ" + String.format("%" + spaceNum + "s", ""));
		System.out.println("Menu:");
		System.out.println("\t1. Nhập thông tin công ty");
		System.out.println("\t2. Phân bổ Nhân viên vào Trưởng phòng");
		System.out.println("\t3. Thêm thông tin một nhân sự");
		System.out.println("\t4. Xóa thông tin một nhân sự");
		System.out.println("\t5. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("\t6. Tính và xuất tổng lương cho toàn công ty");
		System.out.println("\t7. Tìm Nhân viên thường có lương cao nhất");
		System.out.println("\t8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("\t9. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("\t10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("\t11. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("\t12. Tính và Xuất tổng THU NHẬP của từng Giám Đốc");
		System.out.println("\t0. Thoát.");
		System.out.print("Lựa chọn: ");
		return Integer.parseInt(sc.nextLine());
	}

	public void nhapThongTin(Scanner sc) {
		System.out.println("THÔNG TIN CÔNG TY");
		System.out.println("Tên công ty: ");
		this.tenCongTy = sc.nextLine();
		System.out.println("Mã số thuế: ");
		this.maSoThue = sc.nextLine();
		System.out.println("Doanh thu tháng: ");
		this.doanhThuThang = Float.parseFloat(sc.nextLine());
	}

	public void taoDummyData() {
		quanLyNhanSu.them(new NhanVien("Hà", "Ns001", "0909", 22, 222, ""));
		quanLyNhanSu.them(new NhanVien("Thu", "Ns002", "0909", 22, 111, ""));
		quanLyNhanSu.them(new NhanVien("Lâm", "Ns003", "0909", 22, 111, ""));
		quanLyNhanSu.them(new TruongPhong("Đào", "Ns004", "0909", 22, 200, 20));
		quanLyNhanSu.them(new TruongPhong("Ngọc", "Ns005", "0909", 22, 200, 10));
		quanLyNhanSu.them(new GiamDoc("Điệp", "Ns006", "0909", 22, 300, 10));
		quanLyNhanSu.them(new GiamDoc("Thị", "Ns006", "0909", 22, 300, 0));
		quanLyNhanSu.them(new GiamDoc("Th", "Ns006", "0909", 22, 300, 20));
	}
	

}
