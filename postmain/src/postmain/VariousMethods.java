package postmain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VariousMethods {

    private static final DateTimeFormatter current_date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter current_time = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final LocalDateTime now = LocalDateTime.now();

    @SuppressWarnings({"RedundantStringToString", "StaticNonFinalUsedInInitialization"})
    private static final String date = current_date.format(now).toString();
    @SuppressWarnings({"RedundantStringToString", "StaticNonFinalUsedInInitialization"})
    private static final String time = current_time.format(now).toString();

    public static String userNmae;

    public static String getDate() {
        return date;
    }

    public static String getTime() {
        return time;
    }

    //**************************************************************************************************\\
    ArrayList<post> arrayofposts = new ArrayList<>();

    File posts = new File("D:\\post.dat");

    public void khadamat_user() throws IOException {

        Scanner input = new Scanner(System.in);

        int npost = 0;
        int con = -3;
        while (con == -3) {//begin the while loop
            System.out.println("1.ADD POSTS");
            System.out.println("2.DISPLAY POSTS");
            System.out.println("3.PRINT POSTS");
            System.out.println("4.EXIT");

            System.out.println("Please enter the login type  : ");

            try {//begin try
                npost = input.nextInt();
            }//end try
            catch (Exception e) {//begin catch
                System.out.println("over there erroneous !!!!!!!!!!!!!");
            }//end catch 
            switch (npost) {//begin the switch
                case 1:

                    int con2 = -3;
                    while (con2 == -3) {
                        System.out.println("**********************************************");
                        System.out.println("What kind of post do you want ? ");
                        System.out.println("1.text post");
                        System.out.println("2.photo post");
                        System.out.println("3.video post");
                        System.out.println("4.cancel operation");
                        System.out.println("**********************************************");
                        System.out.println("Please enter the type posts :  ");
                        int a = input.nextInt();

                        switch (a) {
                            case 1:
                                Textpost tp = new Textpost();
                                System.out.print("Text Post: ");
                                tp.settextpost(new Scanner(System.in).nextLine());
                                System.out.print("Feeling: ");
                                tp.setfelling(new Scanner(System.in).nextLine());
                                tp.setdate(VariousMethods.getDate());
                                tp.settime(VariousMethods.getTime());
                                tp.setusername(VariousMethods.userNmae);

                                posts.createNewFile();

                                ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(posts));
                                 {
                                    try {
                                        arrayofposts = (ArrayList<post>) OIS.readObject();
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(VariousMethods.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                                arrayofposts.add(tp);
                                ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(posts));
                                OOS.writeObject(arrayofposts);
                                OOS.close();
                                break;

                            case 2:
                                photopost pp = new photopost();
                                System.out.print("Text post: ");
                                pp.settextpost(new Scanner(System.in).nextLine());
                                System.out.print("Feeling: ");
                                pp.setfelling(new Scanner(System.in).nextLine());
                                System.out.print("Photo name: ");
                                pp.setphoto(new Scanner(System.in).nextLine());
                                pp.setdate(VariousMethods.getDate());
                                pp.settime(VariousMethods.getTime());
                                pp.setusername(VariousMethods.userNmae);

                                OIS = new ObjectInputStream(new FileInputStream(posts));
                                 {
                                    try {
                                        arrayofposts = (ArrayList<post>) OIS.readObject();
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(VariousMethods.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                arrayofposts.add(pp);

                                OOS = new ObjectOutputStream(new FileOutputStream(posts));
                                OOS.writeObject(arrayofposts);
                                OOS.close();
                                break;
                            case 3:
                                Videopost vp = new Videopost();
                                System.out.print("Text post: ");
                                vp.settextpost(new Scanner(System.in).nextLine());
                                System.out.print("Feeling: ");
                                vp.setfelling(new Scanner(System.in).nextLine());
                                System.out.print("Video name: ");
                                vp.setvideo(new Scanner(System.in).nextLine());
                                vp.setdate(VariousMethods.getDate());
                                vp.settime(VariousMethods.getTime());
                                vp.setusername(VariousMethods.userNmae);

                                OIS = new ObjectInputStream(new FileInputStream(posts));
                                 {
                                    try {
                                        arrayofposts = (ArrayList<post>) OIS.readObject();
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(VariousMethods.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                arrayofposts.add(vp);

                                OOS = new ObjectOutputStream(new FileOutputStream(posts));
                                OOS.writeObject(arrayofposts);
                                OOS.close();
                                break;
                            case 4:
                                con2++;
                                break;
                            default:
                                System.out.println("Invaild choise");
                        }
                    }
                    break;

                case 2: // DISPLAY POSTS

                    ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(posts));
                     {
                        try {
                            arrayofposts = (ArrayList<post>) OIS.readObject();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(VariousMethods.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    for (int j = 0; j < arrayofposts.size(); j++) {
                        if (arrayofposts.get(j).getusername().equals(userNmae)) {
                            System.out.println("\n" + "The Text : " + arrayofposts.get(j).gettextpost());
                            System.out.println("The Felling : " + arrayofposts.get(j).getfelling());

                            if (arrayofposts.get(j).getphoto() == null && arrayofposts.get(j).getvideo() == null) {

                            } else {
                                if (arrayofposts.get(j).getvideo() == null) {
                                    System.out.println("The Photo : " + arrayofposts.get(j).getphoto());
                                } else {
                                    System.out.println("The Video : " + arrayofposts.get(j).getvideo());
                                }
                            }

                            System.out.println("The Date : " + arrayofposts.get(j).getdata());
                            System.out.println("The Time : " + arrayofposts.get(j).gettime() + "\n\n\n**********************************\n\n\n");
                        }
                    }
                    break;

                case 3: // PRINT POSTS
                    File printposts = new File("D:\\post.txt");
                    //printposts.createNewFile();

                    OIS = new ObjectInputStream(new FileInputStream(posts));
                     {
                        try {
                            arrayofposts = (ArrayList<post>) OIS.readObject();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(VariousMethods.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    PrintWriter printforFile = new PrintWriter(printposts);
                    printforFile.println("");
                    printforFile.close();

                    for (post arrayofpost : arrayofposts) {
                        FileOutputStream stream = new FileOutputStream(printposts, true);
                        PrintWriter p_textFile = new PrintWriter(stream);
                        if (arrayofpost.getusername().equals(userNmae)) {
                            p_textFile.println("\nThe Text : " + arrayofpost.gettextpost()
                                    + "\nThe Felling : " + arrayofpost.getfelling());

                            if (arrayofpost.getphoto() == null && arrayofpost.getvideo() == null) {

                            } else {

                                if (arrayofpost.getvideo() == null) {
                                    p_textFile.println("The Photo : " + arrayofpost.getphoto());
                                } else {
                                    p_textFile.println("The Video : " + arrayofpost.getvideo());
                                }
                            }
                            p_textFile.println("The Date : " + arrayofpost.getdata());
                            p_textFile.println("The Time : " + arrayofpost.gettime() + "\n\n\n**********************************\n\n\n");
                            p_textFile.close();
                        } // enf if
                    } // end for
                    break;
                case 4:
                    ++con;
                    break;
                default:
                    System.out.println("Enter The true number (1,2,3,4)!");
                    break;

            } // end sw nost
        } // end while

    } // end khadamat_user

} // end class 
