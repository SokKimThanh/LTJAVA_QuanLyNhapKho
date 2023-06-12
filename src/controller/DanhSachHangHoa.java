/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HangHoa;

/**
 *
 * @author Thanh 11/06/2023
 */
public class DanhSachHangHoa {

    //fields
    private ArrayList<HangHoa> data;

    //properties
    public ArrayList<HangHoa> getData() {
        return data;
    }

    //constructor
    public DanhSachHangHoa() {
        data = new ArrayList<>();
    }
    
    public void XuatDS() {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).toString());
        }
    }
    
    public boolean Them(HangHoa item) {
        boolean check = false;
        if (data.isEmpty()) {
            data.add(item);
            check = true;
        } else {
            for (HangHoa hh : data) {
                if (hh.getMa().equals(item.getMa())) {
                    try {
                        check = false;
                        throw new Exception("Hang hoa da co trong danh sach");
                    } catch (Exception ex) {
                        Logger.getLogger(DanhSachHangHoa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    data.add(item);
                    check = true;
                }
                
                if (check == true) {
                    break;//sau vòng lặp for
                }
            }
        }
        return check;
    }

    /**
     * @param hh input dau vao la mot hang hoa
     * @return Xoa phan tu dau tien tim thay
     */
    public boolean Xoa(HangHoa hh) {
        for (HangHoa item : data) {
            if (item.getMa().equals(hh.getMa())) {
                data.remove(item);
                return true;// xoa xong
            }
        }
        // chua xoa duoc
        return false;
    }

    /**
     * @param hh input dau vao la mot hang hoa
     * @return Xoa phan tu dau tien tim thay
     */
    public boolean Sua(HangHoa hh) {
        boolean check = false;
        for (HangHoa item : data) {
            if (item.getMa().equals(hh.getMa())) {
                // cap nhat thong tin moi
                item.setMa(hh.getMa());
                item.setTen(hh.getTen());
                item.setDonGia(hh.getDonGia());
                item.setNgaySX(hh.getNgaySX());
                item.setNoisx(hh.getNoisx());
                check = true;// cap nhat xong
            }
            if (check == true) {
                break;
            }
        }
        // chua cap nhat duoc
        return check;
    }
    
    public void SapXep() {
        //interchange
        for (int i = 0; i < data.size() - 1; i++) {
            HangHoa o1 = data.get(i);
            for (int j = i + 1; j < data.size(); j++) {
                HangHoa o2 = data.get(j);
                if (new SapXepHangHoaTheoNoiSanXuat().compare(o1, o2) != 0) {
                    data.sort(new SapXepHangHoaTheoNoiSanXuat());
                } else {
                    data.sort(new SapXepHangHoaTheoThanhTienGiamDan());
                }
            }
        }
    }

    /**
     * @param fileName "danhsach_hanghoa.txt"
     * @return
     */
    public String GhiFile(String fileName) {
        if (fileName == null || "".equals(fileName)) {
            try {
                throw new Exception("File Name khong duoc phep trong");
            } catch (Exception ex) {
                Logger.getLogger(DanhSachHangHoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // khai bao
        String mgs = "";
        try (FileWriter fw = new FileWriter(fileName)) {
            for (HangHoa item : data) {
                mgs += item.ToFile() + "\n";
                fw.write(item.ToFile() + "\n");
            }
            System.out.printf("ghi file %s thanh cong!\n", fileName);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(DanhSachHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mgs;
    }
//ma, ten, noisx, donGia, soluong, ngaySX

    public HangHoa parse(String lines) {
        String[] line = lines.split("#");
        HangHoa hh = new HangHoa();
        hh.setMa(line[0]);
        hh.setTen(line[1]);
        hh.setNoisx(line[2]);
        hh.setDonGia(Integer.parseInt(line[3]));
        hh.setSoluong(Integer.parseInt(line[4]));
        hh.setNgaySX(line[5]);
        return hh;
    }

    /**
     * @param fileName "danhsach_hanghoa.txt"
     * @return
     */
    public String DocFile(String fileName) {
        data.clear();
        String mgs = "";
        try (FileReader fr = new FileReader(fileName)) {
            
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                HangHoa item = parse(line);
                mgs += item.ToFile() + "\n";
                data.add(item);
            }
            System.out.printf("Doc file %s thanh cong!\n", fileName);
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(DanhSachHangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mgs;
    }
}
