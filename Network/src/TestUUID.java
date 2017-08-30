import java.util.UUID;

/**
 * Created by Anakinliu on 2017/3/29.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class TestUUID {
    public static void main(String[] args) {
        UUID uuid = new UUID(0x0000fa00 , 0x1001111f );

        System.out.println("A UUID represents a 128-bit value.");
        System.out.println(Long.toHexString(uuid.getLeastSignificantBits()));
        System.out.println(uuid.toString());
        System.out.println(uuid.version());
    }
}
