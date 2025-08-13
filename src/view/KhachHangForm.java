package view;

import controller.SearchKhachHang;
import dao.KhachHangDAO;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author uyenu
 */
public class KhachHangForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    private static ArrayList<KhachHang> armt;

    public KhachHangForm() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblNCC.setDefaultEditor(Object.class, null);
        initTable();
        armt = KhachHangDAO.getInstance().selectAll();
        loadDataToTable(armt);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        // *** Thêm cột "Số lần mua" ở đây ***
        String[] headerTbl = new String[]{"Mã KH", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Số lần mua"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblNCC.setModel(tblModel);
        tblNCC.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblNCC.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblNCC.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblNCC.getColumnModel().getColumn(3).setPreferredWidth(300);
        tblNCC.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    public void loadDataToTable(ArrayList<KhachHang> kh) {
        try {
            tblModel.setRowCount(0);
            for (KhachHang i : kh) {
                // *** Thêm trường soLanMua vào đây khi load dữ liệu ***
                tblModel.addRow(new Object[]{
                    i.getMaKH(), i.getTenKH(), i.getSdtKH(), i.getDiaChi(), i.getSoLanMua()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KhachHang getKhachHangSelect() {
        int i_row = tblNCC.getSelectedRow();
        KhachHang kh = KhachHangDAO.getInstance().selectAll().get(i_row);
        return kh;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        exportExcel = new javax.swing.JButton();
        importExcel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxlLuaChon = new javax.swing.JComboBox<>();
        txtSearchForm = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÊM TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Vai trò");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm tài khoản");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, 269, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        jButton4.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton4.setText("Xoá");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        jButton5.setText("Sửa");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator1);

        exportExcel.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        exportExcel.setText("Xuất Excel");
        exportExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelActionPerformed(evt);
            }
        });
        jToolBar1.add(exportExcel);

        importExcel.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/table.png"))); // NOI18N
        importExcel.setText("Nhập Excel");
        importExcel.setFocusable(false);
        importExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelActionPerformed(evt);
            }
        });
        jToolBar1.add(importExcel);

        jPanel2.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxlLuaChon.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        cbxlLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ" }));
        jPanel3.add(cbxlLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 40));

        txtSearchForm.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        txtSearchForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchFormActionPerformed(evt);
            }
        });
        txtSearchForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchFormKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchFormKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearchForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 400, 40));

        btnReset.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reload (1).png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 120, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 760, 90));

        jScrollPane1.setBorder(null);

        // NOTE: initComponents auto-model: set columns with the new 5th column
        tblNCC.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã KH", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Số lần mua"
            }
        ));
        jScrollPane1.setViewportView(tblNCC);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1160, 620));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddKhachHang a = new AddKhachHang(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (tblNCC.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng muốn sửa");
        } else {
            UpdateKhachHang up = new UpdateKhachHang(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            up.setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (tblNCC.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá khách hàng", "Xác nhận xoá khách hàng", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                KhachHangDAO.getInstance().delete(getKhachHangSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                loadDataToTable(KhachHangDAO.getInstance().selectAll());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("KhachHang");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblNCC.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblNCC.getColumnName(i));
                }

                for (int j = 0; j < tblNCC.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblNCC.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblNCC.getValueAt(j, k) != null) {
                            // convert to string
                            cell.setCellValue(tblNCC.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportExcelActionPerformed

    private void importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importExcelActionPerformed
        //Import excel (hỗ trợ 5 cột: ma, ten, sdt, diachi, soLanMua) — nếu file chỉ có 4 cột vẫn ok
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        ArrayList<KhachHang> listAccExcel = new ArrayList<>();
        JFileChooser jf = new JFileChooser();
        int result = jf.showOpenDialog(null);
        jf.setDialogTitle("Open file");
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = jf.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    if (excelRow == null) continue;

                    String maKhachHang = "";
                    String tenKhachHang = "";
                    String sdt = "";
                    String diaChi = "";
                    int soLanMua = 0;

                    // cell 0: ma
                    try {
                        Cell c = excelRow.getCell(0);
                        if (c != null) {
                            if (c.getCellType() == CellType.NUMERIC) maKhachHang = String.valueOf((long) c.getNumericCellValue());
                            else maKhachHang = c.getStringCellValue();
                        }
                    } catch (Exception ex) {}

                    // cell 1: ten
                    try {
                        Cell c = excelRow.getCell(1);
                        if (c != null) {
                            if (c.getCellType() == CellType.NUMERIC) tenKhachHang = String.valueOf((long) c.getNumericCellValue());
                            else tenKhachHang = c.getStringCellValue();
                        }
                    } catch (Exception ex) {}

                    // cell 2: sdt
                    try {
                        Cell c = excelRow.getCell(2);
                        if (c != null) {
                            if (c.getCellType() == CellType.NUMERIC) sdt = String.valueOf((long) c.getNumericCellValue());
                            else sdt = c.getStringCellValue();
                        }
                    } catch (Exception ex) {}

                    // cell 3: dia chi
                    try {
                        Cell c = excelRow.getCell(3);
                        if (c != null) {
                            if (c.getCellType() == CellType.NUMERIC) diaChi = String.valueOf((long) c.getNumericCellValue());
                            else diaChi = c.getStringCellValue();
                        }
                    } catch (Exception ex) {}

                    // cell 4: soLanMua (optional)
                    try {
                        Cell c = excelRow.getCell(4);
                        if (c != null) {
                            if (c.getCellType() == CellType.NUMERIC) soLanMua = (int) c.getNumericCellValue();
                            else {
                                String s = c.getStringCellValue();
                                soLanMua = Integer.parseInt(s.trim());
                            }
                        }
                    } catch (Exception ex) {
                        soLanMua = 0;
                    }

                    // tạo object (sử dụng constructor có soLanMua)
                    KhachHang acc = new KhachHang(maKhachHang, tenKhachHang, sdt, diaChi, soLanMua);
                    listAccExcel.add(acc);
                }

                // cập nhật bảng hiển thị từ file excel (preview)
                loadDataToTable(listAccExcel);

                // hỏi user có muốn import vào DB luôn không
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn import dữ liệu vào database không?", "Xác nhận import", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int k = 0;
                    for (KhachHang khachHang : listAccExcel) {
                        int r = KhachHangDAO.getInstance().insert(khachHang);
                        if (r > 0) k++;
                    }
                    if (k > 0) {
                        JOptionPane.showMessageDialog(this, "Import thành công " + k + " bản ghi!");
                        loadDataToTable(KhachHangDAO.getInstance().selectAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Không có bản ghi nào được import (hoặc xảy ra lỗi).");
                    }
                } else {
                    // nếu không import, giữ preview trên table
                }

                if (excelJTableImport != null) excelJTableImport.close();
                if (excelBIS != null) excelBIS.close();
                if (excelFIS != null) excelFIS.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_importExcelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSearchForm.setText("");
        cbxlLuaChon.setSelectedIndex(0);
        loadDataToTable(KhachHangDAO.getInstance().selectAll());
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSearchFormKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFormKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFormKeyPressed

    private void txtSearchFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFormActionPerformed

    private void txtSearchFormKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFormKeyReleased
        String luachon = (String) cbxlLuaChon.getSelectedItem();
        String searchContent = txtSearchForm.getText();
        ArrayList<KhachHang> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả":
                result = SearchKhachHang.getInstance().searchTatCa(searchContent);
                break;
            case "Mã khách hàng":
                result = SearchKhachHang.getInstance().searchMaKH(searchContent);
                break;
            case "Tên khách hàng":
                result = SearchKhachHang.getInstance().searchTenKH(searchContent);
                break;
            case "Địa chỉ":
                result = SearchKhachHang.getInstance().searchDiaChi(searchContent);
                break;
            case "Số điện thoại":
                result = SearchKhachHang.getInstance().searchSdt(searchContent);
                break;
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchFormKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxlLuaChon;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton importExcel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTextField txtSearchForm;
    // End of variables declaration//GEN-END:variables

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
