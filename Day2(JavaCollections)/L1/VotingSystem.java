package JavaCollections.MapInterface;

import java.util.*;

public class VotingSystem {
    // HashMap for efficient vote counting
    private Map<Candidate, Integer> voteCount;

    // LinkedHashMap to maintain the order of votes as they come in
    private Map<Candidate, Integer> votesByOrder;

    // TreeMap to display results sorted by number of votes
    private TreeMap<Integer, List<Candidate>> sortedVotes;

    // Set to keep track of voters who have already voted
    private Set<String> votedVoters;

    public VotingSystem() {
        this.voteCount = new HashMap<>();
        this.votesByOrder = new LinkedHashMap<>();
        this.sortedVotes = new TreeMap<>(Collections.reverseOrder()); // Sort by descending order
        this.votedVoters = new HashSet<>();
    }

    public boolean castVote(String voterId, Candidate candidate) {
        // Check if voter has already voted
        if (votedVoters.contains(voterId)) {
            return false;
        }

        // Record the vote
        votedVoters.add(voterId);

        // Update vote count in HashMap
        int currentVotes = voteCount.getOrDefault(candidate, 0);
        voteCount.put(candidate, currentVotes + 1);

        // Update LinkedHashMap
        votesByOrder.put(candidate, currentVotes + 1);

        // Update TreeMap
        updateSortedVotes(candidate, currentVotes + 1);

        return true;
    }

    private void updateSortedVotes(Candidate candidate, int votes) {
        // Remove candidate from old vote count if exists
        for (List<Candidate> candidates : sortedVotes.values()) {
            candidates.remove(candidate);
        }

        // Add candidate to new vote count
        sortedVotes.computeIfAbsent(votes, k -> new ArrayList<>()).add(candidate);

        // Clean up empty lists
        sortedVotes.values().removeIf(List::isEmpty);
    }

    public Map<Candidate, Integer> getVoteCount() {
        return new HashMap<>(voteCount);
    }

    public Map<Candidate, Integer> getVotesByOrder() {
        return new LinkedHashMap<>(votesByOrder);
    }

    public List<Map.Entry<Integer, List<Candidate>>> getResultsSortedByVotes() {
        return new ArrayList<>(sortedVotes.entrySet());
    }

    public Candidate getWinner() {
        if (sortedVotes.isEmpty()) {
            return null;
        }
        List<Candidate> topCandidates = sortedVotes.firstEntry().getValue();
        return topCandidates.get(0); // Return first candidate with highest votes
    }

    public int getTotalVotes() {
        return votedVoters.size();
    }

    public boolean hasVoted(String voterId) {
        return votedVoters.contains(voterId);
    }

    public void displayResults() {
        System.out.println("\nElection Results:");
        System.out.println("Total Votes Cast: " + getTotalVotes());
        System.out.println("\nResults by Vote Count:");

        for (Map.Entry<Integer, List<Candidate>> entry : sortedVotes.entrySet()) {
            int votes = entry.getKey();
            List<Candidate> candidates = entry.getValue();
            for (Candidate candidate : candidates) {
                System.out.printf("%s (%s): %d votes%n",
                        candidate.getName(), candidate.getParty(), votes);
            }
        }
    }
}