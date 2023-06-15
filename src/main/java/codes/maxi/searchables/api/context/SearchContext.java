package codes.maxi.searchables.api.context;

import codes.maxi.searchables.api.SearchableType;

import java.util.*;
import java.util.function.Predicate;

/**
 * Holds {@link SearchPredicate<T>} to be reduced to a single {@link Predicate<T>} for use in filtering.
 */
public final class SearchContext<T> {
    
    private final List<SearchPredicate<T>> predicates;
    
    public SearchContext() {
        
        this.predicates = new ArrayList<>();
    }
    
    public Predicate<T> createPredicate(final SearchableType<T> type) {
        
        return predicates.stream()
                .map(tSearchPredicate -> tSearchPredicate.predicateFrom(type))
                .reduce(t -> true, Predicate::and);
    }
    
    public void add(final SearchPredicate<T> literal) {
        
        this.predicates.add(literal);
    }
    
}