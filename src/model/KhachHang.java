package model;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String sdtKH;
    private String diaChi;
    private int soLanMua; // Thêm trường số lần mua

    // Constructor mặc định
    public KhachHang() {
    }

    // Constructor không có soLanMua (để code cũ không bị lỗi)
    public KhachHang(String maKH, String tenKH, String sdtKH, String diaChi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.diaChi = diaChi;
        this.soLanMua = 0; // mặc định 0
    }

    // Constructor đầy đủ
    public KhachHang(String maKH, String tenKH, String sdtKH, String diaChi, int soLanMua) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.diaChi = diaChi;
        this.soLanMua = soLanMua;
    }

    // Getter và Setter
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", sdtKH='" + sdtKH + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soLanMua=" + soLanMua +
                '}';
    }
}
