import java.io.UnsupportedEncodingException;

public class AnyDemo {

    static int unsigned2ByteToInt(byte[] bytes) {
        if (bytes == null || bytes.length < 2) {
            return 0;
        }
        return (((bytes[0] & 0xff) << 8) | ((bytes[1] & 0xff)));
    }
    static short unsigned2ByteToShort(byte[] bytes) {
        if (bytes == null || bytes.length < 2) {
            return 0;
        }
        return (short)(((bytes[0] & 0xff) << 8) | ((bytes[1] & 0xff) << 0));
    }

    static int[] bytes2IntArray(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        int[] result = new int[(bytes.length + 1) / 2];
        byte[] fshort = new byte[2];
        for (int i = 0; i * 2 < bytes.length; i++) {
            System.arraycopy(bytes, i * 2, fshort, 0, 2);
            result[i] = unsigned2ByteToInt(fshort);
        }
        return result;
    }
    static short[] bytes2ShortArray(byte[] bytes) {
        if(bytes==null) {
            return null;
        }
        short[] result = new short[(bytes.length + 1)/2];
        byte[] fshort = new byte[2];
        for(int i=0;i*2<bytes.length;i++) {
            System.arraycopy(bytes,i*2,fshort,0,2);
            result[i] = unsigned2ByteToShort(fshort);
        }
        return result;
    }

    static short[][] String2UTF_8_Encoding_uint16_Arrays(String[] strs) {
        short[][] result = new short[strs.length][];
        for(int i = 0; i < strs.length; i++ ) {
            String str = strs[i];
            System.out.printf("字符串:%s  length:%d\n", str, str.length());
            byte[] utf8Bytes = null;
            try {
                utf8Bytes = str.getBytes("UTF-16BE");
                for (byte value : utf8Bytes) {
                    System.out.printf("%02x ", value);
                }
                System.out.println();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println();
            result[i] = bytes2ShortArray(utf8Bytes);
        }
        return result;
    }

    static void printShortAsHex4d(short[][] data) {
        System.out.println("printShortAsHex4d start -------------");
        if(data==null) return;
        for(int i=0; i< data.length; i++) {
            short[] datas = data[i];
            for (short code : datas) {
                int intCode = (int)code;
                System.out.printf("(short -> int) %04x \n", intCode);
                System.out.printf("(int -> short) %04x \n",(short)intCode);
                System.out.printf("(short) %04x \n", code);
            }
            System.out.println();
        }

        System.out.println("printShortAsHex4 end--------------");
    }

    public static void main(String[] args) {
        String[] string = {"上公里用时","总距离","海拔","距离","公里"};
        short[][] coding = String2UTF_8_Encoding_uint16_Arrays(string);
        printShortAsHex4d(coding);
    }
}
