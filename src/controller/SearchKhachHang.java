/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author sinh
 */
public class SearchKhachHang {

    public static SearchKhachHang getInstance() {
        return new SearchKhachHang();
    }

    public ArrayList<KhachHang> searchTatCa(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getMaKH().toLowerCase().contains(text.toLowerCase())
                    || kh.getTenKH().toLowerCase().contains(text.toLowerCase())
                    || kh.getSdtKH().toLowerCase().contains(text.toLowerCase())
                    || kh.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchTenKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getTenKH().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchMaKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getMaKH().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchDiaChi(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchSdt(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getSdtKH().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
}
