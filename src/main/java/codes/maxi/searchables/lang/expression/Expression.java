package codes.maxi.searchables.lang.expression;

import codes.maxi.searchables.lang.expression.visitor.ContextAwareVisitor;
import codes.maxi.searchables.lang.expression.visitor.Visitor;

public abstract class Expression {
    
    public abstract <R> R accept(final Visitor<R> visitor);
    
    public abstract <R, C> R accept(final ContextAwareVisitor<R, C> visitor, final C context);
}
