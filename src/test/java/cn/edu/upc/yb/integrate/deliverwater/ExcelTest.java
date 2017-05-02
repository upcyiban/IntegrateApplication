package cn.edu.upc.yb.integrate.deliverwater;


import cn.edu.upc.yb.integrate.IntegrateApplication;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Jaxlying on 2016/10/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrateApplication.class)
@WebAppConfiguration
public class ExcelTest {

    @Test
    public void excelTest() throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();

        // 创建Excel的工作sheet,对应到一个excel文档的tab
        HSSFSheet sheet = wb.createSheet("sheet1");

        // 设置excel每列宽度
        sheet.setColumnWidth((short)0, (short)4000);
        sheet.setColumnWidth((short)1, (short)9000);


        // 创建字体样式
        HSSFFont font = wb.createFont();
        font.setFontName("Verdana");
        font.setBoldweight((short) 100);
        font.setFontHeight((short) 300);
        font.setColor(HSSFColor.BLUE.index);

        // 创建单元格样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        // 设置边框
        style.setBottomBorderColor(HSSFColor.RED.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        style.setFont(font);// 设置字体

        // 创建Excel的sheet的一行
        HSSFRow row = sheet.createRow(0);
        row.setHeight((short) 500);// 设定行的高度

        // 创建一个Excel的单元格
        HSSFCell cell = row.createCell((short)0);

        // 合并单元格(startRow，endRow，startColumn，endColumn)
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));

        // 给Excel的单元格设置样式和赋值
        cell.setCellStyle(style);

        cell.setCellValue("hello world");

        // 设置单元格内容格式
        HSSFCellStyle style1 = wb.createCellStyle();
        style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));

        style1.setWrapText(true);// 自动换行

        row = sheet.createRow(1);

        // 设置单元格的样式格式

        cell = row.createCell((short) 0);
        cell.setCellStyle(style1);
        cell.setCellValue(new Date());

        File file = new File("d:\\workbook.xls");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream os = new FileOutputStream(file);
        wb.write(os);
        os.close();
    }
}
