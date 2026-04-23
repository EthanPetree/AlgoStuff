package edu.neumont.csc250.isomorph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphGeneratorTest {

    // ============================================================
    //  Sample word lists
    //  Use these as inputs to your analysis methods.
    // ============================================================

    // Input 1 — smaller set, good for getting started
    private static final String[] Input1 = {
            "aaa", "fear", "mates", "gag", "egg", "add", "foo", "sap",
            "yay", "tot", "look", "meet", "took", "seer", "seep",
            "ate", "bar", "eat", "fit"
    };

    // Input 2 — larger set, includes 10-character words and trickier patterns
    private static final String[] Input2 = {
            "aaa", "fear", "mates", "gag", "egg", "add", "foo", "sap",
            "yay", "tot", "look", "meet", "took", "seer", "seep",
            "ate", "bar", "eat", "fit",
            "aaabbbzzz", "bbbaaazzz", "abzzbabaz", "bazzababz",
            "warrior", "aedor", "eiruw",
            "aa", "bb",
            "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
            "bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
            "dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca"
    };

    // ============================================================
    //  Example test — read this first!
    //
    //  This shows you the basic JUnit structure and how to call
    //  your methods. The actual method calls are commented out
    //  because your class/method names may differ — swap them in.
    // ============================================================

    @Test
    public void Example_GetExactPattern_Egg_Returns_0_1_1() {
        // Arrange — the word we want to test
        String word = "egg";

        // Act — call YOUR method here.
        // The name will depend on what you called it in your solution.
        // Something like:
        //
        //   String pattern = IsomorphGenerator.GetExactPattern(word);
        //
        String pattern = IsomorphGenerator.GetExactPattern(word);

        // Assert — verify the result is what you expect.
        // "egg" has two unique characters: e (id 0), g (id 1).
        // g repeats, so its id repeats → pattern is "0 1 1".
        assertEquals("0 1 1", pattern);
    }

    // ============================================================
    //  Exact pattern tests
    //
    //  Hint: the exact pattern assigns an integer ID to each
    //  character in order of first appearance (starting at 0).
    //  Repeated characters reuse their original ID.
    //
    //  Known exact patterns from the spec:
    //    egg        →  0 1 1
    //    roar       →  0 1 2 0
    //    warrior    →  0 1 2 2 3 4 2
    //    suspicious →  0 1 0 2 3 4 3 5 1 0
    //
    //  Things worth testing:
    //    - A word where every character is unique
    //    - A word where every character is the same
    //    - Two different words that share the same exact pattern
    //    - Case sensitivity (is "Gag" the same as "gag"?)
    // ============================================================

    @Test
    public void GetExactPattern_Roar_Returns_0_1_2_0() {
        // Arrange -
        String word = "roar";
        // Act -
        String pattern = IsomorphGenerator.GetExactPattern(word);
        // Assert -
        assertEquals("0 1 2 0", pattern);
    }

    @Test
    public void GetExactPattern_TwoWords_SamePattern() {
        // Hint: "egg", "add", and "foo" should all return the same exact pattern.
        // Arrange -
        String word1 = "add";
        String word2 = "foo";

        // Act -
        String word1Pattern = IsomorphGenerator.GetExactPattern(word1);
        String word2Pattern = IsomorphGenerator.GetExactPattern(word2);

        // Assert -
        assertEquals(word1Pattern, word2Pattern);
    }

    @Test
    public void GetExactPattern_IsCaseSensitive() {
        // Hint: "gag" and "Gag" should NOT produce the same pattern.
        // In "Gag", all three characters (G, a, g) are distinct.
        // Arrange -
        String word1 = "Gag";
        String word2 = "gag";

        // Act -
        String word1Pattern = IsomorphGenerator.GetExactPattern(word1);
        String word2Pattern = IsomorphGenerator.GetExactPattern(word2);

        // Assert -
        assertNotEquals(word1Pattern, word2Pattern);
    }

    // ============================================================
    //  Loose pattern tests
    //
    //  Hint: the loose pattern is just the character frequency
    //  counts sorted from smallest to largest.
    //
    //  Known loose patterns from the spec:
    //    egg        →  1 2
    //    roar       →  1 1 2
    //    warrior    →  1 1 1 1 3
    //    suspicious →  1 1 1 2 2 3
    //
    //  Things worth testing:
    //    - A word where every character appears once
    //    - A word where all characters are the same
    //    - Two words with different exact patterns but the same loose pattern
    //      (e.g. "gag" and "egg" are both "1 2")
    //    - Case sensitivity
    // ============================================================

    @Test
    public void GetLoosePattern_Egg_Returns_1_2() {
        // Arrange -
        String word = "egg";

        // Act -
        String wordPattern = IsomorphGenerator.GetLoosePattern(word);

        // Assert -
        assertEquals("1 2", wordPattern);
    }

    @Test
    public void GetLoosePattern_GagAndEgg_ShareSameLoosePattern() {
        // Hint: even though "gag" and "egg" have different exact patterns,
        // they both have one character appearing once and one appearing twice.
        // Arrange -
        String word1 = "gag";
        String word2 = "egg";

        // Act -
        String word1Pattern = IsomorphGenerator.GetLoosePattern(word1);
        String word2Pattern = IsomorphGenerator.GetLoosePattern(word2);

        // Assert -
        assertEquals(word1Pattern, word2Pattern);
    }

    @Test
    public void GetLoosePattern_IsCaseSensitive() {
        // Arrange -
        String word1 = "Gag";
        String word2 = "gag";

        // Act -
        String word1Pattern = IsomorphGenerator.GetLoosePattern(word1);
        String word2Pattern = IsomorphGenerator.GetLoosePattern(word2);

        // Assert -
        assertNotEquals(word1Pattern, word2Pattern);
    }

    // ============================================================
    //  FindExactIsomorphs and FindLooseIsomorphs tests
    //
    //  The expected dictionaries below are provided for you.
    //  The key is the pattern string, the value is the sorted
    //  list of words that share that pattern.
    //
    //  Your job: call your method and assert that the result
    //  matches the expected map.
    // ============================================================

    // -- Input 1 expected: exact isomorphs --
    private static final HashMap<String, List<String>> ExpectedExactInput1 = new HashMap<>();
    static {
        ExpectedExactInput1.put("0 1 0", Arrays.asList("gag", "tot", "yay"));
        ExpectedExactInput1.put("0 1 1", Arrays.asList("add", "egg", "foo"));
        ExpectedExactInput1.put("0 1 1 2", Arrays.asList("look", "meet", "seep", "seer", "took"));
        ExpectedExactInput1.put("0 1 2", Arrays.asList("ate", "bar", "eat", "fit", "sap"));
    }

    // -- Input 1 expected: loose isomorphs --
    private static final HashMap<String, List<String>> ExpectedLooseInput1 = new HashMap<>();
    static {
        ExpectedLooseInput1.put("1 1 1", Arrays.asList("ate", "bar", "eat", "fit", "sap"));
        ExpectedLooseInput1.put("1 1 2", Arrays.asList("look", "meet", "seep", "seer", "took"));
        ExpectedLooseInput1.put("1 2", Arrays.asList("add", "egg", "foo", "gag", "tot", "yay"));
    }

    // -- Input 2 expected: exact isomorphs --
    private static final HashMap<String, List<String>> ExpectedExactInput2 = new HashMap<>();
    static {
        ExpectedExactInput2.put("0 0", Arrays.asList("aa", "bb"));
        ExpectedExactInput2.put("0 0 0 1 1 1 2 2 2", Arrays.asList("aaabbbzzz", "bbbaaazzz"));
        ExpectedExactInput2.put("0 1 0", Arrays.asList("gag", "tot", "yay"));
        ExpectedExactInput2.put("0 1 0 0 0 2 1 1 3 0", Arrays.asList("bdbbbaddcb", "cacccdaabc", "cdcccaddbc", "dcdddbccad"));
        ExpectedExactInput2.put("0 1 0 0 2 3 1 1 2 0", Arrays.asList("abaadcbbda", "dcddabccad"));
        ExpectedExactInput2.put("0 1 0 2 3 1 0 0 1 2", Arrays.asList("babcdabbac", "bcbadcbbca", "bdbcadbbdc", "cacdbaccad"));
        ExpectedExactInput2.put("0 1 1", Arrays.asList("add", "egg", "foo"));
        ExpectedExactInput2.put("0 1 1 2", Arrays.asList("look", "meet", "seep", "seer", "took"));
        ExpectedExactInput2.put("0 1 2", Arrays.asList("ate", "bar", "eat", "fit", "sap"));
        ExpectedExactInput2.put("0 1 2 2 1 0 1 0 2", Arrays.asList("abzzbabaz", "bazzababz"));
        ExpectedExactInput2.put("0 1 2 3 4", Arrays.asList("aedor", "eiruw", "mates"));
    }

    // -- Input 2 expected: loose isomorphs --
    private static final HashMap<String, List<String>> ExpectedLooseInput2 = new HashMap<>();
    static {
        ExpectedLooseInput2.put("1 1 1", Arrays.asList("ate", "bar", "eat", "fit", "sap"));
        ExpectedLooseInput2.put("1 1 1 1 1", Arrays.asList("aedor", "eiruw", "mates"));
        ExpectedLooseInput2.put("1 1 2", Arrays.asList("look", "meet", "seep", "seer", "took"));
        ExpectedLooseInput2.put("1 1 3 5", Arrays.asList("bdbbbaddcb", "cacccdaabc", "cdcccaddbc", "dcdddbccad"));
        ExpectedLooseInput2.put("1 2", Arrays.asList("add", "egg", "foo", "gag", "tot", "yay"));
        ExpectedLooseInput2.put("1 2 3 4", Arrays.asList("abaadcbbda", "babcdabbac", "bcbadcbbca", "bdbcadbbdc", "cacccbaadb", "cacdbaccad", "dcddabccad"));
        ExpectedLooseInput2.put("2", Arrays.asList("aa", "bb"));
        ExpectedLooseInput2.put("3 3 3", Arrays.asList("aaabbbzzz", "abzzbabaz", "bazzababz", "bbbaaazzz"));
    }

    @Test
    public void FindExactIsomorphs_Input1_MatchesExpected() {
        // Arrange
        String[] words = Input1;

        // Act
        HashMap<String, List<String>> actual = IsomorphGenerator.FindExactIsomorphs(words); // Replace with IsomorphGenerator.FindExactIsomorphs(words);

        // Assert — same number of groups
        assertEquals(ExpectedExactInput1.size(), actual != null ? actual.size() : 0, "Number of exact isomorph groups does not match.");

        // Assert — same keys and same word lists under each key
        for (Map.Entry<String, List<String>> expected : ExpectedExactInput1.entrySet()) {
            assertTrue(actual.containsKey(expected.getKey()), "Missing expected pattern key: '" + expected.getKey() + "'");

            List<String> expectedList = expected.getValue();
            List<String> actualList = actual.get(expected.getKey());

            assertTrue(actualList.containsAll(expectedList) && expectedList.containsAll(actualList),
                    "Word list mismatch for pattern '" + expected.getKey() + "'");
        }
    }

    @Test
    public void FindLooseIsomorphs_Input1_MatchesExpected() {
        // Arrange
        String[] words = Input1;

        // Act
        HashMap<String, List<String>> actual = IsomorphGenerator.FindLooseIsomorphs(words); // Replace with IsomorphGenerator.FindLooseIsomorphs(words);

        // Assert — same number of groups
        assertEquals(ExpectedLooseInput1.size(), actual != null ? actual.size() : 0, "Number of loose isomorph groups does not match.");

        // Assert — same keys and same word lists under each key
        for (Map.Entry<String, List<String>> expected : ExpectedLooseInput1.entrySet()) {
            assertTrue(actual.containsKey(expected.getKey()), "Missing expected pattern key: '" + expected.getKey() + "'");

            List<String> expectedList = expected.getValue();
            List<String> actualList = actual.get(expected.getKey());

            assertTrue(actualList.containsAll(expectedList) && expectedList.containsAll(actualList),
                    "Word list mismatch for pattern '" + expected.getKey() + "'");
        }
    }

    @Test
    public void FindExactIsomorphs_Input2_MatchesExpected() {
        // Arrange
        String[] words = Input2;

        // Act
        HashMap<String, List<String>> actual = IsomorphGenerator.FindExactIsomorphs(words); // Replace with IsomorphGenerator.FindExactIsomorphs(words);

        // Assert — same number of groups
        assertEquals(ExpectedExactInput2.size(), actual != null ? actual.size() : 0, "Number of exact isomorph groups does not match.");

        // Assert — same keys and same word lists under each key
        for (Map.Entry<String, List<String>> expected : ExpectedExactInput2.entrySet()) {
            assertTrue(actual.containsKey(expected.getKey()), "Missing expected pattern key: '" + expected.getKey() + "'");

            List<String> expectedList = expected.getValue();
            List<String> actualList = actual.get(expected.getKey());

            assertTrue(actualList.containsAll(expectedList) && expectedList.containsAll(actualList),
                    "Word list mismatch for pattern '" + expected.getKey() + "'");
        }
    }

    @Test
    public void FindLooseIsomorphs_Input2_MatchesExpected() {
        // Arrange
        String[] words = Input2;

        // Act
        HashMap<String, List<String>> actual = IsomorphGenerator.FindLooseIsomorphs(words); // Replace with IsomorphGenerator.FindLooseIsomorphs(words);

        // Assert — same number of groups
        assertEquals(ExpectedLooseInput2.size(), actual != null ? actual.size() : 0, "Number of loose isomorph groups does not match.");

        // Assert — same keys and same word lists under each key
        for (Map.Entry<String, List<String>> expected : ExpectedLooseInput2.entrySet()) {
            assertTrue(actual.containsKey(expected.getKey()), "Missing expected pattern key: '" + expected.getKey() + "'");

            List<String> expectedList = expected.getValue();
            List<String> actualList = actual.get(expected.getKey());

            assertTrue(actualList.containsAll(expectedList) && expectedList.containsAll(actualList),
                    "Word list mismatch for pattern '" + expected.getKey() + "'");
        }
    }
}