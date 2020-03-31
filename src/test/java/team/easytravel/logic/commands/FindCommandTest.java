//package seedu.address.logic.commands;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
//import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
//import static seedu.address.testutil.TypicalPersons.CARL;
//import static seedu.address.testutil.TypicalPersons.ELLE;
//import static seedu.address.testutil.TypicalPersons.FIONA;
//import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.junit.jupiter.api.Test;
//
//import seedu.address.model.Model;
//import seedu.address.model.ModelManager;
//import seedu.address.model.listmanagers.UserPrefs;
//<<<<<<< HEAD
//import seedu.address.model.listmanager.ActivityManager;
//=======
//import seedu.address.model.listmanager.AccommodationBookingManager;
//>>>>>>> Improve Code Quality
//import seedu.address.model.listmanager.FixedExpenseManager;
//import seedu.address.model.listmanager.PackingListManager;
//import seedu.address.model.listmanager.TransportBookingManager;
//import seedu.address.model.person.NameContainsKeywordsPredicate;
//
///**
// * Contains integration tests (interaction with the Model) for {@code FindCommand}.
// */
//public class FindCommandTest {
//    private Model model = new ModelManager(getTypicalAddressBook(),
//<<<<<<< HEAD
//            new TransportBookingManager(), new FixedExpenseManager(), new PackingListManager(), new ActivityManager(),
//            new UserPrefs());
//    private Model expectedModel = new ModelManager(getTypicalAddressBook(),
//            new TransportBookingManager(), new FixedExpenseManager(), new PackingListManager(), new ActivityManager(),
//            new UserPrefs());
//=======
//            new TransportBookingManager(), new FixedExpenseManager(), new PackingListManager(),
//            new AccommodationBookingManager(), new UserPrefs());
//    private Model expectedModel = new ModelManager(getTypicalAddressBook(),
//            new TransportBookingManager(), new FixedExpenseManager(), new PackingListManager(),
//            new AccommodationBookingManager(), new UserPrefs());
//>>>>>>> Improve Code Quality
//
//    @Test
//    public void equals() {
//        NameContainsKeywordsPredicate firstPredicate =
//                new NameContainsKeywordsPredicate(Collections.singletonList("first"));
//        NameContainsKeywordsPredicate secondPredicate =
//                new NameContainsKeywordsPredicate(Collections.singletonList("second"));
//
//        FindCommand findFirstCommand = new FindCommand(firstPredicate);
//        FindCommand findSecondCommand = new FindCommand(secondPredicate);
//
//        // same object -> returns true
//        assertTrue(findFirstCommand.equals(findFirstCommand));
//
//        // same values -> returns true
//        FindCommand findFirstCommandCopy = new FindCommand(firstPredicate);
//        assertTrue(findFirstCommand.equals(findFirstCommandCopy));
//
//        // different types -> returns false
//        assertFalse(findFirstCommand.equals(1));
//
//        // null -> returns false
//        assertFalse(findFirstCommand.equals(null));
//
//        // different person -> returns false
//        assertFalse(findFirstCommand.equals(findSecondCommand));
//    }
//
//    @Test
//    public void execute_zeroKeywords_noPersonFound() {
//        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
//        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
//        FindCommand command = new FindCommand(predicate);
//        expectedModel.updateFilteredPersonList(predicate);
//        assertCommandSuccess(command, model, expectedMessage, expectedModel);
//        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
//    }
//
//    @Test
//    public void execute_multipleKeywords_multiplePersonsFound() {
//        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
//        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
//        FindCommand command = new FindCommand(predicate);
//        expectedModel.updateFilteredPersonList(predicate);
//        assertCommandSuccess(command, model, expectedMessage, expectedModel);
//        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.getFilteredPersonList());
//    }
//
//    /**
//     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
//     */
//    private NameContainsKeywordsPredicate preparePredicate(String userInput) {
//        return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
//    }
//}