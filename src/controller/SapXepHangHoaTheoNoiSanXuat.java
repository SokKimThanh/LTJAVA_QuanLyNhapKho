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
public class SapXepHangHoaTheoNoiSanXuat implements Comparator<HangHoa> {

    @Override
    public int compare(HangHoa o1, HangHoa o2) {
        return o1.getNoisx().compareTo(o2.getNoisx());
    }

}
