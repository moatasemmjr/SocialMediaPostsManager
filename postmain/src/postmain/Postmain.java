package postmain;

//import java.io.*;
//import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Postmain {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        ArrayList<user> signarr = new ArrayList<>();
        File users = new File("D:\\user.dat");

        int ch_sign = 0;

        while (ch_sign != -3) {
            System.out.println("1. REGISTER a new user  ");
            System.out.println("2. LOGIN ");
            System.out.println("3. EXIT ");
            System.out.println(" Please enter the login type  : "); // 1-->2 --- 3 exit
            ch_sign = input.nextInt();

            switch (ch_sign) {

                case 1: // جديد
                    System.out.println(" enter the New Username : ");
                    String username = input.next();
                    System.out.println(" enter the New Password : ");
                    String password = input.next();
                    user n1 = new user();
                    n1.setUsername(username);
                    n1.setPassword(password);

                    users.createNewFile();
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(users));
                     {
                        try {
                            signarr = (ArrayList<user>) ois.readObject();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Postmain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    signarr.add(n1);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(users));
                    oos.writeObject(signarr);
                    oos.close();

                    System.out.println("success...************************************");
                    //System.out.println("*****************>>" + n1.getUsername() + "*****************");
                    VariousMethods.userNmae = username;
                    VariousMethods VM = new VariousMethods();
                    VM.khadamat_user();
                    break;

                case 2: // LOGIN

                    System.out.println(" enter Username : ");
                    String userName = input.next();
                    System.out.println(" enter Password : ");
                    String passWord = input.next();

                    try {
                        ois = new ObjectInputStream(new FileInputStream(users));
                        signarr = (ArrayList<user>) ois.readObject();
                        for (int i = 0; i < signarr.size(); i++) {
                            if (signarr.get(i).getUsername().equals(userName) && signarr.get(i).getPassword().equals(passWord)) {
                                VariousMethods.userNmae = signarr.get(i).getUsername();
                                VariousMethods vm = new VariousMethods();
                                vm.khadamat_user();
                            }
                        } // end for 
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Postmain.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                case 3:
                    ch_sign = -3;
                    break;

                default:
                    System.out.println("Please enter an available number (1,2,3)! ");
            } //  end swihch
        } // end while

    } // end main
} // end class postmain
