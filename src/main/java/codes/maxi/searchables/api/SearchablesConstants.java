package codes.maxi.searchables.api;

import codes.maxi.searchables.Util;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;
import java.util.function.Predicate;

public class SearchablesConstants {
    public static final String STRING_CHARACTERS = "'\"`";
    
    
    // A user can't search for a term that contains at-least one of each string character,
    // as it will be impossible to tokenize as the engine doesn't have escaped quotes (yet), so lets filter them out.
    public static final Predicate<String> VALID_SUGGESTION = s -> {
        int quoteCount = 0;
        for(int i = 0; i < SearchablesConstants.STRING_CHARACTERS.length(); i++) {
            if(StringUtils.contains(s, SearchablesConstants.STRING_CHARACTERS.charAt(i))) {
                quoteCount++;
            }
        }
        return quoteCount < 3;
    };
    
    // If a term contains a string character or a space, we should quote it for searchability.
    public static final Function<String, String> QUOTE = Util.memoize(s -> {
        if(StringUtils.containsNone(s, SearchablesConstants.STRING_CHARACTERS + " ")) {
            return s;
        }
        char quoteChar = '"';
        while(StringUtils.contains(s, quoteChar)) {
            quoteChar = switch(quoteChar) {
                case '"' -> '\'';
                case '\'' -> '`';
                default ->
                        throw new IllegalStateException("Unable to nicely wrap {" + s + "}! Make sure to filter Strings through 'SearchableComponent#VALID_SUGGESTION'!");
            };
        }
        return StringUtils.wrap(s, quoteChar);
    });
}
