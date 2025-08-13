package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PhieuXuat extends Phieu {

    private KhachHang khachHang; // thêm để fix getKhachHang / setKhachHang

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieu, Timestamp thoiGianTao, String nguoiTao, ArrayList<ChiTietPhieu> CTPhieu, double tongTien) {
        super(maPhieu, thoiGianTao, nguoiTao, CTPhieu, tongTien);
    }

    public PhieuXuat(String maPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien) {
        super(maPhieu, thoiGianTao, nguoiTao, tongTien);
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
