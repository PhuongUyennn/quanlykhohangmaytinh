package dao;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.PhieuXuat;
import model.KhachHang;

public class PhieuXuatDAO implements DAOInterface<PhieuXuat> {

    public static PhieuXuatDAO getInstance() {
        return new PhieuXuatDAO();
    }

    @Override
public int insert(PhieuXuat t) {
    int ketQua = 0;
    Connection con = null;
    try {
        con = JDBCUtil.getConnection();
        con.setAutoCommit(false); // Gộp thành 1 transaction

        // 1. Xử lý khách hàng
        KhachHang kh = t.getKhachHang();
        if (kh != null) {
            // Nếu chưa có maKH -> sinh mã mới
            if (kh.getMaKH() == null || kh.getMaKH().trim().isEmpty()) {
                String sqlMa = "SELECT maKH FROM KhachHang ORDER BY maKH DESC LIMIT 1"; // sửa cho MySQL
                PreparedStatement pstMa = con.prepareStatement(sqlMa);
                ResultSet rs = pstMa.executeQuery();
                String newMa = "KH001";
                if (rs.next()) {
                    String lastMa = rs.getString("maKH").replace("KH", "");
                    int num = Integer.parseInt(lastMa) + 1;
                    newMa = String.format("KH%03d", num);
                }
                kh.setMaKH(newMa);
            }

            // Kiểm tra khách hàng đã tồn tại chưa
            String checkKH = "SELECT COUNT(*) FROM KhachHang WHERE maKH=?";
            PreparedStatement pstCheck = con.prepareStatement(checkKH);
            pstCheck.setString(1, kh.getMaKH());
            ResultSet rsCheck = pstCheck.executeQuery();
            rsCheck.next();
            int count = rsCheck.getInt(1);

            // Nếu chưa tồn tại -> thêm mới
            if (count == 0) {
                String insertKH = "INSERT INTO KhachHang (maKH, tenKH, sdtKH, diaChi, soLanMua) VALUES (?,?,?,?,0)";
                PreparedStatement pstKH = con.prepareStatement(insertKH);
                pstKH.setString(1, kh.getMaKH());
                pstKH.setString(2, kh.getTenKH());
                pstKH.setString(3, kh.getSdtKH());
                pstKH.setString(4, kh.getDiaChi());
                pstKH.executeUpdate();
            }
        }

        // 2. Sinh mã phiếu xuất nếu chưa có
        if (t.getMaPhieu() == null || t.getMaPhieu().trim().isEmpty()) {
            String sqlMaPhieu = "SELECT maPhieu FROM PhieuXuat ORDER BY maPhieu DESC LIMIT 1";
            PreparedStatement pstMaPhieu = con.prepareStatement(sqlMaPhieu);
            ResultSet rsPhieu = pstMaPhieu.executeQuery();
            String newMaPhieu = "PX001";
            if (rsPhieu.next()) {
                String lastMaPhieu = rsPhieu.getString("maPhieu").replace("PX", "");
                int numPhieu = Integer.parseInt(lastMaPhieu) + 1;
                newMaPhieu = String.format("PX%03d", numPhieu);
            }
            t.setMaPhieu(newMaPhieu);
        }

        // 3. Insert phiếu xuất
        String sql = "INSERT INTO PhieuXuat (maPhieu, thoiGianTao, nguoiTao, tongTien, maKH) VALUES (?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getMaPhieu());
        pst.setTimestamp(2, t.getThoiGianTao());
        pst.setString(3, t.getNguoiTao());
        pst.setDouble(4, t.getTongTien());
        pst.setString(5, kh != null ? kh.getMaKH() : null);

        ketQua = pst.executeUpdate();

        con.commit();
    } catch (Exception e) {
        try {
            if (con != null) con.rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();  // in chi tiết lỗi ra console để bạn biết nguyên nhân
    } finally {
        JDBCUtil.closeConnection(con);
    }
    return ketQua;
}




    @Override
    public int update(PhieuXuat t) {
        int ketQua = 0;
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "UPDATE PhieuXuat SET thoiGianTao=?, nguoiTao=?, tongTien=?, maKH=? WHERE maPhieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, t.getThoiGianTao());
            pst.setString(2, t.getNguoiTao());
            pst.setDouble(3, t.getTongTien());
            pst.setString(4, t.getKhachHang() != null ? t.getKhachHang().getMaKH() : null);
            pst.setString(5, t.getMaPhieu());

            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return ketQua;
    }

    @Override
    public int delete(PhieuXuat t) {
        int ketQua = 0;
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "DELETE FROM PhieuXuat WHERE maPhieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());

            ketQua = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return ketQua;
    }

    @Override
    public ArrayList<PhieuXuat> selectAll() {
        ArrayList<PhieuXuat> ketQua = new ArrayList<>();
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT px.*, kh.tenKH, kh.sdtKH, kh.diaChi, kh.soLanMua " +
                         "FROM PhieuXuat px " +
                         "LEFT JOIN KhachHang kh ON px.maKH = kh.maKH " +
                         "ORDER BY px.thoiGianTao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("maPhieu");
                Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
                String nguoiTao = rs.getString("nguoiTao");
                double tongTien = rs.getDouble("tongTien");

                KhachHang kh = null;
                if (rs.getString("maKH") != null) {
                    kh = new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("sdtKH"),
                        rs.getString("diaChi"),
                        rs.getInt("soLanMua")
                    );
                }

                PhieuXuat p = new PhieuXuat(maPhieu, thoiGianTao, nguoiTao,
                        ChiTietPhieuXuatDAO.getInstance().selectAll(maPhieu), tongTien);
                p.setKhachHang(kh);

                ketQua.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return ketQua;
    }

    @Override
    public PhieuXuat selectById(String t) {
        PhieuXuat ketQua = null;
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT px.*, kh.tenKH, kh.sdtKH, kh.diaChi, kh.soLanMua " +
                         "FROM PhieuXuat px " +
                         "LEFT JOIN KhachHang kh ON px.maKH = kh.maKH " +
                         "WHERE px.maPhieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String maPhieu = rs.getString("maPhieu");
                Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
                String nguoiTao = rs.getString("nguoiTao");
                double tongTien = rs.getDouble("tongTien");

                KhachHang kh = null;
                if (rs.getString("maKH") != null) {
                    kh = new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("sdtKH"),
                        rs.getString("diaChi"),
                        rs.getInt("soLanMua")
                    );
                }

                ketQua = new PhieuXuat(maPhieu, thoiGianTao, nguoiTao,
                        ChiTietPhieuXuatDAO.getInstance().selectAll(maPhieu), tongTien);
                ketQua.setKhachHang(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return ketQua;
    }
    
}
