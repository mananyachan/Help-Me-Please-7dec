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
        titleLocateString = "title";
        return titleLocateString;
    }

    public String getMessageLocateString() {
        messageLocateString = "mesage";
        return messageLocateString;
    }

    public String getTitleSoundString() {
        titleSoundString = "title";
        return titleSoundString;
    }

    public String getMessageSoundString() {
        messageSoundString = "message";
        return messageSoundString;
    }

    public String getTitleRangString() {
        titleRangString = "titleRange";
        return titleRangString;
    }

    public String getMessageRangString() {
        messageRangString = "message";
        return messageRangString;
    }

    public int[] getAvataInts() {
        return avataInts;
    }

    public String getTitleHaveSpaceString() {
        titleHaveSpaceString = "มีช่องว่าง";
        return titleHaveSpaceString;
    }

    public String getMessageHaveSpaceString() {
        messageHaveSpaceString = "กรุณากรอกทุกช่องคะ";
        return messageHaveSpaceString;
    }
}   // Main Class
