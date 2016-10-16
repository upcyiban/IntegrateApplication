package cn.edu.upc.yb.integrate.deliverwater.service;

import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Jaxlying on 2016/10/15.
 */
@Service
public class WriteExcelService {

    @Autowired
    private DeliverWaterDao deliverDao;

    public void writeExcel(Iterator<DeliverWater> deliverWaterIterator) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        sheet.setColumnWidth((short) 0, (short) 4000);
        sheet.setColumnWidth((short) 1, (short) 9000);
        HSSFFont font = wb.createFont();
        font.setFontName("Verdana");
        font.setBoldweight((short) 100);
        font.setFontHeight((short) 300);
        font.setColor(HSSFColor.BLACK.index);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(HSSFColor.WHITE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBottomBorderColor(HSSFColor.RED.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setFont(font);

        HSSFRow row = null;
        HSSFCell cell = null;

        short rowNum = 0;
        while (deliverWaterIterator.hasNext()) {
            short cellNum = -1;
            DeliverWater de = deliverWaterIterator.next();
            row = sheet.createRow(rowNum);
            row.setHeight((short) 500);

            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(de.getName());//名字

            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(de.getNum()); //数量

            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(de.getBlockNumber());//楼号

            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(de.getDormitory());//宿舍

            cell = row.createCell(++cellNum);
            cell.setCellStyle(style);
            cell.setCellValue(de.getPhone()); //电话

            //  de.setIsdeal(true);
            deliverDao.save(de);

            ++rowNum;

        }
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH)+1;//获取月份
        int day = cal.get(Calendar.DATE);//获取日
        File dir = new File("deliverwater");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File("deliverwater/" + year + "年" + month + "月" + day + "日" + ".xls");
        FileOutputStream os = new FileOutputStream(file);
        wb.write(os);
        os.close();
    }
}
