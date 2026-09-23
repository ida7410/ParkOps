public record Space(String id, boolean open, boolean occupied, boolean accessible) {
    public boolean isEligible(String currentSpaceId) {
        return open && !occupied && !id.equals(currentSpaceId);
    }

    @Override
    public String toString() {
        return String.format("Space{id='%s', open=%b, occupied=%b, accessible=%b}",
                id, open, occupied, accessible);
    }
}