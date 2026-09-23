public class ProposalService {
    private static int proposalCount = 0;

    public ProposalView propose(String targetId, Booking booking, int policyVersion) {
        // Find target space
        Space targetSpace = StudentApplication.spaces.stream()
                .filter(s -> s.id().equals(targetId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Target not found: " + targetId));

        // Check eligibility (v1: open & not occupied)
        if (policyVersion == 1) {
            String currentSpaceId = booking.spaceId();
            if (!targetSpace.isEligible(currentSpaceId)) {
                throw new IllegalArgumentException("Target not eligible: " + targetId);
            }
        }
        else {
            // Future policy versions can have different eligibility checks
            throw new UnsupportedOperationException("Policy version not supported: " + policyVersion);
        }

        String proposalId = "P" + (++proposalCount);

        return new ProposalView(
                proposalId,
                booking.id(),
                targetId,
                booking.version(),
                policyVersion,
                "PENDING"
        );
    }

}
