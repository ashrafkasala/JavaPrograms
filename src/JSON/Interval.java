package JSON;

//import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.in;

public class Interval {

    public static void main(String... args) throws UnsupportedEncodingException, IOException {

        List<HashMap<String, String>> list = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(in);

        String str;
        System.out.print("Write something here and press Enter:");


        while ((str = input.readLine()) != null) {
            if (str.contains("name")) {
                String array1[] = str.split("name:");
                StringBuilder sname = new StringBuilder();
                String strname = array1[1];
                for (int i = 0; i < strname.length(); i++) {

                    if (strname.charAt(i) != '"' || strname.charAt(i) != ',' || strname.charAt(i) != ' ') {
                        sname.append(strname.charAt(i));
                    }
                }

                nameList.add(String.valueOf(sname));
            } else if (str.contains("start")) {
                String array1[] = str.split("start:");
                StringBuilder sstart = new StringBuilder();
                String ststart = array1[1];

                for (int i = 0; i < ststart.length(); i++) {

                    if (ststart.charAt(i) != '"' || ststart.charAt(i) != ',' || ststart.charAt(i) != ' ') {
                        sstart.append(ststart.charAt(i));
                    }
                }

                startList.add(Integer.parseInt(String.valueOf(sstart)));
            }
            else if(str.contains("end")){
                String array1[] = str.split("end:");
                StringBuilder ssend = new StringBuilder();
                String send = array1[1];

                for (int i = 0; i < send.length(); i++) {

                    if (send.charAt(i) != '"' || send.charAt(i) != ',' || send.charAt(i) != ' ') {
                        ssend.append(send.charAt(i));
                    }
                }

                endList.add(Integer.parseInt(String.valueOf(ssend)));
            }

            System.out.println("str = " + str);

        }

        System.out.println("nameList = " + nameList);
        System.out.println("startList = " + startList);
    }
}
