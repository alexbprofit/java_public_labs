package validator;

import ModelBook.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorDateValidator implements ConstraintValidator<Book, Integer> {

    private boolean ignoreCase;
    public void initialize(AuthorDate constraint) {
        ignoreCase = constraint.ignoreCase();
    }
    private boolean equalsDate(String value1, String value2) {
        return ignoreCase ? value1.equalsIgnoreCase(value2) : value1.equals(value2);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value > 1900 && value < 2020;
    }
}
