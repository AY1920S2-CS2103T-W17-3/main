package seedu.address.model.listmanagers.fixedexpense;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.text.Element;

import org.junit.jupiter.api.Test;

import seedu.address.model.util.uniquelist.UniqueList;
import seedu.address.model.util.uniquelist.UniqueListElement;
import seedu.address.model.util.uniquelist.exceptions.DuplicateElementException;
import seedu.address.model.util.uniquelist.exceptions.ElementNotFoundException;


class UniqueFixedExpenseListTest {

    // Temporary fields that will be replaced by FixedExpenses made using a FixedExpenseBuilder.
    public static final FixedExpense FIXED_ACCOMMODATION_EXPENSE =
            new FixedExpense(new Amount("500.00"), new Description("Hotel"),
                    new Category("Accommodation"));

    public static final FixedExpense FIXED_ACTIVITY_EXPENSE =
            new FixedExpense(new Amount("100"), new Description("Disneyland"),
                    new Category("Activity"));

    private static final FixedExpense FIXED_TRANSPORTATION_EXPENSE =
            new FixedExpense(new Amount("1000"), new Description("Airplane"),
                    new Category("Transportation"));

    private final UniqueList<FixedExpense> uniqueFixedExpenseList = new UniqueList<FixedExpense>();


    @Test
    public void containsNullFixedExpenseThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList.contains(null));
    }

    @Test
    public void containsExpenseNotInListReturnsFalse() {
        assertFalse(uniqueFixedExpenseList.contains(FIXED_ACCOMMODATION_EXPENSE));
    }

    @Test
    public void containsExpenseInListReturnsTrue() {
        uniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        assertTrue(uniqueFixedExpenseList.contains(FIXED_ACCOMMODATION_EXPENSE));
    }

    @Test
    public void containsExpenseWithSameIdentifyFieldsInListReturnsTrue() {
        //Slightly different from UniquePersonListTest, due to different
        //contains convention used for AB3 and for ours.
        uniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        FixedExpense editedExpense = new FixedExpense(new Amount("500.00"),
                new Description("hotel"), new Category("Accommodation"));
        assertFalse(uniqueFixedExpenseList.contains(editedExpense));
    }

    @Test
    public void addNullFixedExpenseThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList.add(null));
    }

    @Test
    public void addDuplicateFixedExpenseThrowsDuplicateFixedExpenseException() {
        uniqueFixedExpenseList.add(FIXED_ACTIVITY_EXPENSE);
        assertThrows(DuplicateElementException.class, () -> uniqueFixedExpenseList.add(FIXED_ACTIVITY_EXPENSE));
    }

    @Test
    public void setFixedExpenseNullTargetFixedExpenseThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList.setElement(null,
                FIXED_ACTIVITY_EXPENSE));
    }

    @Test
    public void setFixedExpenseNullFixedExpenseThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList
                .setElement(FIXED_ACCOMMODATION_EXPENSE,
                null));
    }

    @Test
    public void setFixedExpenseTargetFixedExpenseNotInListThrowsFixedExpenseNotFoundException() {
        assertThrows(ElementNotFoundException.class, () -> uniqueFixedExpenseList.setElement(
                FIXED_ACCOMMODATION_EXPENSE, FIXED_ACCOMMODATION_EXPENSE));
    }

    @Test
    public void setFixedExpenseEditedFixedExpenseIsSameFixedExpenseSuccess() {
        uniqueFixedExpenseList.add(FIXED_ACTIVITY_EXPENSE);
        uniqueFixedExpenseList.setElement(FIXED_ACTIVITY_EXPENSE, FIXED_ACTIVITY_EXPENSE);
        UniqueList<FixedExpense> expectedFixedExpenseList = new UniqueList<>();
        expectedFixedExpenseList.add(FIXED_ACTIVITY_EXPENSE);
        assertEquals(expectedFixedExpenseList, uniqueFixedExpenseList);
    }

    @Test
    public void setFixedExpenseHasSameIdentitySuccess() {
        uniqueFixedExpenseList.add(FIXED_ACTIVITY_EXPENSE);
        FixedExpense editedExpense = new FixedExpense(new Amount("100"), new Description("Disneyland"),
                new Category("Activity"));
        uniqueFixedExpenseList.setElement(FIXED_ACTIVITY_EXPENSE, editedExpense);
        UniqueList<FixedExpense> expectedUniqueFixedExpenseList = new UniqueList<>();
        expectedUniqueFixedExpenseList.add(editedExpense);
        assertEquals(expectedUniqueFixedExpenseList, uniqueFixedExpenseList);
    }

    @Test
    public void setFixedExpenseEditedFixedExpenseHasDifferentFixedExpenseSuccess() {
        uniqueFixedExpenseList.add(FIXED_ACTIVITY_EXPENSE);
        uniqueFixedExpenseList.setElement(FIXED_ACTIVITY_EXPENSE, FIXED_ACCOMMODATION_EXPENSE);
        UniqueList<FixedExpense> expectedFixedExpenseList = new UniqueList<>();
        expectedFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        assertEquals(expectedFixedExpenseList, uniqueFixedExpenseList);
    }

    @Test
    public void setFixedExpenseEditedFixedExpenseHasNonUniqueIdentityThrowsDuplicateFixedExpenseException() {
        uniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        uniqueFixedExpenseList.add(FIXED_TRANSPORTATION_EXPENSE);
        assertThrows(DuplicateElementException.class, () -> uniqueFixedExpenseList.setElement
                (FIXED_ACCOMMODATION_EXPENSE, FIXED_TRANSPORTATION_EXPENSE));
    }

    @Test
    public void removeNullFixedExpenseThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList.remove(null));
    }

    @Test
    public void removeFixedExpenseDoesNotExistThrowsFixedExpenseNotFoundException() {
        assertThrows(ElementNotFoundException.class, () -> uniqueFixedExpenseList
                .remove(FIXED_ACCOMMODATION_EXPENSE));
    }

    @Test
    public void removeExistingFixedExpenseRemovesFixedExpense() {
        uniqueFixedExpenseList.add(FIXED_TRANSPORTATION_EXPENSE);
        uniqueFixedExpenseList.remove(FIXED_TRANSPORTATION_EXPENSE);
        UniqueList<FixedExpense> expectedUniquePersonList = new UniqueList<>();
        assertEquals(expectedUniquePersonList, uniqueFixedExpenseList);
    }

    @Test
    public void setFixedExpenseNullUniqueFixedExpenseListThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList
                .setElements((UniqueList<FixedExpense>) null));
    }

    @Test
    public void setFixedExpenseUniqueFixedExpenseReplacesOwnListWithProvidedUniqueFixedExpenseList() {
        uniqueFixedExpenseList.add(FIXED_TRANSPORTATION_EXPENSE);
        UniqueList<FixedExpense> expectedFixedExpenseList = new UniqueList<>();
        uniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        uniqueFixedExpenseList.setElements(expectedFixedExpenseList);
        assertEquals(expectedFixedExpenseList, uniqueFixedExpenseList);
    }

    @Test
    public void setFixedExpenseNullListThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFixedExpenseList
                .setElements((List<FixedExpense>) null));
    }

    @Test
    public void setFixedExpenseListReplacesOwnListWithProvidedList() {
        uniqueFixedExpenseList.add(FIXED_TRANSPORTATION_EXPENSE);
        List<FixedExpense> fixedExpenseLists = Collections.singletonList(FIXED_ACCOMMODATION_EXPENSE);
        uniqueFixedExpenseList.setElements(fixedExpenseLists);
        UniqueList<FixedExpense> expectedUniqueFixedExpenseList = new UniqueList<>();
        expectedUniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        assertEquals(expectedUniqueFixedExpenseList, uniqueFixedExpenseList);
    }

    @Test
    public void setFixedExpenseListWithDuplicateFixedExpenseThrowsDuplicateFixedExpenseException() {
        List<FixedExpense> listWithDuplicateFixedExpenses = Arrays
                .asList(FIXED_ACCOMMODATION_EXPENSE, FIXED_ACCOMMODATION_EXPENSE);
        assertThrows(DuplicateElementException.class, ()
            -> uniqueFixedExpenseList.setElements(listWithDuplicateFixedExpenses));
    }

    @Test
    public void asUnmodifiableObservableListModifyListThrowsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueFixedExpenseList.asUnmodifiableObservableList().remove(0));
    }

    @Test
    public void testEquals() {
        UniqueList<FixedExpense> expectedUniqueFixedExpenseLists = new UniqueList<>();
        expectedUniqueFixedExpenseLists.add(FIXED_ACCOMMODATION_EXPENSE);
        uniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        assertEquals(uniqueFixedExpenseList, expectedUniqueFixedExpenseLists);
    }

    @Test
    public void testHashCode() {
        //Same Hash Code
        uniqueFixedExpenseList.add(FIXED_ACCOMMODATION_EXPENSE);
        UniqueList<FixedExpense> ue = new UniqueList<>();
        ue.add(FIXED_ACCOMMODATION_EXPENSE);
        assertEquals(uniqueFixedExpenseList.hashCode() , ue.hashCode());

        //Different Hash code
        UniqueList<FixedExpense> diffUe = new UniqueList<>();
        diffUe.add(FIXED_ACTIVITY_EXPENSE);
        assertNotEquals(diffUe.hashCode(), uniqueFixedExpenseList.hashCode());
    }
}
