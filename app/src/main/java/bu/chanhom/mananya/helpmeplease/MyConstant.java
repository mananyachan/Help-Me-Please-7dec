package bu.chanhom.mananya.helpmeplease;

/**
 * Created by masterUNG on 12/7/2016 AD.
 */

public class MyConstant {

    private String titleHaveSpaceString, messageHaveSpaceString;
    private int[] avataInts = new int[]{R.drawable.bird48, R.drawable.doremon48,
            R.drawable.kon48, R.drawable.nobita48, R.drawable.rat48};

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
