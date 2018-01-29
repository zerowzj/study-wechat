import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MyTest {

    String src = "26803BDCD00D41CFA94BBD450E8E58F4" + "2018-01-2915:48:00";

    @Test
    public void test() {

        System.out.println(src.length());
        System.out.println("aagBND0010c5fafb97d60a169ef598666b8d0b0ca58bf8dbf1".length());
        System.out.println(DigestUtils.md5Hex(src));
        System.out.println(DigestUtils.sha1Hex(src));
        System.out.println(DigestUtils.sha256Hex(src));
    }
}
