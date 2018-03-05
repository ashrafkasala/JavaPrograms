package exam;

import java.util.Scanner;

public class UsPhone {

    public  static  void main(String args[]){
        Scanner scan = new Scanner(System.in);
    String f="rj54gth";
    int g=f.charAt(2) -'0';
    System.out.println("g "+g);
        String phone= scan.next();


        boolean flag=false;


        phone+=scan.nextLine();
       System.out.println("phone"+phone);
        int n= phone.length();
        for(int i=0;i<n;i++){
            if(Character.isDigit(phone.charAt(i))){
                    if(i+11<n) {
                        if (phone.charAt(i + 3) == '-' && phone.charAt(i + 7) == '-') {
                            for (int j = 1; j <= 11; j++) {

                                System.out.println("huh"+i + j);
                                if (j != 3 && j != 7) {
                                    if(Character.isDigit(phone.charAt(i+j))) {
                                        System.out.println("ww0"+i + j);

                                        flag=true;
                                    }
                                    else{
                                        flag = false;
                                        break;
                                    }
                                }
                            }

                            if(flag){
                                System.out.print("   edf"+ phone.substring(i,i+12));
                                break;
                            }
                        }

                    }
                }

                if(phone.charAt(i)=='(') {
                    System.out.print("in side if 2nd"+ i+" ");
                    System.out.print("n :"+n);
                    if (i+13 <= n) {
                        System.out.print("in side if 2.1");
                        if (phone.charAt(i + 4) == ')' && phone.charAt(i + 5) == ' ' && phone.charAt(i + 9) == '-') {
                            for (int j = 1; j <= 13; j++) {

                                System.out.println("2nd" + i + j);
                                if (j != 4 && j != 5 && j != 9) {
                                    if (Character.isDigit(phone.charAt(i + j))) {
                                        System.out.println("ww2" + i + j);

                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }

                                }
                            }
                            if (flag) {
                                System.out.print("   2nd " + phone.substring(i, i + 13));
                                break;
                            }


                        }
                }

                }


            }
        }
    }


