package codes.maxi.searchables.api.context;

import codes.maxi.searchables.api.SearchableComponent;
import codes.maxi.searchables.api.SearchableType;

import java.util.function.Predicate;

record SearchLiteral<T>(String value) implements SearchPredicate<T> {
    
    @Override
    public Predicate<T> predicateFrom(final SearchableType<T> type) {
        
        return type.defaultComponent()
                .map(SearchableComponent::filter)
                .<Predicate<T>> map(filter -> t -> filter.test(t, value()))
                .orElse(t -> true);
    }
    
}