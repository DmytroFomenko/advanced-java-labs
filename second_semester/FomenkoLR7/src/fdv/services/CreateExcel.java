package fdv.services;


import fdv.entities.Smartphone;
import fdv.entities.SmartphoneClasses;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

public class CreateExcel {

    private static final String TIMES_NEW_ROMAN = "Times New Roman";

    @SuppressWarnings("deprecation")
    public static void writeSmartListIntoExcel(ArrayList<SmartphoneClasses> smartphones) {
        XSSFRow row;
        XSSFCell cell;

        try (InputStream iS = Files.newInputStream(new File("Template.xlsx").toPath())) {

            XSSFWorkbookFactory wbF = new XSSFWorkbookFactory();
            try (XSSFWorkbook workbook = wbF.create(iS)) {

                XSSFFont defaultFont = workbook.createFont();
                defaultFont.setFontHeightInPoints((short) 12);
                defaultFont.setFontName(TIMES_NEW_ROMAN);
                defaultFont.setBold(false);
                defaultFont.setItalic(false);

                XSSFCellStyle defaultStyle = workbook.createCellStyle();
                defaultStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                defaultStyle.setAlignment(HorizontalAlignment.CENTER);
                //defaultStyle.setAlignment(HorizontalAlignment.LEFT);
                defaultStyle.setFont(defaultFont);
                defaultStyle.setWrapText(true);
                defaultStyle.setBorderTop(BorderStyle.THIN);
                defaultStyle.setBorderBottom(BorderStyle.THIN);
                defaultStyle.setBorderLeft(BorderStyle.THIN);
                defaultStyle.setBorderRight(BorderStyle.THIN);

                XSSFCellStyle defaultStyleLeft = workbook.createCellStyle();
                defaultStyleLeft.setVerticalAlignment(VerticalAlignment.CENTER);
                defaultStyleLeft.setAlignment(HorizontalAlignment.LEFT);
                defaultStyleLeft.setFont(defaultFont);
                defaultStyleLeft.setWrapText(true);
                defaultStyleLeft.setBorderTop(BorderStyle.THIN);
                defaultStyleLeft.setBorderBottom(BorderStyle.THIN);
                defaultStyleLeft.setBorderLeft(BorderStyle.THIN);
                defaultStyleLeft.setBorderRight(BorderStyle.THIN);

                XSSFSheet sheet = workbook.getSheetAt(0);


                int currentRow = 1;
                String valuecell;

                for (SmartphoneClasses sCl : smartphones) {
                    currentRow++;
                    row = sheet.createRow(currentRow);
                    cell = row.createCell(0);

                    // Set type fo smartphone
                    valuecell = String.valueOf(sCl.getType());
                    cell.setCellValue(valuecell);
                    cell.setCellStyle(defaultStyleLeft);
                    cell = row.createCell(1);
                    ArrayList<Smartphone> list = sCl.getComposition();
                    StringBuilder sb = new StringBuilder();

                    // Form string of smartphones characteristics
                    for (int i = 0, n = list.size(); i < n; i++) {
                        Smartphone sf = list.get(i);
                        sb.append(sf.getCompany())
                                .append(" ")
                                .append(sf.getModel())
                                .append(" (performance: ")
                                .append(sf.getPerformance())
                                .append(", price: $")
                                .append(sf.getPrice())
                                .append(")");
                        if (i != n - 1) {
                            sb.append("\n");
                        }
                        //sb.append("\n");
                    }
                    valuecell = sb.toString();
                    cell.setCellValue(valuecell);
                    cell.setCellStyle(defaultStyle);

                    cell = row.createCell(2);

                    // Set price range
                    valuecell = sCl.getPriceRange();
                    cell.setCellValue(valuecell);
                    cell.setCellStyle(defaultStyle);

                }
                //Saving table to File

                //File rezFile = new File("Smartphones_LR7.xlsx");

                Scanner scan = new Scanner(System.in);
                System.out.print("Enter path to directory to save the file: ");
                String strPathToDir = scan.nextLine();

                while (!exists(Path.of(strPathToDir))) {
                    System.out.print("Wrong path!!! Enter an existing path: ");
                    strPathToDir = scan.nextLine();
                }
                System.out.println();
                System.out.print("Enter the name of file: ");
                String filename = scan.nextLine();
                while (filename.equals("")) {
                    System.out.print("Name of file can't be empty!!! Enter not empty filename: ");
                    filename = scan.nextLine();
                }
                String fullStrPathToFile = strPathToDir + "\\" + filename + ".xlsx";
                Path fullPathToFile = Path.of(fullStrPathToFile);

                // If file already exists
                if (exists(fullPathToFile) && isRegularFile(fullPathToFile)) {
                    System.out.println("\nSuch a file already exists!!!\nOptions for action:\nReplace it - enter 1\nCancel save - enter 2");
                    System.out.print("Your choose: ");
                    String choose = scan.nextLine();
                    while (!choose.equals("1") && !choose.equals("2")) {
                        System.out.print("Wrong symbol! Enter 1 or 2: ");
                        choose = scan.nextLine();
                    }
                    if (choose.equals("1")) {
                        Files.deleteIfExists(fullPathToFile);
                        File rezFile = new File(fullStrPathToFile);
                        try (FileOutputStream outputStream = new FileOutputStream(rezFile)) {
                            workbook.write(outputStream);
                            System.out.println("\nThe file was successfully replaced and saved!!!");
                        } catch (Exception e) {
                            System.err.println("Error saving data in file");
                        }
                    } else {
                        System.out.println("\nSaving canceled.");
                    }

                } else {
                    File rezFile = new File(fullStrPathToFile);
                    try (FileOutputStream outputStream = new FileOutputStream(rezFile)) {
                        workbook.write(outputStream);
                        System.out.println("\nThe file was successfully saved!!!");
                    } catch (Exception e) {
                        System.err.println("Error saving data in file");
                    }
                }
            } catch (Exception e) {
                System.err.println("Error working with workbook");
            }
        } catch (Exception e) {
            System.err.println("Error when open template");
        }
    }

}
