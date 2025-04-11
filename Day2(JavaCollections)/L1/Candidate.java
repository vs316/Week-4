package JavaCollections.MapInterface;

public class Candidate implements Comparable<Candidate> {
    private String name;
    private String party;
    private int candidateId;

    public Candidate(int candidateId, String name, String party) {
        this.candidateId = candidateId;
        this.name = name;
        this.party = party;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public int getCandidateId() {
        return candidateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Candidate candidate = (Candidate) o;
        return candidateId == candidate.candidateId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(candidateId);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + candidateId +
                ", name='" + name + '\'' +
                ", party='" + party + '\'' +
                '}';
    }

    @Override
    public int compareTo(Candidate other) {
        return Integer.compare(this.candidateId, other.candidateId);
    }
}