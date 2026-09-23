import java.util.List;
import java.util.Map;
/** Synthetic input data, not the assessed domain implementation. Values are immutable. */
public final class Fixture {
    private Fixture() {}
    public static Booking booking() {
        return new Booking("B1", "A17", 3, true, 0);
    }
    public static List<Space> spaces() {
        return List.of(new Space("A17",false,true,false),
                        new Space("B12",true,false,false),
                        new Space("C03",true,false,true),
                        new Space("D09",true,true,true));
    }
    private static Space space(String id,boolean open,boolean occupied,boolean accessible) {
        return new Space(id, open, occupied, accessible);
    }
    public static String proposalRequest(String target) {
        return MiniJson.stringify(Map.of("tool","PROPOSE_REASSIGNMENT","bookingId","B1","targetId",target));
    }
    public static ReplayProvider replay() {
        return new ReplayProvider(List.of(
            "{\"tool\":\"READ_BOOKING\",\"bookingId\":\"B1\",\"targetId\":\"\"}",
            "{\"tool\":\"LIST_ALTERNATIVES\",\"bookingId\":\"B1\",\"targetId\":\"\"}",
            proposalRequest("B12")));
    }
}
