package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO KhachHang (maKH, tenKH, sdtKH, diaChi, soLanMua) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaKH());
            pst.setString(2, t.getTenKH());
            pst.setString(3, t.getSdtKH());
            pst.setString(4, t.getDiaChi());
            pst.setInt(5, t.getSoLanMua()); // số lần mua
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được khách hàng " + t.getMaKH(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            // Chỉ update tên, sdt, địa chỉ - không động vào soLanMua
            String sql = "UPDATE KhachHang SET tenKH=?, sdtKH=?, diaChi=? WHERE maKH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenKH());
            pst.setString(2, t.getSdtKH());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getMaKH());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(KhachHang t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM KhachHang WHERE maKH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaKH());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String sdtKH = rs.getString("sdtKH");
                String diaChi = rs.getString("diaChi");
                int soLanMua = rs.getInt("soLanMua");
                ketQua.add(new KhachHang(maKH, tenKH, sdtKH, diaChi, soLanMua));
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public KhachHang selectById(String t) {
        KhachHang ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE maKH=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String sdtKH = rs.getString("sdtKH");
                String diaChi = rs.getString("diaChi");
                int soLanMua = rs.getInt("soLanMua");
                ketQua = new KhachHang(maKH, tenKH, sdtKH, diaChi, soLanMua);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    // Kiểm tra khách hàng đã tồn tại chưa
    public boolean isCustomerExist(String tenKH, String sdtKH) {
        boolean exists = false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT 1 FROM KhachHang WHERE tenKH = ? AND sdtKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tenKH);
            pst.setString(2, sdtKH);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                exists = true;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    // Lấy mã KH theo tên và SĐT
    public String getCustomerIdByInfo(String tenKH, String sdtKH) {
        String maKH = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maKH FROM KhachHang WHERE tenKH = ? AND sdtKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tenKH);
            pst.setString(2, sdtKH);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                maKH = rs.getString("maKH");
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maKH;
    }

    // Tạo mã KH mới
    public String generateNewCustomerId() {
        String newId = "KH01";
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maKH FROM KhachHang ORDER BY CAST(SUBSTRING(maKH, 3) AS UNSIGNED) DESC LIMIT 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String lastId = rs.getString("maKH"); // VD: "KH05"
                int number = Integer.parseInt(lastId.substring(2));
                number++;
                newId = String.format("KH%02d", number);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newId;
    }

    // Tăng số lần mua dựa vào SĐT
    public void tangSoLanMua(String sdtKH) {
        try (Connection con = JDBCUtil.getConnection()) {
            String sqlCount = """
                SELECT COUNT(px.maPX) AS soLan
                FROM PhieuXuat px
                JOIN KhachHang kh ON px.maKH = kh.maKH
                WHERE TRIM(kh.sdtKH) = TRIM(?)
            """;
            PreparedStatement pstCount = con.prepareStatement(sqlCount);
            pstCount.setString(1, sdtKH);
            ResultSet rs = pstCount.executeQuery();

            if (rs.next()) {
                int soLan = rs.getInt("soLan");

                String sqlUpdate = "UPDATE KhachHang SET soLanMua = ? WHERE TRIM(sdtKH) = TRIM(?)";
                PreparedStatement pstUpdate = con.prepareStatement(sqlUpdate);
                pstUpdate.setInt(1, soLan);
                pstUpdate.setString(2, sdtKH);
                pstUpdate.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Kiểm tra tồn tại khách hàng theo SĐT
    public boolean isCustomerExistBySdt(String sdtKH) {
        boolean exists = false;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT 1 FROM KhachHang WHERE TRIM(sdtKH) = TRIM(?) LIMIT 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sdtKH);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) exists = true;
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    // Tăng số lần mua theo SĐT
    public int tangSoLanMuaBySdt(String sdtKH) {
        int rows = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE KhachHang SET soLanMua = soLanMua + 1 WHERE TRIM(sdtKH) = TRIM(?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sdtKH);
            rows = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    // Lấy khách theo SĐT
    public KhachHang getCustomerBySdt(String sdtKH) {
        KhachHang kh = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE TRIM(sdtKH) = TRIM(?) LIMIT 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sdtKH);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                kh = new KhachHang(
                    rs.getString("maKH"),
                    rs.getString("tenKH"),
                    rs.getString("sdtKH"),
                    rs.getString("diaChi"),
                    rs.getInt("soLanMua")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }
}
