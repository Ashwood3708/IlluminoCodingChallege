/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package illuminochallenge;
import java.util.*;
/**
 *
 * @author Abdul
 */
public interface fireWall {
    List<ArrayList<String[]>> lists = new ArrayList();
     void fireWall(String path);
     boolean accept_packet(String dir, String protocol, int port, String ip);  
}
