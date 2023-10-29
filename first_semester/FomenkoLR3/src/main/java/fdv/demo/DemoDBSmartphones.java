package fdv.demo;


import fdv.daosmartphones.DAOSmartphones;

import fdv.dbconnect.DBConnect;
import fdv.model.Smartphone;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class DemoDBSmartphones {

    public static void main(String[] args) {

        System.out.println("**** Programm JDBC Struct MySQL ****");

        try {
            DBConnect.DBConection();
            System.out.println("Start working");
            System.out.println("\nConnecting to MySQL DB....");
            Connection con = DBConnect.getConnection();
            System.out.println("DB successfully connected!");

            Smartphone newSmartphone;
            Smartphone smartForSeek;

            int id;
            Scanner scan = new Scanner(System.in);
            int choice = 0;
            do {
                choice = menu(scan); //show menu and catch user's input
                switch (choice) {
                    case 1:
                        //SELECT
                        System.out.println("\nSELECT ALL");
                        showAll(DAOSmartphones.getSmartphoneList(con), "STORED Data");
                        break;
                    case 2:
                        //SEEK
                        System.out.println("\nSEARCH OF THE OBJECT");

                        smartForSeek = createSmartphoneModelToSeek(scan);
                        id = DAOSmartphones.getIdByModel(con, smartForSeek);
                        if (id == -1) {
                            System.out.println("== SEARCH ID == This smartphone was not found");
                        } else {
                            System.out.println("== SEARCH ID == This smartphone have id = " + id);
                            System.out.println(DAOSmartphones.getSmartphoneDataByModel(con, smartForSeek));
                        }
                        break;
                    case 3:
                        //INSERT
                        System.out.println("\nINSERT NEW");
                        newSmartphone = new Smartphone(scan, "Input data about new smartphone");
                        boolean insertRes = DAOSmartphones.insert(con, newSmartphone);
                        if (insertRes) {
                            System.out.println("\nSmartphone has been inserted SUCCESSFULLY!!!\n");
                            showAll(DAOSmartphones.getSmartphoneList(con), "Data AFTER INSERT");
                        } else {
                            System.out.println("== INSERT == May be smartphone with the same MODEL contained in database");
                        }
                        break;
                    case 4:
                        //UPDATE
                        System.out.println("\nUPDATE");
                        smartForSeek = createSmartphoneModelToSeek(scan);
                        id = DAOSmartphones.getIdByModel(con, smartForSeek);
                        if (id != -1) {
                            newSmartphone = new Smartphone(scan, "Input data for updating");
                            boolean updateRes = DAOSmartphones.update(con, id, newSmartphone);
                            if (updateRes) {
                                System.out.println("\nObject has been updated SUCCESSFULLY!!!\n");
                                showAll(DAOSmartphones.getSmartphoneList(con), "Data AFTER UPDATE");
                            } else {
                                System.out.println("== UPDATE == May be smartphone with the same MODEL contained in database");
                            }
                        } else {
                            System.out.println("== UPDATE == Object with specified data not found");
                        }
                        break;
                    case 5:
                        //DELETE
                        System.out.println("\nDELETE");
                        smartForSeek = createSmartphoneModelToSeek(scan);
                        id = DAOSmartphones.getIdByModel(con, smartForSeek);
                        if (id != -1) {
                            boolean deleteRes = DAOSmartphones.delete(con, id);
                            if (deleteRes) {
                                System.out.println("\nObject has been deleted SUCCESSFULLY!!!\n");
                                showAll(DAOSmartphones.getSmartphoneList(con), "Data AFTER DELETE");
                            } else {
                                System.out.println("== DELETE used ID == Mistake when SQL execute!!!!");
                            }
                        } else {
                            System.out.println("== DELETE used ID == Smartphone with this model not found");
                        }
                        break;

                    case 0:
                        System.out.println("\n");
                        break;
                    default:
                        System.out.println("Wrong choice! Try again ...");
                }
            } while (choice != 0);
            //Dissconnecting DB and terminanate app
            DBConnect.DBClose();
            scan.close();
        } catch (ClassNotFoundException | NoSuchMethodException
                 | InvocationTargetException | InstantiationException
                 | IllegalAccessException ex) {
            System.out.println("JDBC driver absent, work impossible");
            System.exit(111);
        } catch (SQLException ex) {
            System.out.println("Connecting to DB not executed!\nCheck path to file with database and its readу to work!");
            System.exit(222);
        }
        System.out.println("**** THE END ****");
    }

    private static int menu(Scanner scan) {
        int choice = 0; //0 - Exit
        //Output menu items
        System.out.println("\n\n***** MENU *****");
        System.out.println("1. SELECT ALL");
        System.out.println("2. Search by MODEL");
        System.out.println("3. INSERT");
        System.out.println("4. UPDATE");
        System.out.println("5. DELETE");
        System.out.println("0. Exit");
        System.out.print("***** Make your choice ====>>> ");
        try {
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        System.out.println();
        return choice;
    }

    private static Smartphone createSmartphoneToSeek(Scanner scan) {
        return new Smartphone(scan);
    }

    private static Smartphone createSmartphoneModelToSeek(Scanner scan) {
        return new Smartphone(scan, true);
    }

    private static void showAll(List list, String label) {
        if (list == null) {
            System.out.println("\nThere are no records in the specified table or an error occurred while executing the SQL SELECT query");
        } else {
            System.out.println("\n" + label);
            System.out.println(list.toString());
        }
    }
}
