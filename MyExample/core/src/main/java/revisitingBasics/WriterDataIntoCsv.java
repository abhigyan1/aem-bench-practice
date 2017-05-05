package revisitingBasics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class WriterDataIntoCsv {
public static void main (String[] argsv) throws HPSFException
{

    ArrayList data = new ArrayList();
    ArrayList headers = new ArrayList();

    File file123 = new File("D:\\real\\car.xls");

    headers.add("Model");
    headers.add("Year");
    headers.add("Number");
    Simple simple = new Simple();
    List<Car> lcar =simple.operations();
    for (int i = 0; i < lcar.size(); i++) {
        ArrayList cells = new ArrayList();
        cells.add(lcar.get(i).getModel());
        cells.add(lcar.get(i).getYear());
        cells.add(lcar.get(i).getNumber());
        data.add(cells);
    }

    exportToExcel("Test", headers, data, file123);
}

public static void exportToExcel(String sheetName, ArrayList headers,
        ArrayList data, File outputFile) throws HPSFException {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet(sheetName);

    int rowIdx = 0;
    short cellIdx = 0;

    // Header
    HSSFRow hssfHeader = sheet.createRow(rowIdx);
    HSSFCellStyle cellStyle = wb.createCellStyle();
    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    for (Iterator cells = headers.iterator(); cells.hasNext();) {
        HSSFCell hssfCell = hssfHeader.createCell(cellIdx++);
        hssfCell.setCellStyle(cellStyle);
        hssfCell.setCellValue((String) cells.next());
    }
    // Data
    rowIdx = 1;
    for (Iterator rows = data.iterator(); rows.hasNext();) {
        ArrayList row = (ArrayList) rows.next();
        HSSFRow hssfRow = sheet.createRow(rowIdx++);
        cellIdx = 0;
        for (Iterator cells = row.iterator(); cells.hasNext();) {
            HSSFCell hssfCell = hssfRow.createCell(cellIdx++);
            hssfCell.setCellValue((String) cells.next());
        }
    }

    wb.setSheetName(0, sheetName);
    try {
        FileOutputStream outs = new FileOutputStream(outputFile);
        wb.write(outs);
        outs.close();
    } catch (IOException e) {
        throw new HPSFException(e.getMessage());
    }

}
}	


