package codes.maxi.searchables;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

@TypeQualifierDefault(value={ElementType.METHOD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MethodsReturnNonnullByDefault {
}

