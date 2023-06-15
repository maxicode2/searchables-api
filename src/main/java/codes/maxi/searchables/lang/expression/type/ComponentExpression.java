package codes.maxi.searchables.lang.expression.type;

import codes.maxi.searchables.lang.expression.visitor.ContextAwareVisitor;
import codes.maxi.searchables.lang.expression.visitor.Visitor;
import codes.maxi.searchables.lang.Token;
import codes.maxi.searchables.lang.expression.Expression;

public class ComponentExpression extends Expression {
    
    private final Expression left;
    private final Token operator;
    private final Expression right;
    
    public ComponentExpression(final Expression left, final Token operator, final Expression right) {
        
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    
    @Override
    public <R> R accept(final Visitor<R> visitor) {
        
        return visitor.visitComponent(this);
    }
    
    @Override
    public <R, C> R accept(final ContextAwareVisitor<R, C> visitor, final C context) {
        
        return visitor.visitComponent(this, context);
    }
    
    public Expression left() {
        
        return left;
    }
    
    public Token operator() {
        
        return operator;
    }
    
    public Expression right() {
        
        return right;
    }
    
    @Override
    public String toString() {
        
        return "[%s%s%s]".formatted(left, operator.literal(), right);
    }
    
}
