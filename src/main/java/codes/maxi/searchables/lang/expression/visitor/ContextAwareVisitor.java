package codes.maxi.searchables.lang.expression.visitor;

import codes.maxi.searchables.lang.expression.type.PairedExpression;
import codes.maxi.searchables.lang.expression.type.ComponentExpression;
import codes.maxi.searchables.lang.expression.type.GroupingExpression;
import codes.maxi.searchables.lang.expression.type.LiteralExpression;

public interface ContextAwareVisitor<R, C> {
    
    R visitGrouping(GroupingExpression expr, C context);
    
    R visitComponent(ComponentExpression expr, C context);
    
    R visitLiteral(LiteralExpression expr, C context);
    
    R visitPaired(PairedExpression expr, C context);
    
    default R postVisit(R obj, C context) {
        
        return obj;
    }
    
}