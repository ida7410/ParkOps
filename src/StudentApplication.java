import java.util.List;

public final class StudentApplication {
    // Raw fixture storage only. Replace or wrap it with your protected domain objects.
    public static final Booking booking = Fixture.booking();
    public static final List<Space> spaces = Fixture.spaces();

    public Booking bookingSnapshot() { return booking; }

    public ProposalView propose(String targetId) {
        // TODO D1: validate policy, check eligibility, create proposal, retain history.
        // Add separate operator approve/reject/execute operations and tick(time).
        ProposalService service = new ProposalService();
        return service.propose(targetId, booking, 1);
    }
    public String run(ModelProvider provider,int limit) {
        // TODO D2: validate protocol, dispatch tools, retain observation history,
        // bound invocations and stop at pending approval. No automatic commit.
        // Add separate operator approve/reject/execute operations and tick(time).
        throw new UnsupportedOperationException("D2 model/tool coordination");
    }
    // TODO D3: evolve policy, preserve regressions, refactor and specify contracts.
}
