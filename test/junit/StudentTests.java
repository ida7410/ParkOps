import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Add focused @org.junit.jupiter.api.Test methods here.
// Create fresh objects for each test and assert results AND unchanged state on rejection.
// The supplied wrapper is not a substitute for your own test design.
public class StudentTests {

    @Test
    void proposingCurrentSpaceIsRejected() {
        StudentApplication app = new StudentApplication();
        var before = app.bookingSnapshot();
        assertThrows(IllegalArgumentException.class, () -> app.propose("B1"));
        assertEquals(before, app.bookingSnapshot());
    }

    @Test
    void proposalIdsAreUnique() {
        StudentApplication app1 = new StudentApplication();
        StudentApplication app2 = new StudentApplication();

        ProposalView proposal1 = app1.propose("B12");
        ProposalView proposal2 = app1.propose("B12");
        ProposalView proposal3 = app2.propose("B12");
        assertNotEquals(proposal1.proposalId(), proposal2.proposalId());
        assertNotEquals(proposal1.proposalId(), proposal3.proposalId());
        assertNotEquals(proposal2.proposalId(), proposal3.proposalId());
    }
}
