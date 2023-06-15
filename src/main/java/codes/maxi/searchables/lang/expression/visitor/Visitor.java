package codes.maxi.searchables.lang.expression.visitor;

import codes.maxi.searchables.lang.expression.type.ComponentExpression;
import codes.maxi.searchables.lang.expression.type.GroupingExpression;
import codes.maxi.searchables.lang.expression.type.LiteralExpression;
import codes.maxi.searchables.lang.expression.type.PairedExpression;

public interface Visitor<R> {
    
    R visitGrouping(GroupingExpression expr);
    
    R visitComponent(ComponentExpression expr);
    
    R visitLiteral(LiteralExpression expr);
    
    R visitPaired(PairedExpression expr);
    
    default R postVisit(R obj) {
        return obj;
    }
    
}