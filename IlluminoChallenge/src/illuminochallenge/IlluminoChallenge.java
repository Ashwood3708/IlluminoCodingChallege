/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package illuminochallenge;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author Abdul
 */
public class IlluminoChallenge implements fireWall {

    @Override
    public void fireWall(String path) {

        String line = "";
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < 4; i++) {
                lists.add(new ArrayList());
            }
            while ((line = br.readLine()) != null) {
                String[] inputs = line.split(delimiter);
                //udp&Inbound=0,udp&outbound=1,tcp&inbound=2,tcp&outbound=3
                int pos = 0;
                if (inputs[0].equals("outbound")) {
                    pos++;
                }
                if (inputs[1].equals("tcp")) {
                    pos += 2;
                }
                lists.get(pos).add(inputs);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean accept_packet(String dir, String protocol, int port, String ip) {
        int loc = 0;
        if (dir.equals("outbound")) {
            loc++;
        }
        if (protocol.equals("tcp")) {
            loc += 2;
        }
        List<String[]> packet = lists.get(loc);
        for (String[] list : packet) {
            boolean p = comparePorts(list[2], port);
            boolean q = compareIp(list[3], ip);
            if (p == q && q == true) {
                return true;
            }
        }

        return false;
    }

    public int parseIp(String address) {
        int result = 0;
        // iterate over each octet
        for (String part : address.split(Pattern.quote("."))) {
            // shift the previously parsed bits over by 1 byte
            result = result << 8;
            result |= Integer.parseInt(part);
        }
        return result;
    }

    public boolean compareIp(String ip, String t) {
        if (ip.contains("-")) {
            String[] r = ip.split("-");
            int max = parseIp(r[1]);
            int min = parseIp(r[0]);
            return (min < parseIp(t) && max > parseIp(t));
        }
        return (t.equals(ip));
    }

    public boolean comparePorts(String ports, int t) {
        if (ports.contains("-")) {
            String[] r = ports.split("-");
            int max = Integer.parseInt(r[1]);
            int min = Integer.parseInt(r[0]);
            return (min < t && max > t);
        }
        return (t == Integer.parseInt(ports));
    }

}
