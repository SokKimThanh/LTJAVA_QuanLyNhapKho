/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Comparator;
import model.HangHoa;

/**
 *
 * @author Thanh
 */
public class SapXepHangHoaTheoThanhTienGiamDan implements Comparator<HangHoa> {

    @Override
    public int compare(HangHoa o1, HangHoa o2) {
        if (o1.ThanhTien() > o2.ThanhTien()) {
            // tang dan
            return 1;
        } else if (o1.ThanhTien() < o2.ThanhTien()) {
            // giam dan
            return -1;
        }
        // bang nhau
        return 0;
    }

}
