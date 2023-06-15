package codes.maxi.searchables.api.context;

import codes.maxi.searchables.api.SearchableType;

import java.util.function.Predicate;

interface SearchPredicate<T> {
    
    /**
     * Create a predicate for the given {@link SearchableType<T>}
     *
     * @param type The type to search for
     *
     * @return A predicate that can be used to filter elements that the {@link SearchableType<T>} deals with.
     */
    Predicate<T> predicateFrom(final SearchableType<T> type);
    
}