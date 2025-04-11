package JavaCollections.MapInterface;

public class VotingSystemDemo {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Create candidates
        Candidate candidate1 = new Candidate(1, "John Smith", "Party A");
        Candidate candidate2 = new Candidate(2, "Jane Doe", "Party B");
        Candidate candidate3 = new Candidate(3, "Bob Johnson", "Party C");

        // Simulate voting
        System.out.println("Simulating voting process...\n");

        // Cast some votes
        votingSystem.castVote("voter1", candidate1);
        votingSystem.castVote("voter2", candidate2);
        votingSystem.castVote("voter3", candidate1);
        votingSystem.castVote("voter4", candidate3);
        votingSystem.castVote("voter5", candidate2);
        votingSystem.castVote("voter6", candidate1);
        votingSystem.castVote("voter7", candidate1);

        // Try to vote again with same voter ID
        if (!votingSystem.castVote("voter1", candidate2)) {
            System.out.println("Voter 1 attempted to vote again - Rejected!");
        }

        // Display results in different formats
        System.out.println("\nVotes by order of casting:");
        votingSystem.getVotesByOrder()
                .forEach((candidate, votes) -> System.out.printf("%s: %d votes%n", candidate.getName(), votes));

        // Display final results (sorted by vote count)
        votingSystem.displayResults();

        // Display winner
        Candidate winner = votingSystem.getWinner();
        System.out.println("\nWinner: " + winner.getName() +
                " (" + winner.getParty() + ") with " +
                votingSystem.getVoteCount().get(winner) + " votes");
    }
}