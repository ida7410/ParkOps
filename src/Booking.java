public record Booking(String id, String spaceId, int durationHours, boolean requiresAccessible, int version) {
    public Booking {
        DomainRules.requireIdentifier(id);
        DomainRules.requireIdentifier(spaceId);
        DomainRules.requireDuration(durationHours);
    }

    @Override
    public String toString() {
        return String.format("Booking{id='%s', spaceId='%s', durationHours=%d, requiresAccessible=%b, version=%d}",
                id, spaceId, durationHours, requiresAccessible, version);
    }
}
