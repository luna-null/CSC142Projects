package Proj04.lib;
/**
 * Required methods and enums for the LanguageManager class
 * @author      Bill Barry
 * @version     2023-06-24
 */public interface LanguageManagerInterface {

    /**
     * Returns the number of languages currently managed
     * @return      number of languages
     */
    public int getLanguageCount();

    /**
     * Returns the language at specified index in the list
     * @param index     position of the language
     * @return          language at that position
     */
    // public Language getLanguage(int index); TODO figure out why this exists

    /**
     * Across languages, finds and returns the length of the shortest keyword.  Ignores languages with no keywords.
     * @return      the length of the shortest keyword
     */
    public int findShortestKwdLength();

    /**
     * Across languages, finds and returns the length of the longest keyword.  Ignores languages with no keywords.
     * @return      the length of the longest keyword
     */
    public int findLongestKwdLength();

    /**
     * Across languages, find the language with the fewest keywords and returns its position.
     * Ignores languages with no keywords.  Returns -1 if there are no languages with keywords.
     * @return      the position of the language with the fewest keywords
     */
    public int findLangWithFewestKwds();

    /**
     * Across languages, find the language with the most keywords and returns its position.
     * Ignores languages with no keywords.  Returns -1 if there are no languages with keywords.
     * @return      the position of the language with the most keywords
     */
    public int findLangWithMostKwds();

    /**
     * Looks for the specified keyword across all languages and returns an array of the positions of those languages.
     * Does not use an ArrayList or other data structure in the process.
     * @param keyword       keyword to search for
     * @return              array of indexes of (only) the languages that contain that keyword, a "right-sized" array
     */
    public int[] findLangKwdMatches(String keyword);

    /**
     * Looks for languages of the specified type and returns an array of the positions of those languages.
     * Does not use an ArrayList or other data structure in the process.
     * @param type          the type of language to search for
     * @return              array of indexes of (only) the languages that match the specified type, a "right-sized" array
     */
    // public int[] findLangsOfType(Language.Type type); TODO - make a Language class I guess?

    /**
     * Sorts the languages alphabetically (case-sensitive).  Implements an Insertion Sort adapted from the
     *      code given in class (see slides on Sorting).
     */
    public void sortLangs();

}
