import java.util.*;

class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

}

public class HuffmanEncoding {
    public static Map<Character, String> buildHuffmanTree(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<HuffmanNode> priorityqueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));// lower
                                                                                                                        // value
                                                                                                                        // have
                                                                                                                        // higher
                                                                                                                        // priority

        for (char c : frequencies.keySet()) {
            priorityqueue.offer(new HuffmanNode(c, frequencies.get(c)));
        }

        while (priorityqueue.size() > 1) {
            HuffmanNode left = priorityqueue.poll();
            HuffmanNode right = priorityqueue.poll();

            HuffmanNode merged = new HuffmanNode('-', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;

            priorityqueue.offer(merged);
        }

        HuffmanNode root = priorityqueue.poll();
        Map<Character, String> huffmancodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmancodes);

        return huffmancodes;

    }

    private static void generateHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmancodes) {
        if (node == null) {
            return;
        }

        if (node.data != '-') {
            huffmancodes.put(node.data, code);
        }
        generateHuffmanCodes(node.left, code + "0", huffmancodes);
        generateHuffmanCodes(node.right, code + "1", huffmancodes);

    }

    public static void main(String[] args) {
        String input = "aabbbccdddd";
        Map<Character, String> huffmancodes = buildHuffmanTree(input);
        for (char c : huffmancodes.keySet()) {
            System.out.println(c + ": " + huffmancodes.get(c));
        }
    }
}