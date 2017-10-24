package com.xingyun.smartsite.utils;

import org.apache.poi.ss.usermodel.Cell;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class CommonUtil {
	public static String getSaveLocation(String userId) {

		StringBuilder sb = new StringBuilder();
		sb.append(userId).append("/").append(getTodayYear()).append("/")
				.append(getTodayMonth()).append("/").append(getTodayDay())
				.append("/");

		return sb.toString();
	}

	public static String getFileType(String ext) {
		String fileType = "TXT";
		switch (ext) {
		case "DOC":
		case "EXLS":
		case "PPT":
			fileType = "TXT";
			break;
		case "JPG":
		case "GIF":
		case "PNG":
			fileType = "IMG";
			break;
		case "MP3":
		case "OGG":
			fileType = "AUD";
			break;
		case "MP4":
		case "WEBM":
		case "AVI":
			fileType = "VED";
			break;
		case "ZIP":
		case "EPUB":
			fileType = "EPUB";
			break;
		default:
			break;
		}
		return fileType;
	}

	public static String getTodayYear() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(dt);
	}

	public static String getTodayMonth() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(dt);
	}

	public static String getTodayDay() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(dt);
	}

	public static String getRequestHost(HttpServletRequest request) {
		return new StringBuilder("http://").append(request.getServerName())
				.append(":").append(request.getServerPort()).toString();
	}

	public static boolean isWindows() {
		String OS = System.getProperty("os.name");
		return OS.startsWith("Windows");
	}

	public static String getValue(Cell cell) {
		if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf((int) cell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(cell.getStringCellValue());
		}
	}

	public static void deleFile(String path) {
		// 把服务器上的excel删除
		File file = new File(path);
		// 判断目录或文件是否存在
		if (file.exists()) {
			if (file.isFile()) { // 为文件时调用删除文件方法
				file.delete();
			}
		}
	}

	/*
	 * 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	public static void main(String[] args) {
		for (int i = 1; i < 256; i++) {
			System.out.println(i + " = " + getItem(i));
		}
		// System.out.println(getItem(210));

	}

	public static String getItem(int i) {
		String str = Integer.toBinaryString(i);
		// System.out.println("HGFEDCBA");
		// System.out.println(str);
		String rs = "";
		String[] arr = { "A", "B", "C", "D", "E", "F", "G", "H" };
		char[] strChar = str.toCharArray();
		int size = strChar.length;
		for (int j = 0; j < size; j++) {
			// System.out.print(strChar[j]);
			if ('1' == strChar[size - 1 - j]) {

				rs += arr[j];
			}
		}
		// if()
		return rs;
	}

	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(new Date());
	}

}