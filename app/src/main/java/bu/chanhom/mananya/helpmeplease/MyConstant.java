package bu.chanhom.mananya.helpmeplease;

/**
 * Created by masterUNG on 12/7/2016 AD.
 */

public class MyConstant {

    private String titleHaveSpaceString, messageHaveSpaceString,
            titleRangString, messageRangString,
            titleSoundString, messageSoundString,
            titleLocateString, messageLocateString;
    private int[] avataInts = new int[]{R.drawable.bird48, R.drawable.doremon48,
            R.drawable.kon48, R.drawable.nobita48, R.drawable.rat48};

    public String getTitleLocateString() {
        titleLocateString = "ปลายทางที่ต้องการไป";
        return titleLocateString;
    }


    public String getMessageLocateString() {
        messageLocateString = "กรุณาระบุปลายทาง";
        return messageLocateString;
    }

    public String getTitleSoundString() {
        titleSoundString = "เสียงแจ้งเตือน";
        return titleSoundString;
    }

    public String getMessageSoundString() {
        messageSoundString = "กรุณาเลือกเสียงแจ้งเตือน";
        return messageSoundString;
    }

    public String getTitleRangString() {
        titleRangString = "ระยะทาง";
        return titleRangString;
    }

    public String getMessageRangString() {
        messageRangString = "กรุณาเลือกระยะทาง";
        return messageRangString;
    }

    public int[] getAvataInts() {
        return avataInts;
    }

    public String getTitleHaveSpaceString() {
        titleHaveSpaceString = "กรอกข้อมูลไม่ครบ";
        return titleHaveSpaceString;
    }

    public String getMessageHaveSpaceString() {
        messageHaveSpaceString = "กรุณากรอกให้ครบถ้วน";
        return messageHaveSpaceString;
    }
}   // Main Class
