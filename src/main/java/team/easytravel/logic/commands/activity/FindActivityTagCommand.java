package team.easytravel.logic.commands.activity;

import static java.util.Objects.requireNonNull;

import team.easytravel.commons.core.Messages;
import team.easytravel.logic.commands.Command;
import team.easytravel.logic.commands.CommandResult;
import team.easytravel.model.Model;
import team.easytravel.model.listmanagers.activity.ActivityTagContainsPredicate;

/**
 * Finds all the activity tags
 */
public class FindActivityTagCommand extends Command {
    public static final String COMMAND_WORD = "findtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all activity with "
            + "the specified tags (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " hot";

    private final ActivityTagContainsPredicate predicate;

    public FindActivityTagCommand(ActivityTagContainsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredActivityList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_ACTIVITY_LISTED_OVERVIEW, model.getFilteredActivityList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindActivityTagCommand // instanceof handles nulls
                && predicate.equals(((FindActivityTagCommand) other).predicate)); // state check
    }
}
