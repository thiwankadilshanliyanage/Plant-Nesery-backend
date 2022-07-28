/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiwanka
 */
public class DataAccessobj {

    private static final List<storage> datas = new ArrayList<>();

    public static void putData(storage data) {
        if (data != null) {
            datas.add(data);
        }
    }

    public static List<storage> getDatas() {
        return datas;
    }
    
    
}
