// 檔案路徑: c:\Users\m306\Desktop\114_1_Java\114-10-31\CompositionDemo\src\Date.java
public class Date {
    private final int month; // 月份 1-12
    private final int day; // 日期 1-31（視月份而定）
    private final int year; // 年份（任何年）

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 建構子：檢查給定年份下月份與日期是否正確
    public Date(int month, int day, int year) {
        // 檢查月份是否在範圍內
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "月份 (" + month + ") 必須為 1-12");
        }

        // 檢查日期是否在該月份的範圍內
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("日期 (" + day +
                    ") 超出指定月份和年份的範圍");
        }

        // 若為2月29日，檢查是否為閏年
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("日期 (" + day +
                    ") 超出指定月份和年份的範圍");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        //System.out.printf("Date 物件建構完成，日期為 %s%n", this);
    }

    // 回傳字串格式為 月/日/年
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}